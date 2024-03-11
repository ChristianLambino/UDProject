package com.castres.breand.block6.p1.androidproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(private val cartItems: List<CartItem>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productNameTextView: TextView = itemView.findViewById(R.id.textViewProductName)
        val productPriceTextView: TextView = itemView.findViewById(R.id.textViewProductPrice)
        // Add other necessary views
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return CartViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val currentItem = cartItems[position]
        holder.productNameTextView.text = currentItem.productName
        holder.productPriceTextView.text = currentItem.productPrice
        // Bind other necessary data
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }
}
