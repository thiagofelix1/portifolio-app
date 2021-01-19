package br.com.thiagofelix.portifolioapp.sidemenu

import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.thiagofelix.portifolioapp.databinding.ItemMenuBinding
import br.com.thiagofelix.portifolioapp.portifolio.PortifolioItem

class MenuAdapter(val listener: Callback):RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(){

    var mData = listOf<MenuItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMenuBinding.inflate(layoutInflater, parent , false)

        return MenuViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = mData[position]
        holder.binding.itemMenuIcon.setImageResource(item.icon!!)
        if (item.isSelected!!){
            holder.binding.itemMenuSelected.visibility = View.VISIBLE
        }else{
            holder.binding.itemMenuSelected.visibility = View.GONE
        }
        holder.bind(item , listener)
    }

    class MenuViewHolder(val binding:ItemMenuBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(
            item: MenuItem , listener: Callback
        ){
            binding.itemMenuIcon.setImageResource(item.icon!!)
            binding.itemMenuSelected.isSelected = item.isSelected!!

            binding.root.setOnClickListener {
                listener.onSideMenuItem(adapterPosition)
            }
        }
    }
}