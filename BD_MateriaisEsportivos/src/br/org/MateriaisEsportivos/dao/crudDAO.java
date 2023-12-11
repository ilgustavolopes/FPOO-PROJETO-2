package br.org.MateriaisEsportivos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.org.MateriaisEsportivos.model.Produto;

import br.org.MateriaisEsportivos.controller.*;

public class crudDAO {
	//cruddao
	//crud c-Create r-Read u-Update d-Delete
	
	//Create (inserir DADOS)
	public void create(Produto produto) {
		String sql = "INSERT INTO produtos_nbbshop(Categoria, Nome, Preço) VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast classe de pai ve a filha
			p.setString(1, produto.getCategoria());
			p.setString(2, produto.getNome());
			p.setFloat(3, produto.getPreco());
			p.execute();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "erro ao inserir dados! \nERRO: " + e);
		}finally {
			try {
				if(p != null);
				p.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
	}//fim create
	
	//metodo atualizar (update)
	public void update(Produto produto) {
		String sql = "UPDATE produtos_nbbshop SET Categoria = ?, Nome = ?, Preço = ?  WHERE Nip = ?";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast classe de pai ve a filha
			p.setString(1, produto.getCategoria());
			p.setString(2, produto.getNome());
			p.setFloat(3, produto.getPreco());
			p.setInt(4, produto.getNip());
			p.execute();//"executa inst para gravar" dados no banco
			JOptionPane.showMessageDialog(null, "dados atualizados com sucesso!");
			System.out.println("dados atualizados com sucesso!");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "erro ao inserir dados! \nERRO: " + e);
		}finally {
			try {
				if(p != null);
				p.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}//fim update
	
	//read
	public List<Produto> read(){
		String sql = "SELECT * FROM produtos_nbbshop";
		List<Produto> produtos = new ArrayList<Produto>();
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet resultado = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast classe de pai ve a filha
		    resultado = p.executeQuery();//mostra os dados da consulta sql
		    while(resultado.next()){
		    	Produto ver_produto = new Produto();
		    	//recuperar nip
		    	ver_produto.setNip(resultado.getInt("nip"));
		    	//recuperar categoria
		    	ver_produto.setCategoria(resultado.getString("categoria"));
		    	//recuperar o nome
		    	ver_produto.setNome(resultado.getString("nome"));
		    	//recuperar o preco
		    	ver_produto.setPreco(resultado.getFloat("preço"));
		    	//adicionar na lista
		    	produtos.add(ver_produto);
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(p != null);
					p.close();
				}catch (Exception e){
					e.printStackTrace();
				}
		}
			return produtos;
	}//fim read
	
	//delete
	public boolean delete(int Nip) {
		String sql = "DELETE FROM produtos_nbbshop WHERE Nip = ?";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast classe de pai ve a filha
			p.setInt(1, Nip);
			p.execute();
			JOptionPane.showMessageDialog(null, "dados excluidos com sucesso!");
			System.out.println( "dados excluidos com sucesso!");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "erro ao excluir dados \nERRO: " + e);
		}finally {
				try {
					if(p != null);
					p.close();
				}catch (Exception e){
					e.printStackTrace();
				}
		}
		return false;
	}//fim delete
	
}//fim class crud


