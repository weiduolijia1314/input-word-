package com.modle.admin;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "users2")
public class Admin {
    @TableId(value = "ID")
    private String id;
    private String name;
    private String stuno;
}
