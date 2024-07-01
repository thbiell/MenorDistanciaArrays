package main.java;

import java.util.*;

public class MenorDistanciaArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  
        int tamanho1;
        do {
            System.out.println("Digite o tamanho do primeiro array (mínimo 10):");
            tamanho1 = scanner.nextInt();
        } while (tamanho1 < 10);
        
        int[] array1 = new int[tamanho1];
        System.out.println("Digite os elementos do primeiro array:");
        for (int i = 0; i < tamanho1; i++) {
            array1[i] = scanner.nextInt();
        }

        int tamanho2;
        do {
            System.out.println("Digite o tamanho do segundo array (mínimo 10):");
            tamanho2 = scanner.nextInt();
        } while (tamanho2 < 10);
        
        int[] array2 = new int[tamanho2];
        System.out.println("Digite os elementos do segundo array:");
        for (int i = 0; i < tamanho2; i++) {
            array2[i] = scanner.nextInt();
        }

        int[] resultado = encontrarMenorDistancia(array1, array2);

        System.out.println("A menor distância é: " + resultado[0]);
        System.out.println("Os números são: " + resultado[1] + " (array 1) e " + resultado[2] + " (array 2)");
    }

    public static int[] encontrarMenorDistancia(int[] array1, int[] array2) {
        int menorDistancia = Integer.MAX_VALUE;
        int num1 = 0;
        int num2 = 0;

        Arrays.sort(array1);
        Arrays.sort(array2);

        int i = 0, j = 0;
        while (i < array1.length && j < array2.length) {
            int diff = Math.abs(array1[i] - array2[j]);
            if (diff < menorDistancia) {
                menorDistancia = diff;
                num1 = array1[i];
                num2 = array2[j];
            }

            if (array1[i] < array2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return new int[]{menorDistancia, num1, num2};
    }
}
