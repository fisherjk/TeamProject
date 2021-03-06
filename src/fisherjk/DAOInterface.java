/*
 * DAOInterface - interface for various DAO implementations
 * 
 * Created by Paul J. Wagner, 2/28/2013
 */
package fisherjk;



public interface DAOInterface {
	public int connect();				// connect to data store
	public int executeUpdate(String query);	// execute a query, return error code
	public int executeQuery(String query);
	public int disconnect();			// disconnect from data store
	public ErrorLogs getErrorLogs();
}
