// CustomAdapter.kt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example32.listviewadapter.R

class CustomAdapter(private val dataList: List<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_A = 1
        private const val VIEW_TYPE_B = 2
        private const val VIEW_TYPE_C = 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_A -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_type_a, parent, false)
                ViewHolderTypeA(view)
            }
            VIEW_TYPE_B -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_type_b, parent, false)
                ViewHolderTypeB(view)
            }
            VIEW_TYPE_C -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_type_c, parent, false)
                ViewHolderTypeC(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            VIEW_TYPE_A -> {
                val itemA = dataList[position] as ItemA
                val viewHolderTypeA = holder as ViewHolderTypeA
                viewHolderTypeA.bind(itemA)
            }
            VIEW_TYPE_B -> {
                val itemB = dataList[position] as ItemB
                val viewHolderTypeB = holder as ViewHolderTypeB
                viewHolderTypeB.bind(itemB)
            }
            VIEW_TYPE_C -> {
                val itemC = dataList[position] as ItemC
                val viewHolderTypeC = holder as ViewHolderTypeC
                viewHolderTypeC.bind(itemC)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (dataList[position]) {
            is ItemA -> VIEW_TYPE_A
            is ItemB -> VIEW_TYPE_B
            is ItemC -> VIEW_TYPE_C
            else -> throw IllegalArgumentException("Invalid type of data at position $position")
        }
    }
}

class ViewHolderTypeA(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(itemA: ItemA) {

    }
}

class ViewHolderTypeB(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(itemB: ItemB) {

    }
}

class ViewHolderTypeC(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(itemC: ItemC) {

    }
}


data class ItemA(val text: String)


data class ItemB(val text: String)


data class ItemC(val text: String)