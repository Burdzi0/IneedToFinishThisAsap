package tech.burdzi0.ineedtofinishthisasap.model.api

import tech.burdzi0.ineedtofinishthisasap.model.Link

interface LinkService {
    fun getLinkById(id:Long): Link?
}
