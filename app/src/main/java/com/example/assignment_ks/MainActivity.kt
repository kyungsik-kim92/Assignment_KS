package com.example.assignment_ks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.application.booksearchapp.data.repository.BookSearchRepositoryImpl
import com.example.assignment_ks.data.viewmodel.BookSearchViewModel
import com.example.assignment_ks.data.viewmodel.BookSearchViewModelProviderFactory
import com.example.assignment_ks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var bookSearchViewModel: BookSearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val bookSearchRepository = BookSearchRepositoryImpl()
        val factory = BookSearchViewModelProviderFactory(bookSearchRepository)
        bookSearchViewModel = ViewModelProvider(this, factory)[BookSearchViewModel::class.java]
    }
}