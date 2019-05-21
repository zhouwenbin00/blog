package com.test.utils.sql;

import com.test.utils.ConditionsUtil;

/**
 * 更新
 * @Auther: zhouwenbin
 * @Date: 2019/5/20 11:36
 */
public class Update implements SQL{
    private static final String TEMPLATE = "UPDATE `%s` SET %s WHERE %s;";
    private String tableName;
    private String[] setFields;
    private Object[] setValues;
    private Where where;

    private Update(String tableName) {
        this.tableName = tableName;
    }

    public static Update create(String tableName){
        return new Update(tableName);
    }

    public Update set(Object... sets){
        ConditionsUtil.checkArgument(
                sets != null && sets.length > 0 && (sets.length & 1) == 0, "长度必须为2n");
        int length = sets.length >> 1;
        setFields = new String[length];
        setValues = new Object[length];
        for (int i = 0; i < length; i++) {
            setFields[i] = sets[i << 1].toString();
            setValues[i] = sets[(i << 1) + 1];
        }
        return this;
    }

    public Update where(Where where) {
        this.where = where;
        return this;
    }

    @Override
    public String sql() {
        StringBuilder nameBuilder = new StringBuilder();
        for (String name : setFields) {
            nameBuilder.append("`").append(name).append("`").append("=").append("?").append(",");
        }
        nameBuilder.deleteCharAt(nameBuilder.length() - 1);
        return String.format(TEMPLATE, tableName, nameBuilder.toString(), where.sql());
    }

    @Override
    public Object[] params() {
        Object[] conditionValues = where.params();
        Object[] result = new Object[setFields.length + conditionValues.length];
        System.arraycopy(setValues, 0, result, 0, setValues.length);
        System.arraycopy(conditionValues, 0, result, setValues.length, conditionValues.length);
        return result;
    }
}
