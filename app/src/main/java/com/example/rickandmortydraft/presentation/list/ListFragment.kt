package com.example.rickandmortydraft.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.rickandmortydraft.R
import com.example.rickandmortydraft.databinding.FragmentListBinding


class ListFragment : Fragment() {

   private lateinit  var binding :FragmentListBinding
   private val listAdapter by lazy { ListAdapter() }
    private val viewModel:ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRV()
        initSearch()
    }

    private fun initSearch() {
        binding.search.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
               listAdapter.filter.filter(newText)
                return true
            }

        })
    }


    private fun initRV() {
        viewModel.getall()
        binding.rvList.adapter = listAdapter
        viewModel.listLD.observe(viewLifecycleOwner){
            val list = it.body()!!.results
            listAdapter.setList(list)
            listAdapter.onItemClick ={characterId->
                openDetailFragment(characterId)
            }
        }

    }

    private fun openDetailFragment(characterId: Int) {
        val bundle = Bundle()
        bundle.putSerializable("characterId",characterId)
        Navigation.findNavController(requireView()).navigate(R.id.detailFragment,bundle)
    }
}