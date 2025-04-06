/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.coau.coau;

import br.com.coau.persistence.JPADao;
import br.com.coau.persistence.Livros;

/**
 *
 * @author Warley
 */
public class Coau {

    public static void main(String[] args) {
        JPADao jpd = new JPADao();
        Livros l = new Livros();
        
        l.setNomeliv("A senha");
        l.setAutorliv("Warley");
        l.setAssuntoliv("teste");
        l.setEditoraliv("Estudante");
      
        jpd.CadastarLivros(l);
    }
}
