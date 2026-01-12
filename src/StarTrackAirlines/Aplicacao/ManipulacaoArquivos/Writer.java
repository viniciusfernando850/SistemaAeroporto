package StarTrackAirlines.Aplicacao.ManipulacaoArquivos;

import java.io.IOException;

public interface Writer<T> {

    public void salvarDados(T object) throws IOException;
}
