package com.ben.exhibitionapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ben.exhibitionapp.R
import com.ben.model.model.Exhibit
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_exhibit.view.*

class ExhibitItemAdapter : RecyclerView.Adapter<ExhibitItemAdapter.ExhibitItemViewHolder>() {

    val dataList = ArrayList<Exhibit>()

    var actionItemClicked: (item: Exhibit) -> Unit = {}

    fun sedData(list: List<Exhibit>) {
        this.dataList.clear()
        this.dataList.addAll(list)
        notifyDataSetChanged()
    }

    fun addItem(item: Exhibit) {
        dataList.add(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExhibitItemViewHolder {
        return ExhibitItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_exhibit,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ExhibitItemViewHolder, position: Int) {
        holder.bind(dataList.get(position), actionItemClicked)
    }

    class ExhibitItemViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        val adapter = ExhibitPhotoAdapter()

        fun bind(item: Exhibit, actionItemClicked: (item: Exhibit) -> Unit) {

            containerView.exhibitTitle.text = item.title

            containerView.exhibitPhotos.layoutManager =
                LinearLayoutManager(containerView.context, LinearLayoutManager.HORIZONTAL, false)
            containerView.exhibitPhotos.adapter = adapter

            adapter.sedData(item.images)

            containerView.rootLayout.setOnClickListener {
                actionItemClicked.invoke(item)
            }
        }
    }
}