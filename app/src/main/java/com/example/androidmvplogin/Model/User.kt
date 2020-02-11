package com.example.androidmvplogin.Model

import android.text.TextUtils
import android.util.Patterns

class User(private val email: String, private val password: String) : IUser {
    override fun getEmail(): String = email

    override fun getPassword(): String = password

    override fun isValidData(): Boolean {
        return !TextUtils.isEmpty(getEmail()) && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() &&
                getPassword().length > 6
    }
}