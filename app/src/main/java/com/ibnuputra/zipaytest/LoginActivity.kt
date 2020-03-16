package com.ibnuputra.zipaytest

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    private lateinit var inputPhone: EditText
    private lateinit var inputPass: EditText
    private lateinit var loginBtn: CardView
    private var pns: Int = 0
    private var pss: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        inputPhone = findViewById(R.id.phone_input)
        inputPass = findViewById(R.id.pass_input)
        loginBtn = findViewById(R.id.login_button)

        loginState()

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
                        number_checker.setImageResource(R.drawable.ic_check_true)
                        number_checker.visibility = View.VISIBLE
                        input_phone_layout.background = resources.getDrawable(R.drawable.bordered_bg_green)
                        pss = 1
                        loginState()
                    }
                    s.length < 12 -> {
                        number_checker.setImageResource(R.drawable.ic_input_wrong)
                        input_phone_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        number_checker.visibility = View.VISIBLE
                        pss = 0
                        loginState()
                    }
                    s.isEmpty()-> {
                        number_checker.visibility = View.INVISIBLE
                        input_phone_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        pss = 0
                        loginState()
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
                        password_checker.setImageResource(R.drawable.ic_check_true)
                        password_checker.visibility = View.VISIBLE
                        input_pass_layout.background = resources.getDrawable(R.drawable.bordered_bg_green)
                        pns = 1
                        loginState()
                    }
                    s.length<6 -> {
                        password_checker.setImageResource(R.drawable.ic_input_wrong)
                        password_checker.visibility = View.VISIBLE
                        input_pass_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        pns = 0
                        loginState()
                    }
                    s.isEmpty() -> {
                        password_checker.visibility = View.VISIBLE
                        input_pass_layout.background = resources.getDrawable(R.drawable.bordered_bg)
                        pns = 0
                        loginState()
                    }
                }
            }
        })
    }

    fun loginState(){
        if (pns == 1 && pss == 1){
            loginBtn.setCardBackgroundColor(resources.getColor(R.color.colorOrange))
            loginBtn.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }else{
            loginBtn.isClickable = false
            loginBtn.setCardBackgroundColor(resources.getColor(R.color.colorDarkGray))
        }

    }
}
