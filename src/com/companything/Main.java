package com.companything;

import com.companything.entities.Product;
import com.companything.entities.Question;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<Product> products = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        Main main = new Main();
        main.run();

    }

    private void run() throws Exception {
        System.out.println("Are you an admin?");
        String choice;


        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        do {

            System.out.println("Please Select An Option:");
            System.out.println("1. Add product");
            System.out.println("2. List products");
            System.out.println("3. Add question to product");
            System.out.println("4. List questions");
            System.out.println("Q. Quit");
            choice = scanner.nextLine().toLowerCase();
            switch (choice) {

                case "1":
                    addProduct(scanner);
                    break;

                case "2":
                    listProducts();
                    break;
                case "3":
                    addQuestion(scanner);
                    break;
                case "4":
                    listQuestions();
                    break;
                case "q":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unrecognised Command");
                    System.out.println("Press any key return to the main menu");
                    break;

            }
        } while (!choice.toLowerCase().equals("q"));
    }

    private void listQuestions() {

        for (Product product : products) {
            List<Question> questions = product.getQuestions();
            for (int questionIndex = 0; questionIndex < questions.size(); questionIndex++) {
                System.out.println("Product " + product.getName() + ".  Q" + questionIndex + ": " + questions.get(questionIndex).getQuestionText());
            }
        }
    }

    private void addQuestion(Scanner scanner) throws Exception {
        System.out.println("Which product is this for?");
        listProducts();
        String productChoice = scanner.nextLine().toLowerCase();
        Product p = products.get(Integer.valueOf(productChoice));
        if (p == null) {
            throw new Exception("Could not find product with name: " + productChoice);
        }
        System.out.print("Please enter your question: ");
        String questionText = scanner.nextLine().toLowerCase();
        p.getQuestions().add(new Question(questionText));
    }

    private Product findProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    private void listProducts() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + ": " + products.get(i));
        }
    }

    private void addProduct(Scanner scanner) {
        System.out.print("Please enter the Product Name: ");
        String choice = scanner.nextLine().toLowerCase();
        products.add(new Product(choice));
        System.out.println("You added a " + choice);

    }
}
