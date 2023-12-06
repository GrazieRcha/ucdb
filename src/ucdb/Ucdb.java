
package ucdb;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author grazi
 */

public class Ucdb {
    private String endereco;
    private List<Professor> professores;
    private List<Curso> cursos;

    public Ucdb() {
        this.professores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public Ucdb(String endereco, int anoFundacao) {
        this.endereco = endereco;
    }

    public void cadastrarProfessor(Professor professor) {
        getProfessores().add(professor);
    }

    public void cadastrarCurso(Curso curso) {
        getCursos().add(curso);
    }

    public void listarProfessores() {
        for (Professor professor : getProfessores()) {
            System.out.println("Nome: " + professor.getNome() + ", Salario: " + professor.getSalario());
        }
    }

    public void listarCursos() {
        for (Curso curso : getCursos()) {
            System.out.println("Nome: " + curso.getNome() + ", Area: " + curso.getArea() + ", Vagas: " + curso.getVagas());
        }
    }

    public List<Curso> consultarCursosPorArea(String area) {
        List<Curso> cursosPorArea = new ArrayList<>();
        for (Curso curso : getCursos()) {
            if (curso.getArea().equalsIgnoreCase(area)) {
                cursosPorArea.add(curso);
            }
        }
        return cursosPorArea;
    }

    public List<Professor> consultarProfessoresPorSalario(double salario) {
        List<Professor> professoresPorSalario = new ArrayList<>();
        for (Professor professor : getProfessores()) {
            if (professor.getSalario() >= salario) {
                professoresPorSalario.add(professor);
            }
        }
        return professoresPorSalario;
    }

    public List<Professor> consultarProfessoresPorIdade(int idade) {
        List<Professor> professoresPorIdade = new ArrayList<>();
        for (Professor professor : getProfessores()) {
            if (professor.getIdade() >= idade) {
                professoresPorIdade.add(professor);
            }
        }
        return professoresPorIdade;
    }

    public double calcularGastoMensal() {
        double gastoMensal = 0;
        for (Professor professor : getProfessores()) {
            gastoMensal += professor.getSalario();
        }
        return gastoMensal;
    }

    public Professor encontrarProfessorMaiorSalario() {
        Professor maiorSalario = null;
        for (Professor professor : getProfessores()) {
            if (maiorSalario == null || professor.getSalario() > maiorSalario.getSalario()) {
                maiorSalario = professor;
            }
        }
        return maiorSalario;
    }

    public Professor encontrarProfessorMaiorIdade() {
        Professor maiorIdade = null;
        for (Professor professor : getProfessores()) {
            if (maiorIdade == null || professor.getIdade() > maiorIdade.getIdade()) {
                maiorIdade = professor;
            }
        }
        return maiorIdade;
    }

    public Curso encontrarCursoMaisAntigo() {
        Curso maisAntigo = null;
        for (Curso curso : getCursos()) {
            if (maisAntigo == null || curso.getAnoFundacao() < maisAntigo.getAnoFundacao()) {
                maisAntigo = curso;
            }
        }
        return maisAntigo;
    }

    public void executarMenu() {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> cadastrarProfessor(scanner);
                case 2 -> cadastrarCurso(scanner);
                case 3 -> listarProfessores();
                case 4 -> listarCursos();
                case 5 -> listarProfessoresPorArea();
                case 6 -> consultarCursosPorArea(scanner);
                case 7 -> consultarProfessoresPorSalario(scanner);
                case 8 -> consultarProfessoresPorIdade(scanner);
                case 9 -> System.out.println("Gasto mensal da UCDB com professores: R$" + calcularGastoMensal());
                case 10 -> exibirProfessorMaiorSalario();
                case 11 -> exibirProfessorMaiorIdade();
                case 12 -> exibirCursoMaisAntigo();
                case 0 -> System.out.println("Coming Out!!!");
                default -> System.out.println("Opcao invalida!! Tente novamente...");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n__________Menu__________");
        System.out.println("1. Cadastrar Professor");
        System.out.println("2. Cadastrar Curso");
        System.out.println("3. Listar Professores");
        System.out.println("4. Listar Cursos");
        System.out.println("5. Listar Professores por Area");
        System.out.println("6. Consultar Cursos por Area");
        System.out.println("7. Consultar Professores por Salario");
        System.out.println("8. Consultar Professores por Idade");
        System.out.println("9. Calcular Gasto Mensal com Professores");
        System.out.println("10. Encontrar Professor com Maior Salario");
        System.out.println("11. Encontrar Professor com Maior Idade");
        System.out.println("12. Encontrar Curso Mais Antigo");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opcao: ");
    }

    private void cadastrarProfessor(Scanner scanner) {
        System.out.print("Digite o nome do professor: ");
        scanner.nextLine();
        String nome = scanner.nextLine();

        System.out.print("Digite o ID do professor: ");
        String id = scanner.next();

        System.out.print("Digite a idade do professor: ");
        int idade = scanner.nextInt();

        System.out.print("Digite o endereco do professor: ");
        scanner.nextLine();
        String endereco = scanner.nextLine();

        System.out.print("Digite o telefone do professor: ");
        String telefone = scanner.next();

        System.out.print("Digite o salario do professor: ");
        double salario = scanner.nextDouble();

        System.out.println("Escolha a area de atuacao do professor:");
        System.out.println("1. Saude");
        System.out.println("2. Exatas");
        System.out.println("3. Humanas");
        System.out.print("Digite o numero correspondente a area: ");
        int areaEscolhida = scanner.nextInt();

        String area = null;
        switch (areaEscolhida) {
            case 1:
                area = "Saude";
                break;
            case 2:
                area = "Exatas";
                break;
            case 3:
                area = "Humanas";
                break;
            default:
                System.out.println("Opcao invalida!! ");
                break;
        }

        Professor professor = new Professor(nome, idade, endereco, telefone, salario, area);
        cadastrarProfessor(professor);
        System.out.println("Professor cadastrado com sucesso!");
    }

    private void listarProfessoresPorArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a area desejada para listar professores: ");
        String areaDesejada = scanner.next();

        boolean areaEncontrada = false;
        for (Professor professor : getProfessores()) {
            if (professor.getArea() != null && professor.getArea().equalsIgnoreCase(areaDesejada)) {
                areaEncontrada = true;
                System.out.println("Nome: " + professor.getNome() + ", Area: " + professor.getArea());
            }
        }

        if (!areaEncontrada) {
            System.out.println("Nenhum professor encontrado para a area informada.");
        }
    }

    private void cadastrarCurso(Scanner scanner) {
        System.out.print("Digite o nome do curso: ");
        scanner.nextLine();
        String nome = scanner.nextLine();
        
        System.out.print("Digite o numero de vagas do curso: ");
        int vagas = scanner.nextInt();
        
        System.out.println("Escolha a area do curso:");
        System.out.println("1. Saude");
        System.out.println("2. Exatas");
        System.out.println("3. Humanas");
        System.out.print("Digite o numero correspondente a area: ");
        int areaEscolhida = scanner.nextInt();

      
        String area = null;
        switch (areaEscolhida) {
            case 1:
                area = "Saude";
                break;
            case 2:
                area = "Exatas";
                break;
            case 3:
                area = "Humanas";
                break;
            default:
                System.out.println("Opcao invalida!!!");
                return;
        }
        
        
        System.out.print("Digite o ano de fundacao do curso: ");
        int anoFundacao = scanner.nextInt();

        Curso curso = new Curso(nome, area, anoFundacao, vagas);
        cadastrarCurso(curso);
        System.out.println("Curso cadastrado com sucesso!");
    }

    private void consultarCursosPorArea(Scanner scanner) {
        System.out.print("Digite a area do curso a ser consultada: ");
        String area = scanner.next();
        List<Curso> cursosPorArea = consultarCursosPorArea(area);
        for (Curso curso : cursosPorArea) {
            System.out.println("Nome: " + curso.getNome());
        }
    }

    private void consultarProfessoresPorSalario(Scanner scanner) {
        System.out.print("Digite o salario minimo para a consulta: ");
        double salarioMinimo = scanner.nextDouble();
        List<Professor> professoresPorSalario = consultarProfessoresPorSalario(salarioMinimo);
        for (Professor professor : professoresPorSalario) {
            System.out.println("Nome: " + professor.getNome() + ", Salario: " + professor.getSalario());
        }
    }

    private void consultarProfessoresPorIdade(Scanner scanner) {
        System.out.print("Digite a idade minima para a consulta: ");
        int idadeMinima = scanner.nextInt();
        List<Professor> professoresPorIdade = consultarProfessoresPorIdade(idadeMinima);
        for (Professor professor : professoresPorIdade) {
            System.out.println("Nome: " + professor.getNome() + ", Idade: " + professor.getIdade());
        }
    }

    private void exibirProfessorMaiorSalario() {
        Professor maiorSalario = encontrarProfessorMaiorSalario();
        System.out.println("Professor com maior salario: " + maiorSalario.getNome() + ", Salario: " + maiorSalario.getSalario());
    }

    private void exibirProfessorMaiorIdade() {
        Professor maiorIdade = encontrarProfessorMaiorIdade();
        System.out.println("Professor com maior idade: " + maiorIdade.getNome() + ", Idade: " + maiorIdade.getIdade());
    }

    private void exibirCursoMaisAntigo() {
    Curso cursoMaisAntigo = encontrarCursoMaisAntigo();
    if (cursoMaisAntigo != null) {
        System.out.println("Curso mais antigo: " + cursoMaisAntigo.getNome() + ", Ano de fundacao: " + cursoMaisAntigo.getAnoFundacao());
    } else {
        System.out.println("Nenhum curso cadastrado.");
    }
}

    public static void main(String[] args) {
        Ucdb ucdb = new Ucdb();
        ucdb.executarMenu();
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}

