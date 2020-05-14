package com.douglasborba.booksofny.presentation.base

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class BaseActivity: AppCompatActivity() {

    protected fun setupToolBar(toolbar: Toolbar, titleIdRes: Int, enable: Boolean){
        toolbar.title = getString(titleIdRes)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(enable)
    }
}