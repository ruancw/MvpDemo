package com.zhongmeng.rxjava2test.bean;

/**
 * Created by rcw on 2017/7/31.
 */

public class LoginBean extends BaseBean{

    /**
     * invalidtime : 20171018133244
     * time : 1508304764000
     * token : 18000597a66e3bc4b3d044cfa1c293dc
     * userinfo : {"head_url":"http://owauh0662.bkt.clouddn.com/user_headimage_app_20170924160119.jpg","id":146,"username":"小竹","unitname":"四叶草幸运之草公司","use_state":"1","areacode":"410801000000","loginid":"15555123456","plat_type":"1","password":"463408fdf59bb9d9","unit_code":"41080130000"}
     */

    private long invalidtime;

    @Override
    public String toString() {
        return "LoginBean{" +
                "invalidtime=" + invalidtime +
                ", time=" + time +
                ", token='" + token + '\'' +
                ", userinfo=" + userinfo +
                '}';
    }

    private long time;
    private String token;
    private UserinfoBean userinfo;

    public long getInvalidtime() {
        return invalidtime;
    }

    public void setInvalidtime(long invalidtime) {
        this.invalidtime = invalidtime;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserinfoBean getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserinfoBean userinfo) {
        this.userinfo = userinfo;
    }

    public static class UserinfoBean {
        /**
         * head_url : http://owauh0662.bkt.clouddn.com/user_headimage_app_20170924160119.jpg
         * id : 146
         * username : 小竹
         * unitname : 四叶草幸运之草公司
         * use_state : 1
         * areacode : 410801000000
         * loginid : 15555123456
         * plat_type : 1
         * password : 463408fdf59bb9d9
         * unit_code : 41080130000
         */

        private String head_url;
        private int id;
        private String username;
        private String unitname;
        private String use_state;
        private String areacode;

        @Override
        public String toString() {
            return "UserinfoBean{" +
                    "head_url='" + head_url + '\'' +
                    ", id=" + id +
                    ", username='" + username + '\'' +
                    ", unitname='" + unitname + '\'' +
                    ", use_state='" + use_state + '\'' +
                    ", areacode='" + areacode + '\'' +
                    ", loginid='" + loginid + '\'' +
                    ", plat_type='" + plat_type + '\'' +
                    ", password='" + password + '\'' +
                    ", unit_code='" + unit_code + '\'' +
                    '}';
        }

        private String loginid;
        private String plat_type;
        private String password;
        private String unit_code;

        public String getHead_url() {
            return head_url;
        }

        public void setHead_url(String head_url) {
            this.head_url = head_url;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUnitname() {
            return unitname;
        }

        public void setUnitname(String unitname) {
            this.unitname = unitname;
        }

        public String getUse_state() {
            return use_state;
        }

        public void setUse_state(String use_state) {
            this.use_state = use_state;
        }

        public String getAreacode() {
            return areacode;
        }

        public void setAreacode(String areacode) {
            this.areacode = areacode;
        }

        public String getLoginid() {
            return loginid;
        }

        public void setLoginid(String loginid) {
            this.loginid = loginid;
        }

        public String getPlat_type() {
            return plat_type;
        }

        public void setPlat_type(String plat_type) {
            this.plat_type = plat_type;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUnit_code() {
            return unit_code;
        }

        public void setUnit_code(String unit_code) {
            this.unit_code = unit_code;
        }
    }
}
