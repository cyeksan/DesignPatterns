package com.example.patterns.factorypattern.subclass

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.patterns.factorypattern.IGlideListener
import com.example.patterns.factorypattern.baseclass.ImagePrinter

class Glide(
    private val context: Context,
    private val url: String,
    private val imgView: ImageView,
    private val iGlideListener: IGlideListener
) : ImagePrinter() {

    override fun imagePrinting() {

        Glide.with(context).load(url).listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                iGlideListener.ifGlideCannotBeUsed()
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                iGlideListener.showGlideSuccessToast()
                return false
            }
        }).into(imgView)
    }

}


