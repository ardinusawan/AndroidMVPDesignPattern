package com.example.androidmvplogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.androidmvplogin.Presenter.LoginPresenter
import com.example.androidmvplogin.View.ILoginView
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity(), ILoginView {

    private lateinit var loginPresenter: LoginPresenter

    private lateinit var edtEmail: EditText

    private lateinit var edtPassword: EditText

    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init
        btnLogin = findViewById(R.id.btn_login)
        edtEmail = findViewById(R.id.edt_email)
        edtPassword = findViewById(R.id.edt_password)

        // Init
        loginPresenter = LoginPresenter(this)

        // Event
        btnLogin.setOnClickListener {
            loginPresenter.onLogin(
                edtEmail.text.toString(),
                edtPassword.text.toString()
            )
        }
    }

    override fun onLoginSuccess(message: String) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginError(message: String) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show()
    }
}
