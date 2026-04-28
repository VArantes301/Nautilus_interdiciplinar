package nautilus.enums;

public class EnumRem {

    public enum opTarja {
        PRETA,
        VERMELHA,
        AMARELA,
        LIVRE
    }

    public enum opVia {
        ORAL,
        PARENTAL,
        SUBLINGUAL,
        RETAL,
        OCULAR,
        OTOLOGICA,
        CUTANEA,
        TRANSDERMICA
    }

    public enum opFarm {
        SOLIDAS,
        SEMISSOLIDAS,
        SUBLINGUAL,
        LIQUIDAS,
        GASOSA
    }

    public  enum opStatus {
        LIBERADO,
        EM_FALTA,
        BLOQUEADO,
        EXCESSO
    }
}