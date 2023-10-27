package javaSolutions.src.old.interview
//
//// Write a simple android app that asks the user to input a mathematical expression and display the result using some backend API that we already have built.
//
//
//fun calculate(input: String): String = ""
//
//class MainActivity(): Activity {
//    var viewModel: byViewModels<MainViewModel>
//    override fun onCreate() {
//        setcontentView(R.layout.blabla)
//        setUpUi()
//        setUpObserver()
//    }
//
//    private fun setUpObserver() {
//        viewModel.apply {
//            resultLiveData.observe(viewLifecycleOwner) { result ->
//                result?.let { resultText ->
//                    result_text_view.text = resultText
//                }
//            }
//
//        }
//    }
//
//    private fun setUpUi() {
//        calculate_button.setOnClickListener {
//            val expression = expression_exit_text.getText().toString()
//            if (expression.isEmpty()) {
//                // show alert
//                return@setOnClickListener
//            }
//            viewModel.calculate(expression)
//        }
//    }
//}
//
//class MainViewModel(repository: CalculatorRepository): ViewModel {
//
//    private var _resultLiveData = MutableLiveData<String>()
//    val resultLiveData: LiveData<String>()
//    get() = _resultLiveData
//
//
//    fun calculate(expression: String) = viewModelScope.launch {
//        // loading indicator livedata started
//        when (val result = repository.calculate(expression)) {
//            is Success-> {
//                _resultLiveData.postValue = result.data
//            }
//            is Error -> {
//                // show error
//            }
//        }
//    }
//}
//sealed class Result<T>() {
//    class Success: Result(data: T)
//    class Error: Result()
//}