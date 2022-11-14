/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon;

import java.util.HashMap;

/**
 *
 * @author sdiazram
 */
public class UserDB {
    private static HashMap<String, User> users = new HashMap<>(){{
        put("sergio", new User("sergio","cont","sergio@gmail.com"));
        put("ana", new User("ana","cont","ana@gmail.com"));
        put("pepe", new User("pepe","cont","pepe@gmail.com"));
    }};
    
    public static Trainer getRandomTrainer() {
        
        int randomIndex = (int) (Math.random() * users.size());
        Object[] usersArray = users.values().toArray();
        User randomUser = (User) usersArray[randomIndex];
        
        return randomUser.getTrainer();
    }
    
    public static User getUser(String username) {
        return users.get(username);
    }
    
    public static boolean contains(String username) {
        return users.containsKey(username);
    }
    
    public static void put(User user) {
        users.put(user.getName(), user);
    }
    
    public static void printUsers() {
        for(String userName: users.keySet()) {
            System.out.println(userName);
        }
    }
}
