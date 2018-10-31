package com.balljoint.mktsui.app.getAverage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.balljoint.mktsui.sdk.getAverage.GetAverage


class MainActivity : AppCompatActivity() {

    private lateinit var getAverage: GetAverage
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAverage = GetAverage()

        val eText = findViewById(R.id.edittext) as EditText

        val btn1 = findViewById(R.id.addNumber) as Button

        btn1.setOnClickListener{
            val str = eText.getText().toString()
            if (str.isNotBlank()) {
                val num = Integer.parseInt(str)
                getAverage.addMoreNumbers(num)
                val msg = Toast.makeText(getBaseContext(), "$str added", Toast.LENGTH_SHORT)
                msg.show()
                eText.getText().clear()
            }
        }


        val btn2 = findViewById(R.id.getAverage_action) as Button
        btn2.setOnClickListener{
            val result = getAverage.computeAverageInt()

            val res = String.format("Average: %s\n",
                    result)
            val textView = findViewById(R.id.getAverage_result) as TextView
            textView.setText(res)
        }

    }
}