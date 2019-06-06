package tech.burdzi0.ineedtofinishthisasap.view.fragments
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import tech.burdzi0.ineedtofinishthisasap.R
import tech.burdzi0.ineedtofinishthisasap.model.LinkFragmentItem

class ListAdapter(private val list: List<LinkFragmentItem>)
    : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val link: LinkFragmentItem = list[position]
        holder.bind(link)
    }

    override fun getItemCount(): Int = list.size

}

class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
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

}