package com.castres.breand.block6.p1.androidproject

// CartManager.kt

object CartManager {
    private val cartItems: MutableList<CartItem> = mutableListOf()
    private var cartItemAdapter: CartItemAdapter? = null

    fun setAdapter(adapter: CartItemAdapter) {
        cartItemAdapter = adapter
    }

    fun addItemToCart(item: ComponentsItems) {
        val cartItem = CartItem(
            productName = item.componentsItemName,
            productPrice = item.componentsPrice,
            productImageResId = item.componentsCover
            // Add other necessary fields
        )
        cartItems.add(cartItem)
        updateAdapter()
    }

    fun getCartItems(): List<CartItem> {
        return cartItems.toList()
    }

    fun removeCartItem(position: Int) {
        if (position in 0 until cartItems.size) {
            cartItems.removeAt(position)
            updateAdapter()
        }
    }

    private fun updateAdapter() {
        // Notify the adapter that the dataset has changed
        cartItemAdapter?.updateItems(cartItems.toList())
    }
}




