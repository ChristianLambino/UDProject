package com.castres.breand.block6.p1.androidproject.Components

import androidx.recyclerview.widget.RecyclerView
import com.castres.breand.block6.p1.androidproject.databinding.ComponentsCardcellBinding

class ComponentsCardViewHolder (
    private val componentsCardcellBinding: ComponentsCardcellBinding,
    private val clickListener: ComponentsClickListener
): RecyclerView.ViewHolder(componentsCardcellBinding.root)
{
    fun bindComponentsItems(componentsItems: ComponentsItems){

        componentsCardcellBinding.componentsCover.setImageResource(componentsItems.componentsCover)
        componentsCardcellBinding.componentsItemName.text = componentsItems.componentsItemName
        componentsCardcellBinding.componentsPrice.text = componentsItems.componentsPrice

        componentsCardcellBinding.componentsCV.setOnClickListener {
            clickListener.onClick(componentsItems)
        }
    }
}