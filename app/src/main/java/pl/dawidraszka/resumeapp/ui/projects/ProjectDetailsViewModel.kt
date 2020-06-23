package pl.dawidraszka.resumeapp.ui.projects

import androidx.lifecycle.ViewModel
import pl.dawidraszka.resumeapp.data.repository.projects.ProjectsRepository
import javax.inject.Inject

class ProjectDetailsViewModel @Inject constructor(private val projectsRepository: ProjectsRepository) :
    ViewModel() {

    fun getCurrentProject() = projectsRepository.currentProject
}