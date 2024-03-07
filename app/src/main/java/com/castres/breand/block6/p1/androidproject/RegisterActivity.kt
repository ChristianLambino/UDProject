package com.castres.breand.block6.p1.androidproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.castres.breand.block6.p1.androidproject.dataclass.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerEmail: EditText
    private lateinit var registerName: EditText
    private lateinit var registerPW: EditText
    private lateinit var registerConfirmPW: EditText
    private lateinit var Phone: EditText
    private lateinit var Address: EditText
    private lateinit var registerButton: Button
    private lateinit var loginTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerEmail = findViewById(R.id.registerEmail)
        registerName = findViewById(R.id.registerName)
        registerPW = findViewById(R.id.registerPW)
        registerConfirmPW = findViewById(R.id.registerConfirmPW)
        Phone = findViewById(R.id.Phone)
        Address = findViewById(R.id.Address)
        registerButton = findViewById(R.id.register_Button)
        loginTextView = findViewById(R.id.loginTextView)

        loginTextView.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        registerButton.setOnClickListener {
            val email = registerEmail.text.toString()
            val name = registerName.text.toString()
            val password = registerPW.text.toString()
            val confirmPassword = registerConfirmPW.text.toString()
            val phone = Phone.text.toString()
            val address = Address.text.toString()

            if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (email.isEmpty()) {
                Toast.makeText(this, "Email is Required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (name.isEmpty()) {
                Toast.makeText(this, "Name is Required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (phone.isEmpty()) {
                Toast.makeText(this, "Phone is Required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (address.isEmpty()) {
                Toast.makeText(this, "Address is Required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check email availability before registration
            checkEmailAvailability(email)
        }
    }

    private fun checkEmailAvailability(email: String) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val API = RetrofitInstance.PostAPI(this@RegisterActivity)
                val response = API.checkEmail(email)

                if (response.isSuccessful) {
                    // Email is already in use
                    Toast.makeText(this@RegisterActivity, "Email is already in use", Toast.LENGTH_SHORT).show()
                } else {
                    // Email is available, proceed with registration
                    val userData = User() // You need to fill in the User object with necessary details
                    registerUser(userData)
                }
            } catch (e: Exception) {
                // Handle network errors or other exceptions
                Toast.makeText(this@RegisterActivity, "Failed to check email availability: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun registerUser(userData: User) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val API = RetrofitInstance.PostAPI(this@RegisterActivity)
                val response = API.registerUser(userData)

                if (response.isSuccessful) {
                    // Handle successful registration
                    Toast.makeText(this@RegisterActivity, "Registration successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Handle unsuccessful registration
                    val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                    Toast.makeText(this@RegisterActivity, "Registration failed: $errorMessage", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                // Handle other exceptions
                Toast.makeText(this@RegisterActivity, "Registration failed: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

}