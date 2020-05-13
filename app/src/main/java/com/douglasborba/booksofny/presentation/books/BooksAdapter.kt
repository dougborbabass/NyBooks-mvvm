package com.douglasborba.booksofny.presentation.books

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.douglasborba.booksofny.R
import com.douglasborba.booksofny.data.model.Book

class BooksAdapter(private val books: List<Book>) : RecyclerView.Adapter<BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent,false)
        return BooksViewHolder(view)
    }

    override fun getItemCount() = books.count()

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bindView(books[position])
    }
}