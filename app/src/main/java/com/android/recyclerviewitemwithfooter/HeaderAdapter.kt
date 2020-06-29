package com.tiwari.rajshekhar.headerrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.recyclerviewitemwithfooter.Generic
import com.android.recyclerviewitemwithfooter.R

import java.util.ArrayList

/**
 * Created by rajshekhar on 2/8/16.
 */

class HeaderAdapter(internal var context: Context, internal var generics: ArrayList<Generic>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    /*    if (viewType == TYPE_HEADER) {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.header_item, parent, false)
            return HeaderViewHolder(v)
        } else */if (viewType == TYPE_ITEM) {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return GenericViewHolder(v)
        } else if (viewType == TYPE_FOOTER) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.footer_item, parent, false)
            return FooterViewHolder(view)
        }
        throw RuntimeException("there is no type that matches the type $viewType + make sure your using types correctly")
    }


    private fun getItem(position: Int): Generic {
        return generics[position]
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
/*        if (holder is HeaderViewHolder) {
            holder.txtTitleHeader.text = "Header View"
            holder.txtTitleHeader.setOnClickListener { Toast.makeText(context, "You clicked at Header View!", Toast.LENGTH_SHORT).show() }
        } else*/ if (holder is FooterViewHolder) {
            holder.txtFooter.text = "Footer View"
            holder.txtFooter.setOnClickListener { Toast.makeText(context, "You clicked at Footer View", Toast.LENGTH_SHORT).show() }
        } else if (holder is GenericViewHolder) {
            holder.txtName.text = "Recycler Item $position"
            holder.txtName.setOnClickListener { Toast.makeText(context, "You clicked at item $position", Toast.LENGTH_SHORT).show() }
        }
    }

    override fun getItemViewType(position: Int): Int {
     /*   if (position == 0) {
            return TYPE_HEADER
        } else*/ if (isPositionFooter(position)) {
            return TYPE_FOOTER
        }
        return TYPE_ITEM
    }

    private fun isPositionHeader(position: Int): Boolean {
        return position == 0
    }

    private fun isPositionFooter(position: Int): Boolean {
        return position == generics.size + 1
    }

    override fun getItemCount(): Int {
        return generics.size + 2
    }

    internal inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitleHeader: TextView

        init {
            this.txtTitleHeader = itemView.findViewById(R.id.txtHeader) as TextView
        }
    }

    internal inner class GenericViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtName: TextView

        init {
            this.txtName = itemView.findViewById(R.id.txtName) as TextView
        }
    }

    internal inner class FooterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtFooter: TextView

        init {
            this.txtFooter = view.findViewById(R.id.txtFooter) as TextView
        }
    }

    companion object {

        private val TYPE_HEADER = 0
        private val TYPE_ITEM = 0
        private val TYPE_FOOTER = 1
    }
}




