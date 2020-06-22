package pl.dawidraszka.resumeapp

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import pl.dawidraszka.resumeapp.data.repository.projects.ProjectsRepository
import pl.dawidraszka.resumeapp.data.repository.resume.ResumeRepository
import pl.dawidraszka.resumeapp.ui.contact.ContactFragment
import pl.dawidraszka.resumeapp.ui.projects.ProjectDetailsFragment
import pl.dawidraszka.resumeapp.ui.projects.ProjectsFragment
import pl.dawidraszka.resumeapp.ui.resume.ResumeFragment
import pl.dawidraszka.resumeapp.ui.resume.sections.SectionView
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