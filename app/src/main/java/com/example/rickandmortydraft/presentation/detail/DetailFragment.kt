package com.example.rickandmortydraft.presentation.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.rickandmortydraft.MainUtils.MAIN
import com.example.rickandmortydraft.R
import com.example.rickandmortydraft.databinding.FragmentDetailBinding
import com.example.rickandmortydraft.databinding.FragmentListBinding


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel : DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
    }

    private fun initObserver() {
        var mBundle: Bundle? = Bundle()
        mBundle = arguments
        var characterId =  mBundle!!.getInt("characterId")
        if (characterId != null) {
            viewModel.getCharacterById(characterId)
            Log.i("id",characterId.toString())
        }
        viewModel.characterByIdLD.observe(viewLifecycleOwner){
            Glide.with(MAIN)
                .load(it.body()!!.image)
                .into(binding.characterImage)
            Log.i("tag", it.body()!!.image)
        }

    }


}