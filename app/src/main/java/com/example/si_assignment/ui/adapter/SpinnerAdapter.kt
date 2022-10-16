package com.example.si_assignment.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.si_assignment.R
import com.example.si_assignment.ui.adapter.model.SpinnerModel

class SpinnerAdapter(context: Context, private val list: List<SpinnerModel>, private val listener: OnItemSelect) :
    BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ItemHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.custom_spinner_item, parent, false)
            viewHolder = ItemHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ItemHolder
        }
        viewHolder.teamName.text = list[position].teamName
        view.setOnClickListener {
            listener.onClick(list[position].id)
        }
        return view
    }

    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Any = list[position]

    override fun getItemId(position: Int): Long = position.toLong()

    class ItemHolder(view: View) {
        val teamName: TextView
        init {
            teamName = view.findViewById(R.id.team_name)
        }
    }

    interface OnItemSelect{
        fun onClick(int: Int)
    }
}