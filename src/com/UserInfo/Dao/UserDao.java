package com.UserInfo.Dao;

import com.EnumReponse.HTTP_UserCode;
import com.HTTPReponse.HTTPReponse;
import com.Tool.MyBatisSqlSessionFactory;
import com.Tool.ToolsToken;
import com.UserInfo.Entity.UserInfo;
import com.UserInfo.Entity.UserInfoEntity;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.SqlSession;


/**
 * Created by vd on 2017/7/30.
 */
public class UserDao {
    public JSONObject register(UserInfoEntity entity)
    {
//        entity.setToken(ToolsToken.loginToken(entity.getPhone()));
        SqlSession session = MyBatisSqlSessionFactory.openSession();
        UserInfo mapper = session.getMapper(UserInfo.class);
        UserInfoEntity user= mapper.searchUserInfoByPhone(entity.getPhone());
        HTTPReponse response = new HTTPReponse();
        if(user!=null)
        {
            response.setCode(HTTP_UserCode.PHONE_EXITS);
            response.setMessage("手机号码已经存在");
        }else
        {
            mapper.insertUser(entity);
            session.commit();
            response.setCode(HTTP_UserCode.SUCESS);
            response.setMessage("注册成功");
            response.setObj(entity);
        }
        JSONObject object = new JSONObject();
        try {
            object.put("code",response.getCode());
            object.put("message",response.getMessage());
            object.put("obj",response.getObj());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }
}
