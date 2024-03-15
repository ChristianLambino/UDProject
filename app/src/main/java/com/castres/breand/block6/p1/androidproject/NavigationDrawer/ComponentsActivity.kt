package com.castres.breand.block6.p1.androidproject.NavigationDrawer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.castres.breand.block6.p1.androidproject.Components.COMPONENTS_ID_EXTRA
import com.castres.breand.block6.p1.androidproject.Components.ComponentRepository
import com.castres.breand.block6.p1.androidproject.Components.ComponentsClickListener
import com.castres.breand.block6.p1.androidproject.Components.ComponentsDetailActivity
import com.castres.breand.block6.p1.androidproject.Components.ComponentsItems
import com.castres.breand.block6.p1.androidproject.HorizontalRV.ComponentsAdapter
import com.castres.breand.block6.p1.androidproject.MVVM.ComponentViewModelFactory
import com.castres.breand.block6.p1.androidproject.MVVM.ComponentsViewModel
import com.castres.breand.block6.p1.androidproject.RetrofitInstance
import com.castres.breand.block6.p1.androidproject.data.model.modeling.API
import com.castres.breand.block6.p1.androidproject.databinding.ActivityComponentsBinding

class ComponentsActivity : AppCompatActivity(), ComponentsClickListener {
    private lateinit var binding: ActivityComponentsBinding
    private lateinit var api: API
    private lateinit var componentsAdapter: ComponentsAdapter
    private lateinit var viewModel: ComponentsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComponentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the API
        api = RetrofitInstance.FetchComp(this)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this, ComponentViewModelFactory(repository = ComponentRepository(api)))
            .get(ComponentsViewModel::class.java)

        // Initialize ComponentsAdapter with an empty list
        componentsAdapter = ComponentsAdapter(mutableListOf(), this)

        // Set up RecyclerView
        binding.componentsRV.layoutManager = GridLayoutManager(this, 2)
        binding.componentsRV.adapter = componentsAdapter

        binding.componentsRVtwo.layoutManager = GridLayoutManager(this, 2)
        binding.componentsRVtwo.adapter = componentsAdapter


        // Observe ViewModel
        observeViewModel()

        // Populate the componentsList
        fetchComponents()
    }

    private fun fetchComponents() {
        viewModel.getComponent()
    }

    private fun observeViewModel() {
        viewModel.componentsList.observe(this, Observer {
            componentsAdapter.setItems(it)
        })

        viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.loading.observe(this, Observer {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        })
    }

    override fun onClick(componentsItems: ComponentsItems) {
        val intent = Intent(applicationContext, ComponentsDetailActivity::class.java)
        intent.putExtra(COMPONENTS_ID_EXTRA, componentsItems.id ?: -1)
        startActivity(intent)
    }
}




