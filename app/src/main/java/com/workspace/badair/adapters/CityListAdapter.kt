package com.workspace.badair.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.workspace.badair.R
import com.workspace.badair.models.Cities

class CityListAdapter (private val cities: Cities) : RecyclerView.Adapter<CityViewHolder>() {
    override fun getItemCount(): Int {
        return cities.data.size
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.cityItem.text = cities.data[position].city
        holder.stateItem.text = cities.data[position].state
        holder.countryItem.text = cities.data[position].country
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.activity_city, parent, false)
        return CityViewHolder(itemView)
    }
}

class CityViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    val cityItem : TextView = itemView.findViewById(R.id.item_city)
    val stateItem : TextView = itemView.findViewById(R.id.item_state)
    val countryItem : TextView = itemView.findViewById(R.id.item_country)
}
