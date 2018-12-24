package com.example.everything.product.service;

/**
 * @author win10
 */
public interface ProductService {
    /**
     * 通过id调用查询
     * @param id
     * @return
     */
    String selectById(int id);

    /**
     * 通过id调用查询
     * @param id
     * @return
     */
    String selectByList(int id);
}
