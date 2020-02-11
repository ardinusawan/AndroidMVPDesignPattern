package com.example.androidmvplogin.Presenter

import com.example.androidmvplogin.Model.User
import com.example.androidmvplogin.View.ILoginView

class LoginPresenter(private val loginView: ILoginView) : ILoginPresenter {

    override fun onLogin(email: String, password: String) {
        val user = User(email, password)
        val isLoginSuccess: Boolean = user.isValidData()

        if (isLoginSuccess)
            loginView.onLoginResult("Login success")
        else
            loginView.onLoginResult("Login error")
    }
}