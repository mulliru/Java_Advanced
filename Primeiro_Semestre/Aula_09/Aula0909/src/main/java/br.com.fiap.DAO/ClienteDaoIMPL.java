private EntityManager em;
	
	public ClienteDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		em.persist(cliente);
	}
	
	public void atualizar(Cliente cliente) throws idNaoEncotradoException{
		buscarPorId(cliente.getId()); //valida se existe o cliente para atualizar
		em.merge(cliente);
	}

	public void remover(int id)throws idNaoEncontradoException {
		Cliente cliente = buscarPorId(id)
		em.remove(cliente);
	}
	
	public Cliente buscarPorId(int id)throws idNaoEncontradoException {
		Cliente cliente = em.find(Cliente.class, id);
		if (cliente == null)
			throw new IdNaoncontradoException("Cliente não encontrado");
		return cliente;
	}
	
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}
}
