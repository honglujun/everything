package com.example.everything.product.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 前端系统展示使用
 *
 * @author win10
 */
@Getter
@Setter
public class ProductVo implements Serializable {

    private static final long serialVersionUID = 3890116569971576839L;

    private String deValue;
    private String detTime;
    private String enterpriseName;
    private String monitor;
    private String poName;
    private String provinceName;
    private String staValue;
}
