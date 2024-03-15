package com.castres.breand.block6.p1.androidproject.Components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Toast
import com.castres.breand.block6.p1.androidproject.AddToCart.CartManager
import com.castres.breand.block6.p1.androidproject.databinding.ActivityComponentsDetailBinding

class ComponentsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComponentsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComponentsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val componentsID = intent.getIntExtra(COMPONENTS_ID_EXTRA, -1)
        val component = componentFromID(componentsID)
        if (component != null)
        {
            binding.componentsDetailCover.setImageResource(component.componentsCover)
            binding.componentsDetailItemName.text = component.componentsItemName
            binding.componentsDetailPrice.text = component.componentsPrice
            binding.componentsDetailDescription.text = component.componentsDescription
            binding.componentsDetailADC.setImageResource(component.componentsAddToCart)
            // Add click listener to componentsDetailADC
            binding.componentsDetailADC.setOnClickListener {


                // Add the selected item to the cart and show a Toast message
                CartManager.addItemToCart(component)
                // Show a Toast message when clicked
                Toast.makeText(this, "Item Added To Cart", Toast.LENGTH_SHORT).show()

                bounceAnimation(binding.componentsDetailADC)
            }
        }
    }

    private fun bounceAnimation(view: View){
        val bounceAnimation = ScaleAnimation(
            1.0f, 1.2f,  // Start and end values for the X-axis scaling
            1.0f, 1.2f,  // Start and end values for the Y-axis scaling
            Animation.RELATIVE_TO_SELF, 0.5f,  // Pivot point of X scaling
            Animation.RELATIVE_TO_SELF, 0.5f   // Pivot point of Y scaling
        )

        bounceAnimation.duration = 300 // Duration of the animation in milliseconds
        bounceAnimation.repeatMode = Animation.REVERSE // Reverse the animation when it ends
        bounceAnimation.repeatCount = 1 // Number of times to repeat the animation

        view.startAnimation(bounceAnimation)
    }

    private fun componentFromID(componentsID: Int): ComponentsItems?
    {
        for (component in componentsList)
        {
            if (component.id == componentsID)
                return component
        }
        return null
    }
}