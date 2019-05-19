package com.test.utils.sql;

/**
 * SQL构建器
 * @Auther: zhouwenbin
 * @Date: 2019/5/20 11:35
 */
public interface Prepare {
    /**
     * 开始编写插入语句
     *
     * @return
     */
    static Insert insert() {
        return Insert.create();
    }

    /**
     * 开始编写更新语句
     *
     * @return
     */
    static Update update(String tableName) {
        return Update.create(tableName);
    }

    /**
     * 开始编写删除语句
     *
     * @return
     */
    static Delete delete() {
        return Delete.create();
    }

    /**
     * 开始编写查找语句
     *
     * @return
     */
    static Select select(String... fields) {
        return Select.create(fields);
    }

}
