package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
 * Classe Banco
 * 
 * Simulando um bando de dados para o sistema gerenciador
 * 
 * */
public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	//simulando uma primary key
	private static Integer chaveSequencial = 1;
	
	//Toda a evz que o sistema for reiniciado, ser� inicializado com as empresas abaixo
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		
		lista.add(empresa);
		lista.add(empresa2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		
		//pederia ser feito com foreach
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {
				it.remove();
			}
		}
		
		//Exemplo do que foi dito no ultimo coment�rio:
		/*for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				it.remove();
			}
		}*/
	}

	public Empresa buscaEmpresaPelaId(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

}
