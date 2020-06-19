package pl.dawidraszka.resumeapp.data.repository.resume

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
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResumeRepository @Inject constructor() {
    val firestoreDatabase = Firebase.firestore

    val resume = MutableLiveData<Resume>()

    init {
        //TODO REMOVE
        val resumeTemp = Resume(
            ObjectiveSection("Highly motivated graduate seeking an Junior Android Development position where I can utilize my software development skills to create mobile applications."),
            EducationSection(
                listOf(
                    School(
                        "Bachelor of Computer Science" +
                                "Bachelor",
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
                    "Java 8 – ability to create working, native Android applications using lambdas, interfaces, collections, inheritance and other functionalities. ",
                    "Known frameworks, patterns and techniques: Firebase, Room, Retrofit, CameraX, MVVM, LiveData, Singleton pattern, Android SDK, Android Resources, Android Permissions, adapters. ",
                    "Kotlin – basics, but quickly improving",
                    "Unity and C# - ability to create simple video games",
                    "Swift – basics, but willing to learn more in the future"
                )
            ),
            SkillsSection(
                listOf(
                    "Quick and keen learner ",
                    "Experienced in working as part of a team ",
                    "Ability to create Android applications using modern techniques and frameworks",
                    "Fluent in English and Polish "
                )
            ),
            WorkExperienceSection(
                listOf(
                    WorkExperience(
                        "Java Developer Intern",
                        "Accenture Technology",
                        "Katowice",
                        SimpleDate(Month.April, 2019),
                        SimpleDate(Month.July, 2019),
                        listOf(
                            "Collaborated with team to develop new features for ERP system using Java",
                            "Helped to create and expand company wiki - which helps new employees become familiarized with the system",
                            "Learned how to organize work using Jira "
                        )
                    ),
                    WorkExperience(
                        "Android Developer Intern",
                        "ProfitCard Ltd.",
                        "Cieszyn",
                        SimpleDate(Month.April, 2017),
                        SimpleDate(Month.July, 2017),
                        listOf(
                            "Created Android application based on client requirements",
                            "Learned best software development practices",
                            "Collaborated with team to ensure compatibility with internal server"
                        )
                    )
                )
            ),
            VolunteerWorkSection(
                listOf(
                    VolunteerWork(
                        "Lecturer and organizer",
                        "F44 Red",
                        " Dąbrowa Górnicza",
                        SimpleDate(Month.October, 2017),
                        SimpleDate(Month.March, 2020),
                        listOf(
                            "Helped to organize several events to help students learn basics of game and Android development",
                            "Lectured students about game development",
                            "Participated in a series of workshops for kids about game development as a teacher"
                        )
                    )
                )
            ),
            AwardsSection(List(1) {
                Award(
                    "Second place in Sensei Game Jam", "Wrocław", SimpleDate(Month.December, 2017),
                    listOf("Awarded second place for participation and game creation during Sensei Game Jam in Wrocław")
                )
            }),
            HobbiesSection(listOf("Board games", "Lego", "Science", "Fantasy books", "Electronics"))
        )

        firestoreDatabase.collection("resumes").document("resume").set(resumeTemp)
    }

    fun getResume(): LiveData<Resume> {
        firestoreDatabase.collection("resumes").document("resume")
            .get()
            .addOnSuccessListener {
                val resumeTemp = it.toObject<Resume>()
                resume.value = resumeTemp
            }
        return resume
    }
}