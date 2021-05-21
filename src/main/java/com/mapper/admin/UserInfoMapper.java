package com.mapper.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.modle.admin.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    @Select("select a.uid,a.name,b.speed,b.time,a.sex,a.birthday,a.state,b.ip,b.time,b.word from users as a LEFT JOIN score as b on a.uid = b.uid limit 1000;")
    public List<UserInfo> getAllInfo();

}
