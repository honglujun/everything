package com.example.everything.common.mybatis;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author win10
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
