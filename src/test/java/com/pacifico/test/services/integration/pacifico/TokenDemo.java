package com.pacifico.test.services.integration.pacifico;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenDemo {

    @SerializedName("token")
    @Expose
    private String token_id;

    public String getToken_id() {
        return token_id;
    }

}