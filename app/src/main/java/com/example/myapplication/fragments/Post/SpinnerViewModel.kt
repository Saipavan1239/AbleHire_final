import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SpinnerViewModel : ViewModel() {
    private val _jobRegions = MutableLiveData<List<String>>()
    val jobRegions: LiveData<List<String>> get() = _jobRegions

    private val _jobTypes = MutableLiveData<List<String>>()
    val jobTypes: LiveData<List<String>> get() = _jobTypes

    private val _jobCategories = MutableLiveData<List<String>>()
    val jobCategories: LiveData<List<String>> get() = _jobCategories

    init {
        _jobRegions.value = listOf("Hyderabad", "Mumbai", "Bangalore")
        _jobTypes.value = listOf("Part Time", "Full Time")
        _jobCategories.value = listOf("Hardware", "Software")
    }
}
