package com.APIRestAssuredPrograms.modules.restfulbooker;

import com.APIRestAssuredPrograms.pojos.restfulbooker.request.Auth;
import com.APIRestAssuredPrograms.pojos.restfulbooker.request.Booking;
import com.APIRestAssuredPrograms.pojos.restfulbooker.request.BookingDates;
import com.APIRestAssuredPrograms.pojos.restfulbooker.response.BookingResponse;
import com.APIRestAssuredPrograms.pojos.restfulbooker.response.TokenResponse;
import com.google.gson.Gson;

public class PayloadManager {
    Gson gson;
    //Convert your JAVA Object into JSON String to use as the payload
    // Serialization

    public String createPayloadBookingAsString() {

        Booking booking = new Booking();
        booking.setFirstname("Vipendra");
        booking.setLastname("Mishra");
        booking.setTotalprice(1100);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2026/01/01");
        bookingDates.setCheckout("2026/01/31");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        //Java Object to JSON
        gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        return jsonStringBooking;
    }

    // Convert JSON String to JAVA Object so that we can verify the response body
    // Dserialization

    public BookingResponse bookingResponseJava(String responseString) {
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;

    }

    public String createPayLoadBookingAsStringWrongBody() {
        Booking booking = new Booking();
        booking.setFirstname("会意; 會意会意;");
        booking.setLastname("会意; 會意");
        booking.setTotalprice(0000);
        booking.setDepositpaid(false);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("5055/01/01");
        bookingDates.setCheckout("9085/01/01");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("会意; 會意");

        System.out.println(booking);

        // Java Object to JSON
        //Serialization
        gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        return jsonStringBooking;

    }


    // JSON to JAVA Object
    //Dserialization
    public BookingResponse bookingResponse(String responseString) {
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }


    //JAVA Object to JSON
    public String setAuthPayload() {
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonpayloadString = gson.toJson(auth);
        System.out.println("Payload set to " + jsonpayloadString);
        return jsonpayloadString;
    }

    //JSON to JAVA Object
    public String getTokenFromJSON(String tokenResponse) {
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse1.getToken();
    }

    public Booking getResponsefromJSON(String responseString) {
        gson = new Gson();
        Booking bookingResponse = gson.fromJson(responseString, Booking.class);
        return bookingResponse;
    }

    public String fullUpdatePayloadAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Chunky");
        booking.setLastname("kkr");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        return gson.toJson(booking);

    }
}
