/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon;

import pokemons.*;
import java.util.Scanner;

/**
 *
 * @author sdiazram
 */
public class Main {

    static User user;
    static boolean keepAlive = true;

    public static int askOption(int numberOfOptions) {
        Scanner sc = new Scanner(System.in);
        int selectedOption;
        do {
            try {
                selectedOption = sc.nextInt();
            } catch (Exception e) {
                selectedOption = -1;
                sc.next();
            }
            if (selectedOption < 0 || selectedOption > numberOfOptions - 1) {
                System.out.println("Elige una opción válida");
            }
        } while (selectedOption < 0 || selectedOption > numberOfOptions - 1);

        return selectedOption;
    }

    public static void printFight(Trainer myTrainer, Pokemon pokemon1, Pokemon pokemon2) {
        System.out.println(pokemon1.toString());
        System.out.println("===== VS =====");
        System.out.println(pokemon2.toString());
        System.out.println();
        FightManagment fightManagment = new FightManagment(pokemon1, pokemon2);
        int fightResult = fightManagment.fight();
        if (fightResult == 1) {
            System.out.println("Has ganado: \n" + pokemon1.toString() + "\n");
            System.out.println("""
                               ¿ Desea capturar el pokemon ?
                               0: Sí,   1: No
                               """);
            int option = askOption(2);
            if (option == 0) {
                boolean wasCapture = myTrainer.capture(pokemon2);
                if (wasCapture) {
                    System.out.println("Pokemon capturado");
                } else {
                    System.out.println("El pokemon se escapó");
                }
            }

        } else if (fightResult == -1) {
            System.out.println("Has perdido contra: \n" + pokemon2.toString() + "\n");
        } else {
            System.out.println("Empate\n");
        }
    }

    private static User useSecurityQuestion(User userTry) {
        user = UserDB.getUser(userTry.getName());
        if (user.getSecurityQuestion() == null) {
            Login.setErrorMessage("No tiene pregunta de seguridad");
            Login.setAttempts(0);
            return null;
        }

        System.out.println(user.getSecurityQuestion() + "\nRespuesta: ");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        return Login.loginWithSecurityQuestion(userTry, answer);
    }

    public static void menu() {

        Trainer myTrainer = user.getTrainer();
        int option;
        boolean playing = true;
        while (playing) {
            Pokemon enemy;
            System.out.println("""
                                0: Encontrar pokemon
                                1: Entrenar pokemon
                                2: Luchar contra entrenador
                                3: Salir
                               """);
            option = askOption(4);

            switch (option) {
                // Encontrar pokemon
                case 0 -> {
                    int id = (int) (Math.random() * 7 + 1);
                    int lvl = (int) (Math.random() * 100 + 1);
                    enemy = DB.getPokemon(id); 
                    enemy.setLevel(lvl);
                    
                    Pokemon myPokemon = myTrainer.getRandomPokemon();
                    
                    printFight(myTrainer, myPokemon, enemy);
                    if (myPokemon.getLevel() == myPokemon.getEvolutionLevel()) {
                        myPokemon = myPokemon.evolve();
                    }
                }
                // Entrenar pokemon
                case 1 -> {
                    System.out.println("Elige tu pokemon a entrenar");
                    Pokemon[] myPokemons = user.getTrainer().getPokemonTeam();
                    for (int i=0; i < myPokemons.length; i++) {
                        if(myPokemons[i] != null) {
                            System.out.println(i +": \n"+ myPokemons[i].toString());    
                            System.out.println("==========================");
                        }
                    }
                    option = askOption(myPokemons.length);
                    myPokemons[option].train();
                    if (myPokemons[option].getLevel() == myPokemons[option].getEvolutionLevel()) {
                        myPokemons[option] = myPokemons[option].evolve();
                    }
                }
                // Luchar contra entrenador
                case 2 -> {
                    Trainer enemyTrainer = UserDB.getRandomTrainer();
                    while (myTrainer.equals(enemyTrainer)) {
                        enemyTrainer = UserDB.getRandomTrainer();
                    }

                    printFight(myTrainer, myTrainer.getRandomPokemon(),
                            enemyTrainer.getRandomPokemon());
                    Pokemon[] myPokemons = myTrainer.getPokemons();
                    System.out.println("Tus pokemons son:");
                    for (int i = 0; i < myPokemons.length; i++) {
                        System.out.println(myPokemons[i].toString() + "\n");
                    }

                    System.out.println("Tu enemigo es: ");
                    System.out.println(enemyTrainer.getName());
                    Pokemon[] enemyPokemons = enemyTrainer.getPokemons();
                    System.out.println("Pokemons del enemigo:");
                    for (int i = 0; i < enemyPokemons.length; i++) {
                        System.out.println(enemyPokemons[i].toString() + "\n");
                    }
                }
                case 3 -> {
                    playing = false;
                }
            }
        }
    }

    public static void main(String[] args) {

        Trainer sergio = UserDB.getUser("sergio").getTrainer();
        sergio.addPokemon(new Charizar());
        sergio.addPokemon(new Charmander());
        sergio.addPokemon(new Charmeleon());
        
        Trainer ana = UserDB.getUser("ana").getTrainer();
        ana.addPokemon(new Squirtle());
        ana.addPokemon(new Charmander());
        
        Trainer pepe = UserDB.getUser("pepe").getTrainer();
        pepe.addPokemon(new Bulbasaur());
        pepe.addPokemon(new Charmander());

        while (keepAlive) {
            System.out.println("""
                               0: login
                               1: registro
                               2: salir
                               """);

            int option = askOption(3);
            switch (option) {
                //Login
                case 0 -> {
                    Scanner sc = new Scanner(System.in);
                    if (user == null) {
                        System.out.println("Nombre: ");
                        String name = sc.nextLine();
                        System.out.println("Contraseña: ");
                        String password = sc.nextLine();
                        User userTry = new User(name, password);
                        user = Login.login(userTry);
                        if (user != null) {
                            System.out.println("Sesión iniciada\n");
                            while (user != null) {
                                menu();
                            }
                        } else {
                            System.out.println(Login.getErrorMessage());
                            if (Login.getAttempts() > 1) {
                                System.out.println("¿ Desea utilizar su pregunta de seguridad ? (s/n)");
                                String opt = sc.nextLine();
                                if (opt.equals("s")) {
                                    user = useSecurityQuestion(userTry);
                                    if (user == null) {
                                        System.out.println(Login.getErrorMessage());
                                    }
                                } else {
                                    Login.setAttempts(0);
                                }
                            }
                        }
                    }
                }
                //Register
                case 1 -> {
                    System.out.println("Nombre: ");
                    Scanner sc = new Scanner(System.in);
                    String name = sc.nextLine();
                    System.out.println("Contraseña: ");
                    String password = sc.nextLine();
                    System.out.println("Correo");
                    String email = sc.nextLine();
                    System.out.println("""
                                    Elige un pokemon inicial:
                                    0: Bulbasaur, 1: Charmander, 2: Squirtle
                                              """);
                    option = askOption(3);
                    User userTry = new User(name, password, email);
                    switch (option) {
                        case 0 -> {
                            userTry.getTrainer().addPokemon(new Bulbasaur());
                        }
                        case 1 -> {
                            userTry.getTrainer().addPokemon(new Charmander());
                        }
                        case 2 -> {
                            userTry.getTrainer().addPokemon(new Squirtle());
                        }
                    }
                    
                    user = Register.register(userTry);
                    if (user != null) {
                        System.out.println("Se ha registrado correctamente\n");
                        while (user != null) {
                            menu();
                            System.out.println();
                        }
                    } else {
                        System.out.println(Register.getErrorMessage());
                    }
                }
                //Exit
                case 2 -> {
                    keepAlive = false;
                }

            }
        }
    }
}
