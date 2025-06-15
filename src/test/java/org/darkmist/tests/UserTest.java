package org.darkmist.tests;

import org.darkmist.api.ApiClient;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class UserTest {


    @Test
    public void getUserByUserName() {
        String url = "https://petstore.swagger.io/v2/user/darkmist";

        ApiClient.get(url);
    }

    @Test
    public void getUserByUserName2() {
        String url = "https://petstore.swagger.io/v2/user/darkmist";

        ApiClient.get(url);
    }

    @Test
    public void getUserByUserName3() {
        String url = "https://petstore.swagger.io/v2/user/darkmist";

        ApiClient.get(url);
    }
}
