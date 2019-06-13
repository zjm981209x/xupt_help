package com.help.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageResult {
    /**
     * 数据总条数
     */
    private long totals;
    /**
     * 每页数据
     */
    private List rows;
}
