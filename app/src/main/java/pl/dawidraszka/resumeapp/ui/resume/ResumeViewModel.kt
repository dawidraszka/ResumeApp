package pl.dawidraszka.resumeapp.ui.resume

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.dawidraszka.resumeapp.data.repository.resume.ResumeRepository

class ResumeViewModel : ViewModel() {
    fun getResume() = ResumeRepository.getResume()
}