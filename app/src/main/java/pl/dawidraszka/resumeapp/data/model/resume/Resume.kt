package pl.dawidraszka.resumeapp.data.model.resume

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.toObject
import pl.dawidraszka.resumeapp.data.model.resume.sections.awards.Award
import pl.dawidraszka.resumeapp.data.model.resume.sections.awards.AwardsSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.education.EducationSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.hobbies.HobbiesSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.objective.ObjectiveSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.skills.SkillsSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.technicalskills.TechnicalSkillsSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.volunteerwork.VolunteerWorkSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.workexperience.WorkExperienceSection

data class Resume(
    val objectiveSection: ObjectiveSection? = null,
    val educationSection: EducationSection? = null,
    val technicalSkillsSection: TechnicalSkillsSection? = null,
    val skillsSection: SkillsSection? = null,
    val workExperienceSection: WorkExperienceSection? = null,
    val volunteerWorkSection: VolunteerWorkSection? = null,
    val awardsSection: AwardsSection? = null,
    val hobbiesSection: HobbiesSection? = null
)