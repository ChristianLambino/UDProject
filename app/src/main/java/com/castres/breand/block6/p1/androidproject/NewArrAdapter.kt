package com.castres.breand.block6.p1.androidproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.castres.breand.block6.p1.androidproject.databinding.CardcellBinding

class NewArrAdapter (
    private val newArrItems: List<NewArrItems>,
    private val clickListener: NewArrClickListener
)
    : Adapter<NewArrCardViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewArrCardViewHolder
    {
        val from = LayoutInflater.from(parent.context)
        val binding = CardcellBinding.inflate(from, parent, false)
        return NewArrCardViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: NewArrCardViewHolder, position: Int)
    {
       holder.bindNewArrItems(newArrItems[position])
    }
    override fun getItemCount(): Int = newArrItems.size

}
