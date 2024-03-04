package com.castres.breand.block6.p1.androidproject

import androidx.recyclerview.widget.RecyclerView
import com.castres.breand.block6.p1.androidproject.databinding.PartnershipsCardcellBinding

class PartnershipsCardViewHolder (
    private val partnershipsCardCellBinding: PartnershipsCardcellBinding,
    private val partnershipsClickListener: PartnershipsClickListener
):RecyclerView.ViewHolder(partnershipsCardCellBinding.root){
    fun bindPartnershipsItems(partnershipsItems: PartnershipsItems){
        partnershipsCardCellBinding.partnershipsCover.setImageResource(partnershipsItems.partnershipsCover)
        partnershipsCardCellBinding.partnershipsItemName.text = partnershipsItems.partnershipsItemName
        partnershipsCardCellBinding.partnershipsPrice.text = partnershipsItems.partnershipsPrice

        partnershipsCardCellBinding.partnershipsCV.setOnClickListener{
            partnershipsClickListener.onClick(partnershipsItems)
        }

    }

}