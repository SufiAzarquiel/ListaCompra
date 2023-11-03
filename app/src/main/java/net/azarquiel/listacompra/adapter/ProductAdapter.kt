package net.azarquiel.recyclerviewproducts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.azarquiel.listacompra.R
import net.azarquiel.listacompra.model.Product

class ProductAdapter(val context: Context,
                    val layout: Int
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private var dataList: List<Product> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewlayout = layoutInflater.inflate(layout, parent, false)
        return ViewHolder(viewlayout, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    internal fun setProducts(products: List<Product>) {
        this.dataList = products
        notifyDataSetChanged()
    }


    class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {
        fun bind(dataItem: Product){
            val tvRowProductName = itemView.findViewById(R.id.tvRowProductName) as TextView
            val tvRowProductStock = itemView.findViewById(R.id.tvRowProductStock) as TextView


            tvRowProductName.text = dataItem.name
            tvRowProductStock.text = dataItem.stock

            itemView.tag = dataItem
        }
    }
}