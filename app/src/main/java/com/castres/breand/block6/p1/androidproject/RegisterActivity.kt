package com.castres.breand.block6.p1.androidproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerEmail: EditText
    private lateinit var registerName: EditText
    private lateinit var registerPW: EditText
    private lateinit var registerConfirmPW: EditText
    private lateinit var registerButton: Button
    private lateinit var loginTextView: TextView

    // Sample list to represent registered users
    private val registeredUsers = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerEmail  = findViewById(R.id.registerEmail)
        registerName  = findViewById(R.id.registerName)
        registerPW  = findViewById(R.id.registerPW)
        registerConfirmPW  = findViewById(R.id.registerConfirmPW)
        registerButton = findViewById(R.id.register_Button)
        loginTextView  = findViewById(R.id.loginTextView)

        loginTextView.setOnClickListener{
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        registerButton.setOnClickListener{
            // Check if passwords match
            val password = registerPW.text.toString()
            val confirmPassword = registerConfirmPW.text.toString()

            if (password == confirmPassword) {
                // Passwords match, check if the user is already registered
                if (registeredUsers.contains(registerEmail.text.toString())) {
                    // User is already registered, show a prompt
                    Toast.makeText(this, "User already registered", Toast.LENGTH_SHORT).show()
                } else {
                    // User is not registered, proceed with signup logic
                    // Access entered values using emailEditText.text.toString(), nameEditText.text.toString(), etc.
                    registeredUsers.add(registerEmail.text.toString())
                    // Optionally, you can show a success prompt or navigate to another screen
                    Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Passwords don't match, show a prompt
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            }
        }

        // Other setup code...
    }
}