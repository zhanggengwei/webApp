package com.UserInfo.Action;

import com.UserInfo.Dao.UserDao;
import com.UserInfo.Entity.UserInfoEntity;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vd on 2017/7/30.
 */
public class UserAction extends ActionSupport{
    public JSONObject responseJson;
    public JSONObject getResponseJson() {
        return responseJson;
    }
    public void setResponseJson(JSONObject responseJson) {
        this.responseJson = responseJson;
    }

    public String registerAction()
    {
        responseJson = new JSONObject();
        HttpServletRequest request= ServletActionContext.getRequest();
        String phone = request.getParameter("phone");
        String passWord = request.getParameter("passWord");
        UserInfoEntity entity = new UserInfoEntity();
        entity.setPassWord(passWord);
        entity.setPhone(phone);
        entity.setResign("+86");
        JSONObject response = new UserDao().register(entity);
        this.setResponseJson(response);
        return SUCCESS;
    }

}
