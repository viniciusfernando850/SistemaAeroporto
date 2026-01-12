package StarTrackAirlines.Aplicacao.ManipulacaoArquivos;

import java.io.IOException;

public interface Loader<T> {

    public T carregarDados() throws IOException;
}
