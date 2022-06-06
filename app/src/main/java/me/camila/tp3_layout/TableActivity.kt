package me.camila.tp3_layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class TableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        val name = intent.getStringExtra("Name")

        val tvName = this.findViewById<TextView>(R.id.tvName)

        "Olá $name, vamos jogar? Some os números mentalmente".also { tvName.text = it }


        //------------

        var result = 0
        val numRange = 1..5000

        val tv1 = this.findViewById<TextView>(R.id.tv1)
        val tv2 = this.findViewById<TextView>(R.id.tv2)
        val tv3 = this.findViewById<TextView>(R.id.tv3)
        val tv4 = this.findViewById<TextView>(R.id.tv4)
        val tv5 = this.findViewById<TextView>(R.id.tv5)
        val tv6 = this.findViewById<TextView>(R.id.tv6)
        val tv7 = this.findViewById<TextView>(R.id.tv7)
        val tv8 = this.findViewById<TextView>(R.id.tv8)
        val tv9 = this.findViewById<TextView>(R.id.tv9)

        //----------------------


        val btResult = this.findViewById<Button>(R.id.btResult)

        //-----------------------------


        //-------------------------
        val etRow1 = this.findViewById<EditText>(R.id.etRow1)
        val etRow2 = this.findViewById<EditText>(R.id.etRow2)
        val etRow3 = this.findViewById<EditText>(R.id.etRow3)

        //----------------------------

        tv1.text = numRange.random().toString()
        tv2.text = numRange.random().toString()
        tv3.text = numRange.random().toString()
        tv4.text = numRange.random().toString()
        tv5.text = numRange.random().toString()
        tv6.text = numRange.random().toString()
        tv7.text = numRange.random().toString()
        tv8.text = numRange.random().toString()
        tv9.text = numRange.random().toString()

        //---------------------
        btResult.setOnClickListener {

            if(check(tv1,tv2,tv3,etRow1)){
                result ++
            }

            if(check(tv4,tv5,tv6,etRow2)){
                result ++
            }

            if(check(tv7,tv8,tv9,etRow3)){
                result ++
            }

            val resultIntent = Intent(this, ResultActivity::class.java)

            resultIntent.putExtra("Result", result)

            Toast.makeText(this, "$result", Toast.LENGTH_LONG).show()

            startActivity(resultIntent)


        }




    }

    private fun check(tv1:TextView, tv2:TextView, tv3:TextView, et:EditText): Boolean {
        val num1 = tv1.text.toString().toInt()
        val num2 = tv2.text.toString().toInt()
        val num3 = tv3.text.toString().toInt()

        val resultRow = num1 + num2 + num3

        val etRow = et.text.toString().toInt()

        return etRow == resultRow
    }
}