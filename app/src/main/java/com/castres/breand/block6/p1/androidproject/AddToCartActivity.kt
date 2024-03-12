package com.castres.breand.block6.p1.androidproject

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
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
        cartItemAdapter = CartItemAdapter(CartManager.getCartItems(), ::onDeleteClickListener, ::onCartItemClick)

        binding.cartRecyclerView.adapter = cartItemAdapter
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(this)

        // Set the adapter reference in CartManager
        CartManager.setAdapter(cartItemAdapter)
    }

    private fun onDeleteClickListener(position: Int) {
        CartManager.removeCartItem(position)
    }

    private fun onCartItemClick(cartItem: CartItem) {
        val intent = Intent(this, AddToCartDetailActivity::class.java)
        intent.putExtra(AddToCartDetailActivity.CART_ITEM_EXTRA, cartItem as Parcelable)
        startActivity(intent)
    }
}


