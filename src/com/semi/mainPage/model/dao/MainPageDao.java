package com.semi.mainPage.model.dao;

import static com.semi.common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

	
public class MainPageDao {

	private Properties prop = null;
	
	 public MainPageDao() throws Exception{
		 
	      String fileName = MainPageDao.class.getResource("/com/semi/sql/mainPage/mainPage-query.properties").getPath();
	      
	      prop = new Properties();
	      
	      prop.load(new FileReader(fileName));
	}
	
	
	/** 카테고리 조회용 Dao
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<String> selectCategory(Connection conn) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<String> cList = new ArrayList<String>();
		
		String query = prop.getProperty("selectCategory");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, 1);
			pstmt.setInt(2, 16);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				String arrStr = (rset.getString("CATEGORY_NM"));
				
				cList.add(arrStr); 
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
				
		return cList;
	}

}
