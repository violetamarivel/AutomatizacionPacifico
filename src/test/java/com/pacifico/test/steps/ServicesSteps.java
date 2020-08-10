package com.pacifico.test.steps;

import com.pacifico.framework.base.Base;
import com.pacifico.framework.utilities.CommonUtil;
import com.pacifico.framework.utilities.CucumberNewUtil;
import com.pacifico.test.services.integration.pacifico.Token;
import com.pacifico.test.services.test.ResponseServicesProject;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class ServicesSteps extends Base {

    @Then("^I validate POST auth service$")
    public void iValidatePOSTAuthService(DataTable table) {

        ArrayList<String> listResults = new ArrayList<>();
        CucumberNewUtil.ConvertDataTableToDict(table);
        List<List<String>> data = table.raw();

        SoftAssert sa = new SoftAssert();

        for (int i = 1; i < data.size(); i++) {

            String aResource = CucumberNewUtil.GetCellValueWithRowIndex("resource", i);
            int statusExpected = Integer.parseInt(CucumberNewUtil.GetCellValueWithRowIndex("expStatus", i));
            boolean aExpAccessToken = Boolean.parseBoolean(CucumberNewUtil.GetCellValueWithRowIndex("expAccessToken", i));
            boolean aExpTokentype = Boolean.parseBoolean(CucumberNewUtil.GetCellValueWithRowIndex("expTokentype", i));

            System.out.println("==============================================================================");
            System.out.println("================== TOKEN (POST) - Se obtiene el bearer =======================");
            System.out.println("==============================================================================");
            Response response = ResponseServicesProject.postToken(aResource);
            String strMessageError = CommonUtil.responseMessage(response, statusExpected);
            sa.assertEquals(response.getStatusCode(), statusExpected, "[post token] Test [" + i + "] Message [" + strMessageError + "]");

            if (aExpAccessToken && aExpTokentype) {
                Token restoken = response.as(Token.class);
                sa.assertEquals(restoken.getToken_type().length() > 0, aExpAccessToken, "Test [" + i + "] Token Type");
                sa.assertEquals(restoken.getAccess_token().length() > 0, aExpTokentype, "Test [" + i + "] Access Token");
            }

            listResults.add("Test [" + i + "][" + aResource + "][" + statusExpected + "][" + aExpAccessToken + "] [" + aExpAccessToken + "]");


        }

        sa.assertAll();

        System.out.println("================================================");
        System.out.println("================== Resume test =================");
        System.out.println("================================================");

        for (String result : listResults) {
            System.out.println(result);
        }

    }


}
