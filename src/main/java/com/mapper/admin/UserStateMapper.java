package com.mapper.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.modle.admin.UserState;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStateMapper extends BaseMapper<UserState> {
    @Select("SELECT name,speed FROM users JOIN state on users.uid = state.uid ORDER by speed desc LIMIT 0,10")
    public List<UserState> state();
}
