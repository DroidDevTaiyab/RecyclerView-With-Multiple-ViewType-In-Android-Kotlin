package com.techpassmaster.recyclerviewwithmultipleviewtype.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

import com.techpassmaster.recyclerviewwithmultipleviewtype.R
import com.techpassmaster.recyclerviewwithmultipleviewtype.model.MainDataModel

/**
 * Created by Techpass Master on 8-April-21.
 * Website - https://techpassmaster.com/
 * Email id - hello@techpassmaster.com
 */

class MusicAdapter(
        private val context: Context,
        private var mainDataModelList: ArrayList<MainDataModel>)
    : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    private var limit = 4

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {

        return MusicViewHolder(
                LayoutInflater.from(context).inflate(R.layout.music_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {

        val musicItem = mainDataModelList[position]
        holder.music_name.text = musicItem.title


        holder.container_musicItem.setOnClickListener {
            Toast.makeText(context, "Music Position: $position", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return if (mainDataModelList.size > limit) {
            limit
        } else {
            mainDataModelList.size

        }
    }

    class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val music_name: TextView = itemView.findViewById(R.id.tv_musicTitle)
        val container_musicItem: ConstraintLayout = itemView.findViewById(R.id.container_musicItem)
    }
}

