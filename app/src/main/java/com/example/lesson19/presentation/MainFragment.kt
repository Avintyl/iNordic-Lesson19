package com.example.lesson19.presentation

import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.lesson19.R
import com.google.android.material.snackbar.Snackbar
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import java.util.*
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.concurrent.TimeUnit


class MainFragment : Fragment(R.layout.fragment_main) {

    companion object {
        const val image_url = "https://startandroid.ru/images/stories/courses/kotlin/001/x010.jpg.pagespeed.ic.s-EGcSPt9X.webp"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

//        val observable = Observable.just(1, 2, 3)
//        observable.subscribe { Log.e("Main", "$it") }
//
//        val secondObservable = Observable.fromIterable(listOf("Hell", "ooooo", "burned"))
//        secondObservable
//            .concatMap { word -> Observable.just(word).delay(3, TimeUnit.SECONDS) }
//            //.delay(3, TimeUnit.SECONDS)
//            .subscribe {
//                Log.e("Main", "$it")
//                //secondObservable.delay(3, TimeUnit.SECONDS)
////                Snackbar.make(
////                    requireContext(), requireView(), "$it",
////                        Snackbar.LENGTH_LONG).show()
//            }
        btnPress.setOnClickListener{
            Observable.just(loadImage(ivPicture, image_url))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, {Log.e("Exception", it.toString())})
        }
    }

    private fun loadImage(iv: ImageView, url: String) {
        Glide.with(this)
            .load(url)
            .into(iv)
    }
}