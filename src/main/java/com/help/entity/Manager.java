package com.help.entity;

import lombok.Data;

@Data
public class Manager {
    private int id;
    /**
     * 0不通过   1通过
     */
    private int pass;
}
