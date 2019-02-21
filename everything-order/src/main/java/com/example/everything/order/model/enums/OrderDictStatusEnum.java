package com.example.everything.order.model.enums;

/**
 * 枚举
 *
 * @author win10
 */
public enum OrderDictStatusEnum {

    /**
     * 启用
     */
    ENABLE(10, "启用"),
    /**
     * 禁用
     */
    DISABLE(20, "禁用");

    /**
     * The Type.
     */
    int type;
    /**
     * The Name.
     */
    String name;

    OrderDictStatusEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * 获取type
     *
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * 获取name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 通过type获取name
     *
     * @param type
     * @return type
     */
    public static String getName(int type) {
        for (OrderDictStatusEnum ele : OrderDictStatusEnum.values()) {
            if (type == ele.getType()) {
                return ele.getName();
            }
        }
        return null;
    }

    /**
     * 通过type获取Enum
     *
     * @param type
     * @return type
     */
    public static OrderDictStatusEnum getEnum(int type) {
        for (OrderDictStatusEnum ele : OrderDictStatusEnum.values()) {
            if (type == ele.getType()) {
                return ele;
            }
        }
        return ENABLE;
    }

}
