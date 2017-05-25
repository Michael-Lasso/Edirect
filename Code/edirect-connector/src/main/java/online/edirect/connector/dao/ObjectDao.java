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
import online.edirect.connector.service.EdirectRecord;

/**
 * @author Michael Lasso
 */
@Component
public class ObjectDao {
	public static final Logger log = Logger.getLogger(ObjectDao.class);

	private final SqlSession sqlSession;

	public ObjectDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	/**
	 * Insert query with queryID in Datasource.xml. Pass null as the second
	 * argument if no parameters are needed for the query
	 * 
	 * @param QueryId
	 * @param criteria
	 * @throws Exception
	 */
	public void insertQuery(String QueryId, Object criteria) throws Exception {
		log.info("-----------------------------------------------");
		log.info("Insert query: " + QueryId);
		log.info("Rows affected: " + this.sqlSession.insert(QueryId, criteria));
		log.info("Successful query");
		log.info("-----------------------------------------------\n");
	}

	/**
	 * Insert query with queryID in Datasource.xml. Pass null as the second
	 * argument if no parameters are needed for the query
	 * 
	 * @param QueryId
	 * @param criteria
	 * @throws Exception
	 */
	public void updateQuery(String QueryId, Object criteria) throws Exception {
		log.info("-----------------------------------------------");
		log.info("Update query: " + QueryId);
		log.info("Rows affected: " + this.sqlSession.update(QueryId, criteria));
		log.info("Successful query");
		log.info("-----------------------------------------------\n");
	}

	/**
	 * Executes query with queryId in Datasource.xml
	 * 
	 * @param QueryId
	 * @param criteria
	 * @return
	 */
	public <T> List<T> getList(String QueryId, Object criteria) throws Exception {
		log.info("-----------------------------------------------");
		log.info("List query: " + QueryId);
		List<T> list = this.sqlSession.selectList(QueryId, criteria);
		log.info("Rows affected: " + list.size());
		log.info("-----------------------------------------------\n");
		return list;
	}

	/**
	 * Executes query with queryId in Datasource.xml
	 * 
	 * @param QueryId
	 * @param criteria
	 * @return
	 */
	public <T extends Number> T getNumber(String QueryId, Object criteria) throws Exception {
		log.info("-----------------------------------------------");
		log.info("List query: " + QueryId);
		T list = this.sqlSession.selectOne(QueryId, criteria);
		log.info("Rows affected: " + list);
		log.info("-----------------------------------------------\n");
		return list;
	}

	public <T extends EdirectRecord> T getRecord(String QueryId, Object criteria) throws Exception {
		log.info("-----------------------------------------------");
		log.info("List query: " + QueryId);
		T list = this.sqlSession.selectOne(QueryId, criteria);
		log.info("Rows affected: " + list);
		log.info("-----------------------------------------------\n");
		return list;
	}

	public <T> T getEdirectRecord(String QueryId, Object criteria) throws Exception {
		log.info("-----------------------------------------------");
		log.info("List query: " + QueryId);
		T list = this.sqlSession.selectOne(QueryId, criteria);
		log.info("Rows affected: " + list);
		log.info("-----------------------------------------------\n");
		return list;
	}

	public void dropTempTable(String QueryId, Object criteria) throws Exception {
		this.sqlSession.delete(QueryId, criteria);
	}

}
