package com.example.roomdatabase_tutorial.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase_tutorial.data.Note
import com.example.roomdatabase_tutorial.databinding.FragmentNotesBinding
import com.example.roomdatabase_tutorial.ui.base.BaseAdapter

class NotesFragment : Fragment(), NoteInteractionListener {


    private lateinit var myAdapter: BaseAdapter<Note>


    private lateinit var binding: FragmentNotesBinding
    private val viewModel by activityViewModels<NotesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotesBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerNotes.setHasFixedSize(true)

        binding.recyclerNotes.layoutManager = LinearLayoutManager(context)

        myAdapter = NoteAdapter(emptyList(), this)
        binding.recyclerNotes.adapter = myAdapter

    }

}