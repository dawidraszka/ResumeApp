package pl.dawidraszka.resumeapp

import android.content.Context
import dagger.Module
import dagger.Provides
import pl.dawidraszka.resumeapp.ui.resume.sections.*

@Module
class SectionViewsModule{

    @Provides
    fun provideSectionViews(context: Context): List<SectionView>{
        return listOf(
            ObjectiveSectionView(context),
            WorkExperienceSectionView(context),
            EducationSectionView(context),
            SkillsSectionView(context),
            TechnicalSkillsSectionView(context),
            VolunteerWorkSectionView(context),
            AwardsAndHonoursSectionView(context),
            HobbiesSectionView(context)
        )
    }
}