package com.example.uas_pemograman_mobile.ui.update_covid19

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_pemograman_mobile.databinding.ListViewItemUpdateBinding
import com.example.uas_pemograman_mobile.network.DataCovid19


class DataKematianListAdapter (val clickListener: DataKematianListener) :
    ListAdapter<DataCovid19, DataKematianListAdapter.DataKematianViewHolder> (DiffCallback) {

    class DataKematianViewHolder(
        var binding: ListViewItemUpdateBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: DataKematianListener, dataCovid: DataCovid19) {
            binding.data = dataCovid
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<DataCovid19>() {
        override fun areItemsTheSame(oldItem: DataCovid19, newItem: DataCovid19): Boolean {
            return oldItem.countryRegion == newItem.countryRegion
        }

        override fun areContentsTheSame(oldItem: DataCovid19, newItem: DataCovid19): Boolean {
            return oldItem.confirmed == newItem.confirmed
                    && oldItem.deaths == newItem.deaths
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataKematianListAdapter.DataKematianViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DataKematianListAdapter.DataKematianViewHolder(
            ListViewItemUpdateBinding.inflate(layoutInflater, parent, false)
        )
    }
    override fun onBindViewHolder(holder: DataKematianListAdapter.DataKematianViewHolder, position: Int) {
        val update = getItem(position)
        holder.bind(clickListener, update)
    }
}

class DataKematianListener(val clickListener: (dataCovid: DataCovid19 ) -> Unit) {
        fun onClickData(data: DataCovid19) = clickListener(data)

}
