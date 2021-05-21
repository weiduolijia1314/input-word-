package com.modle;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class State {
    @TableId(value = "id",type = IdType.AUTO)
    private String id;
    private String uid;
    private String logintime;
    private String endtime;
    private String speed;
}

