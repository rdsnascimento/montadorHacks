/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Douglas Janovik Maliszewski
 */
public class Mc {
    public ArrayList<String> tabelaMacros;
    public String TituloMacro;
    public ArrayList<String> Args;
    public String label;
    public int num;
    
    public Mc(){
        this.label = new String();
        this.TituloMacro = new String();
        this.tabelaMacros = new ArrayList();
        this.Args = new ArrayList();
        this.num = 0;
    }
}