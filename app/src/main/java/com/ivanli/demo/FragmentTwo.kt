package com.ivanli.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.fragment_two.*
import kotlinx.android.synthetic.main.row_function.view.*
import java.util.*


class  FragmentTwo : Fragment(){
    val items = listOf<String>("Item1","Item2","Item3","Item4","Item5","Item6","Item7")

    val weekNamelist = listOf<String>("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
    var c = Calendar.getInstance()
    var c_year = c.get(Calendar.YEAR)
    var c_month = c.get(Calendar.MONTH)
    var c_day = c.get(Calendar.DAY_OF_MONTH)
    var c_dayOfWeek = c.get(Calendar.DAY_OF_WEEK)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_two,container,false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycer.layoutManager = LinearLayoutManager(activity)
        recycer.setHasFixedSize(true)
        recycer.adapter = ItemAdapter()
    }

    inner class ItemAdapter():RecyclerView.Adapter<ItemHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_function,parent,false)
            val holder = ItemHolder(view)
            return  holder
        }

        override fun getItemCount(): Int {
            return items.size
        }

        override fun onBindViewHolder(holder: ItemHolder, position: Int) {
            holder.item.text = items.get(position)
            holder.date.text = setDateFormat(position)
        }
    }

    class  ItemHolder(view : View) : RecyclerView.ViewHolder(view){
        var item : TextView = view.tv_item
        var date : TextView = view.tv_date
    }

    fun setDateFormat(position: Int): String {
        if(position != 0) {
            c.add(Calendar.DAY_OF_MONTH, -1)
            c_year = c.get(Calendar.YEAR)
            c_month = c.get(Calendar.MONTH)
            c_day = c.get(Calendar.DAY_OF_MONTH)
            c_dayOfWeek = c.get(Calendar.DAY_OF_WEEK)
        }
        return "${c_year}/${c_month+1}/$c_day (${weekNamelist[c_dayOfWeek-1]})"
    }
}