package com.example.assignment2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.assignment2.R
import com.example.assignment2.databinding.FragmentTrueFalseBinding

class FragmentTrueFalse : Fragment(R.layout.fragment_true_false) {
    private var _binding: FragmentTrueFalseBinding? = null
    private val binding get() = _binding!!
    private var score = 0
    private var currentQuestionIndex = 0
    private var wrongAttempts = 0

    private val questions = listOf(
        Question("The French word for 'apple' is 'pomme'.", true),
        Question("The French word for 'book' is 'livre'.", true),
        Question("In French, 'dog' is 'chat'.", false),
        Question("The French word for 'water' is 'eau'.", true),
        Question("In French, 'car' is 'voiture'.", true),
        Question("The French word for 'house' is 'maison'.", true),
        Question("In French, 'cat' is 'chien'.", false),
        Question("The French word for 'friend' is 'ami'.", true),
        Question("In French, 'school' is 'école'.", true),
        Question("The French word for 'city' is 'village'.", false),
        Question("In French, 'sun' is 'soleil'.", true),
        Question("The French word for 'moon' is 'lune'.", true),
        Question("In French, 'sea' is 'rivière'.", false),
        Question("The French word for 'mountain' is 'montagne'.", true),
        Question("In French, 'food' is 'nourriture'.", true),
        Question("The French word for 'street' is 'route'.", true),
        Question("In French, 'bread' is 'pain'.", true),
        Question("The French word for 'music' is 'musique'.", true),
        Question("In French, 'language' is 'langue'.", true),
        Question("The French word for 'love' is 'amour'.", true),
        Question("In French, 'city' is 'ville'.", true),
        Question("The French word for 'night' is 'jour'.", false),
        Question("In French, 'day' is 'jour'.", true),
        Question("The French word for 'year' is 'année'.", true),
        Question("In French, 'child' is 'enfant'.", true),
        Question("The French word for 'teacher' is 'professeur'.", true),
        Question("In French, 'family' is 'famille'.", true),
        Question("The French word for 'computer' is 'ordinateur'.", true),
        Question("In French, 'phone' is 'téléphone'.", true),
        Question("The French word for 'coffee' is 'café'.", true),
        Question("In French, 'shirt' is 'chemise'.", true),
        Question("The French word for 'shoes' is 'chaussures'.", true),
        Question("In French, 'color' is 'couleur'.", true),
        Question("The French word for 'bookstore' is 'bibliothèque'.", false),
        Question("In French, 'doctor' is 'médecin'.", true),
        Question("The French word for 'hospital' is 'hôpital'.", true),
        Question("In French, 'pen' is 'stylo'.", true),
        Question("The French word for 'key' is 'clé'.", true),
        Question("In French, 'window' is 'fenêtre'.", true),
        Question("The French word for 'door' is 'porte'.", true),
        Question("In French, 'airplane' is 'avion'.", true),
        Question("The French word for 'train' is 'train'.", true),
        Question("In French, 'bus' is 'autobus'.", true),
        Question("The French word for 'bike' is 'vélo'.", true),
        Question("In French, 'restaurant' is 'restaurant'.", true),
        Question("The French word for 'market' is 'marché'.", true),
        Question("In French, 'store' is 'magasin'.", true),
        Question("The French word for 'park' is 'parc'.", true),
        Question("In French, 'river' is 'fleuve'.", true),
        Question("The French word for 'lake' is 'lac'.", true),
        Question("In French, 'mountain' is 'montagne'.", true),
        Question("The French word for 'desert' is 'désert'.", true),
        Question("In French, 'forest' is 'forêt'.", true),
        Question("The French word for 'beach' is 'plage'.", true),
        Question("In French, 'holiday' is 'vacances'.", true),
        Question("The French word for 'summer' is 'été'.", true),
        Question("In French, 'winter' is 'hiver'.", true),
        Question("The French word for 'spring' is 'printemps'.", true),
        Question("In French, 'autumn' is 'automne'.", true)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrueFalseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadQuestion()
        binding.submitButton.setOnClickListener {
            checkAnswer()
        }
    }

    private fun loadQuestion() {
        if (currentQuestionIndex < questions.size) {
            val currentQuestion = questions[currentQuestionIndex]
            binding.tfquestion.text = currentQuestion.text
            binding.answerRadioGroup.clearCheck()
            binding.incorrectMessageTextView.text = ""
            binding.answerRadioGroup.visibility = View.VISIBLE
            binding.submitButton.isEnabled = true
            wrongAttempts = 0
        } else {
            endQuiz()
        }
        updateScoreDisplay()
    }

    private fun checkAnswer() {
        val selectedId = binding.answerRadioGroup.checkedRadioButtonId
        if (selectedId == -1) {
            binding.incorrectMessageTextView.text = "Please select an answer"
            return
        }

        val userAnswer = when (selectedId) {
            R.id.truebtn -> true
            R.id.falsebtn -> false
            else -> return
        }

        val correctAnswer = questions[currentQuestionIndex].answer
        if (userAnswer == correctAnswer) {
            score++
            currentQuestionIndex++
            loadQuestion()
        } else {
            wrongAttempts++
            score--
            binding.incorrectMessageTextView.text = "Incorrect Answer"
            if (wrongAttempts >= 3) {
                currentQuestionIndex++
                loadQuestion()
            }
        }
        updateScoreDisplay()
    }

    private fun updateScoreDisplay() {
        binding.scoreTextView.text = "Score: $score"
    }

    private fun endQuiz() {
        binding.tfquestion.text = "Quiz completed! Your final score: $score"
        binding.submitButton.isEnabled = false
        binding.answerRadioGroup.visibility = View.GONE
        binding.incorrectMessageTextView.text = ""
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    data class Question(val text: String, val answer: Boolean)
}
