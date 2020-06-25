package pl.dawidraszka.resumeapp.ui.projects.viewmodels

import androidx.lifecycle.ViewModel
import pl.dawidraszka.resumeapp.data.model.projects.Project
import pl.dawidraszka.resumeapp.data.repository.projects.ProjectsRepository
import javax.inject.Inject

class ProjectsViewModel @Inject constructor(private val projectsRepository: ProjectsRepository) :
    ViewModel() {

    fun getProjects() = projectsRepository.getProjects()
    fun setCurrentProject(project: Project) {
        projectsRepository.currentProject = project
    }
}