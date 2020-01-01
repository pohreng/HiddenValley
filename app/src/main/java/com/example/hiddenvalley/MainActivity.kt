package com.example.hiddenvalley

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.user_registration.*
import kotlinx.android.synthetic.main.user_registration.pass
import kotlinx.android.synthetic.main.user_registration.username

class  MainActivity : AppCompatActivity() {

    lateinit var handler: AccDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = AccDatabase(this)

        showHome()

        registration_button.setOnClickListener{
            showUserReg()
        }

        login_button.setOnClickListener{
            showLogin()
        }

        back_button.setOnClickListener{
            showHome()
        }

        sign_button.setOnClickListener{
            if(pass.text.toString()==password.text.toString()) {
                handler.insertUserData(username.text.toString(), pass.text.toString())
                showHome()
            }else {
                Toast.makeText(this, "Incorrect Second Password", Toast.LENGTH_SHORT).show()
                showUserReg()
            }
        }

        login.setOnClickListener{
            if(handler.userPresent(login_username.text.toString(),login_pass.text.toString())) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                showHome()
            }
            else {
                Toast.makeText(this, "Username Or Password Incorrect", Toast.LENGTH_SHORT).show()
                showHome()
            }
        }
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
