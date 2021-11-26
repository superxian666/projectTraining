package com.firewolf.apitest_platform.domain;
/**
 * 数据库实体类禁止使用int !!!
 * 为空时会报错@！
 */

public class Case {
    private Integer id;
    private Integer cid;//表示collection的id表示在哪个项目集合下
    private String name;
    private String url;
    private String method;
    private String type;

    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Case() {
    }

    public Case(Integer id, Integer cid, String name, String url, String method, String type) {
        this.id = id;
        this.cid = cid;
        this.name = name;
        this.url = url;
        this.method = method;
        this.type = type;
    }

    public Case(Integer cid, String name, String url, String method, String type) {
        this.cid = cid;
        this.name = name;
        this.url = url;
        this.method = method;
        this.type = type;
    }

    public Case(Integer id, Integer cid, String name, String url, String method, String type, String body) {

        this.id = id;
        this.cid = cid;
        this.name = name;
        this.url = url;
        this.method = method;
        this.type = type;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", cid=" + cid +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
