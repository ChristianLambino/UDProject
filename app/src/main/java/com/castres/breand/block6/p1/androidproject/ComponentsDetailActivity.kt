package com.castres.breand.block6.p1.androidproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

            //redirects to add to cart activity
           binding.componentsDetailADC.setOnClickListener{
               redirectToCart()
           }

        }
    }

    private fun redirectToCart(){
        val intent = Intent(this,AddToCartActivity::class.java)
        startActivity(intent)
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