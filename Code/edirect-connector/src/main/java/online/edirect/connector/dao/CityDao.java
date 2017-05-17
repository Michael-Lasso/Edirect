/**
 *    Copyright 2015-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package online.edirect.connector.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import online.edirect.connector.domain.Category;
import online.edirect.connector.domain.City;

/**
 * @author Eddú Meléndez
 */
@Component
public class CityDao {
	public static final Logger log = Logger.getLogger(CityDao.class);

	private final SqlSession sqlSession;

	public CityDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public City selectCityById(long id) {
		return this.sqlSession.selectOne("selectCityById", id);
	}

	public Category findCategoryById(long id) {
		return this.sqlSession.selectOne("selectCityById", id);
	}

	/**
	 * Insert query with queryID in Datasource.xml. Pass null as the second
	 * argument if no parameters are needed for the query
	 * 
	 * @param queryID
	 * @param criteria
	 * @throws Exception
	 */
	public void insertQuery(String queryID, Object criteria) throws Exception {
		log.info("-----------------------------------------------");
		log.info("Insert query: " + queryID);
		log.info("Rows affected: " + this.sqlSession.insert(queryID, criteria));
		log.info("Successful query");
		log.info("-----------------------------------------------\n");
	}

	/**
	 * Insert query with queryID in Datasource.xml. Pass null as the second
	 * argument if no parameters are needed for the query
	 * 
	 * @param queryID
	 * @param criteria
	 * @throws Exception
	 */
	public void updateQuery(String queryID, Object criteria) throws Exception {
		log.info("-----------------------------------------------");
		log.info("Update query: " + queryID);
		log.info("Rows affected: " + this.sqlSession.update(queryID, criteria));
		log.info("Successful query");
		log.info("-----------------------------------------------\n");
	}

	/**
	 * Executes query with queryId in Datasource.xml
	 * 
	 * @param queryId
	 * @param criteria
	 * @return
	 */
	public <T> List<T> getList(String queryId, Object criteria) throws Exception {
		log.info("-----------------------------------------------");
		log.info("List query: " + queryId);
		List<T> list = this.sqlSession.selectList(queryId, criteria);
		log.info("Rows affected: " + list.size());
		log.info("-----------------------------------------------\n");
		return list;
	}

	public void dropTempTable(String queryId, Object criteria) throws Exception {
		this.sqlSession.delete(queryId, criteria);
	}

}
