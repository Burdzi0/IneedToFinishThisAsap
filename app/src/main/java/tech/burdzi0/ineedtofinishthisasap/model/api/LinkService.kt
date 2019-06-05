package tech.burdzi0.ineedtofinishthisasap.model.api

import tech.burdzi0.ineedtofinishthisasap.executor.Executor.execute
import tech.burdzi0.ineedtofinishthisasap.model.Link
import java.util.concurrent.Callable

class LinkService {

    private val linkService = LinkServiceProvider.get()

    fun getLinkById(id:Long): Link? {
        val linkCall = linkService.getLinkById(id)
        val link = execute(
            Callable<Link> {
                linkCall.execute().body()
            }
        )
        return link
    }
}