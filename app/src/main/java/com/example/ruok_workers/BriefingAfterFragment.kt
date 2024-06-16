package com.example.ruok_workers

import android.annotation.SuppressLint
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class BriefingAfterFragment : Fragment() {

    private lateinit var dbManager: DBManager
    private lateinit var sqlitedb: SQLiteDatabase
    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_briefing_after, container, false)
        listView = view.findViewById(R.id.listView_briefing_after)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dbManager = DBManager(requireContext(), "RUOKsample", null, 1)
        sqlitedb = dbManager.readableDatabase
        displayBriefings()
    }

    @SuppressLint("Range")
    private fun displayBriefings() {
        val briefingsAfter = mutableListOf<String>()

        val cursor: Cursor = sqlitedb.rawQuery("SELECT * FROM briefing WHERE b_type = 0", null)

        while (cursor.moveToNext()) {
            val title = cursor.getString(cursor.getColumnIndex("b_title"))
            val bTime = cursor.getString(cursor.getColumnIndex("b_time"))
            briefingsAfter.add("$title - $bTime")
        }

        cursor.close()
        dbManager.close()

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, briefingsAfter)
        listView.adapter = adapter
    }
}
