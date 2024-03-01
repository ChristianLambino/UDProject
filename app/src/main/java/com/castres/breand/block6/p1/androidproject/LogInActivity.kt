package com.castres.breand.block6.p1.androidproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.castres.breand.block6.p1.androidproject.dataclass.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
        // Create an instance of the ApiService using RetrofitInstance
        val apiService = RetrofitInstance.api

        val requestCall = apiService.userLogin()

        // Make the API call in a coroutine
        lifecycleScope.launch(Dispatchers.Main) {
            try {
                // Call the userLogin function with the user object
                val response = withContext(Dispatchers.IO) {
                    requestCall.enqueue(object : Callback<User> {
                        override fun onResponse(call: Call<User>, response: Response<User>) {
                            if (response.isSuccessful) {
                                // Handle successful login
                                val loggedInUser = response.body()
                                // You can use the loggedInUser object here
                                Toast.makeText(this@LogInActivity, "Login successful", Toast.LENGTH_SHORT).show()

                                // Optionally, navigate to another activity after registration
                                val intent = Intent(this@LogInActivity, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                // Handle login failure (e.g., invalid credentials)
                                Toast.makeText(this@LogInActivity, "Login failed: ${response.message()}", Toast.LENGTH_SHORT).show()
                            }
                        }

                        override fun onFailure(call: Call<User>, t: Throwable) {
                            // Handle network or other errors
                            Toast.makeText(this@LogInActivity, "Login failed: ${t.message}", Toast.LENGTH_SHORT).show()
                        }
                    })
                }
            } catch (e: Exception) {
                // Handle exceptions
                Toast.makeText(this@LogInActivity, "Login failed: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


