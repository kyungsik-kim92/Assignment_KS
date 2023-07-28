package com.application.booksearchapp.data.repository

import com.example.assignment_ks.data.api.RetrofitInstance.api
import com.example.assignment_ks.data.model.SearchResponse
import retrofit2.Response

class BookSearchRepositoryImpl : BookSearchRepository {

    override suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<SearchResponse> {
        return api.searchBooks(query, sort, page, size)
    }
}