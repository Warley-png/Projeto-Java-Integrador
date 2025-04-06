
package br.com.coau.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "tbretiradalivro")
public class AlugarLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idret;

    @ManyToOne
    @JoinColumn(name = "idcli", nullable = false) // Define a chave estrangeira para Cliente
    private Cliente cliente; // Relacionamento com a classe Cliente

    @ManyToOne
    @JoinColumn(name = "idliv", referencedColumnName = "idliv", nullable = false) // Define a chave estrangeira para Livros
    private Livros livro; // Relacionamento com a classe Livros

    private Date datasaida; // Data de saída
    private Date dataretorno; // Data de retorno
    private boolean status; // Status do aluguel

    public AlugarLivro() {
    }

    

    public long getIdret() {
        return idret;
    }

    public void setIdret(long idret) {
        this.idret = idret;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Livros getLivro() {
        return livro;
    }

    public void setLivro(Livros livro) {
        this.livro = livro;
    }

    public Date getDatasaida() {
        return datasaida;
    }

    public void setDatasaida(Date datasaida) {
        this.datasaida = datasaida;
    }

    public Date getDataretorno() {
        return dataretorno;
    }

    public void setDataretorno(Date dataretorno) {
        this.dataretorno = dataretorno;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Método para marcar o aluguel como inativo e definir a data de devolução
    public void devolverLivro() {
        this.status = false;
        this.dataretorno = new Date(); // Define a data de devolução como a data atual
    }
}