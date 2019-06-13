package tech.burdzi0.ineedtofinishthisasap.view.dialog

import android.app.AlertDialog
import android.content.Context
import android.view.Gravity
import android.widget.TextView
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import tech.burdzi0.ineedtofinishthisasap.R
import tech.burdzi0.ineedtofinishthisasap.model.api.LinkService
import tech.burdzi0.ineedtofinishthisasap.view.LinkViewTransformer
import tech.burdzi0.ineedtofinishthisasap.view.fragments.ListAdapter

class InfoAlertDialog(private val context: Context):KoinComponent {

    private val linkService: LinkService by inject()
    private val transformer: LinkViewTransformer by inject()

    fun showAlertDialog(
        listAdapter: ListAdapter,
        position: Int
    ) {
        context.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton(R.string.ok) { dialog, id ->
                    dialog.cancel()
                }

                setNeutralButton(R.string.delete) { dialog, id ->
                    val link = listAdapter.get(position)
                    if (link != null) {
                        linkService.deleteLink(link.id)
                    }

                    val list = linkService.getAllLinks()
                    listAdapter.changeList(list.toMutableList())
                    listAdapter.notifyDataSetChanged()
                }
            }
            prepareDialogText(listAdapter, position, builder)
            builder.create().show()
        }
    }

    private fun prepareDialogText(
        listAdapter: ListAdapter,
        position: Int,
        builder: AlertDialog.Builder)
    {
        val textView = TextView(context)
        textView.gravity = Gravity.CENTER
        listAdapter.get(position)?.let { link ->
            textView.text = transformer.transform(link)
        }

        builder.setView(textView)
    }

}