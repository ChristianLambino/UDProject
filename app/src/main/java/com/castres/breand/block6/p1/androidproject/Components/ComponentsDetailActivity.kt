package com.castres.breand.block6.p1.androidproject.Components

import ItemRequest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.castres.breand.block6.p1.androidproject.AddToCart.AddToCartActivity
import com.castres.breand.block6.p1.androidproject.AddToCart.CartManager
import com.castres.breand.block6.p1.androidproject.RetrofitInstance
import com.castres.breand.block6.p1.androidproject.data.model.modeling.API
import com.castres.breand.block6.p1.androidproject.databinding.ActivityComponentsDetailBinding
import kotlinx.coroutines.launch

class ComponentsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComponentsDetailBinding
    private lateinit var api: API
    private lateinit var component: ComponentsDetailItems

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComponentsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize API instance using RetrofitInstance
        api = RetrofitInstance.getComp(this)

        // Retrieve the component ID from the intent extras

        // Fetch component details using the ID
        fetchComponentDetails()


    }

    private fun fetchComponentDetails() {
        lifecycleScope.launch {
            try {
                // Make the network request to fetch component details by ID
                val response = api.getComponentDetails()
                if (response.isSuccessful) {
                    val component = response.body()
                    component?.let {
                        displayComponentDetails(component)

                    }
                } else {
                    // Handle unsuccessful response
                }
            } catch (e: Exception) {
                // Handle failure
            }
        }
    }

    private fun displayComponentDetails(component: ComponentsDetailItems) {
        this.component = component
// Load the image using Glide
        Glide.with(binding.root)
            .load(component.image) // Assuming component.image is a URL or a string representing an image resource
            .into(binding.componentsDetailCover)

        binding.componentsDetailItemName.text = component.prod_name
        binding.componentsDetailPrice.text = component.price.toString()
        binding.componentsDetailDescription.text = component.description
        binding.componentsDetailADC

        binding.componentsDetailADC.setOnClickListener {
            addToCart(component)
        }
    }

    private fun addToCart(component: ComponentsDetailItems) {
        val itemRequest = ItemRequest(
            prod_name = component.prod_name ?: "",
            description = component.description ?: "",
            price = component.price ?: "0",
            image = component.image ?: "",
            category = component.category ?: "",
            id = component.id ?: -1
        )

        lifecycleScope.launch {
            try {
                val response = api.addToCart(itemRequest)
                if (response.isSuccessful) {
                    redirectToCart()
                } else {
                    Log.e("ComponentDetailActivity", "Add to Cart Failed: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("ComponentDetailActivity", "Error fetching Component", e)
            }
        }
    }



    fun redirectToCart(view: View? = null) {
        val intent = Intent(this, AddToCartActivity::class.java)
        startActivity(intent)
    }


}