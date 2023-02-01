package com.zahideaksak.valoagents.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.zahideaksak.valoagents.databinding.LayoutValoBinding
import com.zahideaksak.valoagents.ui.home.HomeUiData
import com.zahideaksak.valoagents.utility.loadImage

class ValoUiComponent @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    FrameLayout(context, attributeSet, defStyleAttr) {

    private val binding = LayoutValoBinding.inflate(LayoutInflater.from(context), this, false)

    init {
        addView(binding.root)
    }

    fun setValoData(homeUiData: HomeUiData) {
        binding.name.text = homeUiData.name
        binding.valoImage.loadImage(homeUiData.imageUrl)
    }
}