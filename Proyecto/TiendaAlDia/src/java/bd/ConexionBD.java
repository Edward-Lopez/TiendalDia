
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexionBD {
    private String BD_driver;
    private String url;
    private String db;
    private String host;
    private String username;
    private String password;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    
    public ConexionBD(){
        BD_driver = "com.mysql.jdbc.Driver";
        host = "localhost:3306";
        db = "tiendaaldia";
        url = "jdbc:mysql://" + host + "/" +db;
        username = "root";
        password = "1234";
        
        try{
            Class.forName(BD_driver);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            con = DriverManager.getConnection(url,username,password);
            con.setTransactionIsolation(8);
        }catch(SQLException ex){
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public Connection getConection (){
        try {
            con.setAutoCommit(true);
            return con;
        }catch(SQLException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);  
          return null;
        }
    }
    
    public void closeConection (Connection con){
        try {
            con.close();
        }catch(SQLException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    
    public boolean commitDB(){
        try {
            con.commit();
            return true;
        }catch(SQLException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return false;
        }   
    }
    
    public boolean rollbackDB(){
        try {
            con.rollback();
            return true;
        }catch(SQLException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return false;
        }   
    }
    //nombreTabla = usuarios
    //columnas = [idUsuarios, nombres, apellidos]
    //valores = [1, camila,pimentel]
    public int insertar(String nombreTabla,String[] columnas, String[] valores ){
        StringBuilder query = new StringBuilder ("INSERT INTO ");
        query.append(nombreTabla);
        query.append("(");
        
        for (int i = 0; i < columnas.length; i++){
            query.append(columnas[i]);
            if((i+1) < columnas.length)
                query.append(",");
        }
        query.append(") VALUES (");
         for (int i = 0; i < valores.length; i++){
            query.append("'"); 
            query.append(valores[i]);
            query.append("'");
            if((i+1) < valores.length)
                query.append(",");
        }
        query.append(")"); 
        try {
            stmt = con.createStatement();
            int colsAfectadas = stmt.executeUpdate(query.toString(), Statement.RETURN_GENERATED_KEYS);
            if(colsAfectadas == 0){
                throw new SQLException("No se pudo guardar el registro");           
            }
            ResultSet idsGenerados = stmt.getGeneratedKeys();
            if(idsGenerados.next()){
                return idsGenerados.getInt(1);
            }else{
                return 0;
            }
        }catch(SQLException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return 0;
        }catch(RuntimeException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return 0;
        }catch(Exception ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return 0;
        } 
    }
        
    
    
    public boolean actualizar(String nombreTabla, String[] columnas, String[] valores, int id, String campoId) {
        StringBuilder query = new StringBuilder("UPDATE ");
        query.append(nombreTabla);
        query.append(" SET ");
        for (int i = 0; i < columnas.length; i++) {
            query.append(columnas[i]);
            query.append(" = '");
            query.append(valores[i]);
            query.append("'");
            if ((i + 1) < columnas.length) {
                query.append(",");
            }
        }
        query.append(" WHERE ");
        query.append(campoId);
        query.append(" = ");
        query.append(id);
        try {
            stmt = con.createStatement();
            return stmt.execute(query.toString());
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public ResultSet consultar(String nombreTabla) {
        String query = "SELECT * FROM " + nombreTabla;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (RuntimeException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (Exception ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public ResultSet consultarWhere(String nombreTabla, String condiciones){
        String query = "SELECT * FROM " + nombreTabla + " WHERE " + condiciones;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }catch(RuntimeException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return null;
        }catch(Exception ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return null;
        } 
    }
    
    public ResultSet consultarvista(String nombreVista){
        String query = "SELECT * FROM " + nombreVista;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }catch(RuntimeException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return null;
        }catch(Exception ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return null;
        } 
    }
    
    public boolean eliminar (String nombreTabla, int id, String campoId){
        String query = "DELETE FROM " + nombreTabla + " WHERE "+ campoId +  " = " + id;
        try {
            stmt = con.createStatement();
            return stmt.execute(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }catch(RuntimeException ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return false;
        }catch(Exception ex){
          Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
          return false;
        } 
    }
}
    

