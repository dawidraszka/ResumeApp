package pl.dawidraszka.resumeapp.application

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import pl.dawidraszka.resumeapp.data.repository.projects.ProjectsRepository
import pl.dawidraszka.resumeapp.data.repository.resume.ResumeRepository
import pl.dawidraszka.resumeapp.ui.contact.ContactFragment
import pl.dawidraszka.resumeapp.ui.projects.fragments.ProjectDetailsFragment
import pl.dawidraszka.resumeapp.ui.projects.fragments.ProjectsFragment
import pl.dawidraszka.resumeapp.ui.resume.ResumeFragment
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {
    fun resumeRepository(): ResumeRepository
    fun inject(fragment: ResumeFragment)
    fun inject(fragment: ContactFragment)

    fun projectsRepository(): ProjectsRepository
    fun inject(fragment: ProjectsFragment)
    fun inject(fragment: ProjectDetailsFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}