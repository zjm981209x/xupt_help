package com.help.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class FoodResult {
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

    private int foodId;
    /**
     * 地址
     */
    private String address;
    /**
     * 食物花费
     */
    private double cost;
    /**
     * 酬劳
     */
    private double pay;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 其他备注
     */
    private String description;
    /**
     * 约定时间
     */
    private Timestamp time;
}
