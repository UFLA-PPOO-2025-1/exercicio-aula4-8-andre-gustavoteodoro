import java.util.List;

public abstract class SerVivo implements Ator {
    // Características compartilhadas por todos os seres vivos (atributos estáticos, da classe).
    private boolean vivo;
    // A localização do animal.
    private Localizacao localizacao;
    // O campo ocupado.
    private Campo campo;

    public SerVivo(Campo campo, Localizacao localizacao) {
        this.vivo = true;
        this.campo = campo;
        definirLocalizacao(localizacao);
    }

     protected void morrer()
    {
        vivo = false;
        if(localizacao != null) {
            campo.limpar(localizacao);
            localizacao = null;
            campo = null;
        }
    }
    
    /**
     * Retorna a localização do animal.
     * @return A localização do animal.
     */
    public Localizacao obterLocalizacao()
    {
        return localizacao;
    }
    
    /**
     * Coloca o animal na nova localização no campo fornecido.
     * @param novaLocalizacao A nova localização do animal.
     */
    protected void definirLocalizacao(Localizacao novaLocalizacao)
    {
        if(localizacao != null) {
            campo.limpar(localizacao);
        }
        localizacao = novaLocalizacao;
        campo.colocar(this, novaLocalizacao);
    }

    public Campo obterCampo() {
        return campo;
    }
    
    protected boolean estaVivo(){
        return vivo;
    }

    /**
     * Método abstrato que define o comportamento do ser vivo.
     * @param seresVivos A lista de seres vivos no campo.
     */
    @Override
    public abstract void agir(List<Ator> seresVivos);

    @Override
    public boolean estaAtivo() {
        return estaVivo();
    }
}
