package com.test.utils;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.net.URL;

/**
 * 文件工具类 @Auther: zhouwenbin @Date: 2019/5/17 10:42
 */
public class FileUtil {


    /**
     * 先从当前目录查找文件，如果没有则从resource中查找
     *
     * @param name
     * @return
     */
    public static InputStream newFileInputStream(String name) throws FileNotFoundException {
//    return newFileInputStream(name, ClassLoader.getSystemClassLoader());
        return newFileInputStream(name, Thread.currentThread().getContextClassLoader());
    }

    public static InputStream newFileInputStream(String name, ClassLoader loader)
            throws FileNotFoundException {
        File file = new File(name);
        if (file.exists()) {
            return new FileInputStream(file);
        } else {
            return ConditionsUtil.checkNotNull(
                    loader.getResourceAsStream(name), "找不到文件%s", loader.getResource(name).getPath());
        }
    }

    /**
     * 获得包下面的所有的class
     *
     * @param
     * @return List包含所有class的实例
     */

    public static List<Class<?>> getClasssFromPackage(String packageName, boolean recursive) {
        List<Class<?>> clazzs = new ArrayList<>();
        // 是否循环搜索子包
        // 包名对应的路径名称
        String packageDirName = packageName.replace('.', '/');
        Enumeration<URL> dirs;

        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {

                URL url = dirs.nextElement();
                String protocol = url.getProtocol();

                if ("file".equals(protocol)) {
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    findClassInPackageByFile(packageName, filePath, recursive, clazzs);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return clazzs;
    }

    /**
     * 在package对应的路径下找到所有的class
     */
    public static void findClassInPackageByFile(String packageName, String filePath, final boolean recursive,
                                                List<Class<?>> clazzs) {
        File dir = new File(filePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        // 在给定的目录下找到所有的文件，并且进行条件过滤
        File[] dirFiles = dir.listFiles(new FileFilter() {

            public boolean accept(File file) {
                boolean acceptDir = recursive && file.isDirectory();// 接受dir目录
                boolean acceptClass = file.getName().endsWith("class");// 接受class文件
                return acceptDir || acceptClass;
            }
        });

        for (File file : dirFiles) {
            if (file.isDirectory()) {
                findClassInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, clazzs);
            } else {
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
//                    clazzs.add(ClassLoader.getSystemClassLoader().loadClass(packageName + "." + className));
                    clazzs.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + "." + className));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

