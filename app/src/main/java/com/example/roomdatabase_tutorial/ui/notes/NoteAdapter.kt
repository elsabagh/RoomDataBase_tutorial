package com.example.roomdatabase_tutorial.ui.notes

import com.example.roomdatabase_tutorial.R
import com.example.roomdatabase_tutorial.data.Note
import com.example.roomdatabase_tutorial.ui.base.BaseAdapter
import com.example.roomdatabase_tutorial.ui.base.BaseInteractionListener

class NoteAdapter(items: List<Note>, listener: NotesFragment) :
    BaseAdapter<Note>(items, listener) {
    override val layoutId: Int = R.layout.item_notes

}

interface NoteInteractionListener : BaseInteractionListener{

}