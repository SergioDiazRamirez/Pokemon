/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon;

import pokemons.Pokemon;
import pokemons.Charmander;
import java.util.HashMap;
import pokemons.Bulbasaur;
import pokemons.Charizar;
import pokemons.Charmeleon;
import pokemons.Squirtle;

/**
 *
 * @author sdiazram
 */
public class DB {
    
    private static HashMap<Type, Type> weakness = new HashMap<>(){{
        put(Type.Fire, Type.Water);
        put(Type.Grass, Type.Fire);
        put(Type.Water, Type.Grass);

    }};
    private static HashMap<Type, Type> strength = new HashMap<>(){{
        put(Type.Fire, Type.Grass);
        put(Type.Grass, Type.Water);
        put(Type.Water, Type.Fire);
    }};

    public static Type getWeakness(Pokemon pokemon) {
        Type type = pokemon.getType();
        return weakness.get(type);
    }
    
    public static Type getStrength(Pokemon pokemon) {
        Type type = pokemon.getType();
        return strength.get(type);
    }
    
    /**
     *
     */
    public static final HashMap<Integer, Pokemon> pokemons;
    static {
        pokemons = new HashMap<>();
        pokemons.put(1, new Bulbasaur());
        pokemons.put(2, new Bulbasaur()); // Faltan crear más clases de pokemons
        pokemons.put(3, new Bulbasaur()); //     
        pokemons.put(4, new Charmander());
        pokemons.put(5, new Charmeleon());
        pokemons.put(6, new Charizar());
        pokemons.put(7, new Squirtle());
    };
    
    public static Pokemon getPokemon(int id) {
        return pokemons.get(id);
    }
}
