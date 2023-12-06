# UCDB - Universidade Católica Dom Bosco

Bem-vindo ao repositório UCDB, uma implementação em Java que representa a Universidade Católica Dom Bosco (UCDB). Este projeto incorpora conceitos de Programação Orientada a Objetos (POO) para modelar a UCDB, incluindo informações sobre endereço, ano de fundação, cursos e professores.

## Descrição da Classe UCDB

A classe UCDB possui métodos para cadastrar cursos e professores, realizar consultas específicas, calcular gastos mensais e identificar destaques como o professor com o maior salário, o mais experiente em idade e o curso mais antigo.

## Funcionalidades Principais

- **Construtores:**
  - `UCDB()`: Construtor padrão que não recebe argumentos para professores e cursos.
  - `UCDB(endereco, anoFundacao)`: Construtor que recaba argumentos para endereço e ano de fundação.

- **Cadastro de Cursos e Professores:**
  - `cadastrarCurso(curso)`: Permite cadastrar novos cursos.
  - `cadastrarProfessor(professor)`: Permite cadastrar novos professores.

- **Listagem de Informações:**
  - `listarProfessores()`: Lista informações dos professores, permitindo consultas por salário e idade.
  - `listarCursos()`: Lista informações dos cursos, permitindo consultas por área.

- **Gastos Mensais:**
  - `calcularGastoMensal()`: Calcula o gasto mensal da UCDB com os professores cadastrados.

- **Destaques:**
  - `professorMaiorSalario()`: Retorna o professor com o maior salário.
  - `professorMaiorIdade()`: Retorna o professor com a maior idade.

- **Curso Mais Antigo:**
  - `cursoMaisAntigo()`: Retorna o curso mais antigo entre todos os cursos cadastrados.

## Utilização

Para utilizar a classe UCDB em seu projeto Java, siga o exemplo abaixo:

```java
// Exemplo de utilização da classe UCDB
UCDB ucdb = new UCDB("Endereco da UCDB", 1970);
ucdb.cadastrarCurso(curso1);
ucdb.cadastrarProfessor(professor1);

// Realize outras operações conforme a necessidade do seu projeto
