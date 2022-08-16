package com.example.rickandmortydraft.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortydraft.MainUtils.MAIN
import com.example.rickandmortydraft.databinding.ItemListBinding
import com.example.rickandmortydraft.domain.entities.Character
import java.util.*
import kotlin.collections.ArrayList

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>(),Filterable {

    private var filteredMovieList:List<Character.Result> = emptyList()
    private var movieList:List<Character.Result> = emptyList()

    var onItemClick: ((Int) -> Unit)? = null


    inner  class ViewHolder (var binding:ItemListBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder){
            with(filteredMovieList[position]){
                val characterId = this.id
                itemView.setOnClickListener {
                    onItemClick!!.invoke(characterId)
                }
                binding.characterName.text = this.name
                Glide.with(MAIN)
                    .load(this.image)
                    .centerCrop()
                    .into(binding.characterImage)
            }
        }
    }

    override fun getItemCount(): Int  = filteredMovieList.size

    fun setList(list:List<Character.Result>){
        filteredMovieList = list
        movieList = list
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object :Filter(){
            override fun performFiltering(char: CharSequence?): FilterResults {
                val searchString = char.toString()
                if(searchString.isEmpty()){
                    filteredMovieList = movieList
                }else{
                    val tempFilteredList :ArrayList<Character.Result> = ArrayList()
                    for (movie in movieList){
                        if(movie.name.lowercase(Locale.getDefault()).contains(searchString)){
                            tempFilteredList.add(movie)
                        }
                    }
                    filteredMovieList = tempFilteredList
                }
                val filterResults = FilterResults()
                filterResults.values = filteredMovieList
                return filterResults

            }

            override fun publishResults(p0: CharSequence?, filterResult: FilterResults?) {
                filteredMovieList = filterResult!!.values as List<Character.Result>
                notifyDataSetChanged()
            }

        }
    }


}