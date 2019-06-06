package tech.burdzi0.ineedtofinishthisasap.model.api

import tech.burdzi0.ineedtofinishthisasap.executor.Executor.execute
import tech.burdzi0.ineedtofinishthisasap.model.Link
import java.util.concurrent.Callable

class LinkServiceImpl : LinkService{

    private val linkService = LinkRetrofitServiceProvider.get()

    override fun getLinkById(id:Long): Link? {
        val linkCall = linkService.getLinkById(id)
        return execute(
            Callable<Link> {
                linkCall.execute().body()
            }
        )
    }

    override fun getAllLinks(): List<Link>? {
        val linkCall = linkService.getAllLinks()
        return execute(
            Callable<List<Link>> {
                linkCall.execute().body()
            }
        )
    }
}