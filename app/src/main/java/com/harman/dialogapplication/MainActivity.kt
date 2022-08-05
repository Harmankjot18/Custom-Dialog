package com.harman.dialogapplication

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.harman.dialogapplication.databinding.ActivityMainBinding
import com.harman.dialogapplication.databinding.CustomDialogBinding

class MainActivity : AppCompatActivity() {
    lateinit var tvName2 :TextView
    lateinit var tvAddress2 :TextView
     lateinit var tvGender2 :TextView
     lateinit var tvOther : TextView
    lateinit var etName1 :EditText
    lateinit var etAddress1 :EditText
    lateinit var rgGender :RadioGroup
    lateinit var rbHe : RadioButton
    lateinit var rbShe : RadioButton
    lateinit var rbOther : RadioButton
    lateinit var etOther1 : EditText
    lateinit var binding :ActivityMainBinding
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding =ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)
        var binding1 =CustomDialogBinding.inflate(layoutInflater)
         dialog = Dialog(this)
        dialog.setContentView(binding1.root)
         binding.btnUpdate.setOnClickListener {
             binding1.etName1.setText(binding.tvName2.text.toString())
             binding1.etAddress1.setText(binding.tvAddress2.text.toString())
             when(binding.tvGender2.text.toString()){
                 "male"-> binding1.rbHe.isChecked = true
                 "female"-> binding1.rbShe.isChecked = true
                 else-> {
                     binding1.rbOther.isChecked = true
                     binding1.etOther1.visibility = View.VISIBLE
                 }
             }
             binding1.rgGender.setOnCheckedChangeListener{radioGroup,id->
                 when(id){
                     R.id.rbOther-> {
                         binding1.etOther1.visibility = View.VISIBLE
                         binding.tvOther.visibility = View.VISIBLE
                         binding.tvGender2.setText("Others")
                         binding1.etOther1.text.clear()
                     }
                     R.id.rbHe->{
                         binding1.etOther1.visibility = View.INVISIBLE
                         binding.tvOther.visibility=View.INVISIBLE
                         binding.tvGender2.setText("Male")
                     }
                     R.id.rbShe->{
                        binding1.etOther1.visibility = View.INVISIBLE
                         binding.tvOther.visibility=View.INVISIBLE
                         binding.tvGender2.setText("Female")
                     }
                     else-> {
                         binding1.etOther1.visibility = View.INVISIBLE
                         binding.tvOther.visibility=View.INVISIBLE
                     }
                 }
             }
             binding1.btnUpdate1.setOnClickListener {
                 if (binding1.etName1.text.isNullOrEmpty()){
                     Toast.makeText(this,"Enter your name",Toast.LENGTH_LONG).show()
                     binding1.etName1.requestFocus()
                 }
                 else if (binding1.etAddress1.text.isNullOrEmpty()){
                     Toast.makeText(this,"Enter your Address",Toast.LENGTH_LONG).show()
                      binding1.etAddress1.requestFocus()
                 }
                 else if(binding1.etOther1.text.isNullOrEmpty() && binding1.rbOther.isChecked){
                     Toast.makeText(this, "Enter other name", Toast.LENGTH_LONG).show()
                     binding1.etOther1.requestFocus()
                 }
                 else{
                     binding.tvName2.setText(binding1.etName1.text.toString())
                     binding.tvAddress2.setText(binding1.etAddress1.text.toString())
                     binding.tvOther.setText(binding1.etOther1.text.toString())
                     when(binding1.rgGender.checkedRadioButtonId){
                         R.id.rbOther-> {
                             binding1.etOther1.visibility = View.VISIBLE
                             binding.tvOther.visibility = View.VISIBLE
                             binding.tvGender2.setText("Others")
                             binding1.etOther1.text.clear()
                         }
                         R.id.rbHe->{
                             binding1.etOther1.visibility = View.INVISIBLE
                             binding.tvOther.visibility=View.INVISIBLE
                             binding.tvGender2.setText("Male")
                         }
                         R.id.rbShe->{
                             binding1.etOther1.visibility = View.INVISIBLE
                             binding.tvOther.visibility=View.INVISIBLE
                             binding.tvGender2.setText("Female")
                         }
                         else-> {
                             binding1.etOther1.visibility = View.INVISIBLE
                             binding.tvOther.visibility=View.INVISIBLE
                         }
                     }
                     dialog.dismiss()
                 }
             }
             dialog.show()

             }

    }
}