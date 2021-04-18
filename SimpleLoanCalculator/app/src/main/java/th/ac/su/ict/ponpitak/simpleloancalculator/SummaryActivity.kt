package th.ac.su.ict.ponpitak.simpleloancalculator

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_installment)

        val showResult=findViewById<TextView>(R.id.showResult)

        val A=intent.getStringExtra("sum")
        showResult.setText(A)

        val btnBack=findViewById<Button>(R.id.btnBack);
        btnBack.setOnClickListener {
            var intent = Intent()
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}