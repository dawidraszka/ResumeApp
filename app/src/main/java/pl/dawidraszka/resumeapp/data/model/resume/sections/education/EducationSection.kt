package pl.dawidraszka.resumeapp.data.model.resume.sections.education

import pl.dawidraszka.resumeapp.data.model.resume.Section
import pl.dawidraszka.resumeapp.data.model.resume.sections.ComplexItem

data class EducationSection(val schools : List<School>? = null) : Section("Education")