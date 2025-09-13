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
        pessoa1.setcpfCnpj("254151451");
        pessoa1.setnumeroCtps(1234L);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setnomeCompleto("Sam");
        pessoa2.setcpfCnpj("145153315");
        pessoa2.setnumeroCtps(4567L);

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setnomeCompleto("Fragile");
        pessoa3.setcpfCnpj("51351613");
        pessoa3.setnumeroCtps(8967l);
        System.out.println("Pessoa 1: "+pessoa1.getnomeCompleto());
        System.out.println("cpf/cnpj: "+pessoa1.getcpfCnpj());
        System.out.println("ctps: "+ pessoa1.getnumeroCtps());

        System.out.println("\nPessoa 2: "+pessoa2.getnomeCompleto());
        System.out.println("cpf/cnpj: "+pessoa2.getcpfCnpj());
        System.out.println("ctps: "+ pessoa2.getnumeroCtps());

        System.out.println("\nPessoa 3: "+pessoa3.getnomeCompleto());
        System.out.println("cpf/cnpj: "+pessoa3.getcpfCnpj());
        System.out.println("ctps: "+ pessoa3.getnumeroCtps());
    }



}
