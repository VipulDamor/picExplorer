package com.example.picexplorer.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.picexplorer.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

@androidx.databinding.BindingAdapter("android:text")
fun bindText(editText: TextInputEditText, text: String?) {
    editText.setText(text)
}

@androidx.databinding.InverseBindingAdapter(attribute = "android:text")
fun captureText(editText: TextInputEditText): String {
    return editText.text.toString()
}

@androidx.databinding.BindingAdapter("errorText")
fun setError(view: TextInputLayout, error: String?) {
    view.error = error
}

@BindingAdapter("android:imageURL")
fun setImageURL(view: ImageView, url: String?) {
    Glide.with(view.context).load(url).apply(
        RequestOptions().centerCrop().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
    ).into(view)
}

@androidx.databinding.BindingAdapter("clearErrorOnTextChange")
fun clearErrorOnTextChange(editText: EditText, error: String?) {
    editText.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(
            charSequence: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {
        }

        override fun onTextChanged(
            charSequence: CharSequence?,
            start: Int,
            before: Int,
            count: Int
        ) {
        }

        override fun afterTextChanged(editable: Editable?) {
            // Clear the error when text changes
            if (error != null && editable?.isNotEmpty() == true) {
                editText.error = null
            }
        }
    })
}