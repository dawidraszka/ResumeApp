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
        //TODO REMOVE
        val projectsTemp = listOf(
            Project(
                "BookOn!",
                "Java",
                "Application for people interested in books. BookOn compares prices, displays reviews and shows Google search results. ",
                listOf("Firebase MLKit", "Retrofit2", "Room", "CameraX", "MVVM with LiveData, Repositories and Data Sources" ),
                listOf(
                    "https://www.cashbackworld.com/media/pl/content-pages/mobile-app-2019.png",
                    "https://i.ytimg.com/vi/7QYDCqMmphA/hqdefault.jpg",
                    "https://pl.avm.de/fileadmin/_processed_/b/2/csm_fritzapp_und_icon_myfritzapp_3840x2560_android_en_22d1424b73.png",
                    "https://www.scandlines.pl/-/media/scandlines/scandlinesdk/images/landing-pages/smile-app/scandlinesapp_400x450px.ashx?h=450&la=pl&w=400&hash=A7898F4450F35D9C46424D33BDF1EC7ECF3F63AA",
                    "https://pomoc.home.pl/wp-content/uploads/2020/01/app-store-1.png"
                )
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