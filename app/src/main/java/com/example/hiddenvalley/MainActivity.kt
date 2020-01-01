package com.example.hiddenvalley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.signup.*
import java.sql.DatabaseMetaData

class MainActivity : AppCompatActivity() {

    lateinit var handler: AccDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        handler = AccDatabase(this)


        /*sign.setOnClickListener{
            showSignUp()
        }*/

        /*save.setOnClickListener{}{
            handler.insertUserData(username.text.toString(),pass.text.toString())
        }*/
    }

    private fun showSignUp(){
        sign.visibility= View.VISIBLE
        sign.visibility= View.GONE
    }

}
