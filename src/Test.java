import com.opensymphony.xwork2.ActionSupport;


import java.util.*;
/**
 * Created by vd on 2017/7/30.
 */
public class Test extends ActionSupport {
    public String  responseJson;
    public String getResponseJson() {
        return responseJson;
    }
    public void setResponseJson(String responseJson) {
        this.responseJson = responseJson;
    }

    public String getList(){
//        JSONObject jsonObject = new JSONObject();
//        JSONObject root = new JSONObject();
//        try {
//            jsonObject.put("code",200);
//            jsonObject.put("message","sucess");
//            root.put("root",jsonObject);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        this.setResponseJson(root.toString());
        return SUCCESS;
    }
}
