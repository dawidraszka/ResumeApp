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
    var currentProject : Project? = null
    val firestoreDatabase = Firebase.firestore

    val projects = MutableLiveData<List<Project>>()

    init {
        //TODO REMOVE
        val projectsTemp = listOf(
            Project(
                "BookOn!",
                "Java",
                "Application for people interested in books. BookOn compares prices, displays reviews and shows Google search results. ",
                listOf("Firebase MLKit"), listOf()
            ),
            Project(
                "ResumeApp",
                "Kotlin",
                "Some description. Some description. Some description. Some description. Some description. Some description. ",
                listOf("Firebase MLKit"), listOf()
            )
        )

        for (project in projectsTemp) {
            if (project.name != null)
                firestoreDatabase.collection("projects").document("dawid_raszka")
                    .collection("projects").document(project.name).set(project)
        }
    }

    fun getProjects(): LiveData<List<Project>> {
        firestoreDatabase.collection("projects").document("dawid_raszka").collection("projects")
            .get()
            .addOnSuccessListener { documents ->
                projects.value = documents.toObjects()
               /* for (document in documents) {

                }
                projects.value = it.toObject<List<Project>>()*/
            }
        return projects
    }
}