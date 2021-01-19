package br.com.thiagofelix.portifolioapp.portifolio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.thiagofelix.portifolioapp.cv.CVItem
import br.com.thiagofelix.portifolioapp.databinding.FragmentPortifolioBinding
import br.com.thiagofelix.portifolioapp.databinding.ItemPortifolioBinding

class PortifolioAdapter:RecyclerView.Adapter<PortifolioAdapter.PortifolioViewHolder>() {

    var mData = listOf<PortifolioItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortifolioViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding = ItemPortifolioBinding
                .inflate(layoutInflater, parent , false)

        return PortifolioViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: PortifolioViewHolder, position: Int) {
        val item = mData[position]
        holder.binding.itemPortText.text = item.title
        holder.bind(item)
    }

    class PortifolioViewHolder(val binding:ItemPortifolioBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(
            item:PortifolioItem
        ){
            binding.itemPortText.text = item.title
        }
    }

}