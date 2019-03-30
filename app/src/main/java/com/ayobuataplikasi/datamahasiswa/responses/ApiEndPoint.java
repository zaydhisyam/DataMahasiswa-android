package com.ayobuataplikasi.datamahasiswa.responses;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiEndPoint {

    @FormUrlEncoded
    @POST("read_all.php")
    Call<ReadResponse> readAllRequest(@Field("key") String key);

    @FormUrlEncoded
    @POST("read.php")
    Call<ReadResponse> readRequest(@Field("key") String key,
                                   @Field("nim") String nim);

    @FormUrlEncoded
    @POST("create.php")
    Call<ReadResponse> createRequest(@Field("key") String key,
                                     @Field("nim") String nim,
                                     @Field("nama") String nama,
                                     @Field("fakultas") String fakultas,
                                     @Field("jurusan") String jurusan,
                                     @Field("prodi") String prodi,
                                     @Field("seleksi") String seleksi);

    @FormUrlEncoded
    @POST("update.php")
    Call<ReadResponse> updateRequest(@Field("key") String key,
                                     @Field("nim") String nim,
                                     @Field("nama") String nama,
                                     @Field("fakultas") String fakultas,
                                     @Field("jurusan") String jurusan,
                                     @Field("prodi") String prodi,
                                     @Field("seleksi") String seleksi);

    @FormUrlEncoded
    @POST("delete.php")
    Call<ReadResponse> deleteRequest(@Field("key") String key,
                                     @Field("nim") String nim);

}
