package Dados;

public class Produto implements Comparable<Produto> {
    private String codigo;
    private String descricao;
    private String fornecedor;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String codigo, String descricao, String fornecedor, double preco, int quantidadeEmEstoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Descrição: " + descricao + ", Fornecedor: " + fornecedor + 
               ", Preço: " + preco + ", Quantidade em estoque: " + quantidadeEmEstoque;
    }

    @Override
    public int compareTo(Produto outro) {
        return this.codigo.compareTo(outro.codigo);
    }
}
