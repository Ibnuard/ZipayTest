package com.ibnuputra.zipaytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.number_checker

class SignUpActivity : AppCompatActivity() {
    private lateinit var inputPhone: EditText
    private lateinit var inputPass: EditText
    private lateinit var phoneChecker: ImageView
    private lateinit var passChecker: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        inputPass = findViewById(R.id.pass_input)
        inputPhone = findViewById(R.id.phone_input)
        phoneChecker = findViewById(R.id.number_checker)
        passChecker = findViewById(R.id.password_checker)

        val coloredText = "<font color=#616161>By tapping on 'CREATE', you agree to the </font> <font color=#1e88e5>Terms of Use and Privacy Policy</font>"
        zippayTv.text = Html.fromHtml(coloredText)

        checker()
    }

    private fun checker() {
        fullname_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

            }
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ){}
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                when {
                    s.length == 12 -> {
                        name_checker.setImageResource(R.drawable.ic_check_true)
                        name_checker.visibility = View.VISIBLE
                        //input_phone_layout.background = resources.getDrawable(R.drawable.bordered_bg_green)
                    }
                    s.length < 12 -> {
                        name_checker.setImageResource(R.drawable.ic_input_wrong)
                        //input_phone_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        name_checker.visibility = View.VISIBLE
                    }
                    s.isEmpty()-> {
                        number_checker.visibility = View.INVISIBLE
                        //input_phone_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                    }
                }
            }
        })


        email_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

            }
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ){}
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                when {
                    s.length == 12 -> {
                        email_checker.setImageResource(R.drawable.ic_check_true)
                        email_checker.visibility = View.VISIBLE
                        //input_phone_layout.background = resources.getDrawable(R.drawable.bordered_bg_green)
                    }
                    s.length < 12 -> {
                        email_checker.setImageResource(R.drawable.ic_input_wrong)
                        //input_phone_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        email_checker.visibility = View.VISIBLE
                    }
                    s.isEmpty()-> {
                        email_checker.visibility = View.INVISIBLE
                        //input_phone_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                    }
                }
            }
        })

        inputPhone.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

            }
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ){}
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                when {
                    s.length == 12 -> {
                        phoneChecker.setImageResource(R.drawable.ic_check_true)
                        phoneChecker.visibility = View.VISIBLE
                        //input_phone_layout.background = resources.getDrawable(R.drawable.bordered_bg_green)
                    }
                    s.length < 12 -> {
                        phoneChecker.setImageResource(R.drawable.ic_input_wrong)
                        //input_phone_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        phoneChecker.visibility = View.VISIBLE
                    }
                    s.isEmpty()-> {
                        phoneChecker.visibility = View.INVISIBLE
                        //input_phone_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                    }
                }
            }
        })

        inputPass.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ){}
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                when {
                    s.length >= 6 -> {
                        passChecker.setImageResource(R.drawable.ic_check_true)
                        passChecker.visibility = View.VISIBLE
                        //input_pass_layout.background = resources.getDrawable(R.drawable.bordered_bg_green)
                    }
                    s.length<6 -> {
                        passChecker.setImageResource(R.drawable.ic_input_wrong)
                        passChecker.visibility = View.VISIBLE
                        //input_pass_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                    }
                    s.isEmpty() -> {
                        passChecker.visibility = View.VISIBLE
                        //input_pass_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                    }
                }
            }
        })


        referal_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

            }
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ){}
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                when {
                    s.length == 6 -> {
                        referal_checker.setImageResource(R.drawable.ic_check_true)
                        referal_checker.visibility = View.VISIBLE
                        //input_phone_layout.background = resources.getDrawable(R.drawable.bordered_bg_green)
                    }
                    s.length < 6 -> {
                        referal_checker.setImageResource(R.drawable.ic_input_wrong)
                        //input_phone_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        referal_checker.visibility = View.VISIBLE
                    }
                    s.isEmpty()-> {
                        referal_checker.visibility = View.INVISIBLE
                        //input_phone_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                    }
                }
            }
        })
    }
}
