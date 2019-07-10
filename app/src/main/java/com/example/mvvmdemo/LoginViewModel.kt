package com.example.mvvmdemo

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.text.TextUtils
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

open class LoginViewModel:ViewModel() {
   val api = ApiClient.getClient().create(ApiInterface::class.java)

    fun checkValidation(email: String, password: String): Boolean {
        return !(TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
    }
    val loginData:MutableLiveData<LoginResponse> = MutableLiveData<LoginResponse>()

    fun Response():MutableLiveData<LoginResponse> = loginData

    fun login(email:String,password: String)
    {
        api.login(email, password).enqueue(object :retrofit2.Callback<LoginResponse>{
            override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                loginData.postValue(null)
            }

            override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {
                loginData.postValue(response?.body())
            }
        })
    }
}