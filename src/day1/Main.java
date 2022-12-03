package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(getMaxFromFile(new Scanner(new File("src/day1/day1.txt"))));
        ArrayList<Integer> list = get3TopValuesFromFile(new Scanner(new File("src/day1/day1.txt")));
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1) + list.get(list.size() - 2) + list.get(list.size() - 3));
    }
    public static int getMaxFromFile(Scanner file) {
        int max = 0;
        try (file) {
            int blockTotal = 0;
            while (file.hasNextLine()) {
                String line = file.nextLine();
                if (!line.isBlank()) {
                    blockTotal += Integer.parseInt(line);
                } else {
                    if (blockTotal > max) {
                        max = blockTotal;
                    }
                    blockTotal = 0;
                }
            }
        } catch (Exception ignored) {
        }
        return max;
    }

    public static ArrayList<Integer> get3TopValuesFromFile(Scanner scanner) {
        ArrayList<Integer> list = new ArrayList<>();
        try (scanner) {
            int blockTotal = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isBlank()) {
                    blockTotal += Integer.parseInt(line);
                } else {
                    list.add(blockTotal);
                    blockTotal = 0;
                }

            }
        } catch (Exception ignored) {
        }
        return list;
    }
}