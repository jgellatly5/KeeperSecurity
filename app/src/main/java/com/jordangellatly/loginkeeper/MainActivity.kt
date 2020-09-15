package com.jordangellatly.loginkeeper

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spannable = SpannableString(getString(R.string.account_creation_prompt))
        spannable.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.yellow)),
            23,
            29,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tv_create_account.text = spannable

        btn_login.setOnClickListener {
            if (checkIfEmailIsValid() && checkPasswordLength()) {
                Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkIfEmailIsValid(): Boolean {
        val email: String = et_email.text.toString().trim()
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return if (email.matches(emailPattern.toRegex()) && email.isNotEmpty()) {
            email_label.text = "Email"
            email_label.setTextColor(Color.BLACK)
            check_icon_email.visibility = View.VISIBLE
            true
        } else {
            email_label.text = "This is not a valid email address. Please try again."
            email_label.setTextColor(Color.RED)
            check_icon_email.visibility = View.INVISIBLE
            false
        }
    }

    private fun checkPasswordLength(): Boolean {
        val password: String = et_password.text.toString()
        return if (password.length >= 6) {
            password_label.text = "Master Password"
            password_label.setTextColor(Color.BLACK)
            check_icon_password.visibility = View.VISIBLE
            true
        } else {
            password_label.text = "Password must be at least 6 characters long. Please try again."
            password_label.setTextColor(Color.RED)
            check_icon_password.visibility = View.INVISIBLE
            false
        }
    }
}