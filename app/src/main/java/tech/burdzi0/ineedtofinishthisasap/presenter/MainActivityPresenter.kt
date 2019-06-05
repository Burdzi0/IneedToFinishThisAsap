package tech.burdzi0.ineedtofinishthisasap.presenter

import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import tech.burdzi0.ineedtofinishthisasap.model.api.LinkService
import tech.burdzi0.ineedtofinishthisasap.view.LinkViewTransformer
import tech.burdzi0.ineedtofinishthisasap.view.MainActivityView

class MainActivityPresenter(private val view:MainActivityView): KoinComponent {

    // This is bad
    // but DI within Activities and NonActivities
    // is a bit difficult at the moment

    private val linkService:LinkService by inject()
    private val transformer: LinkViewTransformer by inject()

    fun getLinkById(id: Long) {
        val link = linkService.getLinkById(id)
        view.showLink(transformer.transform(link))
    }

}