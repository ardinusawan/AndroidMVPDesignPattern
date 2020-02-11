package com.example.androidmvplogin.Presenter

import com.example.androidmvplogin.Model.User
import com.example.androidmvplogin.View.ILoginView

class LoginPresenter(private val loginView: ILoginView) : ILoginPresenter {

    override fun onLogin(email: String, password: String) {
        val user = User(email, password)

        when (user.isValidData()) {
            0 -> loginView.onLoginError("You must enter your email")
            1 -> loginView.onLoginError("You must enter valid email")
            2 -> loginView.onLoginError("Password length must be greater than 6")
            else -> loginView.onLoginSuccess("Login Success")
        }
    }
}