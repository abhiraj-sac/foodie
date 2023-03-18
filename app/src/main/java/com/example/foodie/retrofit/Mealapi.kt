package com.example.foodie.retrofit

import com.example.foodie.projo.MealList
import retrofit2.Call
import retrofit2.http.GET


interface Mealapi {
    @GET("random.php")
    fun getrandommeal():Call<MealList>
}