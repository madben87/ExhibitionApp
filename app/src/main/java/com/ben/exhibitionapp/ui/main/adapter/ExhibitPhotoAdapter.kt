package com.ben.exhibitionapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ben.exhibitionapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_exhibit_photo.view.*

class ExhibitPhotoAdapter : RecyclerView.Adapter<ExhibitPhotoAdapter.ExhibitPhotoViewHolder>() {

    val dataList = ArrayList<String>()

    var actionItemClicked: (item: String) -> Unit = {}

    fun sedData(list: List<String>) {
        this.dataList.clear()
        this.dataList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExhibitPhotoViewHolder {
        return ExhibitPhotoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_exhibit_photo,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ExhibitPhotoViewHolder, position: Int) {
        holder.bind(dataList.get(position), actionItemClicked)
    }

    class ExhibitPhotoViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(item: String, actionItemClicked: (item: String) -> Unit) {

            //centerCrop for example
            Glide.with(containerView.context)
                .asBitmap().dontAnimate().load(item)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(containerView.resources.getDrawable(R.drawable.ic_launcher_background))
                .centerCrop()
                .into(containerView.exhibitPhoto)

            containerView.exhibitPhoto.setOnClickListener {
                actionItemClicked.invoke(item)
            }
        }
    }
}