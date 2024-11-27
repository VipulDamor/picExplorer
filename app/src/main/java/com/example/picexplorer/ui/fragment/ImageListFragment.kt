package com.example.picexplorer.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.picexplorer.R
import com.example.picexplorer.databinding.FragmentImageListBinding
import com.example.picexplorer.ui.adapter.ImageListAdapter
import com.example.picexplorer.ui.fragment.placeholder.PlaceholderContent
import com.example.picexplorer.ui.viewmodels.ImageListViewmodel
import com.example.picexplorer.ui.viewmodels.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageListFragment : Fragment() {

    private var _binding: FragmentImageListBinding? = null
    private val binding get() = _binding!!

    private val imagesListViewmodel by viewModels<ImageListViewmodel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImageListBinding.inflate(inflater, container, false)

        activity?.let {
            imagesListViewmodel.imagesList.observe(it) { list ->
                val adapter = ImageListAdapter(list)
                binding.recyclerview.adapter = adapter
                binding.recyclerview.layoutManager = LinearLayoutManager(it)
            }
        }
        return binding.root
    }


}