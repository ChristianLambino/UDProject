package com.castres.breand.block6.p1.androidproject


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Toast
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

            // Add click listener to componentsDetailADC
            binding.partnershipsDetailADC.setOnClickListener {
                // Show a Toast message when clicked
                Toast.makeText(this, "Item Added To Cart", Toast.LENGTH_SHORT).show()

                bounceAnimation(binding.partnershipsDetailADC)
            }
        }
    }

    private fun bounceAnimation(view: View){
        val bounceAnimation = ScaleAnimation(
            1.0f, 1.2f,  // Start and end values for the X-axis scaling
            1.0f, 1.2f,  // Start and end values for the Y-axis scaling
            Animation.RELATIVE_TO_SELF, 0.5f,  // Pivot point of X scaling
            Animation.RELATIVE_TO_SELF, 0.5f   // Pivot point of Y scaling
        )

        bounceAnimation.duration = 300 // Duration of the animation in milliseconds
        bounceAnimation.repeatMode = Animation.REVERSE // Reverse the animation when it ends
        bounceAnimation.repeatCount = 1 // Number of times to repeat the animation

        view.startAnimation(bounceAnimation)
    }


    private fun partnershipsFromID(partnershipsID: Int): PartnershipsItems? {

        for (partnership in partnershipsList){
            if (partnership.id == partnershipsID)
                return partnership
        }
        return null
    }
}