/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import template.Template;

/**
 *
 * @author Heta
 */
public class Main {
    
    public static void main(String[] args) {
        Template template = new Template("Terve, ${nimi}");
        template.korvaa("nimi", "Iivari");
        System.out.println(template.evaluoi());
    }
    
}
