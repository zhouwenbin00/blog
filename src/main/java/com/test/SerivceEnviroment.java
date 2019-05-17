package com.test;

import com.test.utils.CharsetUtil;
import com.test.utils.FileUtil;
// import org.apache.log4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/** @Auther: zhouwenbin @Date: 2019/5/17 10:29 */
public class SerivceEnviroment {
  private static Logger LOGGER = LoggerFactory.getLogger(SerivceEnviroment.class);
  private static final String APP = "blog.properties";
  private static final String DB_URL = "db.url";
  private static final String DB_USR = "db.usr";
  private static final String DB_PWD = "db.pwd";
  private Enviroment enviroment;

  private static class SingletonInstance {
    private static final SerivceEnviroment INSTANCE = new SerivceEnviroment();
  }
  private SerivceEnviroment()  {
    try (InputStream inputStream = FileUtil.newFileInputStream(APP)) {
      enviroment = new Enviroment();
      enviroment.load(new InputStreamReader(inputStream, CharsetUtil.UTF_8));
      LOGGER.info("属性文件{}，开始加载", APP);
      for (Object key : enviroment.keySet()) {
        Object value = enviroment.get(key);
        LOGGER.info("{}:{}", key, value);
      }
      LOGGER.info("属性文件{}，加载完毕", APP);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public static SerivceEnviroment getSerivceEnviroment(){
    return SingletonInstance.INSTANCE;
  }

  public String getDbUrl() {
    return enviroment.getString(DB_URL);
  }

  public String getDbUsr() {
    return enviroment.getString(DB_USR);
  }

  public String getDbPwd() {
    return enviroment.getString(DB_PWD);
  }

  public static void main(String[] args) throws IOException {
    SerivceEnviroment serivceEnviroment = getSerivceEnviroment();
  }
}
