package pl.dawidraszka.resumeapp.data.repository.resume

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import pl.dawidraszka.resumeapp.data.model.resume.Month
import pl.dawidraszka.resumeapp.data.model.resume.Resume
import pl.dawidraszka.resumeapp.data.model.resume.SimpleDate
import pl.dawidraszka.resumeapp.data.model.resume.sections.awards.Award
import pl.dawidraszka.resumeapp.data.model.resume.sections.awards.AwardsSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.education.EducationSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.education.School
import pl.dawidraszka.resumeapp.data.model.resume.sections.hobbies.HobbiesSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.objective.ObjectiveSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.skills.SkillsSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.technicalskills.TechnicalSkillsSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.volunteerwork.VolunteerWork
import pl.dawidraszka.resumeapp.data.model.resume.sections.volunteerwork.VolunteerWorkSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.workexperience.WorkExperience
import pl.dawidraszka.resumeapp.data.model.resume.sections.workexperience.WorkExperienceSection
import java.util.*

object ResumeRepository {
    val firestoreDatabase = Firebase.firestore

    val resume = MutableLiveData<Resume>()

    init {
        //TODO REMOVE
        val resumeTemp = Resume(
            ObjectiveSection("Highly motivated graduate seeking an Junior Android Development position where I can utilize my software development skills to create mobile applications."
            +"Highly motivated graduate seeking an Junior Android Development position where I can utilize my software development skills to create mobile applications."+
                    "Highly motivated graduate seeking an Junior Android Development position where I can utilize my software development skills to create mobile applications."
            +"Highly motivated graduate seeking an Junior Android Development position where I can utilize my software development skills to create mobile applications."
            +"Highly motivated graduate seeking an Junior Android Development position where I can utilize my software development skills to create mobile applications."
            +"Highly motivated graduate seeking an Junior Android Development position where I can utilize my software development skills to create mobile applications."
            +"Highly motivated graduate seeking an Junior Android Development position where I can utilize my software development skills to create mobile applications."
            ),
            EducationSection(
                listOf(
                    School(
                        "Bachelor of Computer Science",
                        "WSB University",
                        "Dąbrowa Górnicza ",
                        SimpleDate(Month.October, 2016),
                        SimpleDate(Month.March, 2020),
                        listOf(
                            "President of the Student Research Circle - F44 Red",
                            "Helped to organize many events and workshops for students",
                            "Top 10% in class which resulted in scholarships each semester",
                            "Participated in Erasmus+ Student Exchange Program in Horsens, Denmark. Learned how to work in an international environment, how to cooperate with people from different cultures and significantly improved English "
                        )
                    )
                )
            ),
            TechnicalSkillsSection(
                listOf(
                    "technicalskill1",
                    "technicalskill2",
                    "technicalskill3",
                    "technicalskill4",
                    "technicalskill5",
                    "technicalskill1",
                    "technicalskill2",
                    "technicalskill3",
                    "technicalskill4",
                    "technicalskill5",
                    "technicalskill1",
                    "technicalskill2",
                    "technicalskill3",
                    "technicalskill4",
                    "technicalskill5",
                    "technicalskill1",
                    "technicalskill2",
                    "technicalskill3",
                    "technicalskill4",
                    "technicalskill5",
                    "technicalskill1",
                    "technicalskill2",
                    "technicalskill3",
                    "technicalskill4",
                    "technicalskill5",
                    "technicalskill1",
                    "technicalskill2",
                    "technicalskill3",
                    "technicalskill4",
                    "technicalskill5",
                    "technicalskill1",
                    "technicalskill2",
                    "technicalskill3",
                    "technicalskill4",
                    "technicalskill5",
                    "technicalskill1",
                    "technicalskill2",
                    "technicalskill3",
                    "technicalskill4",
                    "technicalskill5",
                    "technicalskill1",
                    "technicalskill2",
                    "technicalskill3",
                    "technicalskill4",
                    "technicalskill5"
                )
            ),
            SkillsSection(listOf("skill1")),
            WorkExperienceSection(
                listOf(
                    WorkExperience(
                        "jobtitle1",
                        "company1", "cieszyn", Date(1), Date
                            (2), listOf("detail1")
                    )
                )
            ),
            VolunteerWorkSection(
                listOf(
                    VolunteerWork(
                        "volunter1", "org1",
                        "city1", Date(1), Date
                            (2), listOf("detail1")
                    )
                )
            ),
            AwardsSection(List(1) {
                Award(
                    "award1", "city2", Date(1),
                    listOf("detail5")
                )
            }),
            HobbiesSection(listOf("hobby1", "hobby2"))
        )

        firestoreDatabase.collection("resumes").document("resume").set(resumeTemp)
    }

    fun getResume(): LiveData<Resume> {
        firestoreDatabase.collection("resumes").document("resume")
            .get()
            .addOnSuccessListener {
                val resumeTemp = it.toObject<Resume>()
                resume.value = resumeTemp
                Log.d(TAG, "${it.id} => ${it.data}")
            }
        return resume
    }
}