package pl.dawidraszka.resumeapp.data.model.resume

import pl.dawidraszka.resumeapp.data.model.resume.sections.awards.AwardsSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.education.EducationSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.hobbies.HobbiesSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.objective.ObjectiveSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.skills.SkillsSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.technicalskills.TechnicalSkillsSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.volunteerwork.VolunteerWorkSection
import pl.dawidraszka.resumeapp.data.model.resume.sections.workexperience.WorkExperienceSection

data class Resume(
    val objectiveSection: ObjectiveSection,
    val educationSection: EducationSection,
    val technicalSkillsSection: TechnicalSkillsSection,
    val skillsSection: SkillsSection,
    val workExperienceSection: WorkExperienceSection,
    val volunteerWorkSection: VolunteerWorkSection,
    val awardsSection: AwardsSection,
    val hobbiesSection: HobbiesSection
)