package DAO;

import Model.Patient;

public interface PatientDAO {
	boolean getPatient(String login,String password) throws DAOException;
	boolean UpdatePatient(Patient c) throws DAOException;
	boolean AddClient(Patient c) throws DAOException;
	Patient getInfosPatient(String login) throws DAOException;

}
