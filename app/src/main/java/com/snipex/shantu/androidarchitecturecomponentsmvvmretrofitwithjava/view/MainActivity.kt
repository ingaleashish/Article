package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.view

import android.os.Bundle
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.test.espresso.IdlingResource
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.R
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.espresso.SimpleIdlingResource


class MainActivity : AppCompatActivity() {
    // The Idling Resource which will be null in production.


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    companion object {

        private val TAG = MainActivity::class.java!!.getSimpleName()
        @Nullable
        var mIdlingResource: SimpleIdlingResource? = null
    }

    @VisibleForTesting
    @NonNull
    fun getIdlingResource(): IdlingResource {
        if (mIdlingResource == null) {
            mIdlingResource = SimpleIdlingResource()
        }
        return mIdlingResource as SimpleIdlingResource
    }

}
