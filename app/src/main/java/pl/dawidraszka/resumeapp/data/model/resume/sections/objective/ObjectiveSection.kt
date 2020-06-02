package pl.dawidraszka.resumeapp.data.model.resume.sections.objective

import pl.dawidraszka.resumeapp.data.model.resume.Section

data class ObjectiveSection(val objective: String? = null) : Section("Objective")