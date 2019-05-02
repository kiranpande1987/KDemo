package com.i64bits.kdemo.dashboard

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.i64bits.kdemo.databinding.DashboardListItemBinding

class DashboardAdapter(private var demos: ArrayList<DashboardModel>, private var activity: DashboardActivity): RecyclerView.Adapter<DashboardAdapter.DViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): DashboardAdapter.DViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DashboardListItemBinding.inflate(inflater)
        return DViewHolder(binding)
    }

    override fun getItemCount(): Int = demos.size

    override fun onBindViewHolder(holder: DashboardAdapter.DViewHolder, position: Int) =
        holder.bind(demos.get(position))

    inner class DViewHolder(val binding: DashboardListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DashboardModel) {
            binding.dataModel = item
            binding.executePendingBindings()
            binding.root.setOnClickListener(activity.OnClick(item))
        }
    }
}