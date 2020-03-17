package com.ibnuputra.zipaytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.number_checker
import kotlin.math.sign

class SignUpActivity : AppCompatActivity() {
    private lateinit var inputPhone: EditText
    private lateinit var inputPass: EditText
    private lateinit var phoneChecker: ImageView
    private lateinit var passChecker: ImageView
    private var validateName = 0
    private var validateEmail = 0
    private var validatePhone = 0
    private var validatePass = 0
    private var validateRef = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        inputPass = findViewById(R.id.pass_input)
        inputPhone = findViewById(R.id.phone_input)
        phoneChecker = findViewById(R.id.number_checker)
        passChecker = findViewById(R.id.password_checker)

        val coloredText = "<font color=#616161>By tapping on 'CREATE', you agree to the </font> <font color=#1e88e5>Terms of Use and Privacy Policy</font>"
        zippayTv.text = Html.fromHtml(coloredText)

        signup_btn.isEnabled = false

        checker()

        goBack.setOnClickListener {
            onBackPressed()
            finish()
        }
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
                        fullname_layout.background = resources.getDrawable(R.drawable.bordered_bg_green)
                        validateName = 1
                        validate()
                    }
                    s.length < 12 -> {
                        name_checker.setImageResource(R.drawable.ic_input_wrong)
                        fullname_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        name_checker.visibility = View.VISIBLE
                        validateName = 0
                        validate()
                    }
                    s.isEmpty()-> {
                        number_checker.visibility = View.INVISIBLE
                        fullname_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        validateName = 0
                        validate()
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
                        email_layout.background = resources.getDrawable(R.drawable.bordered_bg_green)
                        validateEmail = 1
                        validate()
                    }
                    s.length < 12 -> {
                        email_checker.setImageResource(R.drawable.ic_input_wrong)
                        email_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        email_checker.visibility = View.VISIBLE
                        validateEmail = 0
                        validate()
                    }
                    s.isEmpty()-> {
                        email_checker.visibility = View.INVISIBLE
                        email_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        validateEmail = 0
                        validate()
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
                        phone_layout.background = resources.getDrawable(R.drawable.bordered_bg_green)
                        validatePhone = 1
                        validate()
                    }
                    s.length < 12 -> {
                        phoneChecker.setImageResource(R.drawable.ic_input_wrong)
                        phone_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        phoneChecker.visibility = View.VISIBLE
                        validatePhone = 1
                        validate()
                    }
                    s.isEmpty()-> {
                        phoneChecker.visibility = View.INVISIBLE
                        phone_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        validatePhone = 1
                        validate()
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
                        password_layout.background = resources.getDrawable(R.drawable.bordered_bg_green)
                        validatePass = 1
                        validate()
                    }
                    s.length<6 -> {
                        passChecker.setImageResource(R.drawable.ic_input_wrong)
                        passChecker.visibility = View.VISIBLE
                        password_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        validatePass = 0
                        validate()
                    }
                    s.isEmpty() -> {
                        passChecker.visibility = View.VISIBLE
                        password_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        validatePass = 0
                        validate()
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
                        referal_layout.background = resources.getDrawable(R.drawable.bordered_bg_green)
                        validateRef = 1
                        validate()
                    }
                    s.length < 6 -> {
                        referal_checker.setImageResource(R.drawable.ic_input_wrong)
                        referal_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        referal_checker.visibility = View.VISIBLE
                        validateRef = 0
                        validate()
                    }
                    s.isEmpty()-> {
                        referal_checker.visibility = View.INVISIBLE
                        referal_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        validateRef = 0
                        validate()
                    }
                }
            }
        })
    }

    private fun validate(){
        if (validateName == 1 && validateEmail == 1 && validatePhone == 1 && validatePass == 1 && validateRef == 1){
            signup_btn.isEnabled = true
            signup_btn.setCardBackgroundColor(resources.getColor(R.color.colorOrange))
            signup_btn.setOnClickListener {
                onBackPressed()
                finish()
            }
        }else{
            signup_btn.isEnabled = false
            signup_btn.setCardBackgroundColor(resources.getColor(R.color.colorDarkGray))
        }
    }
}
