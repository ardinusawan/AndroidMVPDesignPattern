package com.example.androidmvplogin.Model

import android.text.TextUtils
import android.util.Patterns

class User(private val email: String, private val password: String) : IUser {
    override fun getEmail(): String = email

    override fun getPassword(): String = password

    override fun isValidData(): Int {
        return if(TextUtils.isEmpty(getEmail())) 0
        else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()) 1
        else if(getPassword().length <= 6) 2
        else -1
    }
}