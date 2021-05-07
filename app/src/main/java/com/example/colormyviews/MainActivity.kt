package com.example.colormyviews

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    lateinit var rootConstraintLayout: ConstraintLayout
    lateinit var boxOneText: TextView
    lateinit var boxTwoText: TextView
    lateinit var boxThreeText: TextView
    lateinit var boxFourText: TextView
    lateinit var boxFiveText: TextView

    lateinit var redButton: Button
    lateinit var yellowButton: Button
    lateinit var greenButton: Button

    lateinit var clickableViews: List<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    /**
     * Set event listeners
     */
    private fun setListeners() {
        rootConstraintLayout = findViewById(R.id.constraint_layout)
        boxOneText = findViewById(R.id.box_one_text)
        boxTwoText = findViewById(R.id.box_two_text)
        boxThreeText = findViewById(R.id.box_three_text)
        boxFourText = findViewById(R.id.box_four_text)
        boxFiveText = findViewById(R.id.box_five_text)

        redButton = findViewById(R.id.red_button)
        yellowButton = findViewById(R.id.yellow_button)
        greenButton = findViewById(R.id.green_button)

        clickableViews = listOf(rootConstraintLayout, boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText, redButton, yellowButton, greenButton)
        clickableViews.map { view -> view.setOnClickListener{ makeColored(view); makeTextColored(view, true); } }
    }

    /**
     * Change background color
     */
    private fun makeColored(view: View) {
        when (view.id) {
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.YELLOW)
            R.id.red_button -> boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> boxFiveText.setBackgroundResource(R.color.my_green)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    /**
     * Set background image
     */
    private fun setImage(view: View) {
        when (view.id) {
            R.id.box_one_text -> view.setBackgroundResource(android.R.drawable.ic_menu_upload_you_tube)
            R.id.box_two_text -> view.setBackgroundResource(android.R.drawable.ic_lock_power_off)
            R.id.box_three_text -> view.setBackgroundResource(android.R.drawable.ic_lock_silent_mode_off)
            R.id.box_four_text -> view.setBackgroundResource(android.R.drawable.stat_notify_missed_call)
            R.id.box_five_text -> view.setBackgroundResource(android.R.drawable.ic_dialog_email)
            R.id.red_button -> boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> boxFiveText.setBackgroundResource(R.color.my_green)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    /**
     * Set text color
     */
    private fun makeTextColored(view: View, toDefault: Boolean) {
        if (view is TextView) {
            if (toDefault) {
                view.setTextColor(Color.WHITE)
            } else {
                when (view.id) {
                    R.id.box_one_text -> view.setTextColor(Color.BLACK)
                    R.id.box_two_text -> view.setTextColor(Color.GRAY)
                    R.id.box_three_text -> view.setTextColor(Color.BLUE)
                    R.id.box_four_text -> view.setTextColor(Color.MAGENTA)
                    R.id.box_five_text -> view.setTextColor(Color.YELLOW)
                    else -> view.setTextColor(Color.LTGRAY)
                }
            }
        }
    }

    /**
     * Switch event handlers
     */
    fun switchFunction(view: View) {
        if (view is Switch && view.isChecked) {
            clickableViews.map { view -> view.setOnClickListener{ setImage(view); makeTextColored(view, false); } }
        } else {
            clickableViews.map { view -> view.setOnClickListener{ makeColored(view); makeTextColored(view, true); } }
        }
        Toast.makeText(this, "switch clicked", Toast.LENGTH_SHORT).show()
    }
}