package nautilus.models;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class RegiForm {

    private String nome;
    private String cpf;
    private String rg;
    private String dataNasc;
    private String cartSUS;
    private int idade;

    public RegiForm (String nome, String cpf, String rg, String dataNasc, String cartSUS, int idade) {

        setNome(nome);
        setCpf(cpf);
        setRg(rg);
        setDataNasc(dataNasc);
        setCartSUS(cartSUS);
        this.idade = idade; // para fazer posteriormente
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String fNome) {
        if (fNome != null && fNome.replace(" ", "").matches("[a-zA-ZÀ-ÿ]+")) {
            this.nome = fNome;
        } else {
            throw new IllegalArgumentException("Nome invalido! Use apenas letras.");
        }
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String fCpf) {
        if (fCpf != null && fCpf.replace(" ", "").matches("[0-9]+") && fCpf.length() == 11) {
            this.cpf = fCpf;
        } else {
            throw new IllegalArgumentException("CPF invalido!");
        }
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String fRg) {
        if (fRg != null && fRg.matches("[0-9]+") && fRg.length() == 9) {
            this.rg = fRg;
        } else {
            throw new IllegalArgumentException("RG invalido!");
        }
    }

    public String getDataNasc() {
        return this.dataNasc;
    }

    public void setDataNasc(String fDataNasc) {
        try {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(fDataNasc, formatador);

            if (data.isBefore(LocalDate.now())) {
                this.dataNasc = fDataNasc;
            } else {
                throw new IllegalArgumentException("Digite uma data valida.");
            }
            
        } catch (Exception e) {
                throw new IllegalArgumentException("Formato de data invalido! Use dd/MM/yyyy.");
        }
    }

    public String getCartSUS() {
        return this.cartSUS;
    }

    public void setCartSUS(String fCartSUS) {
        if (fCartSUS != null && fCartSUS.matches("[0-9]+") && fCartSUS.length() == 15) {
            this.cartSUS = fCartSUS;
        } else {
            throw new IllegalArgumentException("Digite um cartão SUS valido!.");
        }
    }

    public int getIdade() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nascimento = LocalDate.parse(this.dataNasc, formatador);
        return Period.between(nascimento, LocalDate.now()).getYears();
    }

}