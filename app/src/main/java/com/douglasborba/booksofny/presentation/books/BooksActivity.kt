package com.douglasborba.booksofny.presentation.books

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.douglasborba.booksofny.R
import com.douglasborba.booksofny.presentation.base.BaseActivity
import com.douglasborba.booksofny.presentation.details.BookDetailsActivity
import kotlinx.android.synthetic.main.activity_books.*
import kotlinx.android.synthetic.main.include_toolbar.*

class BooksActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        setupToolBar(toolbar_main, R.string.book_title, false)

        // criando o factory do viewModel
        val viewModel: BooksViewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)

        // fica escutando todas alterações do livedata
        viewModel.booksLiveData.observe(this, Observer {
            //só entra no let se for diferente de nulo
            it?.let { books ->
                // instanciando o recyclerview
                with(recycler_books) {
                    layoutManager =
                        LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = BooksAdapter(books) { book ->
                        val intent = BookDetailsActivity.getStartIntent(
                            this@BooksActivity,
                            book.title,
                            book.description
                        )
                        this@BooksActivity.startActivity(intent)
                    }
                }
            }
        })

        viewModel.viewFlipperLiveData.observe(this, Observer {
            it?.let { viewFlipper ->
                viewflipper_books.displayedChild = viewFlipper.first
                viewFlipper.second?.let { messageErrorResId ->
                    text_error.text = getString(messageErrorResId)
                }
            }
        })

        viewModel.getBooks()
    }
}
