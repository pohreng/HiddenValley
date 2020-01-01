package com.example.hiddenvalley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.signup.*
import java.sql.DatabaseMetaData

class MainActivity : AppCompatActivity() {

    lateinit var handler: AccDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = AccDatabase(this)


        /*sign.setOnClickListener{
            showSignUp()
        }*/

        /*save.setOnClickListener{}{
            handler.insertUserData(username.text.toString(),pass.text.toString())
        }*/
    }

    private fun showUserReg(){
        registration_layout.visibility=View.VISIBLE
        login_layout.visibility=View.GONE
        main123.visibility=View.GONE
    }
    private fun showLogin(){
        registration_layout.visibility=View.GONE
        login_layout.visibility=View.VISIBLE
        main123.visibility=View.GONE
    }
    private fun showHome(){
        registration_layout.visibility=View.GONE
        login_layout.visibility=View.GONE
        main123.visibility=View.VISIBLE
    }
}
