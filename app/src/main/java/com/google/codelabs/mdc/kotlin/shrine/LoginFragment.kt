package com.google.codelabs.mdc.kotlin.shrine

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.shr_login_fragment.*
import kotlinx.android.synthetic.main.shr_login_fragment.view.*

/**
 * Fragment representing the login screen for Shrine.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        // Snippet from "Navigate to the next Fragment" section goes here.


        val view = inflater.inflate(R.layout.shr_login_fragment, container, false)

        view.next.setOnClickListener({
            if (!passValidation(pass_edit_text.text!!)) {
                pass_text_input.error = getString(R.string.shr_error_password)
            } else {
                // Clear the error.
                pass_text_input.error = null
                (activity as NavigationHost).navigateTo(ProductGridFragment(), false)
            }
        })

        // Clear the error once more than 8 characters are typed.
        view.pass_edit_text.setOnKeyListener({ _, _, _ ->
            if (passValidation(pass_edit_text.text!!)) {
                // Clear the error.
                pass_text_input.error = null
            }
            false
        })

        return view
    }

    private fun passValidation(text:Editable): Boolean{
        return text != null && text.length >= 5
    }

    // "isPasswordValid" from "Navigate to the next Fragment" section method goes here
}
