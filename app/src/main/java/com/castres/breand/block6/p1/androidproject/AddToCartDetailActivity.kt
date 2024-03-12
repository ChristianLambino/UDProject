package com.castres.breand.block6.p1.androidproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class AddToCartDetailActivity : AppCompatActivity() {

    companion object {
        const val CART_ITEM_EXTRA = "CART_ITEM_EXTRA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_cart_detail)

        val cartItem = intent.getParcelableExtra<CartItem>(CART_ITEM_EXTRA)
        // Use the cartItem as needed
    }
}