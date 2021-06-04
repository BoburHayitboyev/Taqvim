package uz.ramazon.taqvim2021.ramazontaqvim2021.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.ramazon.taqvim2021.ramazontaqvim2021.model.Item
import uz.ramazon.taqvim2021.ramazontaqvim2021.databinding.ItemMainBinding

class ItemAdapter(private val items: ArrayList<Item>,
                  private val itemClickListener: ItemClickListener
) :
    ListAdapter<Item, ItemAdapter.ItemViewHolder>(ItemDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]

        holder.binding.sana.text = item.sana
        holder.binding.iftorlik.text = item.iftorlik
        holder.binding.saharlik.text = item.saharlik
        holder.binding.kun.text = item.kun

        holder.binding.root.setOnClickListener {
            itemClickListener.onItemClick(item)
        }
    }

    override fun getItemCount() = 30

    class ItemClickListener(val ItemClickListener: (item: Item) -> Unit) {
        fun onItemClick(item: Item) = ItemClickListener(item)
    }
    inner class ItemViewHolder(val binding: ItemMainBinding) :
        RecyclerView.ViewHolder(binding.root)

    class ItemDiffCallBack : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.sana == newItem.sana
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }
}