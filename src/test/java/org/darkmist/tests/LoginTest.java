package org.darkmist.tests;

import org.darkmist.api.ApiClient;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest {


    @Test
    public void userLogin() {
        String url = "https://petstore.swagger.io/v2/user/login";

        Map<String, String> queryParam = Map.of("username","darkmist","password","password");
        ApiClient.getWithQueryParams(url,queryParam);
    }


}
