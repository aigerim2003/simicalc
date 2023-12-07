package org.example;

import java.io.IOException;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            WordProcessor wordProcessor1 = new WordProcessor();
            String filePath1 = "src/main/resources/file1.txt";
            wordProcessor1.readFile(filePath1);

            WordProcessor wordProcessor2 = new WordProcessor();
            String filePath2 = "file2.txt";
            wordProcessor2.readFile(Main.class.getClassLoader().getResource(filePath2).getFile());


            Set<String> distinctWords1 = wordProcessor1.getDistinctWords();
            Set<String> distinctWords2 = wordProcessor2.getDistinctWords();

            SimilarityCalculator similarityCalculator = new SimilarityCalculator();
            double jaccardSimilarity = similarityCalculator.calculateSimilarityWithDistinctWords(distinctWords1, distinctWords2);

            System.out.println("Jaccard Similarity: " + jaccardSimilarity);

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
