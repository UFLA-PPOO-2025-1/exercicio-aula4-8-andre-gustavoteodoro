import java.util.List;

public class Cacador extends SerVivo {

    private static final int TIROS = 5;

    public Cacador(Campo campo, Localizacao localizacao) {
        super(campo, localizacao);
    }

    @Override
    public void agir(List<Ator> cacadores) {
        if (!estaAtivo())
            return;

        Localizacao novaLocalizacao = obterCampo().localizacaoAleatoriaLivre(obterLocalizacao());
        if (novaLocalizacao != null) {
            definirLocalizacao(novaLocalizacao);
        } else {
            return;
        }

        // Cheque novamente antes de atirar
        if (estaAtivo() && obterCampo() != null) {
            atirar();
        }
    }

    public void atirar() {
        if (estaAtivo()) {
            for (int i = 0; i < TIROS; i++) {
                Campo campo = obterCampo();
                if (campo == null) {
                    return; // Campo não está mais ativo
                } else {
                    Localizacao alvo = obterCampo().localizacaoAleatoria();
                    if (alvo != null) {
                        Object alvoAtor = obterCampo().obterObjetoEm(alvo);
                        if (alvoAtor instanceof SerVivo) {
                            SerVivo serVivo = (SerVivo) alvoAtor;
                            serVivo.morrer();
                        }
                    }
                }
            }
        }
    }

}
