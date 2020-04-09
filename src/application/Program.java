package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;//conectar o banco
        Statement st = null;//prepara uma consulta SQL para buscar todos os departamentos do banco de dados
        ResultSet rs = null;//guarda o resultado da consulta na variavel rs
        
        try {
        	conn = DB.getConnection();
        	st = conn.createStatement();
        	rs = st.executeQuery("select * from department");
        	
        	while(rs.next()) {
        		System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
        	}
        }
        catch(SQLException e) {
        	e.printStackTrace();//14:59 aula 230
        }
        finally {
        	DB.closeResult(rs);
        	DB.closeStatement(st);
        	DB.closeConnection();
        }
	}

}
