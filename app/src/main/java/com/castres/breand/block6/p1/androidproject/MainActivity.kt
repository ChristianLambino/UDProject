    package com.castres.breand.block6.p1.androidproject

    import android.content.Intent
    import android.os.Bundle
    import android.widget.ImageView
    import android.widget.TextView
    import androidx.appcompat.app.ActionBarDrawerToggle
    import androidx.appcompat.app.AlertDialog
    import androidx.appcompat.app.AppCompatActivity
    import androidx.drawerlayout.widget.DrawerLayout
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.LinearSnapHelper
    import androidx.recyclerview.widget.RecyclerView
    import androidx.recyclerview.widget.SnapHelper
    import com.castres.breand.block6.p1.androidproject.Account.LogInActivity
    import com.castres.breand.block6.p1.androidproject.AddToCart.AddToCartActivity
    import com.castres.breand.block6.p1.androidproject.HorizontalRV.Components
    import com.castres.breand.block6.p1.androidproject.NavigationDrawer.ComponentsActivity
    import com.castres.breand.block6.p1.androidproject.HorizontalRV.ComponentsAdapter
    import com.castres.breand.block6.p1.androidproject.HorizontalRV.NewArrivals
    import com.castres.breand.block6.p1.androidproject.HorizontalRV.NewArrivalsAdapter
    import com.castres.breand.block6.p1.androidproject.HorizontalRV.Partnerships
    import com.castres.breand.block6.p1.androidproject.HorizontalRV.PartnershipsAdapter
    import com.castres.breand.block6.p1.androidproject.NavigationDrawer.AboutActivity
    import com.castres.breand.block6.p1.androidproject.NavigationDrawer.AppointmentsActivity
    import com.castres.breand.block6.p1.androidproject.NavigationDrawer.ContactsActivity
    import com.google.android.material.navigation.NavigationView

    class MainActivity : AppCompatActivity(){

        //start of new arrivals
        private lateinit var drawerLayout: DrawerLayout
        private lateinit var navigationView: NavigationView
        private lateinit var toolbar: androidx.appcompat.widget.Toolbar

        //start of new arrivals
        private lateinit var recyclerView: RecyclerView
        private lateinit var newArrivalsList: ArrayList<NewArrivals>
        private lateinit var newArrivalsAdapter : NewArrivalsAdapter

        //start of components
        private lateinit var recyclerView1: RecyclerView
        private lateinit var componentsList: ArrayList<Components>
        private lateinit var componentsAdapter: ComponentsAdapter

        //start of components
        private lateinit var recyclerView2: RecyclerView
        private lateinit var psList: ArrayList<Partnerships>
        private lateinit var psAdapter: PartnershipsAdapter


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Initialize views
            drawerLayout = findViewById(R.id.drawer_layout)
            navigationView = findViewById(R.id.nav_view)
            toolbar = findViewById(R.id.toolbar)

            // Set toolbar as action bar
            setSupportActionBar(toolbar)


            // Set up drawer toggle
            val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close
            )
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            // Set navigation item click listener
            navigationView.setNavigationItemSelectedListener { menuItem ->
                // Handle navigation item clicks
                when (menuItem.itemId) {
                    R.id.nav_components -> startActivity(Intent(this, ComponentsActivity::class.java))
                    R.id.nav_appointments -> startActivity(Intent(this, AppointmentsActivity::class.java))
                    R.id.nav_about -> startActivity(Intent(this, AboutActivity::class.java))
                    R.id.nav_contacts -> startActivity(Intent(this, ContactsActivity::class.java))
                    R.id.nav_logout -> showLogoutDialog()
                }
                // Close the drawer after handling the item click
                drawerLayout.closeDrawers()
                true
            }

            initNewArrivals()
            initComponents()
            initPartnerships()


            val redirectsToAddToCartActivity: ImageView = findViewById(R.id.cartIcon)
            redirectsToAddToCartActivity.setOnClickListener{
                startActivity(Intent(this, AddToCartActivity::class.java))
            }

            val redirectsToComponentsActivity : TextView = findViewById(R.id.tvComponents)

            redirectsToComponentsActivity.setOnClickListener {
                val intent = Intent(this@MainActivity, ComponentsActivity::class.java)
                startActivity(intent)
            }

        }

        // Function to show logout confirmation dialog
        private fun showLogoutDialog() {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Yes") { dialog, _ ->
                    val intent = Intent(this, LogInActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                .setNegativeButton("No") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }




        private fun initNewArrivals() {
            // new arrivals
            recyclerView = findViewById(R.id.recyclerView) ?: return // Return early if recyclerView is null
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
            val snapHelper: SnapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(recyclerView)
            newArrivalsList = ArrayList()

            addDataToNewArrivalsList()

            newArrivalsAdapter = NewArrivalsAdapter(newArrivalsList)
            recyclerView.adapter = newArrivalsAdapter
        }


        private fun addDataToNewArrivalsList() {
            newArrivalsList.add(NewArrivals(R.drawable.csd_logo, "Item 1"))
            newArrivalsList.add(NewArrivals(R.drawable.csd_logo, "Item 2"))
            newArrivalsList.add(NewArrivals(R.drawable.csd_logo, "Item 3"))
            newArrivalsList.add(NewArrivals(R.drawable.csd_logo, "Item 4"))
            newArrivalsList.add(NewArrivals(R.drawable.csd_logo, "Item 5"))
            newArrivalsList.add(NewArrivals(R.drawable.csd_logo, "Item 6"))
        }
        private fun initComponents() {
            recyclerView1 = findViewById(R.id.recyclerView2)
            recyclerView1.setHasFixedSize(true)
            recyclerView1.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
            val snapHelper1: SnapHelper = LinearSnapHelper()
            snapHelper1.attachToRecyclerView(recyclerView1)
            componentsList = ArrayList()

            addDataToComponentsList()

            componentsAdapter = ComponentsAdapter(componentsList)
            recyclerView1.adapter = componentsAdapter
        }
        private fun addDataToComponentsList (){
            componentsList.add(Components(R.drawable.csd_logo, "Item1"))
            componentsList.add(Components(R.drawable.csd_logo, "Item2"))
            componentsList.add(Components(R.drawable.csd_logo, "Item3"))
            componentsList.add(Components(R.drawable.csd_logo, "Item4"))
            componentsList.add(Components(R.drawable.csd_logo, "Item5"))
            componentsList.add(Components(R.drawable.csd_logo, "Item6"))


        }

        private fun initPartnerships(){
            recyclerView2 = findViewById(R.id.recyclerView3)
            recyclerView2.setHasFixedSize(true)
            recyclerView2.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
            val snapHelper2: SnapHelper = LinearSnapHelper()
            snapHelper2.attachToRecyclerView(recyclerView2)
            psList = ArrayList()

            addDataToPartnershipsList()

            psAdapter = PartnershipsAdapter(psList)
            recyclerView2.adapter = psAdapter
        }

        private fun addDataToPartnershipsList () {
            psList.add(Partnerships(R.drawable.csd_logo, "Item1"))
            psList.add(Partnerships(R.drawable.csd_logo, "Item2"))
            psList.add(Partnerships(R.drawable.csd_logo, "Item3"))
            psList.add(Partnerships(R.drawable.csd_logo, "Item4"))
            psList.add(Partnerships(R.drawable.csd_logo, "Item5"))
            psList.add(Partnerships(R.drawable.csd_logo, "Item6"))
        }


    }