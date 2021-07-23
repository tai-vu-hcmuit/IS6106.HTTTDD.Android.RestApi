package taivu.uit.htttdd.tryrestapiwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}


//package taivu.uit.htttdd.tryrestapiwithretrofit
//import android.os.Bundle
//import android.view.View
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//
//
//class MainActivity : AppCompatActivity() {
//    var responseText: TextView? = null
//    var apiInterface: APIInterface? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
////        responseText = findViewById<View>(R.id.responseText) as TextView
//
//        apiInterface = APIClient.getClient().create<APIInterface>(APIInterface::class.java)
//    }
//}