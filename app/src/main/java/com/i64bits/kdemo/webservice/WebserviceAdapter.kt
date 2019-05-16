package com.i64bits.kdemo.webservice

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.i64bits.kdemo.databinding.DashboardListItemBinding

class WebserviceAdapter(private var listOfMonkey: ArrayList<Monkey>, private var activity: WebserviceActivity): RecyclerView.Adapter<WebserviceAdapter.DViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): WebserviceAdapter.DViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DashboardListItemBinding.inflate(inflater)
        return DViewHolder(binding)
    }

    override fun getItemCount(): Int = listOfMonkey.size

    override fun onBindViewHolder(holder: WebserviceAdapter.DViewHolder, position: Int) =
        holder.bind(listOfMonkey.get(position))

    inner class DViewHolder(val binding: DashboardListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Monkey) {
            binding.txtDashboardListItem.text = item.name
            binding.executePendingBindings()
            //binding.root.setOnClickListener(activity.OnClick(item))
        }
    }
}