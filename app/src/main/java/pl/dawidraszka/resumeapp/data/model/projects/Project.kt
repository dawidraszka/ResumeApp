package pl.dawidraszka.resumeapp.data.model.projects

data class Project(
    val name: String? = null,
    val language: String? = null,
    val description: String? = null,
    val technologies: List<String>? = null,
    val screenshots: List<String>? = null
)