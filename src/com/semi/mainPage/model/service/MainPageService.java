package com.semi.mainPage.model.service;

import static com.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.semi.mainPage.model.dao.MainPageDao;
import com.semi.mainPage.model.vo.Category;

public class MainPageService {

	/** 카테고리 조회용 service
	 * @return showCategory
	 * @throws Exception
	 */
	public List<String> selectCategory() throws Exception{
		
		Connection conn = getConnection();
		
		List<String> showCategory = new MainPageDao().selectCategory(conn);
		
		close(conn);
		
		return showCategory;
	}

}
