package com.example.mrpaint_01;

import com.example.mrpaint_01.Model.JobType;
import com.example.mrpaint_01.Model.ServiceAdvisors;
import com.example.mrpaint_01.Model.User;
import com.example.mrpaint_01.Model.VehicleMake;
import com.example.mrpaint_01.Model.VehicleModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {
    @FormUrlEncoded
    @POST("AuthenticateEmployee")
    Call<String> AuthenticateEmployee(@Field("userName") String userName, @Field("password") String password);

    @FormUrlEncoded
    @POST("GetVehicleModelByMakeId")
    Call<List<VehicleModel>> GetVehicleModelByMakeId(@Field("makeId") String makeId);

    @GET("GetVehicleMake")
    Call<List<VehicleMake>> GetVehicleMake();

    @GET("GetJobType")
    Call<List<JobType>> GetJobType();

    @GET("GetServiceAdvisors")
    Call<List<ServiceAdvisors>> GetServiceAdvisors(@Field("ID") String ID, @Field("UserName") String UserName);

//    @GET("SaveVehicle")
//    Call<List<SaveVehicle>> SaveVehicle(@Field("vehicleNumber") String vehicleNumber, @Field("makeId") String makeId,
//                                        @Field("modelNumber") String modelNumber, @Field("mobile") String mobile,
//                                        @Field("YearOfManufacture") String YearOfManufacture,
//                                        @Field("divisionName") String divisionName );
}
