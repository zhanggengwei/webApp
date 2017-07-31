package com.UserInfo.Entity;

import org.apache.ibatis.annotations.Insert;

/**
 * Created by vd on 2017/7/30.
 */
public interface UserInfo {

    public int insertUser(UserInfoEntity entity);

    public UserInfoEntity searchUserInfoByPhone(String phone);

    public UserInfoEntity updateUserInfo(UserInfoEntity entity);

    public UserInfoEntity searchUserInfoById(long id);

}
