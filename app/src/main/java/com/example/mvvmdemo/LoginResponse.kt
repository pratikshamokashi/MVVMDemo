package com.example.mvvmdemo

import com.google.gson.annotations.SerializedName

//@Generated("com.robohorse.robopojogenerator")
data class LoginResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null,

	@field:SerializedName("user_msg")
	val userMsg: String? = null
)