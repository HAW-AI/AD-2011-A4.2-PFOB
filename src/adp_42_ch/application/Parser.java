/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adp_42_ch.application;

import adp_42_ch.interfaces.Point;
import java.io.BufferedReader;
import java.io.File;
import static adp_42_ch.implementations.Images.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author panos
 */
public class Parser {

    private Set<Point> points;
    private Integer maxX;
    private Integer minX;
    private Integer maxY;
    private Integer minY;

    private Parser(File file) {
        points = getPointsFromFile(file);
    }

    static Parser create(String filename) {
        File file = new File(filename);
//        if(!file.exists()) return null;
        return new Parser(file);
    }
    
    static Parser create(File file) {

        return new Parser(file);
    }

    public Set<Point> points() {
        return new HashSet<Point>(points);
    }

    private Set<Point> getPointsFromFile(File file) {
        Set<Point> result = new HashSet<Point>();
        BufferedReader reader;
        String line;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                if (words.length == 2) {
//                    System.out.println(words[0]);
//                    System.out.println(words[1]);
                    try {
                        int x = Integer.parseInt(words[0]);
                        int y = Integer.parseInt(words[1]);
                        if (minX == null || x < minX) {
                            minX = x;
                        }
                        if (minY == null || y < minY) {
                            minY = y;
                        }
                        if (maxX == null || x > maxX) {
                            maxX = x;
                        }
                        if (maxY == null || y > maxY) {
                            maxY = y;
                        }
                        result.add(point(x, y));
                    } catch (NumberFormatException e) {
                        System.out.println("Illegal character");
                    }
                } else {
                    System.out.println("Illegal line");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        System.out.println(minX);
        System.out.println(maxX);
        System.out.println(minY);
        System.out.println(maxY);
        return result;
    }

    public static void main(String[] args) {
        create("punkte.txt");
    }

    public int maxX() {
        return maxX;
    }

    public int minX() {
        return minX;
    }

    public int maxY() {
        return maxY;
    }

    public int minY() {
        return minY;
    }
}
