package DAO;

import Model.Admin;

public interface AdminDAO {
	boolean getAdmin(String login,String password) throws DAOException;
	boolean UpdateAdmin(Admin c) throws DAOException;
	Admin getInfosAdmin(String login) throws DAOException;

}
