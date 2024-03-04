package com.castres.breand.block6.p1.androidproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.KeyEventDispatcher.Component
import com.castres.breand.block6.p1.androidproject.databinding.ActivityComponentsBinding
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