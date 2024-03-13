package com.castres.breand.block6.p1.androidproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


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
        }
    }
}