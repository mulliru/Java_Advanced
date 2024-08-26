package br.com.fiap.model;

public class Professor extends Pessoa {

	@Override //garantir que o método esttá sobreescrevendo
	@SuppressWarnings("all") //retira os alertas (amarelinho)
	@Deprecated // define que o metodo esta obsoleto e nao deve ser utilizado
	public void andar() {
		System.out.println("Professor andando");
			int x = 123;
	}
	
}