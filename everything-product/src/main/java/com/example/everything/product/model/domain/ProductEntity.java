package com.example.everything.product.model.domain;

import com.example.everything.common.mybatis.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

/**
 * 数据库信息交互实体
 * @author win10
 */
@Setter
@Getter
@Table(name = "pc_mdc_address")
public class ProductEntity extends BaseEntity {

    private static final long serialVersionUID = 6549552468029593892L;


}
