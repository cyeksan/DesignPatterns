package com.example.patterns.factorypattern.subclass

import android.widget.ImageView
import com.example.patterns.factorypattern.IPicassoListener
import com.example.patterns.factorypattern.baseclass.ImagePrinter
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class Picasso(private val url: String,
              private val imgView: ImageView,
              private val iPicassoListener: IPicassoListener
) : ImagePrinter() {


    override fun imagePrinting() {

        Picasso.get().load(url).into(imgView,

            //region Check if Picasso is onSuccess or onError.
            object : Callback{
            override fun onSuccess() {

                //region  If onSuccess is triggered, Picasso can be used and a Toast message is shown.
                iPicassoListener.showPicassoSuccessToast()
                //endregion

            }

            override fun onError(e: Exception?) {

                //region If onError is triggered, Picasso cannot be used and Glide will be used on MainActivity.
                iPicassoListener.ifPicassoCannotBeUsed()
                //endregion


            }
        }
            //endregion

        )
    }

}