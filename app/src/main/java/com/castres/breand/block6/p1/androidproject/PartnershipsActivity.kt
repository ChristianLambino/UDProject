package com.castres.breand.block6.p1.androidproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.castres.breand.block6.p1.androidproject.databinding.ActivityPartnershipsBinding

class PartnershipsActivity : AppCompatActivity(),PartnershipsClickListener {

    private lateinit var binding: ActivityPartnershipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPartnershipsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populatePartnerships()

        val partnershipsActivity = this
        binding.partnershipsRV.apply {
            layoutManager = GridLayoutManager(applicationContext, 3)
            adapter = PartnershipsCardAdapter(partnershipsList, partnershipsActivity)
        }

    }

    override fun onClick(partnershipsItems: PartnershipsItems) {
        val intent = Intent(applicationContext, PartnershipsDetailActivity::class.java)
        intent.putExtra(PARTNERSHIPS_ID_EXTRA,partnershipsItems.id)
        startActivity(intent)
    }

    private fun populatePartnerships() {
        val partnerships1 = PartnershipsItems(
            R.drawable.csd_logo,
            "Item1",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        partnershipsList.add(partnerships1)

        val partnerships2 = PartnershipsItems(
            R.drawable.csd_logo,
            "Item2",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        partnershipsList.add(partnerships2)

        val partnerships3 = PartnershipsItems(
            R.drawable.csd_logo,
            "Item3",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        partnershipsList.add(partnerships3)

        val partnerships4 = PartnershipsItems(
            R.drawable.csd_logo,
            "Item4",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        partnershipsList.add(partnerships4)

        val partnerships5 = PartnershipsItems(
            R.drawable.csd_logo,
            "Item5",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        partnershipsList.add(partnerships5)

        val partnerships6 = PartnershipsItems(
            R.drawable.csd_logo,
            "Item6",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        partnershipsList.add(partnerships6)

        val partnerships7 = PartnershipsItems(
            R.drawable.csd_logo,
            "Item7",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        partnershipsList.add(partnerships7)

        val partnerships8 = PartnershipsItems(
            R.drawable.csd_logo,
            "Item8",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        partnershipsList.add(partnerships8)

        val partnerships9 = PartnershipsItems(
            R.drawable.csd_logo,
            "Item9",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        partnershipsList.add(partnerships9)

        val partnerships10 = PartnershipsItems(
            R.drawable.csd_logo,
            "Item10",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        partnershipsList.add(partnerships10)

        val partnerships11 = PartnershipsItems(
            R.drawable.csd_logo,
            "Item11",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        partnershipsList.add(partnerships11)

        val partnerships12 = PartnershipsItems(
            R.drawable.csd_logo,
            "Item12",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        partnershipsList.add(partnerships12)


    }

}