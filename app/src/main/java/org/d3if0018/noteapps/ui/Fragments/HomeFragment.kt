package org.d3if0018.noteapps.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import org.d3if0018.noteapps.R
import org.d3if0018.noteapps.ViewModel.NotesViewModel
import org.d3if0018.noteapps.databinding.FragmentHomeBinding
import org.d3if0018.noteapps.ui.Adapter.NotesAdapter


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val viewModel : NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        viewModel.getNotes().observe(viewLifecycleOwner, { noteList ->

            binding.rcvAllNotes.layoutManager=GridLayoutManager(requireContext(), 1)
            binding.rcvAllNotes.adapter = NotesAdapter(requireActivity(), noteList)
        })

        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNotesFragment)
        }

        return binding.root
    }

}