package com.pacifico.test.services.integration.pacifico;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token {

    @SerializedName("token_type")
    @Expose
    private String token_type;
    @SerializedName("expires_in")
    @Expose
    private String expires_in;
    @SerializedName("ext_expires_in")
    @Expose
    private String ext_expires_in;
    @SerializedName("expires_on")
    @Expose
    private String expires_on;
    @SerializedName("not_before")
    @Expose
    private String not_before;
    @SerializedName("resource")
    @Expose
    private String resource;
    @SerializedName("access_token")
    @Expose
    private String access_token;

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getExt_expires_in() {
        return ext_expires_in;
    }

    public void setExt_expires_in(String ext_expires_in) {
        this.ext_expires_in = ext_expires_in;
    }

    public String getExpires_on() {
        return expires_on;
    }

    public void setExpires_on(String expires_on) {
        this.expires_on = expires_on;
    }

    public String getNot_before() {
        return not_before;
    }

    public void setNot_before(String not_before) {
        this.not_before = not_before;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }
}