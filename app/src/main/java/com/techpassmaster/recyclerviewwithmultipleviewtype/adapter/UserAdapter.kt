package com.techpassmaster.recyclerviewwithmultipleviewtype.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

import com.techpassmaster.recyclerviewwithmultipleviewtype.R
import com.techpassmaster.recyclerviewwithmultipleviewtype.model.MainDataModel
import com.squareup.picasso.Picasso

/**
 * Created by Techpass Master on 8-April-21.
 * Website - https://techpassmaster.com/
 * Email id - hello@techpassmaster.com
 */


class UserAdapter(
    private val context: Context,
    private var mainDataModelList: ArrayList<MainDataModel>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var limit = 15

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        return UserViewHolder(
            LayoutInflater.from(context).inflate(R.layout.user_profile_item, parent, false)
        )

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val userItem = mainDataModelList[position]

        holder.title.text = userItem.title
        Picasso.get().load(userItem.thumbnailUrl).into(holder.url)

        holder.container_userItem.setOnClickListener {
            Toast.makeText(context, "User Position: $position", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        if (mainDataModelList.size > limit) {
            return limit
        } else {
            return mainDataModelList.size

        }
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_userName)
        var url: ImageView = itemView.findViewById(R.id.img_userProfile)
        var container_userItem: RelativeLayout = itemView.findViewById(R.id.container_userItem)
    }


}

