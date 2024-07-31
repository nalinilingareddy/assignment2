package com.example.assignment2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.assignment2.R
import com.example.assignment2.databinding.FragmentFillInTheBlanksBinding

class FragmentFillInTheBlanks : Fragment(R.layout.fragment_fill_in_the_blanks) {
    private var _binding: FragmentFillInTheBlanksBinding? = null
    private val binding get() = _binding!!
    private var score = 0
    private var currentQuestionIndex = 0
    private var wrongAttempts = 0

    private val questions = listOf(
        Question("Hello in French is ____", "Bonjour"),
        Question("Thank you in French is ____", "Merci"),
        Question("How are you? in French is ____", "Comment ça va?"),
        Question("I am sorry in French is ____", "Je suis désolé"),
        Question("What time is it? in French is ____", "Quelle heure est-il?"),
        Question("Where is the train station? in French is ____", "Où est la gare?"),
        Question("I would like a coffee in French is ____", "Je voudrais un café"),
        Question("Can you help me? in French is ____", "Pouvez-vous m'aider?"),
        Question("I do not understand in French is ____", "Je ne comprends pas"),
        Question("Do you speak English? in French is ____", "Parlez-vous anglais?"),
        Question("My name is ____ in French is ____", "Je m'appelle"),
        Question("What is your name? in French is ____", "Quel est votre nom?"),
        Question("I come from ____ in French is ____", "Je viens de"),
        Question("I am lost in French is ____", "Je suis perdu"),
        Question("How much does it cost? in French is ____", "Combien ça coûte?"),
        Question("I would like to book a table in French is ____", "Je voudrais réserver une table"),
        Question("I am a vegetarian in French is ____", "Je suis végétarien"),
        Question("Do you have a free room? in French is ____", "Avez-vous une chambre libre?"),
        Question("I would like to buy a ticket in French is ____", "Je voudrais acheter un billet"),
        Question("Where is the bathroom? in French is ____", "Où est le toilette?"),
        Question("Can you show me on the map? in French is ____", "Pouvez-vous me montrer sur la carte?"),
        Question("I am tired in French is ____", "Je suis fatigué"),
        Question("I am happy in French is ____", "Je suis heureux"),
        Question("I would like a glass of water in French is ____", "Je voudrais un verre d'eau"),
        Question("What is the dish of the day? in French is ____", "Quel est le plat du jour?"),
        Question("I would like the bill in French is ____", "Je voudrais l'addition"),
        Question("I need a taxi in French is ____", "J'ai besoin d'un taxi"),
        Question("Can I pay by card? in French is ____", "Je peux payer par carte?"),
        Question("The weather is nice today in French is ____", "Il fait beau aujourd'hui"),
        Question("It is raining in French is ____", "Il pleut"),
        Question("It is snowing in French is ____", "Il neige"),
        Question("It is hot in French is ____", "Il fait chaud"),
        Question("It is cold in French is ____", "Il fait froid"),
        Question("I am sick in French is ____", "Je suis malade"),
        Question("I need to go to the hospital in French is ____", "Je dois aller à l'hôpital"),
        Question("Where can I find a pharmacy? in French is ____", "Où puis-je trouver une pharmacie?"),
        Question("I would like a dessert in French is ____", "Je voudrais un dessert"),
        Question("What is your phone number? in French is ____", "Quel est votre numéro de téléphone?"),
        Question("I would like to buy clothes in French is ____", "Je voudrais acheter des vêtements"),
        Question("Do you accept credit cards? in French is ____", "Est-ce que vous acceptez les cartes de crédit?"),
        Question("I am on vacation in French is ____", "Je suis en vacances"),
        Question("I am here for work in French is ____", "Je suis ici pour le travail"),
        Question("I would like a city map in French is ____", "Je voudrais un plan de la ville"),
        Question("Is there a good restaurant here? in French is ____", "Y a-t-il un bon restaurant ici?"),
        Question("I would like a ticket to the museum in French is ____", "Je voudrais un billet pour le musée"),
        Question("I am in a hurry in French is ____", "Je suis pressé"),
        Question("I want to rent a car in French is ____", "Je veux louer une voiture"),
        Question("Where is the subway? in French is ____", "Où est le métro?"),
        Question("I would like a room with a view in French is ____", "Je voudrais une chambre avec une vue"),
        Question("I am allergic to nuts in French is ____", "Je suis allergique aux noix"),
        Question("I would like a backpack in French is ____", "Je voudrais un sac à dos"),
        Question("I need to exchange money in French is ____", "Je dois changer de l'argent"),
        Question("I am looking for a restaurant in French is ____", "Je cherche un restaurant"),
        Question("I would like a table for two in French is ____", "Je voudrais une table pour deux"),
        Question("Is it far from here? in French is ____", "Est-ce loin d'ici?"),
        Question("I would like a room with a bathroom in French is ____", "Je voudrais une chambre avec salle de bain"),
        Question("What is the price of this product? in French is ____", "Quel est le prix de ce produit?"),
        Question("I would like another chance in French is ____", "Je voudrais une autre chance")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFillInTheBlanksBinding.inflate(inflater, container, false)
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
            binding.questionTextView.text = currentQuestion.text
            binding.editTextAnswer.text.clear()
            binding.incorrectMessageTextView.text = ""
            binding.submitButton.isEnabled = true
            wrongAttempts = 0
        } else {
            endQuiz()
        }
        updateScoreDisplay()
    }

    private fun checkAnswer() {
        val userAnswer = binding.editTextAnswer.text.toString().trim()
        if (userAnswer.isEmpty()) {
            binding.incorrectMessageTextView.text = "Please enter an answer"
            return
        }

        val correctAnswer = questions[currentQuestionIndex].answer
        if (userAnswer.equals(correctAnswer, ignoreCase = true)) {
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
        binding.questionTextView.text = "Quiz completed! Your final score: $score"
        binding.submitButton.isEnabled = false
        binding.editTextAnswer.isEnabled = false
        binding.incorrectMessageTextView.text = ""
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    data class Question(val text: String, val answer: String)
}
