package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        URL resource = Main.class.getResource("/words.txt");
        File file = new File(resource.toURI());

        Trie trie = new Trie();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null) {
                trie.insert(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        String str = "";

        System.out.println("Input word or letter");
        str = scanner.nextLine();
        System.out.println(trie.autocomplete(str));


    }
}