package com.techpassmaster.recyclerviewwithmultipleviewtype.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.techpassmaster.recyclerviewwithmultipleviewtype.R
import com.techpassmaster.recyclerviewwithmultipleviewtype.adapter.MainDataAdapter
import com.techpassmaster.recyclerviewwithmultipleviewtype.model.CategoriesModel
import com.techpassmaster.recyclerviewwithmultipleviewtype.model.MainDataModel
import com.techpassmaster.recyclerviewwithmultipleviewtype.repository.Repo
import com.techpassmaster.recyclerviewwithmultipleviewtype.viewmodel.ViewModel
import com.techpassmaster.recyclerviewwithmultipleviewtype.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Techpass Master on 8-April-21.
 * Website - https://techpassmaster.com/
 * Email id - hello@techpassmaster.com
 */

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel
    private lateinit var mainLandingRecyclerView: RecyclerView
    private lateinit var mainDataAdapter: MainDataAdapter
    private var repo = Repo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startShimmerEffect()

        val viewModelFactory = ViewModelFactory(repo)
        viewModel = ViewModelProvider(this, viewModelFactory)[ViewModel::class.java]

        initDynamicView()

    }

    private fun initDynamicView() {

        loadDynamicVideoUI()
    }

    private fun loadDynamicVideoUI() {


        viewModel.getAllDataFromRepo() // fetch on IO thread
        viewModel.response.observe(this, Observer {

            val categoriesModels: ArrayList<CategoriesModel> = ArrayList()

            categoriesModels.add(CategoriesModel(1, "Trending Video", it as ArrayList<MainDataModel>))
            categoriesModels.add(CategoriesModel(2, "Top Star", it))
            categoriesModels.add(CategoriesModel(1, "Recommended For You", it))
            categoriesModels.add(CategoriesModel(1, "#Video", it))
            categoriesModels.add(CategoriesModel(3, "Create Challenge Video", it))
            categoriesModels.add(CategoriesModel(2, "Popular", it))
            categoriesModels.add(CategoriesModel(1, "Previews", it))
            categoriesModels.add(CategoriesModel(2, "Follow", it))
            categoriesModels.add(CategoriesModel(1, "You May Like", it))
            categoriesModels.add(CategoriesModel(1, "Top Picks For You", it))
            categoriesModels.add(CategoriesModel(2, "Follow Your Favourite Show", it))
            categoriesModels.add(CategoriesModel(3, "Create Challenge Video", it))
            categoriesModels.add(CategoriesModel(1, "Lyrical", it))
            categoriesModels.add(CategoriesModel(1, "Show in Demand", it))
            categoriesModels.add(CategoriesModel(1, "Bollywood Style", it))
            categoriesModels.add(CategoriesModel(2, "Most Loved", it))

            setLandingRecyclerView(categoriesModels)
            stopShimmerEffect()

        })

    }

    private fun setLandingRecyclerView(categoriesModel: ArrayList<CategoriesModel>) {
        mainLandingRecyclerView = findViewById(R.id.main_landing_recyclerview)
        val layoutManager = LinearLayoutManager(this@MainActivity)
        mainLandingRecyclerView.layoutManager = layoutManager
        mainDataAdapter = MainDataAdapter(this, categoriesModel)
        mainLandingRecyclerView.adapter = mainDataAdapter
    }


    private fun startShimmerEffect() {
        main_fbShimmer.visibility = View.VISIBLE
        main_landing_recyclerview.visibility = View.INVISIBLE
        main_fbShimmer.startShimmer()
    }

    private fun stopShimmerEffect() {
        main_fbShimmer.visibility = View.INVISIBLE
        main_landing_recyclerview.visibility = View.VISIBLE
        main_fbShimmer.stopShimmer()
    }
}