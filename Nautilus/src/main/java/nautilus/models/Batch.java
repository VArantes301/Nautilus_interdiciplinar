package nautilus.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import nautilus.enums.EnumRem;

public class Batch extends Remedies {

    private float preco;
    private LocalDate fab;
    private LocalDate val;
    private int numLote;
    private LocalDate datCad;

    public Batch(String nome, EnumRem.opTarja tarja, EnumRem.opFarm forFarmac, EnumRem.opVia viaAdm,
                 String regAnvisa, boolean autoMed, EnumRem.opStatus status, int quant,
                 float preco, String fab, String val, int numLote, String datCad) {

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

    public void setFab(String rFab) {
        try {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(rFab, formatador);

            if (data.isBefore(LocalDate.now())) {
                this.fab = data;
            } else {
                throw new IllegalArgumentException("Formato de data invalido! Use dd/MM/yyyy.");
            }
        }catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalArgumentException("Formato de data invalido! Use dd/MM/yyyy.");
        }
    }

    public LocalDate getVal() {
        return this.val;
    }

    public void setVal(String rVal) {
        try {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(rVal, formatador);

            if (data.isAfter(this.fab)) {
                this.val = data;
            } else {
                throw new IllegalArgumentException("Data de validade invalida! Deve ser maior que a data de fabricacao.");
            }
        }catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalArgumentException("Formato de data invalido! Use dd/MM/yyyy.");
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

    public void setDatCad(String rDatCad) {
        try {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(rDatCad, formatador);

            if (data.isBefore(LocalDate.now())) {
                this.datCad = data;
            } else {
                throw new IllegalArgumentException("Formato de data invalido! Use dd/MM/yyyy.");
            }
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalArgumentException("Formato de data invalido! Use dd/MM/yyyy.");
        }
    }
}
