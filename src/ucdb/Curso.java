
package ucdb;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author grazi
 */
public class Curso {
    private String nome;
    private int vagas;
    private String area;
    private int anoFundacao;
    private List<Professor> professores;

    public Curso(String nome, String area, int anoFundacao, int vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.area = area;
        this.anoFundacao = anoFundacao;
        this.professores = new ArrayList<>();
    }

    public void adicionarProfessor(Professor professor) {
        this.professores.add(professor);
    }

    public void adicionarProfessores(List<Professor> novosProfessores) {
        this.professores.addAll(novosProfessores);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the anoFundacao
     */
    public int getAnoFundacao() {
        return anoFundacao;
    }

    /**
     * @param anoFundacao the anoFundacao to set
     */
    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }
 /**
     * @return the vagas
     */
    public int getVagas() {
        return vagas;
    }

    /**
     * @param vagas the vagas to set
     */
    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
    /**
     * @return the professores
     */
    public List<Professor> getProfessores() {
        return professores;
    }

    /**
     * @param professores the professores to set
     */
    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }
}