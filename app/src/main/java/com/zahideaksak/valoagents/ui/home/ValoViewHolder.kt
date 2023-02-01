package com.zahideaksak.valoagents.ui.home

import android.view.ViewGroup
import com.zahideaksak.valoagents.databinding.AdapterValoItemBinding
import com.zahideaksak.valoagents.ui.base.BaseViewHolder
import com.zahideaksak.valoagents.utility.inflateAdapterItem

class ValoViewHolder(private val binding: AdapterValoItemBinding) :
    BaseViewHolder<HomeUiData>(binding.root) {

    companion object {
        fun createFrom(parent: ViewGroup) =
            ValoViewHolder(parent.inflateAdapterItem(AdapterValoItemBinding::inflate))
    }

    override fun onBind(data: HomeUiData) {
        binding.valoComponent.setValoData(data)
    }


}