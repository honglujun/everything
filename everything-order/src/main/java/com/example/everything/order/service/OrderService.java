package com.example.everything.order.service;

/**
 * @author win10
 */
public interface OrderService {

    /**
     * 通过id查询
     * @param id
     * @return
     */
    String selectById(int id);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    String selectByList(int id);
}
