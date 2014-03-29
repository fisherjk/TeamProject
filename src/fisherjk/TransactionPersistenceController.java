/*
 * StudentPersistenceController - controller class to persist a student
 * 
 * Created by Paul J. Wagner, 2/28/2013
 */
package fisherjk;


public class TransactionPersistenceController {
	// data
	//private Transaction transaction;		// student being worked with
	private DAOInterface dao;		// the Data Access Object (DAO) being used
	
	// methods
	// persistStudent - overall method to persist a single student object
	public void persistTransaction(Transaction transaction) {
		String sqlStatement;		// SQL statement to persist the student
		
			// could pass a student object in as parameter to this method
		sqlStatement = generateInsertStmt(transaction);
		dao.connect();
		dao.execute(sqlStatement);
		dao.disconnect();
	}

	// setDAO - set the controller DAO to a given DAO
	public void setDAO(String daoLine) {
		if (daoLine.equals("Mock")) {
			dao = new MockDAO();
		}
		else if (daoLine.equals("MySQL")) {
			dao = new MySQLDAO();
		}
	}
	
	// generateInsertStmt - generate an SQL insert statement for a particular transaction object
	public String generateInsertStmt(Transaction transaction) {
		// TODO: code to convert transaction object to SQL insert statement string for that transaction
		String result = null;
		String transactionDateTime = transaction.getTransactionDate();
		String transactionItemSet = transaction.getTransaction().toString();
		
		String query = "SELECT TransactionSet_ID FROM TransactionSet WHERE TranscationSet_ID =" + transaction.getTransactionSet_ID();
		int transactionTransactionSet_ID =  dao.executeResultSet(query);
		String transactionVendor = "Paul Mart";
		String insert= "INSERT INTO Transaction (TransactionDateTime, TransactionItemSetID, TransactionTransactionSetID, TransactionVendor_ID) VALUES(" + transactionDateTime +","+transactionItemSet+","+transactionTransactionSet_ID+","+transactionVendor+")";
		result = insert;
		return result;
	}
}
