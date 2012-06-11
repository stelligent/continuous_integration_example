package hsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//import org.discoblog.words.ddlutil.DDLReader;
import junit.framework.TestCase;

public class WordsDatabaseSetupTest extends TestCase {
	/**
	 * 
	 */
	protected void setUp() throws Exception {		
        Class.forName("org.hsqldb.jdbcDriver");
	}	
	/**
	 * @throws Exception
	 */
	public void testDatabaseInit() throws Exception{	
		Connection conn = null;
		Statement stmt = null;
		try{
			conn = this.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(this.getDDLText());				
		}finally{
			try{
				stmt.close();				
				conn.commit();				
				conn.close();								
			}catch(Exception e){}
		}
	}
	
	private String getDDLText() throws Exception{
		String path = "./database/hsql-tables.sql";
		String ddl = null;//DDLReader.getDDL(path);
		assertNotNull("ddl was null", ddl);
		return ddl;
	}
	/**
	 * @return Connection
	 * @throws Exception
	 */
	private Connection getConnection() throws Exception{
		Connection conn = 
			DriverManager.getConnection("jdbc:hsqldb:hsql://127.0.0.1", "sa", "");
		assertNotNull("conn was null- is the database running?", conn );
		return conn;
	}
	
	/**
	 * 	 
	 */
	public static void main(String[] args) {
        junit.textui.TestRunner.run(WordsDatabaseSetupTest.class);
    }
}
