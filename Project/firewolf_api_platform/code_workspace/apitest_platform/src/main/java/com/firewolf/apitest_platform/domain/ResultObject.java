package com.firewolf.apitest_platform.domain;

public class ResultObject {
    private String texts;

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }

    @Override
    public String toString() {
        return "ResultObject{" +
                "texts='" + texts + '\'' +
                '}';
    }
}
