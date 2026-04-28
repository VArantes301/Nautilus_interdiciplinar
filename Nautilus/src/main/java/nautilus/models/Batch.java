package nautilus.models;

import java.time.LocalDate;
import nautilus.enums.EnumRem;

public class Batch extends Remedies {

    private float preco;
    private LocalDate fab;
    private LocalDate val;
    private int numLote;
    private LocalDate datCad;

    public Batch(String nome, EnumRem.opTarja tarja, EnumRem.opFarm forFarmac, EnumRem.opVia viaAdm,
                 String regAnvisa, boolean autoMed, EnumRem.opStatus status, int quant,
                 float preco, LocalDate fab, LocalDate val, int numLote, LocalDate datCad) {

        super(nome, tarja, forFarmac, viaAdm, regAnvisa, autoMed, status, quant);
        
        setPreco(preco);
        setFab(fab);
        setVal(val);
        setNumLote(numLote);
        setDatCad(datCad);
    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float rPreco) {
        if (rPreco >= 0) {
            this.preco = rPreco;
        } else {
            throw new IllegalArgumentException("Preco invalido! O valor nao pode ser negativo.");
        }
    }

    public LocalDate getFab() {
        return this.fab;
    }

    public void setFab(LocalDate rFab) {
        if (rFab != null && rFab.isBefore(LocalDate.now())) {
            this.fab = rFab;
        } else {
            throw new IllegalArgumentException("Data de fabricacao invalida!");
        }
    }

    public LocalDate getVal() {
        return this.val;
    }

    public void setVal(LocalDate rVal) {
        if (rVal != null && rVal.isAfter(LocalDate.now())) {
            this.val = rVal;
        } else {
            throw new IllegalArgumentException("Nao e possivel cadastrar um item vencido!");
        }
    }

    public int getNumLote() {
        return this.numLote;
    }

    public void setNumLote(int rNumLote) {
        if (rNumLote > 0) {
            this.numLote = rNumLote;
        } else {
            throw new IllegalArgumentException("Numero de lote invalido!");
        }
    }

    public LocalDate getDatCad() {
        return this.datCad;
    }

    public void setDatCad(LocalDate rDatCad) {
        if (rDatCad != null && !rDatCad.isAfter(LocalDate.now())) {
            this.datCad = rDatCad;
        } else {
            throw new IllegalArgumentException("Data de cadastro invalida!");
        }
    }
}
