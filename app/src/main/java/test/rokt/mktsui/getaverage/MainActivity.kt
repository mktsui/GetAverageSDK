package test.rokt.mktsui.getaverage

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.json.JSONObject
import test.rokt.mktsui.sdk.getaverage.GetAverage
import java.net.HttpURLConnection


class MainActivity : AppCompatActivity() {

    private lateinit var getAverage: GetAverage
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAverage = GetAverage()

        val eText = findViewById(R.id.edittext) as EditText

        val btn1 = findViewById(R.id.addNumber) as Button

        btn1.setOnClickListener{
            val str = Integer.parseInt(eText.getText().toString())
            getAverage.addMoreNumbers(str)
            val msg = Toast.makeText(getBaseContext(), "$str added", Toast.LENGTH_SHORT)
            msg.show()
            eText.getText().clear()
        }


        val btn2 = findViewById(R.id.getAverage_action) as Button
        btn2.setOnClickListener{
            val result = getAverage.computeAverageInt()

            val res = String.format("Average: %s\n",
                    result)
            val textView = findViewById(R.id.getAverage_result) as TextView
            textView.setText(res)
        }

//        val url = "https://roktcdn1.akamaized.net/store/test/android/prestored_scores.json"
//        GetDefault().execute(url)

    }
}
/*
inner class GetDefault : AsyncTask<String, String, String>() {

    override fun onPreExecute() {
        // Before doInBackground
    }

    override fun doInBackground(vararg urls: String?): String {
        var urlConnection: HttpURLConnection? = null

        try {
            val url = URL(urls[0])

            urlConnection = url.openConnection() as HttpURLConnection

            var inString = streamToString(urlConnection.inputStream)

            publishProgress(inString)
        } catch (ex: Exception) {

        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect()
            }
        }

        return " "
    }

    override fun onProgressUpdate(vararg values: String?) {
        try {
            var json = JSONObject(values[0])
        } catch (ex: Exception) {

        }
    }

    override fun onPostExecute(result: String?) {
        // Done
    }
}
*/