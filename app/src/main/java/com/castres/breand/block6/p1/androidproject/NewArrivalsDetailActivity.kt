package com.castres.breand.block6.p1.androidproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.castres.breand.block6.p1.androidproject.databinding.ActivityNewArrivalsDetailBinding

class NewArrivalsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewArrivalsDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewArrivalsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newArrID = intent.getIntExtra(NEW_ARR_ID_EXTRA, -1)
        val items = newArrFromID(newArrID)
        if (items != null){
            binding.cover.setImageResource(items.cover)
        }
    }

    private fun newArrFromID(newArrID:Int): NewArrivals?{
        for (items in newArrList)
        {
            if (items.id == newArrID)
                return items
        }
        return null
    }
}