package com.example.assignment_ks.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.booksearchapp.data.repository.BookSearchRepository
import com.application.booksearchapp.data.repository.BookSearchRepositoryImpl
import com.example.assignment_ks.data.model.SearchResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookSearchViewModel(
    private val bookSearchRepository: BookSearchRepository
) : ViewModel() {

    // Api
    private val _searchResult = MutableLiveData<SearchResponse>()
    val searchResult: LiveData<SearchResponse> get() = _searchResult

    fun searchBooks(query: String) = viewModelScope.launch(Dispatchers.IO) {
        val response = bookSearchRepository.searchBooks(query, "accuracy", 1, 15)
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _searchResult.postValue(body)
            }
        }
    }
}