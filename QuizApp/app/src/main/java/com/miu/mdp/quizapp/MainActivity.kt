package com.miu.mdp.quizapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    var score =0

    @RequiresApi(Build.VERSION_CODES.O)
    var date: LocalDateTime = LocalDateTime.now()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rg1.setOnCheckedChangeListener { group, checkedId ->
            val clicked = group.findViewById(checkedId) as RadioButton
            val checked = clicked.isChecked
            if(checked){
                Toast.makeText(this, clicked.text.toString() + " selected",Toast.LENGTH_LONG).show()
            }
            if (clicked.equals(rg1.rbt2)){
                score=50
            }
            else score=0
        }

        rg2.checkBox1.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                Toast.makeText(this,"You selected choice one ", Toast.LENGTH_LONG).show()
                score+=25
            }
        }

        rg2.checkBox2.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                Toast.makeText(this,"You selected choice two ", Toast.LENGTH_LONG).show()
                score+=0
            }
        }


        rg2.checkBox3.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                Toast.makeText(this,"You selected choice three ", Toast.LENGTH_LONG).show()
                score+=25
            }

        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun submit(view: View) {

        var alert = AlertDialog.Builder(this)
        alert.setTitle("Your score")
        var timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        var timeFormatted = date.format(timeFormatter)
        alert.setMessage("Congratulations! You submitted on $timeFormatted, You achieved $score%")
        val createAlert:AlertDialog = alert.create()
        createAlert.show()
    }
    fun reset(view: View) {
        score=0
        rg1.rbt1.isChecked=false
        rg1.rbt2.isChecked=false
        rg1.rbt3.isChecked=false
        rg2.checkBox1.isChecked=false
        rg2.checkBox2.isChecked=false
        rg2.checkBox3.isChecked=false

    }

}