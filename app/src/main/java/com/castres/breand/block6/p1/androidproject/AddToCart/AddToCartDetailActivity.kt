package com.castres.breand.block6.p1.androidproject.AddToCart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import com.castres.breand.block6.p1.androidproject.R


class AddToCartDetailActivity : AppCompatActivity() {

    companion object {
        const val CART_ITEM_EXTRA = "CART_ITEM_EXTRA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_cart_detail)

        val cartItem = intent.getParcelableExtra<CartItem>(CART_ITEM_EXTRA)
        if (cartItem != null) {
            // Bind the data to the views in your layout
            // Example:
            findViewById<ImageView>(R.id.imageViewProductDetail).setImageResource(cartItem.productImageResId)
            findViewById<TextView>(R.id.textViewProductNameDetail).text = cartItem.productName
            findViewById<TextView>(R.id.textViewProductPriceDetail).text = cartItem.productPrice
            findViewById<TextView>(R.id.textViewProductDescription).text = cartItem.productDescription
            // Bind other views as needed

            // Set the initial value of the NumberPicker to 0
            val numberPickerQuantity = findViewById<NumberPicker>(R.id.numberPickerQuantity)
            numberPickerQuantity.minValue = 1
            numberPickerQuantity.maxValue = 10
            numberPickerQuantity.value = 1
        }

        // Find the Order Now button and set an OnClickListener
        val orderButton = findViewById<Button>(R.id.buttonOrder)
        orderButton.setOnClickListener {
            // Validate address and phone number fields
            val addressEditText = findViewById<EditText>(R.id.editTextAddress)
            val phoneNumberEditText = findViewById<EditText>(R.id.editTextPhoneNumber)
            val address = addressEditText.text.toString().trim()
            val phoneNumber = phoneNumberEditText.text.toString().trim()

            if (address.isEmpty() || phoneNumber.isEmpty()) {
                // Show a toast message if any of the fields is empty
                Toast.makeText(this, "Please fill the necessary fields", Toast.LENGTH_SHORT).show()
            } else {
                // Show a toast message if the fields are properly filled
                Toast.makeText(this, "Your order has been processed. Please check your email for appointment.", Toast.LENGTH_LONG).show()
            }
        }
    }
}