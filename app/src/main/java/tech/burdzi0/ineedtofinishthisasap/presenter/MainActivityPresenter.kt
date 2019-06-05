package tech.burdzi0.ineedtofinishthisasap.presenter

import tech.burdzi0.ineedtofinishthisasap.model.api.LinkService
import tech.burdzi0.ineedtofinishthisasap.view.LinkViewTransformer.transform
import tech.burdzi0.ineedtofinishthisasap.view.MainActivityView

class MainActivityPresenter(private val view:MainActivityView) {

    private val linkService = LinkService()

    fun getLinkById(id: Long) {
        val link = linkService.getLinkById(id)
        view.showLink(transform(link))
    }

}