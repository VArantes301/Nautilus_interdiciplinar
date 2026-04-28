package nautilus.models;

public class RegiForm {

    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNasc;
    private String cartSUS;
    private int idade;

    public RegiForm (String nome, String cpf, String rg, LocalDate dataNasc, String cartSUS, int idade) {

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

    public void setRg(String rg) {
        if (fRg != null && fRg.matches("[0-9]+") && fRg.length() == 9) {
            this.rg = fRg;
        } else {
            throw new IllegalArgumentException("RG invalido!");
        }
    }

    public LocalDate getDataNasc() {
        return this.dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        if (fDataNasc != null && fDataNasc.isBefore(LocalDate.now())) {
            this.dataNasc = fDataNasc
        } else {
            throw new IllegalArgumentException("Digite uma data valida.");
        }
    }

    public String getCartSUS() {
        return this.CartSUS;
    }

    public void setCartSUS(String fCartSUS) {
        if (fCartSUS != null && fCartSUS.matches("[0-9]+") && fCartSUS.length() == 15) {
            this.cartSUS = cartSUS;
        } else {
            throw new IllegalArgumentException("Digite um cartão SUS valido!.");
        }
    }

}
}