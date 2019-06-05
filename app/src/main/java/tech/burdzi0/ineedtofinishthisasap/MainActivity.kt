package tech.burdzi0.ineedtofinishthisasap

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import tech.burdzi0.ineedtofinishthisasap.executor.Executor.execute
import tech.burdzi0.ineedtofinishthisasap.model.Link
import tech.burdzi0.ineedtofinishthisasap.model.api.LinkServiceProvider
import java.util.concurrent.Callable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = LinkServiceProvider.get()

        val linkCall = service.getLinkById(1)
        val link = execute(
            Callable<Link> {
                linkCall.execute().body()
            }
        )
        Log.d("LINK", link.toString())

    }
}
