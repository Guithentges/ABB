package Dados;

import Dados.Produto;
import ABB.ABB;

public class Cadastro {
    private ABB<Produto> produtos;

    public Cadastro() {
        produtos = new ABB<>();
    }

    public void cadastrarProduto(String codigo, String descricao, String fornecedor, double preco, int quantidade) {
        Produto novoProduto = new Produto(codigo, descricao, fornecedor, preco, quantidade);
        Produto produtoExistente = produtos.buscar(novoProduto);
    
        if (produtoExistente == null) {
            produtos.inserir(novoProduto);
            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Produto com este código já existe.");
        }
    }
    
    public void exibirProdutos() {
        produtos.inOrderNR();
    }

    public Produto buscarProduto(String codigo) {
        Produto produto = new Produto(codigo, null, null, 0, 0);
        return produtos.buscar(produto);
    }

    public Produto exibirMenorProduto() {
        return produtos.exibirMenor();
    }

    public Produto exibirMaiorProduto() {
        return produtos.exibirMaior();
    }

    public void exibirPorNivel() {
        produtos.porNivel();
    }

    public int contarProdutos() {
        return produtos.contarNosNR();
    }

    public int contarFolhas() {
        return produtos.contarFolhasNR();
    }
}
