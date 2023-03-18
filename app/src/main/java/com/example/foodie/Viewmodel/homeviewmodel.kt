package com.example.foodie.Viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.foodie.projo.Meal
import com.example.foodie.projo.MealList
import com.example.foodie.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class homeviewmodel:ViewModel() {
    private val randomMealLiveData = MutableLiveData<Meal>()

    fun getrandommeal(){
        RetrofitInstance.api.getrandommeal().enqueue(object : Callback<MealList> {
            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                if(response.body() != null){
                    val randommeal: Meal = response.body()!!.meals[0]
                    Log.d("test" , "${randommeal.idMeal} and ${randommeal.strArea}")
             randomMealLiveData.value = randommeal
                }
                else{
                    return
                }
            }

            override fun onFailure(call: Call<MealList>, t: Throwable) {
                Log.d("failed" , t.message.toString())
            }

        })
    }
    fun ObserverandommealLivedata() : LiveData<Meal>{
        return randomMealLiveData
    }
}