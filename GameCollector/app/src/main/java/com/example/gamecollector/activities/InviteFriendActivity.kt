package com.example.gamecollector.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.gamecollector.R
import kotlinx.android.synthetic.main.activity_invite_friend.*


class InviteFriendActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invite_friend)

        sign_up_button_register.setOnClickListener {
            sendMail()
        }

        login_in_register.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.up_to_down_animation, R.anim.down_to_up_animation)
        }

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
    }

    private fun sendMail() {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:") // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email_input_register.text.toString()))
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject here")
        intent.putExtra(Intent.EXTRA_TEXT, "Body Here")
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
        TODO("Create a correct e-mail body and subject")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.up_to_down_animation, R.anim.down_to_up_animation)
    }
}