package Dados;

public class Aluno implements Comparable<Aluno> {
    private int matricula;
    private String nome;

    public Aluno(int matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public int compareTo(Aluno a1) {
        return Integer.compare(this.matricula, a1.matricula);
    }

    @Override
    public String toString() {
        return this.nome + " {" + "matricula = " + matricula + '}';
    }
}
