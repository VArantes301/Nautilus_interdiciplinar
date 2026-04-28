package nautilus.models;

import nautilus.enums.EnumRem;

public class Remedies {

    private String nome;
    private EnumRem.opTarja tarja;
    private EnumRem.opFarm forFarmac;
    private EnumRem.opVia viaAdm;
    private String regAnvisa;
    private boolean autoMed;
    private EnumRem.opStatus status;
    private int quant;

    public Remedies(String nome, EnumRem.opTarja tarja, EnumRem.opFarm forFarmac, EnumRem.opVia viaAdm, String regAnvisa,
                    boolean autoMed, EnumRem.opStatus status, int quant) {

        setNome(nome);
        setTarja(tarja);
        setForFarmac(forFarmac);
        setViaAdm(viaAdm);
        setRegAnvisa(regAnvisa);
        setAutoMed(autoMed);
        setStatus(status);
        setQuant(quant);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String rNome) {
        if (rNome != null && rNome.replace(" ", "").matches("[a-zA-ZÀ-ÿ]+")) {
            this.nome = rNome;
        } else {
            throw new IllegalArgumentException("Nome invalido! Use apenas letras.");
        }
    }

    public EnumRem.opTarja getTarja() {
        return this.tarja;
    }

    public void setTarja(EnumRem.opTarja rTarja) {
        if (rTarja == null) throw new IllegalArgumentException("Tarja invalida!");
        this.tarja = rTarja;
    }

    public EnumRem.opFarm getForFarmac() {
        return this.forFarmac;
    }

    public void setForFarmac(EnumRem.opFarm rForFarmac) {
        if (rForFarmac == null) throw new IllegalArgumentException("Forma farmaceutica invalida!");
        this.forFarmac = rForFarmac;
    }

    public EnumRem.opVia getViaAdm() {
        return this.viaAdm;
    }

    public void setViaAdm(EnumRem.opVia rViaAdm) {
        if (rViaAdm == null) throw new IllegalArgumentException("Via de administracao invalida!");
        this.viaAdm = rViaAdm;
    }

    public String getRegAnvisa() {
        return this.regAnvisa;
    }

    public void setRegAnvisa(String rRegAnvisa) {
        if (rRegAnvisa != null && rRegAnvisa.matches("[0-9]+") && rRegAnvisa.length() == 13) {
            this.regAnvisa = rRegAnvisa;
        } else {
            throw new IllegalArgumentException("Registro ANVISA invalido! Deve conter 13 digitos.");
        }
    }

    public boolean isAutoMed() {
        return this.autoMed;
    }

    public void setAutoMed(boolean rAutoMed) {
        this.autoMed = rAutoMed;
    }

    public EnumRem.opStatus getStatus() {
        return this.status;
    }

    public void setStatus(EnumRem.opStatus rStatus) {
        if (rStatus == null) {
            this.status = rStatus;
        } else {
            throw new IllegalArgumentException("Status invalido!");
        }
    }

    public int getQuant() {
        return this.quant;
    }

    public void setQuant(int rQuant) {
        if (rQuant >= 0) {
            this.quant = rQuant;
        } else {
            throw new IllegalArgumentException("Quantidade nao pode ser negativa!");
        }
    }
}
