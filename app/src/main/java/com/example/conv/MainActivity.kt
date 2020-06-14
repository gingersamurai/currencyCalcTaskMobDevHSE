package com.example.conv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
fun check(str: String): Boolean{
    if(str == "") return false

    return true
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // set fs
        usd1.setOnClickListener { fs.text = "USD" }
        eur1.setOnClickListener { fs.text = "EUR" }
        rub1.setOnClickListener { fs.text = "RUB" }
        uah1.setOnClickListener { fs.text = "UAH" }

        //set sd
        usd2.setOnClickListener { sd.text = "USD" }
        eur2.setOnClickListener { sd.text = "EUR" }
        rub2.setOnClickListener { sd.text = "RUB" }
        uah2.setOnClickListener { sd.text = "UAH" }
        calc.setOnClickListener {
            if (check(cnt.text.toString())) {
                var n = cnt.text.toString().toDouble()
                if(fs.text.toString() == "USD") {
                    if (sd.text.toString() == "USD") {
                        n *= 1
                    } else if (sd.text.toString() == "EUR") {
                        n *= 0.88
                    } else if (sd.text.toString() == "RUB") {
                        n *= 68
                    } else if (sd.text.toString() == "UAH") {
                        n *= 24.7
                    }
                } else if (fs.text.toString() == "EUR") {
                    if (sd.text.toString() == "USD") {
                        n *= 1.13
                    } else if (sd.text.toString() == "EUR") {
                        n *= 1
                    } else if (sd.text.toString() == "RUB") {
                        n *= 78
                    } else if (sd.text.toString() == "UAH") {
                        n *= 30
                    }
                } else if (fs.text.toString() == "RUB") {
                    if (sd.text.toString() == "USD") {
                        n *= 0.014
                    } else if (sd.text.toString() == "EUR") {
                        n *= 0.012
                    } else if (sd.text.toString() == "RUB") {
                        n *= 1
                    } else if (sd.text.toString() == "UAH") {
                        n *= 0.39
                    }
                } else if (fs.text.toString() == "UAH") {
                    if (sd.text.toString() == "USD") {
                        n *= 0.375
                    } else if (sd.text.toString() == "EUR") {
                        n *= 0.03
                    } else if (sd.text.toString() == "RUB") {
                        n *= 2.6
                    } else if (sd.text.toString() == "UAH") {
                        n *= 1
                    }
                }

                res.text = n.toString()
            } else res.text = "ERROR INPUT"
        }
        arrow.setOnClickListener {
            var c = fs.text.toString()
            fs.text = sd.text.toString()
            sd.text = c
        }
    }
}