package tech.burdzi0.ineedtofinishthisasap

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*
import tech.burdzi0.ineedtofinishthisasap.presenter.MainActivityPresenter
import tech.burdzi0.ineedtofinishthisasap.view.MainActivityView

class MainActivity : AppCompatActivity(), MainActivityView {

    private val presenter = MainActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linkId.addTextChangedListener(
            textWatcher()
        )
    }

    private fun textWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.toString().isEmpty() && !s.toString().isBlank()) {
                    val id = s.toString().toLong()
                    presenter.getLinkById(id)
                }
            }

        }
    }

    override fun showLink(link: String) {
        linkInfo.text = link
    }

}

