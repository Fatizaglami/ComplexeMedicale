package DAO;

import Model.Patient;

public class PatientDaoImp implements PatientDAO {
	
private DAOFactory daoFactory;
	
	public PatientDaoImp(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	}

	@Override
	public boolean getPatient(String login, String password) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean UpdatePatient(Patient c) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AddClient(Patient c) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Patient getInfosPatient(String login) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
