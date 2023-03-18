package com.example.foodie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.foodie.R
import com.example.foodie.Viewmodel.homeviewmodel
import com.example.foodie.databinding.FragmentHomefragmentBinding
import com.example.foodie.projo.Meal
import com.example.foodie.projo.MealList
import com.example.foodie.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Homefragment : Fragment() {
private lateinit var binding:FragmentHomefragmentBinding
private lateinit var homemvvm:homeviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
homemvvm = ViewModelProvider(this)[homeviewmodel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomefragmentBinding.inflate(inflater ,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      homemvvm.getrandommeal()
        Observerandommeal()
    }

    private fun Observerandommeal(){
    homemvvm.ObserverandommealLivedata().observe(viewLifecycleOwner,object:Observer<Meal>{
        override fun onChanged(value: Meal) {
            Glide.with(this@Homefragment)
                .load(value.strMealThumb)
                .into(binding.imgrandommeal)

        }

    })
    }

}