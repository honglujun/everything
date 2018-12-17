package com.example.everything.product.model.enums;

/**
 * 枚举
 *
 * @author win10
 */
public enum ProductDictStatusEnum {

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

    ProductDictStatusEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * 获取type
     *
     * @return
     */
    public int getType() {
        return type;
    }

    /**
     * 获取name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 通过type获取name
     *
     * @param type
     * @return
     */
    public static String getName(int type) {
        for (ProductDictStatusEnum ele : ProductDictStatusEnum.values()) {
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
     * @return
     */
    public static ProductDictStatusEnum getEnum(int type) {
        for (ProductDictStatusEnum ele : ProductDictStatusEnum.values()) {
            if (type == ele.getType()) {
                return ele;
            }
        }
        return ENABLE;
    }

}
