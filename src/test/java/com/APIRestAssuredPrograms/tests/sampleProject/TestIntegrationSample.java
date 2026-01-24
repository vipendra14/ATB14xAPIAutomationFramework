package com.APIRestAssuredPrograms.tests.sampleProject;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSample  {

    @Test(groups = "QA", priority = 1)
    @Owner("Vipendra")
    @Description("TC1 Create the booking")
    public void createbooking(){
        Assert.assertTrue(true);
    }

    @Test(groups = "QA", priority = 2)
    @Owner("Vipendra")
    @Description("TC2 Verify the booking is created")
    public void verifybooking(){
        Assert.assertTrue(true);
    }

    @Test(groups = "QA", priority = 3)
    @Owner("Vipendra")
    @Description("TC3 update the booking")
    public void updatebooking(){
        Assert.assertTrue(true);
    }

    @Test(groups = "QA", priority = 4)
    @Owner("Vipendra")
    @Description("TC4 Delete the booking")
    public void deletebooking(){
        Assert.assertTrue(true);
    }

}
