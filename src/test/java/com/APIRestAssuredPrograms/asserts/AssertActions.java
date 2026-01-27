package com.APIRestAssuredPrograms.asserts;

import io.restassured.response.Response;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertActions {
    public void verifyResponseBody(String actual, String expected, String description){
        assertEquals(actual, expected, description);

    }

    public void verifyResponseBody(int actual, int expected, String description){
        assertEquals(actual, expected,description);

    }
    public void verifyStatusCode(Response response, int expected){
        assertEquals(response.getStatusCode(), expected);
    }

    public void verifyStringKey(String keyActual, String keyExpect){
        assertThat(keyExpect).isNotNull();
        assertThat(keyExpect).isNotBlank();
        assertThat(keyExpect).isEqualTo(keyActual);

 }

 public void verifyStringkeyNotNull(Integer keyExpect){
        assertThat(keyExpect).isNotNull();
 }

 public void verifyStringkeyNotNull(String keyExpect){
        assertThat(keyExpect).isNotNull().isNotEmpty().as("Expected token to be present but not null");
 }

 public void verifyTrue(boolean keyExpect){
        assertTrue(keyExpect);
 }

}
