package com.castres.breand.block6.p1.androidproject

import androidx.recyclerview.widget.RecyclerView
import com.castres.breand.block6.p1.androidproject.databinding.CardcellBinding

class NewArrCardViewHolder (
    private val cardcellBinding: CardcellBinding
) : RecyclerView.ViewHolder(cardcellBinding.root)
{
    fun bindNewArrItems(newArrItems: NewArrItems)
    {
        cardcellBinding.ccCover.setImageResource(newArrItems.cover)
        cardcellBinding.ccItemName.text = newArrItems.itemName
        cardcellBinding.ccPrice.text = newArrItems.itemPrice

    }
}