package pl.dawidraszka.resumeapp

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import pl.dawidraszka.resumeapp.data.repository.resume.ResumeRepository
import pl.dawidraszka.resumeapp.ui.resume.ResumeFragment
import pl.dawidraszka.resumeapp.ui.resume.sections.SectionView
import javax.inject.Singleton

@Singleton
@Component(modules = [SectionViewsModule::class])
interface AppComponent {
    fun resumeRepository(): ResumeRepository
    fun inject(fragment: ResumeFragment)
    fun inject(views: List<@JvmSuppressWildcards SectionView>)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}