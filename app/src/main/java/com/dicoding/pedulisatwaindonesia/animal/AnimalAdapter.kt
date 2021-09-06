package com.dicoding.pedulisatwaindonesia.animal

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.dicoding.pedulisatwaindonesia.R
import com.dicoding.pedulisatwaindonesia.data.AnimalEntity
import com.dicoding.pedulisatwaindonesia.databinding.ItemAnimalBinding
import com.dicoding.pedulisatwaindonesia.detail.DetailActivity
import com.dicoding.pedulisatwaindonesia.detail.DetailViewModel.Companion.ANIMAL

class AnimalAdapter: RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    private var anim = ArrayList<AnimalEntity>()

    fun setAnimal(movies: ArrayList<AnimalEntity>?){
        if (movies.isNullOrEmpty()) return
        this.anim.clear()
        this.anim.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val itemMovieBinding = ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(anim[position])
    }

    override fun getItemCount(): Int = anim.size

    class AnimalViewHolder(private val binding: ItemAnimalBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("NewApi")
        fun bind(animal: AnimalEntity) {
            with(binding) {
                tvName.text = animal.name
                tvSpecies.text = animal.species

                Glide.with(itemView.context)
                        .load(animal.poster)
                        .transform(RoundedCorners(28))
                        .into(ivPoster)

                val bitmap = BitmapFactory.decodeResource(itemView.context.resources, animal.poster)

                Palette.from(bitmap).generate { palette ->
                    val defValue = itemView.resources.getColor(R.color.dark, itemView.context.theme)
                    cardItem.setCardBackgroundColor(palette?.getDarkMutedColor(defValue) ?: defValue)
                }

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ANIMAL, animal.id)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY, ANIMAL)

                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}