package com.castres.breand.block6.p1.androidproject.NavigationDrawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.castres.breand.block6.p1.androidproject.Components.COMPONENTS_ID_EXTRA
import com.castres.breand.block6.p1.androidproject.Components.ComponentsCardAdapter
import com.castres.breand.block6.p1.androidproject.Components.ComponentsClickListener
import com.castres.breand.block6.p1.androidproject.Components.ComponentsDetailActivity
import com.castres.breand.block6.p1.androidproject.Components.ComponentsItems
import com.castres.breand.block6.p1.androidproject.Components.componentsList
import com.castres.breand.block6.p1.androidproject.R
import com.castres.breand.block6.p1.androidproject.databinding.ActivityComponentsBinding

class ComponentsActivity : AppCompatActivity(), ComponentsClickListener {
    private lateinit var binding: ActivityComponentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComponentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateComponents()

        val componentsActivity = this
        binding.componentsRV.apply {
            layoutManager = GridLayoutManager(applicationContext, 3)
            adapter = ComponentsCardAdapter(componentsList, componentsActivity)
        }
    }
    override fun onClick(componentsItems: ComponentsItems) {
        val intent = Intent(applicationContext, ComponentsDetailActivity::class.java)
        intent.putExtra(COMPONENTS_ID_EXTRA,componentsItems.id)
        startActivity(intent)
    }

    private fun populateComponents() {
        val components1 = ComponentsItems(
            R.drawable.csd_logo,
            "Item1",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        componentsList.add(components1)

        val components2 = ComponentsItems(
            R.drawable.changepassword_csd,
            "Item2",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        componentsList.add(components2)

        val components3 = ComponentsItems(
            R.drawable.add_cart,
            "Item3",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        componentsList.add(components3)

        val components4 = ComponentsItems(
            R.drawable.csd_logo,
            "Item4",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        componentsList.add(components4)

        val components5 = ComponentsItems(
            R.drawable.csd_logo,
            "Item5",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        componentsList.add(components5)

        val components6 = ComponentsItems(
            R.drawable.csd_logo,
            "Item6",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        componentsList.add(components6)

        val components7 = ComponentsItems(
            R.drawable.csd_logo,
            "Item7",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        componentsList.add(components7)

        val components8 = ComponentsItems(
            R.drawable.csd_logo,
            "Item8",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        componentsList.add(components8)

        val components9 = ComponentsItems(
            R.drawable.csd_logo,
            "Item9",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        componentsList.add(components9)

        val components10 = ComponentsItems(
            R.drawable.csd_logo,
            "Item10",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        componentsList.add(components10)

        val components11 = ComponentsItems(
            R.drawable.csd_logo,
            "Item11",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        componentsList.add(components11)

        val components12 = ComponentsItems(
            R.drawable.csd_logo,
            "Item12",
            "xxxxx",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n",
            R.drawable.add_cart
        )
        componentsList.add(components12)
    }

}