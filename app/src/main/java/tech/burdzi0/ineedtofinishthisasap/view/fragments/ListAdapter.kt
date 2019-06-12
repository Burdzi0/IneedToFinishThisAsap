package tech.burdzi0.ineedtofinishthisasap.view.fragments
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import tech.burdzi0.ineedtofinishthisasap.R
import tech.burdzi0.ineedtofinishthisasap.model.Link
import tech.burdzi0.ineedtofinishthisasap.model.LinkFragmentItem
import tech.burdzi0.ineedtofinishthisasap.view.dialog.InfoAlertDialog

class ListAdapter(
    private val list: MutableList<Link>,
    private val context: Context
) : RecyclerView.Adapter<LinkFragmentItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinkFragmentItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return LinkFragmentItemViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: LinkFragmentItemViewHolder, position: Int) {
        val link: Link = list[position]
        holder.bind(link) {
            InfoAlertDialog(context).showAlertDialog(this, position)
        }
    }

    override fun getItemCount(): Int = list.size

    fun removeItem(id:Int) {
        list.removeAt(id)
    }

    fun get(position: Int):Link? {
        return list[position]
    }
}

class LinkFragmentItemViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
    private var url: TextView? = null
    private var expiration: TextView? = null

    init {
        url = itemView.findViewById(R.id.url)
        expiration = itemView.findViewById(R.id.expiration)
    }

    fun bind(link: LinkFragmentItem) {
        url?.text = link.url
        expiration?.text = link.expiration
    }

    fun bind(link: Link, func: () -> Unit) {

        itemView.setOnClickListener {
            func()
        }

        url?.text = link.url
        expiration?.text = link.expiration
    }

}