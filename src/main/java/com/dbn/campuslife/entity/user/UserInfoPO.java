package com.dbn.campuslife.entity.user;

import com.dbn.campuslife.util.NatureUtil;

/**
 * 用户的所有信息
 */
public class UserInfoPO implements NatureUtil<UserInfoPO> {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐值
     */
    private String salt;
    /**
     * 昵称
     */
    private String personName;
    /**
     * 年龄
     */
    private Integer personAge;
    /**
     * 住址
     */
    private String personAddress;
    /**
     * 学校名称
     */
    private String schoolName;
    /**
     * 注册时间
     */
    private String createTime;
    /**
     * 是否新注册0:是 1:否
     */
    private Integer newAccount;
    /**
     * 头像
     */
    private String headImage;
    /**
     * 粉丝
     */
    private Integer fans;
    /**
     * 当前登录人是否关注
     */
    private boolean attention;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getPersonAge() {
        return personAge;
    }

    public void setPersonAge(Integer personAge) {
        this.personAge = personAge;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getNewAccount() {
        return newAccount;
    }

    public void setNewAccount(Integer newAccount) {
        this.newAccount = newAccount;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public boolean isAttention() {
        return attention;
    }

    public void setAttention(boolean attention) {
        this.attention = attention;
    }

    @Override
    public String toString() {
        return "UserInfoPO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", personName='" + personName + '\'' +
                ", personAge=" + personAge +
                ", personAddress='" + personAddress + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", newAccount=" + newAccount +
                '}';
    }
}
