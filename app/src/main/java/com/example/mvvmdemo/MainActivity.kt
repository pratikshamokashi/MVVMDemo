package com.example.mvvmdemo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity<LoginViewModel>() {
    lateinit var viewModel: LoginViewModel

    override var getLayout = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout)


        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        viewModel.Response().observe(this, Observer<LoginResponse>
        {
            if (it!=null)
            {
                Toast.makeText(this,it.userMsg,Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
            }
        })
        btnLogin.setOnClickListener {
            if(viewModel.checkValidation(et_username.text.toString(),et_password.text.toString()))
            {
                viewModel.login(et_username.text.toString(),et_password.text.toString())
                showMessage("Sucessfully")
                val intent = Intent(this,Main2Activity::class.java)
                startActivity(intent)
            }
            else
            {
                showMessage("Failed")
            }
        }

    }
}
