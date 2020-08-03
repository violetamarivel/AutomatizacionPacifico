package com.pacifico.test.services.test;

import com.pacifico.framework.config.Settings;
import com.pacifico.test.services.RestAssuredConfiguration;
import com.pacifico.test.services.common.CommonServicesUtil;
import com.pacifico.test.services.common.EndPoint;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseServicesProject {

    public static String abaseAuth = Settings.UrlServices_BASE_Auth;
    public static String auriAuth = Settings.UrlServices_URI_Auth;
    public static String headerAuthorization = "";

    public static Response postToken(String pResource) {

        String strBody = CommonServicesUtil.getResource(pResource);
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(abaseAuth, auriAuth, 0);
        Response response = new RestAssuredConfiguration().getResponseTotalPost(requestSpecification.body(strBody), EndPoint.POST_AUTH);
        headerAuthorization = response.path("token_type") + " " + response.path("access_token");
        return response;
    }

//    public static Response patchStoredInfo(Integer pCustomerId, int pId, String pDocType, String pDocId) {
//        String strBody = CommonServicesUtil.getStoreInfo(pDocType, pDocId);
//        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(abaseAuth, auriOnco, 0);
//        requestSpecification.pathParam("customerId", pId).log().all();
//        requestSpecification.pathParam("id", pCustomerId).log().all();
//        requestSpecification.header("authorization", headerAuthorization);
//        return new RestAssuredConfiguration().getResponseTotalPatch(requestSpecification.body(strBody), EndPoint.PATCH_STOREINFO);
//    }

}