package com.ibnuputra.zipaytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        voucher_input.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                //
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0!!.length == 8){
                    minval.visibility = View.VISIBLE
                }else{
                    minval.visibility = View.GONE
                }
            }

        })


        goBack.setOnClickListener {
            onBackPressed()
            finish()
        }
    }
}
