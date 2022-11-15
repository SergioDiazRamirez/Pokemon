/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon;

import pokemons.Pokemon;
import java.util.ArrayList;

/**
 *
 * @author sdiazram
 */
public class Trainer {
    private final int TEAM_SIZE = 6;
    private int actualTeamSize;
    private Pokemon[] pokemonTeam = new Pokemon[TEAM_SIZE];
    String name;

    public Trainer(String name) {
        this.name = name;
        this.actualTeamSize = 0;
    }
    
    public Pokemon getRandomPokemon() {      
        int index = (int) (Math.random()*TEAM_SIZE);
        for(int i=index; ; i = (i+1)%TEAM_SIZE) {
            if(pokemonTeam[i] != null)
                return pokemonTeam[i];
        }
    }
    
    public boolean capture(Pokemon enemy) {
        boolean success = false;
        Trainer enemyTrainer = enemy.getTrainer();
        //if(0.5 < Math.random()) {
        if(true) {
            addPokemon(enemy);
            if(enemyTrainer != null)
                enemyTrainer.deletePokemon(enemy);
            success = true;
        }
        return success;
    }
    
    public void addPokemon(Pokemon newPokemon) {
        for(int i=0; i < TEAM_SIZE; i++) {
            if(pokemonTeam[i] == null) {
                pokemonTeam[i] = newPokemon;
                newPokemon.setTrainer(this);
                actualTeamSize++;
                break;
            }
            if(i == TEAM_SIZE - 1) {
                //exchangePokemon(newPokemon);
            }
        }
    }
    
    public void deletePokemon(Pokemon pokemon) {
        int index = getPokemonIndex(pokemon);
        if(index >= 0) {
            pokemonTeam[index] = null;
            actualTeamSize--;
        }
    }

    public int getPokemonIndex(Pokemon pokemon) {
        for (int i = 0; i < TEAM_SIZE; i++) {
            if(pokemonTeam[i] != null && pokemonTeam[i].equals(pokemon)) {
                return i;
            }
        }
        return -1;
    }
    
    public Pokemon[] getPokemons() {
        Pokemon[] myPokemons = new Pokemon[actualTeamSize];
        int j = 0;
        for(int i=0; i < TEAM_SIZE; i++) {
            if(pokemonTeam[i] != null) { 
                myPokemons[j] = pokemonTeam[i];
                j++;
            }
        }   
        return myPokemons;
    }

    public Pokemon[] getPokemonTeam() {
        return pokemonTeam;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActualTeamSize() {
        return actualTeamSize;
    }
    
}
