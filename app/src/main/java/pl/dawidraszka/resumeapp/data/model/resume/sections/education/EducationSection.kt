package pl.dawidraszka.resumeapp.data.model.resume.sections.education

import pl.dawidraszka.resumeapp.data.model.resume.Section

data class EducationSection(val schools: List<School>? = null) : Section("Education")