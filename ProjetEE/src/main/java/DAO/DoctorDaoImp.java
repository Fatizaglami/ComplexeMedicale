package DAO;

import Model.Doctor;

public class DoctorDaoImp implements DoctorDAO{
private DAOFactory daoFactory;
	
	public DoctorDaoImp(DAOFactory daoFactory) {
		this.daoFactory=daoFactory;
	}

	@Override
	public boolean getDoctor(String login, String password) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean UpdateDoctor(Doctor c) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AddDoctor(Doctor c) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Doctor getInfosDoctor(String login) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
