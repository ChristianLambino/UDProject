package com.castres.breand.block6.p1.androidproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
                // Show a Toast message when clicked
                Toast.makeText(this, "Item Added To Cart", Toast.LENGTH_SHORT).show()
            }

        }
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