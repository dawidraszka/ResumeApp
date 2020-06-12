package pl.dawidraszka

import dagger.Component
import pl.dawidraszka.resumeapp.MainActivity
import pl.dawidraszka.resumeapp.data.repository.resume.ResumeRepository
import pl.dawidraszka.resumeapp.ui.resume.ResumeFragment
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {
    fun resumeRepository(): ResumeRepository
    fun inject(fragment: ResumeFragment)
}