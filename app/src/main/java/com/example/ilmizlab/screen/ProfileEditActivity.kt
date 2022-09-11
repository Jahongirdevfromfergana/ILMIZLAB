package com.example.ilmizlab.screen

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import com.example.ilmizlab.R
import com.example.ilmizlab.R.*
import com.example.ilmizlab.databinding.ActivityProfileEditBinding
import com.example.ilmizlab.models.ProfileModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class  ProfileEditActivity : AppCompatActivity() {
    companion object{
        val IMAGE_REQUEST_CODE = 100
    }
    lateinit var binding: ActivityProfileEditBinding
    lateinit var auth: FirebaseAuth
    lateinit var databaseReference: DatabaseReference
    lateinit var storageReference: StorageReference
    lateinit var imageUri: Uri
    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProfileEditBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        showProgressBar()

        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        binding.btnSave.setOnClickListener {
//            val userImage = binding.userImage.setImageDrawable(drawable.img1)
            val userName = binding.userName.text.toString()

            val user = ProfileModel(userName)
            if (uid != null){
                databaseReference.child(uid).setValue(user).addOnCompleteListener {
                    if (it.isSuccessful){
                        uploadProfile()
                    }else{
                        hideProgressBar()
                        Toast.makeText(this, "Failed to update profile!", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        binding.tvBack.setOnClickListener {
            finish()
        }
        binding.tvEditImage.setOnClickListener {
            pickImageGallery()
        }
    }
    private fun uploadProfile() {
        imageUri = Uri.parse("android.resource://$packageName/${R.drawable.img1}")
        storageReference = FirebaseStorage.getInstance().getReference("Users/"+auth.currentUser?.uid)
        storageReference.putFile(imageUri).addOnSuccessListener {

            hideProgressBar()
            Toast.makeText(this, "Profile succussfuly update", Toast.LENGTH_LONG).show()

        }.addOnFailureListener{
            hideProgressBar()
            Toast.makeText(this, "Failed to upload the image!", Toast.LENGTH_LONG).show()

        }
    }

    private fun pickImageGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data != null){


            binding.userImage.setImageURI(data?.data)
        }
    }
    private fun showProgressBar(){
        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.diolog_wait)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()


    }
    private fun hideProgressBar(){
        dialog.dismiss()
    }
}