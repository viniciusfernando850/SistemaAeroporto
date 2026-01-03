package AirportSystem.ManipulacaoArquivos;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FuncionariosRepository implements Reader {

    public List<String> carregar(Path caminho) throws IOException {
        return Files.readAllLines(caminho);
    }
}
