package com.techpassmaster.recyclerviewwithmultipleviewtype.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

import com.techpassmaster.recyclerviewwithmultipleviewtype.R
import com.techpassmaster.recyclerviewwithmultipleviewtype.model.MainDataModel
import com.squareup.picasso.Picasso

/**
 * Created by Techpass Master on 8-April-21.
 * Website - https://techpassmaster.com/
 * Email id - hello@techpassmaster.com
 */


class VideoAdapter(private val context: Context, private var mainDataModelList: ArrayList<MainDataModel>) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {

        return VideoViewHolder(
            LayoutInflater.from(context).inflate(R.layout.video_item, parent, false)
        )

    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {

        val videoItem = mainDataModelList[position]
        holder.title.text = videoItem.title
        Picasso.get().load(videoItem.thumbnailUrl).into(holder.img_thumbnail)

        holder.container_videoItem.setOnClickListener {
            Toast.makeText(context, "Video Position: $position", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return mainDataModelList.size
    }

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_videoTitle)
        var img_thumbnail: ImageView = itemView.findViewById(R.id.img_thumbnail)
        var container_videoItem: CardView = itemView.findViewById(R.id.container_videoItem)
    }
}

