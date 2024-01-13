package com.example.myapplication.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.example.myapplication.core.ProgressDialog

open abstract class BaseActivity<B : ViewDataBinding, V : BaseViewModel>(private val layout: (inflater: LayoutInflater) -> B) :
    AppCompatActivity(), View.OnClickListener {
    private lateinit var progressDialog: ProgressDialog
    private lateinit var _binding: B

    protected val binding: B
        get() = _binding

    abstract val viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = layout(layoutInflater)
        setContentView(_binding.root)

        progressDialog = ProgressDialog(this)
    }

    protected fun showProgress() {
        if (!progressDialog.isShowing) {
            progressDialog.show()
        }
    }

    protected fun hideProgress() {
        if (progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }

    fun setUpClicks(vararg views: View) {
        for (view in views) {
            view.setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {}
}