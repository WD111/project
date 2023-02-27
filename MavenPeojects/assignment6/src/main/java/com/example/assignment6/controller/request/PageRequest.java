package com.example.assignment6.controller.request;

import lombok.Data;

@Data
public class PageRequest {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    public PageRequest(int num, int size){
        this.pageNum = num;
        this.pageSize = size;
    }
}
