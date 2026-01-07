package org.example;

import java.util.Scanner;

public class DrawingApp {

    private static char[][] canvas; //2D array - array of arrays
    //canvas.length -> is the rows (height)
    //canvas[i].length -> is the number of columns (width)

    public static void main(String[] args) {
        int width =10;
        int height=5;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Command:");
        String userInput = scanner.nextLine();

        if(userInput.startsWith("Q") ||userInput.startsWith("q")){
            System.out.println("Exiting application");
            scanner.close();;
        }

        createCanvas(width,height);
        drawCanvas(width,height);
    }

    private static void createCanvas(int width, int height){
        canvas= new char[height][width];
//        Fill with space to create the canvas array - replace '\0' (uninitialized chars)
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canvas[i][j] = ' ';
            }
        }

    }

    private static void drawCanvas(int width, int height){
        drawHorizontalBorder(width);
        System.out.println();
        drawVerticalBorderAndCanvas(height, width);
        drawHorizontalBorder(width);

    }

    private static void drawHorizontalBorder(int width){
        for (int i=0; i < width; i++){
            System.out.print("-");
        }
    }

    private static void drawVerticalBorderAndCanvas(int height, int width){
        //Prints the canvas and the side borders around it
        for (int i=0; i < height; i++) {
            System.out.print("|");

             for (int j = 0; j < width -2; j++) {
                System.out.print(canvas[i][j]);
            }
            System.out.println("|");

        }
    }


}