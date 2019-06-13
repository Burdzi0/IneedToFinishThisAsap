package tech.burdzi0.ineedtofinishthisasap.view.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.ext.android.inject
import tech.burdzi0.ineedtofinishthisasap.R
import tech.burdzi0.ineedtofinishthisasap.model.LinkFragmentItem
import tech.burdzi0.ineedtofinishthisasap.model.api.LinkService

class MainFragment : Fragment() {

    private val linkService: LinkService by inject()
    private val linksFromApi = linkService.getAllLinks()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_main, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListAdapter(linksFromApi.toMutableList(), context)
        }
    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}