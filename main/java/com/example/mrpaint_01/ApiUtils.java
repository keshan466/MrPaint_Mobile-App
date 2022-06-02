package com.example.mrpaint_01;

public class ApiUtils extends MainActivity {

    public static final String BASE_URL = "http://192.168.1.5:82/EstimateService.asmx/";
//    public static final String BASE_URL = "http://192.168.1.120:81/EstimateService.asmx/";

    public static UserService getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}
