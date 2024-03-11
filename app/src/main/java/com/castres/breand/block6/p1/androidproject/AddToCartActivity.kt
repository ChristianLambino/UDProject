package com.castres.breand.block6.p1.androidproject

// AddToCartActivity.kt

// AddToCartActivity.kt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.castres.breand.block6.p1.androidproject.databinding.ActivityAddToCartBinding

class AddToCartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddToCartBinding
    private lateinit var cartItemAdapter: CartItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddToCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create a RecyclerView adapter and set it up
        cartItemAdapter = CartItemAdapter(CartManager.getCartItems()) { position ->
            // Handle delete item action here
            CartManager.removeCartItem(position)
        }

        binding.cartRecyclerView.adapter = cartItemAdapter
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(this)

        // Set the adapter reference in CartManager
        CartManager.setAdapter(cartItemAdapter)
    }
}

