package com.example.assignment2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.assignment2.R
import com.example.assignment2.databinding.FragmentFrenchNotesBinding

class FragmentFrenchNotes : Fragment() {
    private var _binding: FragmentFrenchNotesBinding? = null
    private val binding get() = _binding!!
    private lateinit var spinner: Spinner
    private lateinit var submitButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFrenchNotesBinding.inflate(inflater, container, false)
        val root = binding.root


        spinner = root.findViewById(R.id.spinner2)
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.spinner_items,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter


        submitButton = root.findViewById(R.id.notesbtn)
        resultTextView = root.findViewById(R.id.result)

        submitButton.setOnClickListener {

            val selectedOption = spinner.selectedItemPosition
            updateContent(selectedOption)
        }

        return root
    }

    private fun updateContent(option: Int) {
        when (option) {
            0 -> {
                resultTextView.text = "Here are some basic French vocabulary and their meanings:\n\n" +
                        "Bonjour - Hello\n" +
                        "Merci - Thank you\n" +
                        "Oui - Yes\n" +
                        "Non - No\n" +
                        "S'il vous plaît - Please\n\n" +
                        "Basic Greetings and Farewells:\n" +
                        "Salut - Hi / Bye (informal)\n" +
                        "Bonsoir - Good evening\n" +
                        "Bonne nuit - Good night\n" +
                        "Au revoir - Goodbye\n" +
                        "À bientôt - See you soon\n" +
                        "À demain - See you tomorrow\n\n" +
                        "Common Nouns:\n" +
                        "Maison - House\n" +
                        "Voiture - Car\n" +
                        "Arbre - Tree\n" +
                        "Chien - Dog\n" +
                        "Chat - Cat\n" +
                        "Livre - Book\n" +
                        "Table - Table\n" +
                        "Chaise - Chair\n\n" +
                        "Colors:\n" +
                        "Rouge - Red\n" +
                        "Bleu - Blue\n" +
                        "Vert - Green\n" +
                        "Jaune - Yellow\n" +
                        "Noir - Black\n" +
                        "Blanc - White\n" +
                        "Gris - Gray\n" +
                        "Rose - Pink\n\n" +
                        "Days of the Week:\n" +
                        "Lundi - Monday\n" +
                        "Mardi - Tuesday\n" +
                        "Mercredi - Wednesday\n" +
                        "Jeudi - Thursday\n" +
                        "Vendredi - Friday\n" +
                        "Samedi - Saturday\n" +
                        "Dimanche - Sunday\n\n" +
                        "Common Verbs:\n" +
                        "Être - To be\n" +
                        "Avoir - To have\n" +
                        "Faire - To do / To make\n" +
                        "Aller - To go\n" +
                        "Manger - To eat\n" +
                        "Boire - To drink\n" +
                        "Parler - To speak\n" +
                        "Écrire - To write\n\n" +
                        "Common Adjectives:\n" +
                        "Grand(e) - Big / Tall\n" +
                        "Petit(e) - Small / Short\n" +
                        "Bon(ne) - Good\n" +
                        "Mauvais(e) - Bad\n" +
                        "Beau / Belle - Beautiful\n" +
                        "Jeune - Young\n" +
                        "Vieux / Vieille - Old\n" +
                        "Nouveau / Nouvelle - New\n"
            }
            1 -> {
                resultTextView.text = "Here are some common French phrases and their meanings:\n\n" +
                        "Bonjour - Good morning / Hello\n" +
                        "Bonsoir - Good evening\n" +
                        "Bonne nuit - Good night\n" +
                        "Salut - Hi / Bye (informal)\n" +
                        "Au revoir - Goodbye\n\n" +
                        "Polite Expressions:\n" +
                        "Merci - Thank you\n" +
                        "Merci beaucoup - Thank you very much\n" +
                        "De rien - You're welcome\n" +
                        "Excusez-moi - Excuse me\n" +
                        "Je suis désolé - I'm sorry\n\n" +
                        "Asking for Help:\n" +
                        "Pouvez-vous m'aider ? - Can you help me?\n" +
                        "Je ne comprends pas - I don’t understand\n" +
                        "Parlez-vous anglais ? - Do you speak English?\n" +
                        "Pouvez-vous répéter, s'il vous plaît ? - Can you repeat, please?\n" +
                        "Je ne parle pas bien français - I don’t speak French well\n\n" +
                        "Directions and Location:\n" +
                        "Où est...? - Where is...?\n" +
                        "Comment aller à...? - How to get to...?\n" +
                        "C'est loin ? - Is it far?\n" +
                        "Je suis perdu(e) - I’m lost\n" +
                        "À gauche - To the left\n" +
                        "À droite - To the right\n" +
                        "Tout droit - Straight ahead\n\n" +
                        "Dining and Shopping:\n" +
                        "Je voudrais... - I would like...\n" +
                        "Combien ça coûte ? - How much does it cost?\n" +
                        "L'addition, s'il vous plaît - The check, please\n" +
                        "Je voudrais acheter... - I would like to buy...\n" +
                        "Avez-vous... ? - Do you have...?\n\n" +
                        "Travel and Transportation:\n" +
                        "Où est la gare ? - Where is the train station?\n" +
                        "Je voudrais un billet pour... - I would like a ticket to...\n" +
                        "À quelle heure part le train ? - What time does the train leave?\n" +
                        "Je dois aller à l'aéroport - I need to go to the airport\n" +
                        "C'est à quelle distance ? - How far is it?\n\n" +
                        "Emergencies:\n" +
                        "J’ai besoin d’un médecin - I need a doctor\n" +
                        "Appelez une ambulance - Call an ambulance\n" +
                        "Où est l’hôpital le plus proche ? - Where is the nearest hospital?\n" +
                        "Je me suis perdu(e) - I’m lost\n" +
                        "Aidez-moi, s'il vous plaît ! - Help me, please!"
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
