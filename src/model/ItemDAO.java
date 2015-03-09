package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import databeans.FavoriteBean;

public class ItemDAO extends GenericDAO<FavoriteBean> {
	public ItemDAO( String tableName, ConnectionPool cp) throws DAOException {
		super(FavoriteBean.class, tableName, cp);
	}
	
	public void add(FavoriteBean item) throws RollbackException {
		try {
			Transaction.begin();
			

			// Create a new ItemBean in the database with the next id number
			createAutoIncrement(item);

			Transaction.commit();
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}
	
	
	
	public FavoriteBean[] getItems(int userID) throws RollbackException {
		
		// Calls GenericDAO's match() method.
		// This no match constraint arguments, match returns all the Item beans 
		FavoriteBean[] items = match(MatchArg.equals("userID", userID));
        


        
        return items;
	}
	
	public void addclick(int favoriteID) throws RollbackException{
		FavoriteBean bean = read(favoriteID);
		int originalclick = bean.getClickCount();
		bean.setClickCount(originalclick+1);
		update(bean);
	}

}
