package com.castres.breand.block6.p1.androidproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.castres.breand.block6.p1.androidproject.dataclass.LoginResponse
import com.castres.breand.block6.p1.androidproject.dataclass.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInActivity : AppCompatActivity() {

    private lateinit var loginEmail: EditText
    private lateinit var loginPW: EditText
    private lateinit var loginFP: TextView
    private lateinit var loginButton: Button
    private lateinit var loginCA: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        loginEmail = findViewById(R.id.loginEmail)
        loginPW = findViewById(R.id.loginPW)
        loginFP = findViewById(R.id.loginFP)
        loginButton = findViewById(R.id.loginButton)
        loginCA = findViewById(R.id.loginCA)

        // Set click listener for 'Forgot Password' TextView
        loginFP.setOnClickListener {
            // Redirect to ForgotPasswordActivity
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        // Set click listener for 'Create Account' TextView
        loginCA.setOnClickListener {
            // Redirect to register activity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Set click listener for Login Button
        loginButton.setOnClickListener {
            val enteredEmail = loginEmail.text.toString().trim()
            val enteredPassword = loginPW.text.toString().trim()

            // Check for empty fields
            if (enteredEmail.isEmpty() || enteredPassword.isEmpty()) {
                Toast.makeText(this, "Email or Password is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                // Perform login operation
                loginUser()
            }
        }
    }

    private fun loginUser() {
       val user = User()
        val API = RetrofitInstance.getAPI(this)


        API.userLogin(user).enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>){
                val loginResponse= response.body()
                if (response.isSuccessful && loginResponse != null){
                    val token= loginResponse.token
                    RetrofitInstance.saveToken(this@LogInActivity, token)

                    Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_SHORT)
                        .show()
                    val intent = Intent(applicationContext,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(applicationContext,"Login Failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(applicationContext,"Network Error, Please Try Again",Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}


