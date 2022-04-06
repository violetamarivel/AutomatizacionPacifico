package com.pacifico.test.steps;
import com.pacifico.framework.base.Base;
import com.pacifico.framework.utilities.CommonUtil;
import com.pacifico.framework.utilities.CucumberNewUtil;
import com.pacifico.test.services.integration.pacifico.Booking;
import com.pacifico.test.services.integration.pacifico.Token;
import com.pacifico.test.services.integration.pacifico.TokenDemo;
import  com.pacifico.test.services.test.ResponseServicioEjemplo;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;



public class ResfullbookerServicesSteps {
    @Then("^I validate POST create booking$")
    public void iValidatePOSTCreationBooking(DataTable table) {

        ArrayList<String> listResults = new ArrayList<>();
        CucumberNewUtil.ConvertDataTableToDict(table);
        List<List<String>> data = table.raw();

        SoftAssert sa = new SoftAssert();

        for (int i = 1; i < data.size(); i++) {

            String FileRoute = "C:\\Users\\user\\Desktop\\Pacifico\\pruebasAutomatizadas\\frameworkpruebasautomatizadas\\src\\test\\java\\com\\pacifico\\test\\services\\test\\JSON\\" + CucumberNewUtil.GetCellValueWithRowIndex("file", i);
            File JsonBooking = new File(FileRoute);
            int statusExpected = Integer.parseInt(CucumberNewUtil.GetCellValueWithRowIndex("expStatus", i));

            System.out.println("==============================================================================");
            System.out.println("================== TOKEN (POST) - Se obtiene el bearer =======================");
            System.out.println("==============================================================================");
            Response response1 = ResponseServicioEjemplo.postTokenejemplo(JsonBooking);
            String strMessageError = CommonUtil.responseMessage(response1, statusExpected);
            sa.assertEquals(response1.getStatusCode(), statusExpected, "[post token] Test [" + i + "] Message [" + strMessageError + "]");

            Booking restBooking = response1.as(Booking.class);
            sa.assertEquals(restBooking.getBookingid() > 0,true,"Test [" + i + "] Token ID");
            sa.assertEquals(restBooking.getBooking().getFirstname().equals("Jim"),true,"Test [" + i + "] Token ID");



            listResults.add("Test [" + i + "][" + FileRoute + "][\" + aStatusEsperado + \"][" + statusExpected + "]");


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
