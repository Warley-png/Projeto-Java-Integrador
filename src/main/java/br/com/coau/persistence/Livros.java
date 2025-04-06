
package br.com.coau.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "tblivros")
public class Livros {
    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idliv;
    private String nomeliv;
    private String autorliv;
    private String assuntoliv;
    private String editoraliv;
    public boolean disponivelliv;
    
    public Livros(){
        this.disponivelliv=true;
    }

   

    public long getIdliv() {
        return idliv;
    }

    public void setIdliv(long idliv) {
        this.idliv = idliv;
    }

    public String getNomeliv() {
        return nomeliv;
    }

    public void setNomeliv(String nomeliv) {
        this.nomeliv = nomeliv;
    }

    public String getAutorliv() {
        return autorliv;
    }

    public void setAutorliv(String autorliv) {
        this.autorliv = autorliv;
    }

    public String getAssuntoliv() {
        return assuntoliv;
    }

    public void setAssuntoliv(String assuntoliv) {
        this.assuntoliv = assuntoliv;
    }

    public String getEditoraliv() {
        return editoraliv;
    }

    public void setEditoraliv(String editoraliv) {
        this.editoraliv = editoraliv;
    }

    public boolean isDisponivelliv() {
        return disponivelliv;
    }

    public void setDisponivelliv(boolean disponivelliv) {
        this.disponivelliv = disponivelliv;
    }

    

  
    
    
}
   

  