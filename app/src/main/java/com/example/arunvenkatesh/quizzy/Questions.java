package com.example.arunvenkatesh.quizzy;

class Questions {

    String mQuestions[] = {
            "Which is the first planet of the Solar System?",
            "Which is the second planet of the Solar System?",
            "Which is the third planet of the Solar System?",
            "Which is the fourth planet of the Solar System?",
            "Which is the fifth planet of the Solar System?",
            "Which is the sixth planet of the Solar System?",
            "Which is the seventh planet of the Solar System?",
            "Which is the eight planet of the Solar System?",
            "Which is the ninth planet of the Solar System?",
    };



    String mChoices[][] = {
            {"Mercury", "Venus", "Earth", "Mars"},
            {"Jupiter", "Venus", "Earth", "Mars"},
            {"Saturn", "Jupiter", "Earth", "Mars"},
            {"Jupiter", "Saturn", "Uranus", "Mars"},
            {"Jupiter", "Saturn", "Uranus", "Neptune"},
            {"Uranus", "Saturn", "Neptune", "Pluto"},
            {"Neptune", "Saturn", "Uranus", "Pluto"},
            {"Uranus", "Neptune", "Saturn", "Pluto"},
            {"Saturn", "Pluto", "Uranus", "Neptune"},
    };

    String mCorrectAnswers[] = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
}
