package StarTrackAirlines.Aplicacao.ManipulacaoArquivos;

import java.io.IOException;

public interface LoaderComOrigem<T, V> {

    public T carregarDados(V object) throws IOException;
}
