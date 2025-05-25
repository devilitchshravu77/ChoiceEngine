import java.util.Scanner;

public class QuizSystem {

    static int score = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        System.out.println("===== Welcome to Online Quiz System =====");
        System.out.println("1. Start Quiz");
        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                startQuiz();
                break;
            case 2:
                System.out.println("Thank you for using the Quiz System. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Exiting program.");
        }
    }

static void startQuiz() {
        System.out.println("\n----- Quiz Started! -----");

        askQuestion("Which language is known as the mother of all programming languages?",
                    "A. C", "B. Java", "C. Python", "D. HTML", 'A');

        askQuestion("Who is known as the father of Computer Science?",
                    "A. Charles Babbage", "B. Alan Turing", "C. Steve Jobs", "D. Dennis Ritchie", 'B');

        askQuestion("What does CPU stand for?",
                    "A. Central Process Unit", "B. Central Processing Unit", "C. Computer Personal Unit", "D. Central Performance Unit", 'B');

        askQuestion("Which one is a web browser?",
                    "A. Windows", "B. Linux", "C. Chrome", "D. Java", 'C');

        System.out.println("\n----- Quiz Completed! -----");
        System.out.println("Your final score is: " + score + "/4");
    }

    static void askQuestion(String question, String optionA, String optionB, String optionC, String optionD, char correctAnswer) {
        char answer;
System.out.println("\n" + question);
        System.out.println(optionA);
        System.out.println(optionB);
        System.out.println(optionC);
        System.out.println(optionD);
        System.out.print("Enter your answer (A/B/C/D): ");
        answer = sc.next().toUpperCase().charAt(0);

        if (answer == correctAnswer) {
            System.out.println("Correct Answer!");
            score++;
        } else {
            System.out.println("Wrong Answer. Correct option is " + correctAnswer + ".");
        }
    }
}