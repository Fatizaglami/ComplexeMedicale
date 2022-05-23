package DAO;

import Model.Doctor;

public interface DoctorDAO {
	boolean getDoctor(String login,String password) throws DAOException;
	boolean UpdateDoctor(Doctor c) throws DAOException;
	boolean AddDoctor(Doctor c) throws DAOException;
	Doctor getInfosDoctor(String login) throws DAOException;

}
