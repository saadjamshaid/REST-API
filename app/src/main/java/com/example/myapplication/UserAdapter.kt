package com.example.myapplication
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView



class UserAdapter(private val users: List<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    private lateinit var context: Context //creating context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.recycler_view_users, parent, false)
        return ViewHolder(view)


    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {


        val user = users[position]

        holder.title.text = user.title
        holder.body.text =  user.body



    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val body: TextView = itemView.findViewById(R.id.bodyTV)
        val title: TextView = itemView.findViewById(R.id.titleTV)

}



}