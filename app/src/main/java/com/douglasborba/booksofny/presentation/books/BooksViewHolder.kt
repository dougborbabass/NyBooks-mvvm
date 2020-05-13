package com.douglasborba.booksofny.presentation.books

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.douglasborba.booksofny.data.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BooksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val title = view.text_title
    private val author = view.text_author

    fun bindView(book: Book){
        title.text = book.title
        author.text = book.author
    }

}