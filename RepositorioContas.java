import java.util.List;

public interface RepositorioContas {

	void inserir (Conta c);
	Conta procurar (String numConta);
	void remover(String numConta);
	List<Conta> listarContas();
}
