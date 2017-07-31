package test.Main;

import com.EnumReponse.HTTP_UserCode;
import com.Tool.MyBatisSqlSessionFactory;
import com.Tool.ToolsToken;
import com.UserInfo.Entity.UserInfo;
import com.UserInfo.Entity.UserInfoEntity;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by vd on 2017/7/30.
 */
public class Main {
    public static void main(String args[]) throws Exception
    {
        SqlSession session = MyBatisSqlSessionFactory.openSession();
        UserInfo mapper = session.getMapper(UserInfo.class);
        UserInfoEntity entity = new UserInfoEntity();
        entity.setNickName("zhanggeng");
        entity.setPassWord("1234567");
        entity.setPhone("18363070380");
        entity.setResign("86");
        entity.setToken("1");
        mapper.insertUser(entity);
        System.out.println(ToolsToken.loginToken(entity.getPhone()));
        session.commit();
        System.out.println(HTTP_UserCode.PHONE_EXITS);
        UserInfoEntity user= mapper.searchUserInfoById(2);
        System.out.println(user);
    }
}
