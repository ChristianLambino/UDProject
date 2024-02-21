package com.castres.breand.block6.p1.androidproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LogInActivity : AppCompatActivity() {

    private lateinit var loginEmail : EditText
    private lateinit var loginPW : EditText
    private lateinit var loginFP : TextView
    private lateinit var loginButton : Button
    private lateinit var loginCA: TextView

    // Sample list to represent registered users
    private val registeredUsers = mutableListOf<User>()

    // Track login attempts
    private var loginAttempts = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        loginEmail = findViewById(R.id.loginEmail)
        loginPW = findViewById(R.id.loginPW)
        loginFP = findViewById(R.id.loginFP)
        loginButton = findViewById(R.id.loginButton)
        loginCA = findViewById(R.id.loginCA)

        // Mock user registration
        // Set click listener for 'Forgot Password' TextView
        loginFP.setOnClickListener {
            // Redirect to ForgotPasswordActivity
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        // Mock user registration
        // For demonstration purposes, add a user to the list
        registeredUsers.add(User("test@example.com", "password"))

        // Set click listener for Login Button
        loginButton.setOnClickListener {
            val enteredEmail = loginEmail.text.toString().trim()
            val enteredPassword = loginPW.text.toString().trim()

            // Check for empty fields
            if (enteredEmail.isEmpty() || enteredPassword.isEmpty()) {
                // TODO: Show prompt for empty fields
                Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Reset login attempts if both email and password are provided
            loginAttempts = 0

            // Check if the entered email and password match a registered user
            val matchedUser = registeredUsers.find { it.email == enteredEmail && it.password == enteredPassword }

            if (matchedUser != null) {
                if (matchedUser != null) {
                    // Login successful, redirect to MainActivity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Finish the login activity to prevent going back to it
                // Login successful, you can proceed to the next activity or perform other actions
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
            } else {
                // Increment login attempts
                loginAttempts++

                // Show a prompt and allow multiple attempts
                Toast.makeText(this, "Invalid Email or Password (Attempt $loginAttempts)", Toast.LENGTH_SHORT).show()
            }
        }

        // Set click listener for 'Create Account' TextView
        loginCA.setOnClickListener {
            // Redirect to register activity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Other setup code...
    }
}

data class User(val email: String, val password: String)}



