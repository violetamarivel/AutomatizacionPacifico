package com.pacifico.test.services.test;
import com.pacifico.framework.config.Settings;
import com.pacifico.test.services.RestAssuredConfiguration;
import com.pacifico.test.services.common.CommonServicesUtil;
import com.pacifico.test.services.common.EndPoint;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

public class ResponseServicioEjemplo {

    public static String abaseAuth = Settings.UrlServices_BASE_Auth;
    public static String auriAuth = Settings.UrlServices_URI_Auth;
    public static String headerAuthorization = "";

    public static Response postTokenejemplo(File JsonBookinf) {

        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(abaseAuth, auriAuth, 0);
        Response response = new RestAssuredConfiguration().getResponseTotalPost(requestSpecification.body(JsonBookinf), EndPoint.POST_AUTH);
        headerAuthorization = response.path("token_type") + " " + response.path("access_token");
        return response;
    }
}
