package com.app.dial.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var source = PublishSubject.create<Int>()
   private var count=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        source.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).skip(10).subscribe {

            Toast.makeText(this,"count"+it,Toast.LENGTH_LONG).show()

        }

        btnClick.setOnClickListener {

            source.onNext(count++)
        }


    }
}
