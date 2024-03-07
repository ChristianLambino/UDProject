package com.castres.breand.block6.p1.androidproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.castres.breand.block6.p1.androidproject.NEW_ARR_ID_EXTRA
import com.castres.breand.block6.p1.androidproject.NewArrItems
import com.castres.breand.block6.p1.androidproject.databinding.ActivityNewArrivalsDetailBinding
import com.castres.breand.block6.p1.androidproject.newArrList

class NewArrivalsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewArrivalsDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewArrivalsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemsID = intent.getIntExtra(NEW_ARR_ID_EXTRA, -1)
        val items = newArrFromID(itemsID)
        if (items != null){
            binding.nadCover.setImageResource(items.cover)
            binding.nadItemName.text = items.itemName
            binding.nadPrice.text = items.itemPrice
            binding.nadDescription.text = items.description
            binding.nadDetailADC.setImageResource(items.addToCart)

            binding.nadDetailADC.setOnClickListener{
                redirectToCart()
            }
        }
    }

    private fun redirectToCart(){
        val intent = Intent(this, AddToCartActivity::class.java)
        startActivity(intent)
    }

    private fun newArrFromID(itemsID: Int): NewArrItems? {
        for (items in newArrList){
            if (items.id == itemsID)
                return items
        }
        return null

    }
}