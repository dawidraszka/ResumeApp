package pl.dawidraszka.resumeapp.data.model.projects

import java.net.URL

data class Project(
    val name: String? = null,
    val language: String? = null,
    val description: String? = null,
    val technologies: List<String>? = null,
    val screenshots: List<URL>? = null
)