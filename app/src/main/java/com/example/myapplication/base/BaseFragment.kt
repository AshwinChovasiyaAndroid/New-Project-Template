package com.example.myapplication.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.myapplication.core.ProgressDialog

open abstract class BaseFragment<B : ViewDataBinding, V : BaseViewModel>(private val layout: (inflater: LayoutInflater) -> B) :
    Fragment(), View.OnClickListener {
    private lateinit var progressDialog: ProgressDialog
    private lateinit var _binding: B

    protected val binding: B
        get() = _binding

    abstract val viewModel: V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = layout(inflater)
        _binding.lifecycleOwner = this
        progressDialog = ProgressDialog(requireContext())
        return binding.root
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