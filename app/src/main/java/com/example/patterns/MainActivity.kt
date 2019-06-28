package com.example.patterns

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.patterns.builderpattern.buildermethod.UserBuilder
import com.example.patterns.builderpattern.objectdotbuildermethod.alertdialogexample.CustomAlertDialog
import com.example.patterns.builderpattern.objectdotbuildermethod.userexample.User
import com.example.patterns.factorypattern.IPicassoListener
import com.example.patterns.factorypattern.factory.ImagePrinterFactory
import com.example.patterns.factorypattern.IGlideListener
import com.example.patterns.singletonpattern.SingletonObject
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
        singletonPattern()
        customDialogBuilderPatternResult()


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

    private fun customDialogBuilderPatternResult() {

        CustomAlertDialog.Builder(this)
            .setDialogTitle("Info Dialog")
            .setDialogMessage("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
            .setFirstButtonName("OK")
            .setSecondButtonName("CANCEL")
            .setFirstButtonBackgroundDrawable(R.drawable.button_selector)
            .setSecondButtonBackgroundDrawable(R.drawable.button_selector)
            .setFirstButtonTextColor(android.R.color.white)
            .setSecondButtonTextColor(android.R.color.white)
            .setCancelable(true)
            .hideSecondButton(false)
            .showCustomDialog()

    }

    private fun factoryPatternResult() {

        ImagePrinterFactory(this, this).getImagePrinter(
            "Picasso",
            this,
            "https://cdn.pixabay.com/photo/2015/07/14/18/14/school-845196_1280.png",
            iv
        )
    }

    //region Glide & Picasso işlemleri
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
    //endregion

    private fun singletonPattern() {

        //SingletonObject.getInstance() diyerek objeyi tek seferlik yarattık. Şimdi içinde istediğimiz metoda erişebiliriz:
        Log.v("mExample", SingletonObject.getInstance().getNumber().toString())

    }
}
