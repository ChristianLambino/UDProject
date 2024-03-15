package com.castres.breand.block6.p1.androidproject.HorizontalRV

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.castres.breand.block6.p1.androidproject.Components.ComponentsClickListener
import com.castres.breand.block6.p1.androidproject.Components.ComponentsItems
import com.castres.breand.block6.p1.androidproject.R

class ComponentsAdapter(
    private var componentsList: MutableList<ComponentsItems> = mutableListOf(),
    private var clickListener: ComponentsClickListener? = null
) :
    RecyclerView.Adapter<ComponentsAdapter.ComponentsViewHolder>() {

    fun setItems(items: List<ComponentsItems>) {
        componentsList.clear()
        componentsList.addAll(items)
        notifyDataSetChanged()
    }

    fun setOnComponentsClickListener(clickListener: ComponentsClickListener) {
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComponentsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.components, parent, false)
        return ComponentsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComponentsViewHolder, position: Int) {
        val item = componentsList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return componentsList.size
    }

    inner class ComponentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.componentsImageView)
        private val prod_name: TextView = itemView.findViewById(R.id.componentsNameTv)

        fun bind(item: ComponentsItems) {
            Glide.with(itemView.context)
                .load(item.image)
                .placeholder(R.drawable.csd_logo)
                .into(image)

            prod_name.text = item.prod_name

            itemView.setOnClickListener {
                clickListener?.onClick(item)
            }
        }
    }
}

