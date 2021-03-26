package pl.dawidraszka.resumeapp.data.repository.resume

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import pl.dawidraszka.resumeapp.data.model.resume.Resume
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResumeRepository @Inject constructor() {
    val firestoreDatabase = Firebase.firestore
    val resume = MutableLiveData<Resume>()

    fun getResume(): LiveData<Resume> {
        firestoreDatabase.collection("resumes").document("resume")
            .get()
            .addOnSuccessListener {
                resume.value = it.toObject<Resume>()
            }
        return resume
    }
}