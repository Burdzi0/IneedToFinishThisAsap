package tech.burdzi0.ineedtofinishthisasap

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start.*
import org.koin.android.ext.android.startKoin
import tech.burdzi0.ineedtofinishthisasap.di.applicationModule
import tech.burdzi0.ineedtofinishthisasap.view.fragments.FragmentMainActivity

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        startKoin(this, listOf(applicationModule))

        singleLink.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        allLinks.setOnClickListener {
            val intent = Intent(this, FragmentMainActivity::class.java)
            startActivity(intent)
        }
    }
}
