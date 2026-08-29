package com.jannat.alrahman.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jannat.alrahman.databinding.ItemSurahBinding

data class Surah(
    val id: Int,
    val name: String,
    val nameAr: String,
    val ayahs: Int,
    val type: String
)

class SurahAdapter(private val surahs: List<Surah>) : 
    RecyclerView.Adapter<SurahAdapter.SurahViewHolder>() {

    inner class SurahViewHolder(private val binding: ItemSurahBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(surah: Surah) {
            binding.apply {
                surahTitle.text = "${surah.id}. ${surah.nameAr}"
                surahDescription.text = "${surah.ayahs} آيات • ${surah.type}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahViewHolder {
        val binding = ItemSurahBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SurahViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        holder.bind(surahs[position])
    }

    override fun getItemCount(): Int = surahs.size
}
