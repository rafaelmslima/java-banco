package com.algaworks.banco.modelo;

import java.util.Objects;

public abstract class Conta {
    /*
    Uma classe abstrata é usada para criar apenas algo que será uma abstração, ou seja, algo que não pode ser instanciado mas que existe como um
    superTipo, dizendo como as classes derivadas dela devem se comportar na forma base.

    Podemos criar métodos abstratos também, mas um metodo abstrado nao pode ter codigo nele. Quando fazemos isso, as classes que herdam da classe mãe
    devem obrigatoriamente implementar um código para esse método abstrato.
     */
    private Pessoa titular;
    private int agencia;
    private int numero;
    private double saldo;

    Conta() {
    }

    public Conta(Pessoa titular, int agencia, int numero) {
        Objects.requireNonNull(titular);

        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que 0");
        }
        saldo = saldo + valor;
        System.out.println("Valor do saldo agora é " + saldo);
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que 0");
        }

        if (getSaldoDisponivel() - valor < 0) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        saldo = saldo - valor;
    }

    public void sacar(double valor, double taxaSaque) {
        sacar(valor + taxaSaque);
    }

    public abstract void debitarTarifaMensal();

    public Pessoa getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getSaldoDisponivel() {
        return getSaldo();
    }

}
