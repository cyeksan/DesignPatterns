package com.example.patterns

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.patterns.builderpattern.buildermethod.UserBuilder
import com.example.patterns.builderpattern.objectdotbuildermethod.User
import com.example.patterns.factorypattern.IPicassoListener
import com.example.patterns.factorypattern.factory.ImagePrinterFactory
import com.example.patterns.factorypattern.IGlideListener
import com.example.patterns.strategypattern.baseclass.Calculate
import com.example.patterns.strategypattern.strategies.Multiplication
import com.example.patterns.strategypattern.strategies.Subtraction
import com.example.patterns.strategypattern.strategies.Summation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IPicassoListener, IGlideListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        strategyPatternResult()
        builderPatternResult()
        objectDotBuilderPatternResult()
        factoryPatternResult()

    }

    private fun strategyPatternResult() {

        val result = Calculate(10, 5).executeCalculation(Summation())
        Log.v("strategyPatternResult", result.toString())

        val result2 = Calculate(10, 5).executeCalculation(Subtraction())
        Log.v("strategyPatternResult", result2.toString())

        val result3 = Calculate(10, 5).executeCalculation(Multiplication())
        Log.v("strategyPatternResult", result3.toString())
    }

    private fun builderPatternResult() {

        val user = UserBuilder()
            .setUserName("xyz")
            .setUserSurname("abc")
            .setUserHeight(14.1)
            .setUserWeight(12.3)
            .setUserAge(10)
            .build()

        Log.v(
            "builderPatternResult",
            "${user.getUserName()}, ${user.getUserSurname()}, ${user.getUserAge()}, ${user.getUserHeight()}, ${user.getUserWeight()}"
        )

    }

    private fun objectDotBuilderPatternResult() {

        val user = User.Builder()
            .setUserName("hasan")
            .setUserSurname("yilmaz")
            .setUserAge(15)
            .setUserHeight(175.5)
            .setUserWeight(68.9)
            .build()

        Log.v(
            "obj.BuilderPatternRes",
            "${user.getUserName()}, ${user.getUserSurname()}, ${user.getUserAge()}, ${user.getUserHeight()}, ${user.getUserWeight()}"
        )

    }

    private fun factoryPatternResult() {

        ImagePrinterFactory(this, this).getImagePrinter(
            "Picasso",
            this,
            "https://cdn.pixabay.com/photo/2015/07/14/18/14/school-845196_1280.png",
            iv
        )
    }

    override fun showPicassoSuccessToast() {
        Toast.makeText(this, "Picasso çalıştı", Toast.LENGTH_LONG).show()
    }

    override fun ifPicassoCannotBeUsed() {

        ImagePrinterFactory(this, this).getImagePrinter(
            "Glide",
            this,
            "https://cdn.pixabay.com/photo/2015/07/14/18/14/school-845196_1280.png",
            iv
        )

    }

    override fun ifGlideCannotBeUsed() {

        Handler().postDelayed({

            Glide.with(this).load("").error(R.drawable.ic_android_black_24dp).into(iv)

        }, 500)

        Toast.makeText(this, "Default resim gösteriliyor ", Toast.LENGTH_LONG).show()
    }

    override fun showGlideSuccessToast() {
        Toast.makeText(this, "Glide çalıştı ", Toast.LENGTH_LONG).show()
    }

}
