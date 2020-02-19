package ch.itomy.githubtest.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ch.itomy.githubtest.data.model.Repository
import ch.itomy.githubtest.databinding.ItemRepositoryBinding

class RepositoryAdapter(
    private val listener: (Repository) -> Unit
) : ListAdapter<Repository, RepositoryAdapter.ViewHolder>(ItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(
        private val binding: ItemRepositoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                listener.invoke(getItem(adapterPosition))
            }
        }

        fun bind(item: Repository) {
            binding.item = item
        }
    }

    object ItemCallback : DiffUtil.ItemCallback<Repository>() {
        override fun areItemsTheSame(oldItem: Repository, newItem: Repository) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Repository, newItem: Repository) =
            oldItem == newItem
    }
}