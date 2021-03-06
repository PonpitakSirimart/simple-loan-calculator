package th.ac.su.ict.ponpitak.simpleloancalculator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import th.ac.su.ict.ponpitak.simpleloancalculator.Data.Promotion
import th.ac.su.ict.ponpitak.simpleloancalculator.R
import th.ac.su.ict.ponpitak.simpleloancalculator.SummaryActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtMoneyLoan = findViewById<EditText>(R.id.moneyLoan)
        val edtInterestRate = findViewById<EditText>(R.id.InterestRate)
        val edtTime = findViewById<EditText>(R.id.timeLoan)
        val btnRec = findViewById<Button>(R.id.btnRec)

        val btnCal = findViewById<Button>(R.id.btnCal)

        btnRec.setOnClickListener {
            var intent= Intent(this@MainActivity, ProAdapter::class.java)

            startActivity(intent)
        }

        btnCal.setOnClickListener {
            var inA:Double=edtMoneyLoan.text.toString().toDouble()
            var inB:Double=edtInterestRate.text.toString().toDouble()
            var inC:Int=edtTime.text.toString().toInt()

            val calResult =(inA+(inA*(inB/100)*inC))/(inC*12)

            var intent= Intent(this@MainActivity, SummaryActivity::class.java)
            intent.putExtra("sum",calResult.toString())

            startActivity(intent)
        }
    }

}

class ProAdapter {

}
