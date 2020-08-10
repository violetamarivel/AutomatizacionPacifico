package com.pacifico.test.services.common;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public class CommonServicesUtil {

    public static String getResource(String resource) {
        JSONObject jsonParams = new JSONObject();
        jsonParams.put("resource", resource);
        return jsonParams.toString();
    }
}
