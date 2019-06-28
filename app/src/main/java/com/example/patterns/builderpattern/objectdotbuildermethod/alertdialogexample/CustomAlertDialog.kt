package com.example.patterns.builderpattern.objectdotbuildermethod.alertdialogexample

import android.app.Dialog
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.view.Window
import kotlinx.android.synthetic.main.dialog_layout.*
import android.graphics.LightingColorFilter

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.View


class CustomAlertDialog {

    private var title: String? = null
    private var message: String? = null
    private var isCancelable = true
    private var firstButtonName: String? = null
    private var secondButtonName: String? = null
    private var firstButtonDrawable = com.example.patterns.R.drawable.button_selector
    private var secondButtonDrawable = com.example.patterns.R.drawable.button_selector
    private var firstButtonTextColor: Int? = null
    private var secondButtonTextColor: Int? = null
    private var hideSecondButton: Boolean? = null

    class Builder(context: Context) {


        private var context: Context? = null

        private var customAlertDialog: CustomAlertDialog? = null

        init {

            this.context = context
            customAlertDialog = CustomAlertDialog()
        }

        fun setDialogTitle(title: String): Builder {

            customAlertDialog?.title = title
            return this

        }

        fun setDialogMessage(message: String): Builder {

            customAlertDialog?.message = message
            return this
        }

        fun setCancelable(isCancelable: Boolean): Builder {

            customAlertDialog?.isCancelable = isCancelable
            return this

        }

        fun setFirstButtonName(firstButtonName: String): Builder {

            customAlertDialog?.firstButtonName = firstButtonName
            return this
        }

        fun setSecondButtonName(secondButtonName: String): Builder {

            customAlertDialog?.secondButtonName = secondButtonName
            return this
        }

        fun setFirstButtonBackgroundDrawable(firstButtonDrawable: Int): Builder {

            customAlertDialog?.firstButtonDrawable = firstButtonDrawable
            return this
        }

        fun setSecondButtonBackgroundDrawable(secondButtonDrawable: Int): Builder {

            customAlertDialog?.secondButtonDrawable = secondButtonDrawable
            return this
        }

        fun setFirstButtonTextColor(firstButtonTextColor: Int): Builder {

            customAlertDialog?.firstButtonTextColor = firstButtonTextColor
            return this
        }

        fun setSecondButtonTextColor(secondButtonTextColor: Int): Builder {

            customAlertDialog?.secondButtonTextColor = secondButtonTextColor
            return this
        }

        fun hideSecondButton(hideSecondButton: Boolean): Builder {

            customAlertDialog?.hideSecondButton = hideSecondButton
            return this

        }

        fun showCustomDialog(): CustomAlertDialog {

            Dialog(context!!).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setContentView(com.example.patterns.R.layout.dialog_layout)

                window?.setLayout(

                    ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT
                )

                title.text = customAlertDialog?.title
                desc.text = customAlertDialog?.message
                firstButton.text = customAlertDialog?.firstButtonName
                secondButton.text = customAlertDialog?.secondButtonName
                firstButton.background = ContextCompat.getDrawable(context, customAlertDialog?.firstButtonDrawable!!)
                secondButton.background = ContextCompat.getDrawable(context, customAlertDialog?.secondButtonDrawable!!)
                firstButton.setTextColor(ContextCompat.getColor(context, customAlertDialog?.firstButtonTextColor!!))
                secondButton.setTextColor(ContextCompat.getColor(context, customAlertDialog?.secondButtonTextColor!!))
                setCancelable(customAlertDialog?.isCancelable!!)

                if (customAlertDialog?.hideSecondButton!!) {

                    secondButton.visibility = View.GONE
                }

                show()

            }

            return customAlertDialog!!
        }
    }

}