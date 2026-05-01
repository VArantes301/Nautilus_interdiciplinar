package nautilus.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import nautilus.enums.EnumEmp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Employee {

    private static int genId = 0;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private String nome;
    private String cpf;
    private String rg;
    private EnumEmp.EnumEmpl funcao;
    private String dataNasc;
    private String senha;
    private String matricula;
    private final int id;

    public Employee(String nome, String cpf, String rg, EnumEmp.EnumEmpl funcao,
                    String matricula, String dataNasc, String senha) {

        setNome(nome);
        setCpf(cpf);
        setRg(rg);
        this.funcao = funcao;
        setMatricula(matricula);
        setDataNasc(dataNasc);
        setSenha(senha);
        this.id     = ++genId;
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

        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalArgumentException("Formato de data invalido! Use dd/MM/yyyy.");
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
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            this.senha = encoder.encode(fSenha);
        } else {
            throw new IllegalArgumentException("Senha invalida! Minimo 8 caracteres.");
        }
    }

    public boolean verificarSenha(String fSenha) {
        return encoder.matches(fSenha, this.senha);
    }

    public int getId() {
        return this.id;
    }
}
