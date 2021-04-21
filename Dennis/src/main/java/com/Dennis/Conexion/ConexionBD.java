package com.Dennis.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
	
	    private Connection con;
	    
	    public ConexionBD()
	    {
	    	
	    try{
	    	Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost/appbanco","root","root");
	        System.out.println("CONECTADO A LA BASE DE DATOS ");
	        
	    }catch (Exception e)
	    {
	        System.out.println("ERROR DE CONEXION "+ e);
	    }
	    }
	    public Connection RetornarConexion(){   
	        return con;   
	    }
	}