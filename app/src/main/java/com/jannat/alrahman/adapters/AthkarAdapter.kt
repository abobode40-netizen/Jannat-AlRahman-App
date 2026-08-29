package com.jannat.alrahman.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jannat.alrahman.databinding.ItemAthkarBinding

data class Athkar(
    val id: Int,
    val title: String,
    val content: String,
    val count: Int = 0
)

class AthkarAdapter(private val athkarList: MutableList<Athkar>) : 
    RecyclerView.Adapter<AthkarAdapter.AthkarViewHolder>() {

    inner class AthkarViewHolder(private val binding: ItemAthkarBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(athkar: Athkar) {
            binding.apply {
                athkarTitle.text = athkar.title
                athkarContent.text = athkar.content
                countText.text = athkar.count.toString()
                
                increaseBtn.setOnClickListener {
                    athkarList[adapterPosition] = athkar.copy(count = athkar.count + 1)
                    notifyItemChanged(adapterPosition)
                }
                
                decreaseBtn.setOnClickListener {
                    if (athkar.count > 0) {
                        athkarList[adapterPosition] = athkar.copy(count = athkar.count - 1)
                        notifyItemChanged(adapterPosition)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AthkarViewHolder {
        val binding = ItemAthkarBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AthkarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AthkarViewHolder, position: Int) {
        holder.bind(athkarList[position])
    }

    override fun getItemCount(): Int = athkarList.size
}
