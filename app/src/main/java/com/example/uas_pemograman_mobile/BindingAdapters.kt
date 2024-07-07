package com.example.uas_pemograman_mobile

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.uas_pemograman_mobile.network.DataCovid19
import com.example.uas_pemograman_mobile.network.RumahSakit
import com.example.uas_pemograman_mobile.network.InewsItem
import com.example.uas_pemograman_mobile.ui.inews.InewsListAdapter
import com.example.uas_pemograman_mobile.ui.rumah_sakit_covid19.RumahSakitListAdapter
import com.example.uas_pemograman_mobile.ui.update_covid19.DataKematianListAdapter


@BindingAdapter("listDataInews")
fun bindRecyclerViewInews(recyclerView: RecyclerView, data: List<InewsItem>?) {
    val adapter = recyclerView.adapter as InewsListAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDataRumahSakit")
fun bindRecyclerViewRumahSakit(recyclerView: RecyclerView, data: List<RumahSakit>?) {
    val adapter = recyclerView.adapter as RumahSakitListAdapter
    adapter.submitList(data)
}

@BindingAdapter("listDataUpdateData")
fun bindRecylerViewUpdate(recyclerView: RecyclerView, data: List<DataCovid19>?) {
    val adapter = recyclerView.adapter as DataKematianListAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}
