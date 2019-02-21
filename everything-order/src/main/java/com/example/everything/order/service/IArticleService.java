package com.example.everything.order.service;


/**
 * @author win10
 */
public interface IArticleService {

    /**
     * elasticsearch新增
     *
     * @param str
     * @return
     */
    Object save(String str);

    /**
     * elasticsearch查询
     *
     * @param str
     * @return
     */
    Object search(String str);
}
