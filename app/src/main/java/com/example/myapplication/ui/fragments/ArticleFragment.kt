package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.models.Article
import com.example.myapplication.ui.NewsActivity
import com.example.myapplication.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article) {
    lateinit var viewModel : NewsViewModel

    val args : ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(args.article.url)
        }

        fab.setOnClickListener{
            viewModel.saveArticle(args.article)
            Snackbar.make(view, "Article Saved", Snackbar.LENGTH_LONG).show()
        }
    }
}