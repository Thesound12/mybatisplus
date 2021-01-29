package com.bjfu;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjfu.mapper.UserMapper;
import com.bjfu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class WrapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void test() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "WangDan");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }
}
