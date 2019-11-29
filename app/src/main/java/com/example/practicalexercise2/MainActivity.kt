package com.example.practicalexercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalculate = findViewById<View>(R.id.Calculate)
        btnCalculate.setOnClickListener {
            try{
            val weight = Weight.text.toString();
            val height = Height.text.toString();
            val heightInMeter = height.toDouble() / 100;
            val power2InHeight = heightInMeter.toDouble() * heightInMeter.toDouble();
            val bMI= (weight.toDouble()) / (power2InHeight.toDouble());

                val status:String

            val diceImage: ImageView = findViewById(R.id.Empty)

            if (bMI < 18.5) {
                Empty.setImageResource(R.drawable.under)
                status = "Under"
            }
            else if (bMI >= 18.5 && bMI <= 24.9) {
                Empty.setImageResource(R.drawable.normal)
                status = "Normal"
            }
            else  {
                Empty.setImageResource(R.drawable.over)
                status = "Over"
            }
            BMI_Value.text = "BMI value is %.2f".format(bMI, status)
        }catch(ex:Exception){
           val toast:Toast = Toast.makeText(this,"Invalid Input",Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()




            }
        }
        Reset.setOnClickListener(){it
            BMI_Value.text= "";
            Weight.setText("")
            Height.setText("")
            Empty.setImageResource(R.drawable.empty)

    }}

}
