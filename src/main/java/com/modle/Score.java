package com.modle;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Score {
    @TableId(value = "uid")
    private String uid;
    private String speed;
    private String time;
    private String ip;
    private String word;
}
