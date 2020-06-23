package pl.dawidraszka.resumeapp.ui.resume

import androidx.lifecycle.ViewModel
import pl.dawidraszka.resumeapp.data.repository.resume.ResumeRepository
import javax.inject.Inject

class ResumeViewModel @Inject constructor(private val resumeRepository: ResumeRepository) :
    ViewModel() {

    fun getResume() = resumeRepository.getResume()
}