package com.i64bits.kdemo.basicui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.i64bits.kdemo.dashboard.DashboardActivity
import com.i64bits.kdemo.dashboard.DashboardAdapter
import com.i64bits.kdemo.dashboard.DashboardModel
import com.i64bits.kdemo.databinding.BasicUiListItemBinding
import com.i64bits.kdemo.databinding.DashboardListItemBinding

class BasicUIAdapter(private var demos: List<String>): RecyclerView.Adapter<BasicUIAdapter.BViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): BViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BasicUiListItemBinding.inflate(inflater)
        return BViewHolder(binding)
    }

    override fun getItemCount(): Int = demos.size

    override fun onBindViewHolder(holder: BViewHolder, position: Int) = holder.bind(demos.get(position))

    inner class BViewHolder(val binding: BasicUiListItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(item: String)
        {
            binding.string = item
            binding.executePendingBindings()
        }
    }
}