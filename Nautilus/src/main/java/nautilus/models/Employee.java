package nautilus.models;

import java.time.LocalDate;
import nautilus.enums.EnumEmp;
import org.mindrot.jbcrypt.BCrypt;

public class Employee {

    private static int genId = 0;

    private String nome;
    private String cpf;
    private String rg;
    private EnumEmp.EnumEmpl funcao;
    private LocalDate dataNasc;
    private String senha;
    private String matricula;
    private final int id;

    public Employee(String nome, String cpf, String rg, EnumEmp.EnumEmpl funcao,
                    String matricula, LocalDate dataNasc, String senha) {

        setNome(nome);
        setCpf(cpf);
        setRg(rg);
        this.funcao = funcao;
        setMatricula(matricula);
        setDataNasc(dataNasc);
        setSenha(senha);
        this.id = ++genId;
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

    public EnumEmp.EnumEmpl getFuncao() {
        return this.funcao;
    }

    public void setFuncao(EnumEmp.EnumEmpl fFuncao) {
        if (fFuncao == null) {
            throw new IllegalArgumentException("Funcao invalida!");
        }
        this.funcao = fFuncao;
    }

    public LocalDate getDataNasc() {
        return this.dataNasc;
    }

    public void setDataNasc(LocalDate fDataNasc) {
        if (fDataNasc != null && fDataNasc.isBefore(LocalDate.now())) {
            this.dataNasc = fDataNasc
        } else {
            throw new IllegalArgumentException("Digite uma data valida.");
        }
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String fMatricula) {
        if (fMatricula != null && !fMatricula.isBlank() && fMatricula.length() < 30) {
            this.matricula = fMatricula;
        } else {
            throw new IllegalArgumentException("Matricula invalida!");
        }
    }

    public void setSenha(String fSenha) {
        if (fSenha != null && fSenha.length() >= 8) {
            this.senha = BCrypt.hashpw(fSenha, BCrypt.gensalt());
        } else {
            throw new IllegalArgumentException("Senha invalida! Minimo 8 caracteres.");
        }
    }

    public boolean verificarSenha(String fSenha) {
        return BCrypt.checkpw(fSenha, this.senha);
    }

    public int getId() {
        return this.id;
    }
}
