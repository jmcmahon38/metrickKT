package com.testing.metrickkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val convertNum = findViewById<EditText>(R.id.idConvertNumber)
        val rbCmToIn = findViewById<RadioButton>(R.id.idRBCmToIn)
        val rbInToCm = findViewById<RadioButton>(R.id.idRBInToCm)
        val txtResult = findViewById<TextView>(R.id.idResult)
        val convertIt = findViewById<Button>(R.id.idBtnConvert)

        convertIt.setOnClickListener {
            val tenth = DecimalFormat("#.#")
            val dblMeasure = convertNum.text.toString().toDouble()
            val conversionRate = 2.54
            var convertMeasureNum: Double?

            if (rbInToCm.isChecked){
                if (dblMeasure <= 72) {
                    convertMeasureNum = dblMeasure * conversionRate
                    txtResult.text = tenth.format(convertMeasureNum) + " cm"
                } else {
                    Toast.makeText(this, "Inches must be less than 72", Toast.LENGTH_LONG).show()
                }
            }
            if (rbCmToIn.isChecked){
                if (dblMeasure <= 185) {
                    convertMeasureNum = dblMeasure / conversionRate
                    txtResult.text = tenth.format(convertMeasureNum) + " in"
                } else {
                    Toast.makeText(this, "Inches must be less than 185", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}