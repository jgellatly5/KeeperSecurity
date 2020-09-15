package com.jordangellatly.loginkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
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
    }
}