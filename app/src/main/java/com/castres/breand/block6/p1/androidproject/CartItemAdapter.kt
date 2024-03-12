package com.castres.breand.block6.p1.androidproject

// CartItemAdapter.kt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartItemAdapter(
    private var cartItems: List<CartItem>,
    private val onDeleteClickListener: (position: Int) -> Unit,
    private val onCartItemClickListener: (CartItem) -> Unit
) : RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder>() {

    inner class CartItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewProduct: ImageView = itemView.findViewById(R.id.imageViewProduct)
        val textViewProductName: TextView = itemView.findViewById(R.id.textViewProductName)
        val textViewProductPrice: TextView = itemView.findViewById(R.id.textViewProductPrice)
        val btnDelete: ImageButton = itemView.findViewById(R.id.btnDelete)

        init {
            itemView.setOnClickListener { onCartItemClickListener.invoke(cartItems[adapterPosition]) }
            btnDelete.setOnClickListener { onDeleteClickListener.invoke(adapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return CartItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        val currentItem = cartItems[position]

        holder.imageViewProduct.setImageResource(currentItem.productImageResId)
        holder.textViewProductName.text = currentItem.productName
        holder.textViewProductPrice.text = currentItem.productPrice
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    fun updateItems(newCartItems: List<CartItem>) {
        cartItems = newCartItems
        notifyDataSetChanged()
    }
}