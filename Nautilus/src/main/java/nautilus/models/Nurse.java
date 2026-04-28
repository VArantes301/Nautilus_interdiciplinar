package nautilus.models;

import java.time.LocalDate;
import nautilus.enums.EnumEmp;

public class Nurse extends Employee {

    private String coren;
    private EnumEmp.EnumNur composta;

    public Nurse(String nome, String cpf, String rg, String matricula, LocalDate dataNasc,
                 String senha, String coren, EnumEmp.EnumNur composta) {

        super(nome, cpf, rg, EnumEmp.EnumEmpl.ENFERMEIRO, matricula, dataNasc, senha);

        setCoren(coren);
        setComposta(composta);
    }

    public String getCoren() {
        return this.coren;
    }

    public void setCoren(String fCoren) {
        if (fCoren != null && fCoren.length() == 6 && fCoren.matches("[0-9]+")) {
            this.coren = fCoren;
        } else {
            throw new IllegalArgumentException("COREN invalido! Deve conter 6 digitos.");
        }
    }

    public EnumEmp.EnumNur getComposta() {
        return this.composta;
    }

    public void setComposta(EnumEmp.EnumNur fComposta) {
        if (fComposta == null) {
            throw new IllegalArgumentException("Composta invalida!");
        }
        this.composta = fComposta;
    }
}
