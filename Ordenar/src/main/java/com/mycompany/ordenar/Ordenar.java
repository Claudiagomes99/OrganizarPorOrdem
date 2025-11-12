/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ordenar;

/**
 *
 * @author Gomes
 */

import java.util.Scanner;
public class Ordenar {

    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Processar Números (Pares e Ímpares)");
            System.out.println("2 - Processar Nomes (Ordenação)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            switch(opcao) {
                case 1:
                    processarNumeros(scanner);
                    break;
                case 2:
                    processarNomes(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
        
        scanner.close();
    }
    
    // Método para processar números pares e ímpares
    public static void processarNumeros(Scanner scanner) {
        int[] numeros = new int[100];
        int[] pares = new int[100];
        int[] impares = new int[100];
        int totalNumeros = 0;
        int totalPares = 0;
        int totalImpares = 0;
        
        System.out.println("\n=== PROCESSAMENTO DE NÚMEROS ===");
        System.out.println("Digite os números (digite 0 para finalizar):");
        
        while(totalNumeros < 100) {
            System.out.print("Número: ");
            int num = scanner.nextInt();
            
            if(num == 0) {
                break;
            }
            
            numeros[totalNumeros] = num;
            totalNumeros++;
            
            if(num % 2 == 0) {
                pares[totalPares] = num;
                totalPares++;
            } else {
                impares[totalImpares] = num;
                totalImpares++;
            }
        }
        
        // Exibir resultados
        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Total de números digitados: " + totalNumeros);
        
        System.out.println("\nNÚMEROS PARES:");
        if(totalPares == 0) {
            System.out.println("Nenhum número par foi digitado.");
        } else {
            for(int i = 0; i < totalPares; i++) {
                System.out.print(pares[i] + " ");
            }
            System.out.println("\nTotal de pares: " + totalPares);
        }
        
        System.out.println("\nNÚMEROS ÍMPARES:");
        if(totalImpares == 0) {
            System.out.println("Nenhum número ímpar foi digitado.");
        } else {
            for(int i = 0; i < totalImpares; i++) {
                System.out.print(impares[i] + " ");
            }
            System.out.println("\nTotal de ímpares: " + totalImpares);
        }
    }
    
    // Método para processar nomes em ordem crescente e decrescente
    public static void processarNomes(Scanner scanner) {
        String[] nomes = new String[100];
        int totalNomes = 0;
        
        System.out.println("\n=== PROCESSAMENTO DE NOMES ===");
        System.out.println("Digite os nomes (digite 'FIM' para finalizar):");
        
        while(totalNomes < 100) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();
            
            if(nome.equalsIgnoreCase("FIM")) {
                break;
            }
            
            if(!nome.isEmpty()) {
                nomes[totalNomes] = nome;
                totalNomes++;
            }
        }
        
        if(totalNomes == 0) {
            System.out.println("Nenhum nome foi digitado.");
            return;
        }
        
        // Exibir resultados
        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Total de nomes digitados: " + totalNomes);
        
       
        String[] nomesOrdemCrescente = new String[totalNomes];
        for(int i = 0; i < totalNomes; i++) {
            nomesOrdemCrescente[i] = nomes[i];
        }
        
        // Ordenação crescente (Bubble Sort)
        for(int i = 0; i < totalNomes - 1; i++) {
            for(int j = 0; j < totalNomes - i - 1; j++) {
                if(nomesOrdemCrescente[j].compareToIgnoreCase(nomesOrdemCrescente[j + 1]) > 0) {
                    String temp = nomesOrdemCrescente[j];
                    nomesOrdemCrescente[j] = nomesOrdemCrescente[j + 1];
                    nomesOrdemCrescente[j + 1] = temp;
                }
            }
        }
        
        System.out.println("\nNOMES EM ORDEM CRESCENTE (A-Z):");
        for(int i = 0; i < totalNomes; i++) {
            System.out.println("- " + nomesOrdemCrescente[i]);
        }
        
        // Copiar array para ordenação decrescente
        String[] nomesOrdemDecrescente = new String[totalNomes];
        for(int i = 0; i < totalNomes; i++) {
            nomesOrdemDecrescente[i] = nomes[i];
        }
        
        // Ordenação decrescente (Bubble Sort)
        for(int i = 0; i < totalNomes - 1; i++) {
            for(int j = 0; j < totalNomes - i - 1; j++) {
                if(nomesOrdemDecrescente[j].compareToIgnoreCase(nomesOrdemDecrescente[j + 1]) < 0) {
                    String temp = nomesOrdemDecrescente[j];
                    nomesOrdemDecrescente[j] = nomesOrdemDecrescente[j + 1];
                    nomesOrdemDecrescente[j + 1] = temp;
                }
            }
        }
        
        System.out.println("\nNOMES EM ORDEM DECRESCENTE (Z-A):");
        for(int i = 0; i < totalNomes; i++) {
            System.out.println("- " + nomesOrdemDecrescente[i]);
        }
    }
}
