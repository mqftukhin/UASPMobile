package com.example.uas_pemograman_mobile.ui.rumah_sakit_covid19

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_pemograman_mobile.databinding.ListViewItemRsBinding
import com.example.uas_pemograman_mobile.network.RumahSakit


class RumahSakitListAdapter ( val clickListener: RumahSakitListener) :
    ListAdapter<RumahSakit, RumahSakitListAdapter.RumahSakitViewHolder>(DiffCallback) {

    class RumahSakitViewHolder(
        var binding: ListViewItemRsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: RumahSakitListener, rs: RumahSakit) {
            binding.rs = rs
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<RumahSakit>() {
        override fun areItemsTheSame(oldItem: RumahSakit, newItem: RumahSakit): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: RumahSakit, newItem: RumahSakit): Boolean {
            return oldItem.address == newItem.address
                    && oldItem.region == newItem.region
                    && oldItem.phone == newItem.phone
                    && oldItem.province == newItem.province
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RumahSakitViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RumahSakitViewHolder(
            ListViewItemRsBinding.inflate(layoutInflater, parent, false)
        )
    }
    override fun onBindViewHolder(holder: RumahSakitViewHolder, position: Int) {
        val rs = getItem(position)
        holder.bind(clickListener, rs)
    }
}

class RumahSakitListener(val clickListener: (rs: RumahSakit) -> Unit) {
    fun onClickRs(rs: RumahSakit) = clickListener(rs)
}