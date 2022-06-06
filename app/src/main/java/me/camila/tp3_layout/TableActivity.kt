package me.camila.tp3_layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class TableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        val name = intent.getStringExtra("Name")
        val email = intent.getStringExtra("Email")

        val tvName = this.findViewById<TextView>(R.id.tvName)

        "Olá $name, vamos jogar? Some os números mentalmente".also { tvName.text = it }


        //------------



        val tv1 = this.findViewById<TextView>(R.id.tv1)
        val tv2 = this.findViewById<TextView>(R.id.tv2)
        val tv3 = this.findViewById<TextView>(R.id.tv3)
        val tv4 = this.findViewById<TextView>(R.id.tv4)
        val tv5 = this.findViewById<TextView>(R.id.tv5)
        val tv6 = this.findViewById<TextView>(R.id.tv6)
        val tv7 = this.findViewById<TextView>(R.id.tv7)
        val tv8 = this.findViewById<TextView>(R.id.tv8)
        val tv9 = this.findViewById<TextView>(R.id.tv9)

        var tvList = mutableListOf<TextView>()

        tvList.add(tv1)
        tvList.add(tv2)
        tvList.add(tv3)
        tvList.add(tv4)
        tvList.add(tv5)
        tvList.add(tv6)
        tvList.add(tv7)
        tvList.add(tv8)
        tvList.add(tv9)

        tvRange(tvList)

        //----------------------


        val btResult = this.findViewById<Button>(R.id.btResult)
        val btRandom = this.findViewById<Button>(R.id.btRandom)


        //-------------------------
        val etRow1 = this.findViewById<EditText>(R.id.etRow1)
        val etRow2 = this.findViewById<EditText>(R.id.etRow2)
        val etRow3 = this.findViewById<EditText>(R.id.etRow3)


        //---------------------
        btResult.setOnClickListener {
            var result = 0

            if (validated(etRow1, etRow2, etRow3)) {
                if (check(tv1, tv2, tv3, etRow1)) {
                    result++
                }

                if (check(tv4, tv5, tv6, etRow2)) {
                    result++
                }

                if (check(tv7, tv8, tv9, etRow3)) {
                    result++
                }
                val resultIntent = Intent(this, ResultActivity::class.java)

                resultIntent.putExtra("Result", result)
                resultIntent.putExtra("Name",name)
                resultIntent.putExtra("Email",email)

                startActivity(resultIntent)

            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }

        }

        btRandom.setOnClickListener {
            tvRange(tvList)
            etRow1.setText("")
            etRow2.setText("")
            etRow3.setText("")

        }

    }

    private fun tvRange(list: List<TextView>) {
        val numRange = 1..5000
        for (item in list) {
            item.text = numRange.random().toString()
        }
    }

    private fun check(tv1: TextView, tv2: TextView, tv3: TextView, et: EditText): Boolean {

        val num1 = tv1.text.toString().toInt()
        val num2 = tv2.text.toString().toInt()
        val num3 = tv3.text.toString().toInt()

        val resultRow = num1 + num2 + num3


        val etRow = et.text.toString().toInt()

        return etRow == resultRow
    }

    private fun validated(et1: EditText, et2: EditText, et3: EditText): Boolean {
        return et1.text.isNotBlank() && et2.text.isNotBlank() && et3.text.isNotBlank()
    }

}

