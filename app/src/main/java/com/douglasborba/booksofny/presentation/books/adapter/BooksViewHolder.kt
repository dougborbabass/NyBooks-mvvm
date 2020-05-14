package com.douglasborba.booksofny.presentation.books.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.douglasborba.booksofny.data.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BooksViewHolder(
    view: View,
    private val onItemClickListener: ((book: Book) -> Unit)
) : RecyclerView.ViewHolder(view) {

    private val title = view.text_title
    private val author = view.text_author

    fun bindView(book: Book) {
        title.text = book.title
        author.text = book.author

        itemView.setOnClickListener {
            onItemClickListener.invoke(book)
        }
    }

}