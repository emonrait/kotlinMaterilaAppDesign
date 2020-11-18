package com.example.bankasiaapp.ui.account

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.bankasiaapp.R
import com.example.bankasiaapp.model.ApiResponse
import com.example.bankasiaapp.model.getProgressDrawable
import com.example.bankasiaapp.model.loadImage
import kotlinx.android.synthetic.main.item_user.view.*

class UserListAdapter(val usersList: ArrayList<ApiResponse>) :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    fun updateUserList(newUserList: List<ApiResponse>) {
        usersList.clear()
        usersList.addAll(newUserList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.view.name.text = usersList[position].name
        holder.view.mobile.text = usersList[position].mobile
        holder.view.imageView.loadImage(
            usersList[position].imagelink,
            getProgressDrawable(holder.view.imageView.context)
        )
    }

    override fun getItemCount() = usersList.size

    class UserViewHolder(var view: View) : RecyclerView.ViewHolder(view)
}