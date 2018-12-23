package com.ugrow.internet.Entity;

public class BackOperator {
    private int id;
    private String name;
    private int sex;
    private String nike;
    private String pass;
    private String tel;
    private String comments="";
    private String[] sexlist={"男","女"};

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNike() {
        return nike;
    }
    public void setNike(String nike) {
        this.nike = nike;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public int getSex() {
        return sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public String getSexlist() {
        return sexlist[sex];
    }


}