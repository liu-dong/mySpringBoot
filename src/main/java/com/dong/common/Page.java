package com.dong.common;

import lombok.Data;

import java.util.List;

/**
 * 分页
 *
 * @author LD
 */
@Data
public class Page<T> {

    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * 分页数据
     */
    private List<T> dataList;
}
