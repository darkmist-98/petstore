package org.darkmist.api;

import com.aventstack.extentreports.ExtentTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.darkmist.extentReport.ExtentManager;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiClient {

    private static final RequestSpecification requestSpec = given()
            .contentType(ContentType.JSON)
            .log().all();

    public static Response get(String url) {
        logRequest("GET", url, null);
        Response response = requestSpec.get(url);
        logResponse(response);
        return response;
    }

    public static Response getWithQueryParams(String url, Map<String, String> queryParams) {
        logRequest("GET", url, queryParams);
        Response response = requestSpec.queryParams(queryParams).get(url);
        logResponse(response);
        return response;
    }

    private static void logRequest(String method, String url, Object payload) {
        ExtentTest test = ExtentManager.getTest();
        test.info("Request method: " + method);
        test.info("Request URL: " + url);
        if (payload != null) {
            test.info("Request Payload: <pre>" + payload.toString() + "</pre>");
        }
    }

    private static void logResponse(Response response) {
        ExtentTest test = ExtentManager.getTest();
        test.info("Response Status: " + response.getStatusCode());
        test.info("Response Body: <pre>" + response.prettyPrint() + "</pre>");
    }
}
