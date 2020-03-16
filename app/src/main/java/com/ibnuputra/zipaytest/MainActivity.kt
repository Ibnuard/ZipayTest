package com.ibnuputra.zipaytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)

        /*val bottomNavDestination = setOf(
            R.id.navigate_home, R.id.navigate_history
        )*/

        bottomNavView.setupWithNavController(navController)

        bottomNavView.itemIconTintList = null
    }
}
