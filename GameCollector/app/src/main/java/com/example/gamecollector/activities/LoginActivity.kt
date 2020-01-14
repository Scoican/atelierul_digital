package com.example.gamecollector.activities

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.gamecollector.R
import com.example.gamecollector.auth.login.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        val intent = Intent(this, MainMenuActivity::class.java)
        viewModel.loginResult.observe(this, Observer {
            val loginResult = it ?: return@Observer
            if (loginResult is com.example.gamecollector.core.Result.Success) {
                startActivity(intent)
                finish()
            } else if (loginResult is com.example.gamecollector.core.Result.Error) {
                Toast.makeText(this, "Error at login", Toast.LENGTH_SHORT).show()
            }
        })

        sign_in_button_login.setOnClickListener {
            viewModel.login(
                username_input_login.text.toString(),
                password_input_login.text.toString()
            )
        }

        invite_friend_login.setOnClickListener {
            val newIntent = Intent(this, InviteFriendActivity::class.java)
            startActivity(newIntent)
            overridePendingTransition(R.anim.enter_activity, R.anim.exit_activity)
        }

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
    }
}
