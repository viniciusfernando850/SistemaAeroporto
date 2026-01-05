package AirportSystem.ManipulacaoArquivos;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface Reader {

    public List<String> carregar(Path caminho) throws IOException;
}
