package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String referencia;
    @Column(length = 50, nullable = false)
    private String fornecedor;
    @Column(length = 100, nullable = false)
    private String categoria;
    @Column(length = 100, nullable = false)
    private String marca;

    @Column(name = "preco_venda", precision = 10, scale = 2)
    private BigDecimal precoVenda;

    public Produto(String nome,String referencia,String fornecedor, String categoria, String marca, BigDecimal precoVenda){
        this.nome = nome;
        this.referencia = referencia;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
        this.marca = marca;
        this.precoVenda = precoVenda;
    }

    public Produto() {
    }

    public Long getId() { // Adicionado
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public String getMarca() {
        return marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }
}