package com.example.aprendizadoudemy.componentsUdemy

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.aprendizadoudemy.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main2.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        initViews()

        loadSpinner()
        seekbarMinMax()

        spinnerListener()
        seekbarListener()
        switchListener()
        checkboxListener()
        radioListener()

    }

    private fun initViews() {
        buttonToast.setOnClickListener {
            val toast = Toast.makeText(this, "TOAST", Toast.LENGTH_LONG)
            val textView = toast.view?.let { findViewById<TextView>(android.R.id.message) }
            textView?.setTextColor(Color.RED)
            //toast.setGravity(Gravity.TOP,300,500)
            toast.show()
        }
        buttonSnack.setOnClickListener {
            val snack = Snackbar.make(linear_root, "Snack", Snackbar.LENGTH_LONG)

            snack.setAction("Desfazer", View.OnClickListener {
                toast("Desfeito")
            })

            snack.setActionTextColor(Color.BLUE)
            snack.setBackgroundTint(Color.GRAY)
            snack.show()
        }

        buttonGetSpinner.setOnClickListener {
            val selectedItem = spinnerStatic.selectedItem
            val selectedItemId = spinnerStatic.selectedItemId
            val selectedItemPosition = spinnerStatic.selectedItemPosition

            toast("Position: $selectedItemId: $selectedItem")
        }
        buttonSetSpinner.setOnClickListener {
            spinnerStatic.setSelection(1,true)
        }

        buttonGetSeekbar.setOnClickListener {
            toast("Seekbar: ${seekbar.progress}")
        }
        buttonSetSeekbar.setOnClickListener {
            seekbar.progress = 30
        }

        buttonDate.setOnClickListener {
           datePickerListener()
        }
        buttonTime.setOnClickListener {
            timePickerListener() }

        buttonprogressBarCircle.setOnClickListener {
            if (progressBarCircle.visibility == View.VISIBLE){
                progressBarCircle.visibility = View.INVISIBLE
                buttonprogressBarCircle.text = "Mostrar ProgressBar"
            } else{
                progressBarCircle.visibility = View.VISIBLE
                buttonprogressBarCircle.text = "Esconder ProgressBar"
            }
        }
        buttonProgressBarHorizontal.setOnClickListener {
            if (ProgressBarHorizontal.visibility == View.VISIBLE){
                ProgressBarHorizontal.visibility = View.INVISIBLE
                buttonProgressBarHorizontal.text = "Mostrar ProgressBar Horizontal"
            } else {
                ProgressBarHorizontal.visibility = View.VISIBLE
                buttonProgressBarHorizontal.text = "Esconder ProgressBar Horizontal"
            }
        }
    }

    private fun loadSpinner() {
        // Carrega os valores do spinner dinamicamente, esses valores poderiam ter vindo de uma api, class etc...
        val mlist = listOf("Gramas","Kg","Arroba", "Tonelada")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, mlist)
        spinnerDynamic.adapter = adapter
    }

    private fun seekbarMinMax() {
        if (Build.VERSION.SDK_INT >= 26){
            // Min nao funcionando, se setar o min no xml funciona
            seekbar.min = 5000
            seekbar.max = 100000
        } // Numa aplicacao real deveria fazer um else para caso SDK for < 26
    }

    private fun toast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }

    private fun seekbarListener(){
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textSeekValue.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Esse acontece quando vc clica no seekbar
                toast("Track started")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Esse acontece quando vc para de arrastar / Clicar
                toast("Track stoped")
            }

        })
    }

    private fun spinnerListener() {
        // Poderia ser o spinner dinamico tb

        spinnerStatic.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            // Quando um valor nao é selecionado
            override fun onNothingSelected(parent: AdapterView<*>?) {
                toast("nothing")
            }

            // Quando um valor é selecionado
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Pegar o texto da posicao selecionada
                toast(parent?.getItemAtPosition(position).toString())
            }
        }
    }

    private fun switchListener() {
        switchOnOff.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
                toast("Switch: ${if (isChecked) "true" else "false"}")
            }

        })
    }

    private fun checkboxListener() {
        checkboxOnOff.setOnCheckedChangeListener ( object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                toast("Checkbox: ${if (isChecked) "true" else "false"}")
            }

        } )
    }

    private fun radioListener(){
        val radioText = "Radio: "
        radioOn.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                textRadio.text = if (isChecked) "$radioText On" else "$radioText Off"
            }
        })

        radioOff.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                textRadio.text = if (isChecked) "$radioText Off" else "$radioText On"
            }

        })

    }

    private fun timePickerListener() {
        TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener{
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                buttonTime.text = "$hourOfDay: $minute"
            }

        },1,1,false).show()
    }

    private fun datePickerListener() {
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONDAY)
        val year = calendar.get(Calendar.YEAR)

        DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
            // essa funcao onDataSet -> quando usuario seleciona data e clicae em Ok, o que quer fazer com essa data selecionada?
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                buttonDate.text = "$dayOfMonth/${month+1}/$year"
            }/*Para inicializar com a data atual do usuario > essa linha de baixo*/
        },year, month, day).show()
    }

}