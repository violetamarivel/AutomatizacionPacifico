package com.pacifico.test.steps;

import com.pacifico.framework.base.Base;
import com.pacifico.framework.utilities.CucumberNewUtil;
import com.pacifico.test.pages.FunctionalPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class FunctionalSteps extends Base {

    @Given("^paso uno$")
    public void pasoUno() {
    }

    @When("^paso dos$")
    public void pasoDos(DataTable table) {

        ArrayList<String> listResults = new ArrayList<>();
        CucumberNewUtil.ConvertDataTableToDict(table);
        List<List<String>> data = table.raw();

        for (int i = 1; i < data.size(); i++) {

            boolean aColUno = Boolean.parseBoolean(CucumberNewUtil.GetCellValueWithRowIndex("col uno", i));
            boolean aColDos = Boolean.parseBoolean(CucumberNewUtil.GetCellValueWithRowIndex("col dos", i));

            CurrentPage.As(FunctionalPage.class).methodToTest(aColUno, aColDos);

            listResults.add("Test [" + i + "][" + aColUno + "][" + aColDos + "]");

        }

        System.out.println("================================================");
        System.out.println("================== Resume test =================");
        System.out.println("================================================");

        for (String result : listResults) {
            System.out.println(result);
        }
    }

    @Then("^paso tres$")
    public void pasoTres() {
    }

    @When("^paso dos \"([^\"]*)\"$")
    public void pasoDos(String aColUno) {
        CurrentPage.As(FunctionalPage.class).methodToTest2(aColUno);
    }

    @Then("^paso tres \"([^\"]*)\"$")
    public void pasoTres(String aColDos) {
        CurrentPage.As(FunctionalPage.class).methodToTest3(aColDos);
    }
}