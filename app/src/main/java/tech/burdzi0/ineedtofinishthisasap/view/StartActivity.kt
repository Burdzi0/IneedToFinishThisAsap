package tech.burdzi0.ineedtofinishthisasap.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start.*
import tech.burdzi0.ineedtofinishthisasap.MainActivity
import tech.burdzi0.ineedtofinishthisasap.R
import tech.burdzi0.ineedtofinishthisasap.view.fragments.FragmentMainActivity

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

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
