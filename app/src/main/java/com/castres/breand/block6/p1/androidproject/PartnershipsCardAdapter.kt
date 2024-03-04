package com.castres.breand.block6.p1.androidproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.castres.breand.block6.p1.androidproject.databinding.PartnershipsCardcellBinding

class PartnershipsCardAdapter (
    private val partnershipsItems: List<PartnershipsItems>,
    private val partnershipsClickListener: PartnershipsClickListener
    )
    :RecyclerView.Adapter<PartnershipsCardViewHolder>()

{ //baka magkaproblem here
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartnershipsCardViewHolder {
       val from = LayoutInflater.from(parent.context)
       val binding = PartnershipsCardcellBinding.inflate(from, parent, false)
        return PartnershipsCardViewHolder(binding, partnershipsClickListener)
    }

    override fun onBindViewHolder(holder: PartnershipsCardViewHolder, position: Int) {
        holder.bindPartnershipsItems(partnershipsItems[position])
    }
    override fun getItemCount(): Int = partnershipsItems.size

}

