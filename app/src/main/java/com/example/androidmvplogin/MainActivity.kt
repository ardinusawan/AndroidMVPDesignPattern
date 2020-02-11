package com.example.androidmvplogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.androidmvplogin.Presenter.LoginPresenter
import com.example.androidmvplogin.View.ILoginView

class MainActivity : AppCompatActivity(), ILoginView {

    private lateinit var loginPresenter: LoginPresenter

    private lateinit var edt_email: EditText

    private lateinit var edt_password: EditText

    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Init
        btnLogin = findViewById(R.id.btn_login)
        edt_email = findViewById(R.id.edt_email)
        edt_password = findViewById(R.id.edt_password)

        // Init
        loginPresenter = LoginPresenter(this)

        // Event
        btnLogin.setOnClickListener {
            loginPresenter.onLogin(
                edt_email.text.toString(),
                edt_password.text.toString()
            )
        }
    }

    override fun onLoginResult(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
