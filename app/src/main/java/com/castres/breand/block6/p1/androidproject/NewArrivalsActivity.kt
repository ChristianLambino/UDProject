package com.castres.breand.block6.p1.androidproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.castres.breand.block6.p1.androidproject.databinding.ActivityNewArrivalsBinding


class NewArrivalsActivity : AppCompatActivity(), NewArrClickListener {

    private lateinit var binding: ActivityNewArrivalsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewArrivalsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateNewArrItems()

        val newArrActivity = this
        binding.newArrivalsRV.apply {
            layoutManager = GridLayoutManager(applicationContext, 3)
            adapter = NewArrAdapter(newArrList, newArrActivity )
        }

    }


    override fun onClick(newArrItems: NewArrItems) {

        val intent = Intent(applicationContext, NewArrivalsDetailActivity::class.java)
        intent.putExtra(NEW_ARR_ID_EXTRA, newArrItems.id)
        startActivity(intent)
    }

    private fun populateNewArrItems()
    {
        val na1 = NewArrItems(
            R.drawable.csd_logo,
            "Item1",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        newArrList.add(na1)

        val na2 = NewArrItems(
            R.drawable.csd_logo,
            "Item2",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        newArrList.add(na2)

        val na3 = NewArrItems(
            R.drawable.csd_logo,
            "Item3",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        newArrList.add(na3)

        val na4 = NewArrItems(
            R.drawable.csd_logo,
            "Item4",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        newArrList.add(na4)

        val na5 = NewArrItems(
            R.drawable.csd_logo,
            "Item5",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        newArrList.add(na5)

        val na6 = NewArrItems(
            R.drawable.csd_logo,
            "Item6",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        newArrList.add(na6)

        val na7 = NewArrItems(
            R.drawable.csd_logo,
            "Item7",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        newArrList.add(na7)

        val na8 = NewArrItems(
            R.drawable.csd_logo,
            "Item8",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        newArrList.add(na8)

        val na9 = NewArrItems(
            R.drawable.csd_logo,
            "Item9",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        newArrList.add(na9)

        val na10 = NewArrItems(
            R.drawable.csd_logo,
            "Item10",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        newArrList.add(na10)

        val na11 = NewArrItems(
            R.drawable.csd_logo,
            "Item11",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        newArrList.add(na11)

        val na12 = NewArrItems(
            R.drawable.csd_logo,
            "Item12",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        newArrList.add(na12)




    }
}