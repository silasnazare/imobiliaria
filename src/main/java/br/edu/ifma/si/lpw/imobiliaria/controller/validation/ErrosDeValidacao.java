package br.edu.ifma.si.lpw.imobiliaria.controller.validation;

public class ErrosDeValidacao {
    private String campo;
    private String mensagem;

    public ErrosDeValidacao(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
