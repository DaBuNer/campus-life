package com.dbn.campuslife.user;

import com.dbn.campuslife.CampusLifeApplicationTests;
import com.dbn.campuslife.entity.user.RegisterUserDTO;
import com.dbn.campuslife.entity.user.UpdateUser;
import com.dbn.campuslife.mapper.UserMapper;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

public class UserTest extends CampusLifeApplicationTests {

    @Resource
    UserMapper userMapper;

    @Test
    public void existUsername() {
        System.out.println(userMapper.existUsername("a"));
    }

    @Test
    public void addUserInfo() {
        userMapper.addUserInfo(new RegisterUserDTO().with(RegisterUserDTO::setUsername, "zhangSan")
                .with(RegisterUserDTO::setPassword, "123"));
    }


    public static void main(String[] args) throws Exception{
    }

    @Test
    public void getUserInfo() {
        System.out.println(userMapper.getUserInfoByUserName("abc"));
    }


    @Test
    public void updateUserInfoById() {
        userMapper.updateUserInfoById(new UpdateUser().with(UpdateUser::setId, 16)
                .with(UpdateUser::setPersonName, "李四")
                .with(UpdateUser::setPersonAge, 21));
    }

}
