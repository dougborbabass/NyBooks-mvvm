package com.douglasborba.booksofny.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.douglasborba.booksofny.R
import kotlinx.android.synthetic.main.activity_book_details.*

class BookDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        val title = intent.getStringExtra(EXTRA_TITLE)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)

        text_title.text = title
        text_description.text = description
    }

    // metodo estático para poder chamar o intent por outras activities
    companion object {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"

        fun getStartIntent(context: Context, title: String, description: String): Intent {
            return Intent(context, BookDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DESCRIPTION, description)
            }
        }
    }
}
