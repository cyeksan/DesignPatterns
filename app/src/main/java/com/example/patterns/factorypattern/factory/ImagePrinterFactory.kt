package com.example.patterns.factorypattern.factory

import android.content.Context
import android.widget.ImageView
import com.example.patterns.factorypattern.subclass.Glide
import com.example.patterns.factorypattern.IPicassoListener
import com.example.patterns.factorypattern.IGlideListener
import com.example.patterns.factorypattern.subclass.Picasso

class ImagePrinterFactory(private val iPicassoListener: IPicassoListener, private val iGlideListener: IGlideListener) {

    companion object

    fun getImagePrinter(type: String, context: Context, url: String, imgView: ImageView) : Unit? {

        if(type == "Glide") {

            return Glide(context, url, imgView, iGlideListener).imagePrinting()
        }

        else if(type == "Picasso") {

            return Picasso(url, imgView, iPicassoListener).imagePrinting()
        }

        return null
    }

}