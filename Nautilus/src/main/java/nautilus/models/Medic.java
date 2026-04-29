package nautilus.models;

import java.time.LocalDate;
import nautilus.enums.EnumEmp;

public class Medic extends Employee {

    private String crm;
    private int consultorio;
    private EnumEmp.EnuMed esp;

    public Medic(String nome, String cpf, String rg, String matricula, LocalDate dataNasc,
                 String senha, String crm, int consultorio, EnumEmp.EnuMed esp) {

        super(nome, cpf, rg, EnumEmp.EnumEmpl.MEDICO, matricula, dataNasc, senha);

        setCrm(crm);
        setConsultorio(consultorio);
        setEsp(esp);
    }

    public String getCrm() { 
        return this.crm; 
    }

    public void setCrm(String fCrm) {
        if (fCrm != null && fCrm.matches("[0-9]+") && fCrm.length() >= 4) {
            this.crm = fCrm;
        } else {
            throw new IllegalArgumentException("CRM invalido!");
        }
    }

    public int getConsultorio() {
        return this.consultorio;
    }

    public void setConsultorio(int fConsultorio) {
        if (fConsultorio >= 0 && fConsultorio <= 100) {
            this.consultorio = fConsultorio;
        } else {
            throw new IllegalArgumentException("Consultorio invalido! Digite um valor entre 0 e 100.");
        }
    }

    public EnumEmp.EnuMed getEsp() {
        return this.esp;
    }

    public void setEsp(EnumEmp.EnuMed fEsp) {
        if (fEsp == null) {
            throw new IllegalArgumentException("Especialidade invalida!");
        }
        this.esp = fEsp;
    }
}
