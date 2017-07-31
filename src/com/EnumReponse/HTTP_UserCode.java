package com.EnumReponse;

/**
 * Created by vd on 2017/7/30.
 */
public interface HTTP_UserCode {
    int SUCESS = 200;
    int PHONE_EXITS = 1001;//手机号码已经存在
    int PHONE_ORPASSWORD_ERROR = 1002;//手机号或者密码不正确
    int ACCOUNT_ALREADY_EXISTS = 1003;//账号已经存在

}
