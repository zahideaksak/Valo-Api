package com.zahideaksak.valoagents.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zahideaksak.valoagents.ui.base.BaseRecyclerViewAdapter

class ValoRecyclerViewAdapter : BaseRecyclerViewAdapter<HomeUiData, ValoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValoViewHolder {
        return ValoViewHolder.createFrom(parent)
    }

}