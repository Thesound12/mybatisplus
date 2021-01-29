package com.bjfu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjfu.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Thesound
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
