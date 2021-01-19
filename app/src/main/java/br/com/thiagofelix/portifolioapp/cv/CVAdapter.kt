package br.com.thiagofelix.portifolioapp.cv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.thiagofelix.portifolioapp.R
import br.com.thiagofelix.portifolioapp.databinding.ItemCvBinding

class CVAdapter(): RecyclerView.Adapter<CVAdapter.CVViewHolder>() {

    var mData = listOf<CVItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CVViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding = ItemCvBinding
            .inflate(layoutInflater, parent, false)

        return CVViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: CVViewHolder, position: Int) {
        val item = mData[position]
        holder.binding.itemCvTitle.text = item.title
        holder.binding.itemCvDescription.text = item.description

        holder.bind(item)
    }

    class CVViewHolder(val binding:ItemCvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: CVItem
        ){
            item.title = binding.itemCvTitle.text.toString()
            item.description = binding.itemCvDescription.text.toString()
        }
    }
}