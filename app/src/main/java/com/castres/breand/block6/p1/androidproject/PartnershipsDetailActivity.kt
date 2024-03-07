package com.castres.breand.block6.p1.androidproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.castres.breand.block6.p1.androidproject.databinding.ActivityPartnershipsDetailBinding

class PartnershipsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPartnershipsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPartnershipsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val partnershipsID = intent.getIntExtra(PARTNERSHIPS_ID_EXTRA, -1)
        val partnership = partnershipsFromID(partnershipsID)
        if (partnership != null){
            binding.partnershipsDetailCover.setImageResource(partnership.partnershipsCover)
            binding.partnershipsDetailItemName.text = partnership.partnershipsItemName
            binding.partnershipsDetailPrice.text = partnership.partnershipsPrice
            binding.partnershipsDetailDescription.text = partnership.partnershipsDescription
            binding.partnershipsDetailADC.setImageResource(partnership.partnershipsAddToCart)

            binding.partnershipsDetailADC.setOnClickListener{
                redirectToCart()
            }
        }
    }

    private fun redirectToCart(){
        val intent = Intent(this, AddToCartActivity::class.java)
        startActivity(intent)
    }

    private fun partnershipsFromID(partnershipsID: Int): PartnershipsItems? {

        for (partnership in partnershipsList){
            if (partnership.id == partnershipsID)
                return partnership
        }
        return null
    }
}