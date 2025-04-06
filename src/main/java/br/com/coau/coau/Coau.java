
package br.com.coau.coau;

import br.com.coau.persistence.JPADao;
import br.com.coau.persistence.Livros;


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
