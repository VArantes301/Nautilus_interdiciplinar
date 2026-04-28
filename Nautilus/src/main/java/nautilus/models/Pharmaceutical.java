package nautilus.models;

import java.time.LocalDate;

public class Pharmaceutical extends Employee {

    private String crf;

    public Pharmaceutical (String nome, String cpf, String rg, String matricula, LocalDate dataNasc, String senha,
                           String crf) {

        super(nome, cpf, rg, EnumEmp.Enumempl.FARMACEUTICO, matricula, dataNasc, senha);

        setCrf(crf);
    }

    public String getCrf() {
        return this.crf;
    }

    public void setCrf(String fCrf) {
        if (fCrf != null && fCrf.length() == 5 && fCrf.matches("[0-9]+")) {
            this.crf = fCrf;
        } else {
            throw new IllegalArgumentException("Digite um CRF valido!");
        }
    }

    public void createRem (Remedies aRemedies, String nomeRem, EnumRem.opTarja tarjaRem, EnumRem.opFarm farmacRem,
                           EnumRem.opVia viaAdmRem, String regAnvisaRem, boolean autoMedRem, EnumRem.opStatus statusRem,
                           int quantRem) {

        try {
            aRemedies.setNome(nomeRem);
            aRemedies.setTarja(tarjaRem);
            aRemedies.getForFarmac(farmacRem);
            aRemedies.setViaAdm(viaAdmRem);
            aRemedies.setRegAnvisa(regAnvisaRem);
            aRemedies.setAutoMed(autoMedRem);
            aRemedies.setStatus(statusRem);
            aRemedies.setQuant(quantRem);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar remedio: " + e.getMessage());
        }
    }


    public void createBatc (Batch aBatch,  float precoBatc, LocalDate fabBatc, LocalDate valBatc,
                            int numLoteBatc, LocalDate datCadBatc) {

        try {

            aBatch.setPreco(precoBatc);
            aBatch.setFab(fabBatc);
            aBatch.setVal(valBatc);
            aBatch.setNumLote(numLoteBatc);
            aBatch.setDatCad(datCadBatc);
        } catch (IllegalArgumentException e) {
            System.out.println("erro ao criar lote" + e.getMessage());
        }
    }
}