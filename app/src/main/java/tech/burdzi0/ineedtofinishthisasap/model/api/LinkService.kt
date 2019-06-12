package tech.burdzi0.ineedtofinishthisasap.model.api

import tech.burdzi0.ineedtofinishthisasap.model.Link
import java.util.concurrent.Callable

interface LinkService {
    fun getLinkById(id:Long): Link?
    fun getAllLinks(): List<Link>
    fun deleteLink(id: Long): Callable<Link>
}
