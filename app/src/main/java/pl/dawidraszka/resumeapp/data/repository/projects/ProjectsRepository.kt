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

    init {
        val projectsTemp = listOf(
            Project(
                "BookOn!",
                "Java",
                "Application for people interested in books. BookOn compares prices, displays reviews and shows Google search results.",
                listOf(
                    "Firebase MLKit",
                    "Retrofit2",
                    "Room",
                    "CameraX",
                    "MVVM", "LiveData", "Glide"
                ),
                listOf(
                    "https://firebasestorage.googleapis.com/v0/b/resumeapp-1b18f.appspot.com/o/BookOn!_2.png?alt=media&token=bfaa83c1-edfc-4561-b66f-74000caeb770",
                    "https://firebasestorage.googleapis.com/v0/b/resumeapp-1b18f.appspot.com/o/BookOn!_3.png?alt=media&token=77889228-8a77-496b-80ac-e1de2e24097c",
                    "https://firebasestorage.googleapis.com/v0/b/resumeapp-1b18f.appspot.com/o/BookOn!_4.png?alt=media&token=b277a331-b424-425e-b2b8-7239f0eee5d8",
                    "https://firebasestorage.googleapis.com/v0/b/resumeapp-1b18f.appspot.com/o/BookOn!_5.png?alt=media&token=5d92414f-2713-4dcb-88b2-e99b4ca1a6a1",
                    "https://firebasestorage.googleapis.com/v0/b/resumeapp-1b18f.appspot.com/o/BookOn!_6.png?alt=media&token=ba418657-ede7-4a4c-99c1-bb14269a76fa",
                    "https://firebasestorage.googleapis.com/v0/b/resumeapp-1b18f.appspot.com/o/BookOn!_1.png?alt=media&token=12fdae8c-971a-4bd3-bea3-65fdc269c624"
                ),
                "https://github.com/dawidraszka/BookOn-Public"
            ),
            Project(
                "Dawid Raszka Resume",
                "Kotlin",
                "Resume/CV application.",
                listOf("Dagger2", "Firebase Firestore", "Glide", "MVVM", "LiveData"),
                listOf(
                    "https://firebasestorage.googleapis.com/v0/b/resumeapp-1b18f.appspot.com/o/DawidRaszkaResume_2.png?alt=media&token=84129d04-ba4c-4922-973c-1e3fd8e2c28e",
                    "https://firebasestorage.googleapis.com/v0/b/resumeapp-1b18f.appspot.com/o/DawidRaszkaResume_3.png?alt=media&token=1c3cf89c-3dbb-4fe6-a152-5e4c6c0414ba",
                    "https://firebasestorage.googleapis.com/v0/b/resumeapp-1b18f.appspot.com/o/DawidRaszkaResume_1.png?alt=media&token=caec5ad0-a66a-4276-a608-32679a274d91",
                    "https://firebasestorage.googleapis.com/v0/b/resumeapp-1b18f.appspot.com/o/DawidRaszkaResume_4.png?alt=media&token=70c716b0-ca63-4daa-a143-d033cc36fb4d"
                ),
                "https://github.com/dawidraszka/ResumeApp",
                "https://play.google.com/store/apps/details?id=app.com.example.szymi.myapplication&hl=pl"
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
            }
        return projects
    }
}