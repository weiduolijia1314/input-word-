package com.modle;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = "users")
@Data
public class User {

    @TableId(value = "uid",type = IdType.AUTO)
    private String uid;
    private String name;
    private String pwd;
    private String sex;
    private String face;
    private String sign;
    private String birthday;
    private String state;

}
