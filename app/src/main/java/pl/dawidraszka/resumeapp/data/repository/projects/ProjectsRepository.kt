package pl.dawidraszka.resumeapp.data.repository.projects

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import pl.dawidraszka.resumeapp.data.model.projects.Project
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProjectsRepository @Inject constructor() {
    var currentProject: Project? = null
    val firestoreDatabase = Firebase.firestore

    val projects = MutableLiveData<List<Project>>()

    fun getProjects(): LiveData<List<Project>> {
        firestoreDatabase.collection("projects").document("dawid_raszka").collection("projects")
            .get()
            .addOnSuccessListener { documents ->
                projects.value = documents.toObjects()
            }
        return projects
    }
}