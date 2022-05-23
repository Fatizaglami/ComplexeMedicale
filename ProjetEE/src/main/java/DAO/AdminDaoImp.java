package DAO;



import java.sql.*;

import Model.Admin;

public class AdminDaoImp implements AdminDAO{
private DAOFactory daoFactory;
	
	public AdminDaoImp(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	}
	
	private static Admin map( ResultSet resultSet ) throws SQLException {
		Admin admin = new Admin();
		 admin.setEmail( resultSet.getString( "email" ) );
		 admin.setNom( resultSet.getString( "nom" ) );
		 admin.setPrenom( resultSet.getString( "prenom" ) );
		 admin.setTel(resultSet.getString("tel"));
		
		return admin;
	}
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}

	@Override
	public boolean getAdmin(String login, String password) throws DAOException {
		final String SQL_SELECT_ADMIN = "SELECT * FROM admin WHERE email = ? AND password = ?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Admin admin = new Admin();

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_ADMIN,login,password);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if(resultSet.next())
	        	admin = map(resultSet);
	        else 
	        	admin = null;
	        
	        if(admin == null) {
	        	return false;
	        }else {
	        	return true;
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } 
	}

	@Override
	public boolean UpdateAdmin(Admin c) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin getInfosAdmin(String login) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
