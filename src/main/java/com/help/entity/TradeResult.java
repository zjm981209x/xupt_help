package com.help.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class TradeResult {
    private int taskId;
    /**
     * 任务类型
     */
    private String type;
    /**
     * 发布任务的人
     */
    private String pubUser;
    /**
     * 接受任务的人
     */
    private String subUser;
    /**
     * 具体类型任务id
     */
    private int typeId;
    /**
     * 任务状态
     * default(-1)  0未接受   1已接受
     */
    private int status;
    /**
     * 任务发布时间
     */
    private Timestamp timer;

    private int tradeId;
    /**
     * 标题
     */
    private String title;
    /**
     * 物品原价
     */
    private double oldPrice;
    /**
     * 交易价格
     */
    private double newPrice;
    /**
     * 其他描述
     */
    private String content;
    /**
     * 物品图片
     */
    private String image;
    /**
     * 联系方式
     */
    private String phone;
}
