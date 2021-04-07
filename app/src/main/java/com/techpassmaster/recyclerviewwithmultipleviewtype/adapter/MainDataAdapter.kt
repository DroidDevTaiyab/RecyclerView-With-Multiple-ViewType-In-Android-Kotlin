package com.techpassmaster.recyclerviewwithmultipleviewtype.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.techpassmaster.recyclerviewwithmultipleviewtype.R
import com.techpassmaster.recyclerviewwithmultipleviewtype.model.CategoriesModel
import com.techpassmaster.recyclerviewwithmultipleviewtype.model.MainDataModel

/**
 * Created by Techpass Master on 8-April-21.
 * Website - https://techpassmaster.com/
 * Email id - hello@techpassmaster.com
 */

class MainDataAdapter(
    private val context: Context,
    var categoriesModel: ArrayList<CategoriesModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_VIDEO = 1
        const val VIEW_TYPE_USER = 2
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == VIEW_TYPE_VIDEO) {
            return VideoViewHolder(
                LayoutInflater.from(context)
                    .inflate(R.layout.recyclerview_row_item, parent, false)
            )
        }
        if (viewType == VIEW_TYPE_USER) {
            return UserViewHolder(
                LayoutInflater.from(context)
                    .inflate(R.layout.recyclerview_row_item, parent, false)
            )
        }
        return MusicViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.recyclerview_row_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return categoriesModel.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (categoriesModel[position].viewType === VIEW_TYPE_VIDEO) {
            (holder as VideoViewHolder).bind(position)
        } else if (categoriesModel[position].viewType === VIEW_TYPE_USER) {
            (holder as UserViewHolder).bind(position)
        } else {
            (holder as MusicViewHolder).bind(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return categoriesModel[position].viewType
    }

    private inner class VideoViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tv_categoryType: TextView = itemView.findViewById(R.id.tv_categoryType)
        var recyclerView_categoryType: RecyclerView =
            itemView.findViewById(R.id.recyclerView_categoryType)


        fun bind(position: Int) {
            val recyclerViewModel = categoriesModel[position]
            tv_categoryType.text = recyclerViewModel.categoryTitle

            setVideoCategoriesRecyclerView(
                recyclerView_categoryType,
                recyclerViewModel.categoryItemList
            )

        }
    }

    private inner class UserViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tv_categoryType: TextView = itemView.findViewById(R.id.tv_categoryType)
        var recyclerView_categoryType: RecyclerView =
            itemView.findViewById(R.id.recyclerView_categoryType)


        fun bind(position: Int) {
            val recyclerViewModel = categoriesModel[position]
            tv_categoryType.text = recyclerViewModel.categoryTitle

            setUserCategoriesRecyclerView(
                recyclerView_categoryType,
                recyclerViewModel.categoryItemList
            )
        }
    }

    private inner class MusicViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tv_categoryType: TextView = itemView.findViewById(R.id.tv_categoryType)
        var recyclerView_categoryType: RecyclerView =
            itemView.findViewById(R.id.recyclerView_categoryType)


        fun bind(position: Int) {
            val recyclerViewModel = categoriesModel[position]
            tv_categoryType.text = recyclerViewModel.categoryTitle

            setMusicCategoriesRecyclerView(
                recyclerView_categoryType,
                recyclerViewModel.categoryItemList
            )
        }
    }


    //    recyclerView for video
    fun setVideoCategoriesRecyclerView(
        recyclerView: RecyclerView,
        categries: ArrayList<MainDataModel>
    ) {

        val postAdapter = VideoAdapter(context, categries)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = postAdapter


    }

    //    recyclerView for user
    fun setUserCategoriesRecyclerView(
        recyclerView: RecyclerView,
        categries: ArrayList<MainDataModel>
    ) {

        val postAdapter = UserAdapter(context, categries)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = postAdapter
    }

    //    recyclerView for Music
    fun setMusicCategoriesRecyclerView(
        recyclerView: RecyclerView,
        categries: ArrayList<MainDataModel>
    ) {

        val postAdapter = MusicAdapter(context, categries)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.adapter = postAdapter

    }

}