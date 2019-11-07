import java.util.ArrayList;
import java.util.List;

public class RepositorioContasLista implements RepositorioContas{
	
	private List<Conta> contas;
	
	public RepositorioContasLista (){
		contas = new ArrayList<Conta>();
	}

	@Override
	public void inserir(Conta c) {
		contas.add(c);
	}
	
	@Override
	public Conta procurar(String numConta) {
		Conta procurada = null;
		for (Conta conta : contas) {
			if (conta.getNumero().contentEquals(numConta)) {
				procurada = conta;
			}
		}
		return procurada;
	}
	
	@Override
	public void remover (String numConta) {
		int posicao = -1;
		for (Conta conta: contas) {
			if (conta.getNumero().contentEquals(numConta)) {
				posicao = contas.indexOf(conta);
				break;
			}
		}
		
		if (posicao != -1) {
			contas.remove(posicao);
		}		
	}
	
	public List<Conta> listarContas(){
		return this.contas;
	}

	
}
