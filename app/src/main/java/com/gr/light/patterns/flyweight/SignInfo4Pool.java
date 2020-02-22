package com.gr.light.patterns.flyweight;

/**
 * TODO
 * <p>
 * Created by WSS on  2020-02-22
 **/
public class SignInfo4Pool extends SignInfo {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public SignInfo4Pool(String key) {
        this.key = key;
    }
}
