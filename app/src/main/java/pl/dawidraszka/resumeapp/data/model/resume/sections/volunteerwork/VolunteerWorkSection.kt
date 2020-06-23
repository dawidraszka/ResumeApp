package pl.dawidraszka.resumeapp.data.model.resume.sections.volunteerwork

import pl.dawidraszka.resumeapp.data.model.resume.Section

data class VolunteerWorkSection(val volunteerWork: List<VolunteerWork>? = null) :
    Section("Volunteer Work")