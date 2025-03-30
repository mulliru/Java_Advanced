package br.com.fiap.springmvc.model;

public enum Dificuldade {
    FACIL("label.dificuldade.facil"),
    MEDIA("label.dificuldade.media"),
    DIFICIL("label.dificuldade.dificil");

    private final String labelKey;

    Dificuldade(String labelKey) {
        this.labelKey = labelKey;
    }

    public String getLabelKey() {
        return labelKey;
    }
}
