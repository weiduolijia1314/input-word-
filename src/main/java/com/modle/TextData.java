package com.modle;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "textdata")
public class TextData {
    private String id;
    private String text;
    private String state;
}
