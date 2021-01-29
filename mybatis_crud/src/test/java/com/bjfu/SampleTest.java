package com.bjfu;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjfu.mapper.UserMapper;
import com.bjfu.pojo.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest
public class SampleTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("Obama");
        user.setAge(18);
        user.setEmail("1261939899@qq.com");
        int insert = userMapper.insert(user);
        System.out.println("result" + insert);
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(6L);
        user.setName("WangDan");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    @Test
    public void testOptimisticLocker() {
        User user = userMapper.selectById(1);
        user.setName("aaa");
        user.setEmail("@qq.com");
        userMapper.updateById(user);
    }

    @Test
    public void testSelectByBatchId() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 条件查询之一map
     */
    @Test
    public void testSelectByMap() {
        HashMap<String, Object> map = new HashMap<>();
        //自定义查询条件
        map.put("name", "aaa");
        List<User> users = userMapper.selectByMap(map);
        for (User user : users) {
            System.out.println(user);

        }
    }

    @Test
    public void testPagination() {
        Page<User> userPage = new Page<>(1, 5);
        userMapper.selectPage(userPage, null);
    }
}
