package com.ljstudio.android.awesomeutils.sample;

/**
 * Created by guoxinyu on 2016/7/19.
 *
 */
public class MyMeetingData {

//    did 域名id
//    domain 域名
//    passwd 域名密码
//    enddate 到期时间
//
//    tid 虚机id
//    enddate 到期日期
//    stype 虚机类型
//    domain 绑定域名
//    typename 类型名称
//
//    Tid 数据库id
//    osystem 系统名称
//    IP 数据库IP
//    passwd 数据库密码
//    dbuser 数据库名
//    enddate 到期时间

    private String did;

    private String tid;
    private String stype;
    private String typename;

    private String Tid;
    private String osystem;
    private String IP;
    private String dbuser;

    private String domain;
    private String enddate;
    private String passwd;

    private String type;


    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getOsystem() {
        return osystem;
    }

    public void setOsystem(String osystem) {
        this.osystem = osystem;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getDbuser() {
        return dbuser;
    }

    public void setDbuser(String dbuser) {
        this.dbuser = dbuser;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MyMeetingData{" +
                "did='" + did + '\'' +
                ", tid='" + tid + '\'' +
                ", stype='" + stype + '\'' +
                ", typename='" + typename + '\'' +
                ", Tid='" + Tid + '\'' +
                ", osystem='" + osystem + '\'' +
                ", IP='" + IP + '\'' +
                ", dbuser='" + dbuser + '\'' +
                ", domain='" + domain + '\'' +
                ", enddate='" + enddate + '\'' +
                ", passwd='" + passwd + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
