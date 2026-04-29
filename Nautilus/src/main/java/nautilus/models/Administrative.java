package nautilus.models;

import java.time.LocalDate;
import nautilus.enums.EnumEmp;

public class Administrative extends Employee {

    private float verba;

    public Administrative(String nome, String cpf, String rg, String matricula,
                          LocalDate dataNasc, String senha, float verba) {
        super(nome, cpf, rg, EnumEmp.EnumEmpl.ADMINISTRATIVO, matricula, dataNasc, senha);

        setVerba(verba);
    }

    public float getVerba() {
        return this.verba;
    }

    public void setVerba(float rVerba) {
        if (rVerba >= 0) {
            this.verba = rVerba;
        } else {
            throw new IllegalArgumentException("Verba invalida! O valor nao pode ser negativo.");
        }
    }

    public void createEmployee(Employee aEmployee, String nomeEmp, String cpfEmp, String rgEmp,
                               EnumEmp.EnumEmpl funEmp, String matrEmp, LocalDate nascEmp, String senhaEmp) {
        try {
            aEmployee.setNome(nomeEmp);
            aEmployee.setCpf(cpfEmp);
            aEmployee.setRg(rgEmp);
            aEmployee.setFuncao(funEmp);
            aEmployee.setMatricula(matrEmp);
            aEmployee.setDataNasc(nascEmp);
            aEmployee.setSenha(senhaEmp);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar funcionario: " + e.getMessage());
        }
    }

    public void createMedic(Medic aMedic, String crMed, int consultMed, EnumEmp.EnuMed espMed) {
        try {
            aMedic.setCrm(crMed);
            aMedic.setConsultorio(consultMed);
            aMedic.setEsp(espMed);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar medico: " + e.getMessage());
        }
    }

    public void createNurse(Nurse aNurse, String coreNur, EnumEmp.EnumNur compostaNur) {
        try {
            aNurse.setCoren(coreNur);
            aNurse.setComposta(compostaNur);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar enfermeiro: " + e.getMessage());
        }
    }

    public void createPharmaceutical(Pharmaceutical aPharmaceutical, String crfPha) {
        try {
            aPharmaceutical.setCrf(crfPha);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar farmaceutico: " + e.getMessage());
        }
    }
}
