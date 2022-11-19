/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author omrani
 */

@AllArgsConstructor
@NoArgsConstructor
@Data // or @Getters/@Setters
@ToString
public class User {    
   private int id;
   private String  login, pwd,	name,	email;
   
   
}
