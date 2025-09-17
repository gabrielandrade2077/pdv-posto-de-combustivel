package com.br.pdvpostocombustivel;
import com.br.pdvpostocombustivel.domain.entity.Pessoa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdvpostocombustivelApplication {

    public static void main(String[] args) {
        //SpringApplication.run(PdvpostocombustivelApplication.class, args);
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setnomeCompleto("Higgs");
        pessoa1.setcpfCnpj("548.243.511-92");
        pessoa1.setnumeroCtps(1234L);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setnomeCompleto("Sam");
        pessoa2.setcpfCnpj("872.456.981-01");
        pessoa2.setnumeroCtps(4567L);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setnomeCompleto("Ellie");
        pessoa3.setcpfCnpj("123.654.789-32");
        pessoa3.setnumeroCtps(8967l);
        System.out.println("Pessoa 1: ");
        System.out.println("Nome Completo: "+pessoa1.getnomeCompleto());
        System.out.println("Cpf/Cnpj: "+pessoa1.getcpfCnpj());
        System.out.println("ctps: "+ pessoa1.getnumeroCtps());

        System.out.println("\nPessoa 2: ");
        System.out.println("Nome Completo: "+pessoa2.getnomeCompleto());
        System.out.println("Cpf/Cnpj: "+pessoa2.getcpfCnpj());
        System.out.println("Ctps: "+ pessoa2.getnumeroCtps());

        System.out.println("\nPessoa 3: ");
        System.out.println("Nome Completo: "+pessoa3.getnomeCompleto());
        System.out.println("Cpf/Cnpj: "+pessoa3.getcpfCnpj());
        System.out.println("Ctps: "+ pessoa3.getnumeroCtps());
    }



}
