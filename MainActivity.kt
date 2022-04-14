package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button=findViewById(R.id.button)
        rollButton.setOnClickListener{
            rolldice()
        //val toast= Toast.makeText(this,"Dice Rolled!",Toast.LENGTH_SHORT)
        //toast.show()
        }
    }

    private fun rolldice() {
        val dice=dice(6)
        val sdice=dice(6)
        val diceImage: ImageView =findViewById(R.id.imageView)
        val diceroll=dice.roll()
        val DiceImage :ImageView=findViewById(R.id.imageView2)
        val sdiceroll=sdice.roll()


        val drawableResource=when(diceroll and sdiceroll)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription=diceroll.toString()
        DiceImage.setImageResource(drawableResource)
        DiceImage.contentDescription=sdiceroll.toString()
    }
}
class dice(private val numsides:Int)
{
    fun roll():Int{
        return(1..numsides).random()
    }
}