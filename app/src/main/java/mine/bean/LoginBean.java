package mine.bean;

/**
 * Created by Administrator on 2017/11/13 0013.
 */

public class LoginBean {
    /**
     * msg : 登录成功
     * code : 0
     * data : {"age":null,"appkey":null,"appsecret":null,"createtime":"2017-11-13T15:18:14","email":null,"gender":0,"icon":null,"mobile":"13264568923","money":0,"nickname":null,"password":"123456","token":"8DB8B4B1D997BCA72B590D3FBCECC1C5","uid":1010,"username":"13264568923"}
     */

    private String msg;
    private String code;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
