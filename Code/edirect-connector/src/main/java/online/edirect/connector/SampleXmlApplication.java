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
package online.edirect.connector;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import online.edirect.connector.dao.ObjectDao;
import online.edirect.connector.mapper.HotelMapper;

//@SpringBootApplication
public class SampleXmlApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SampleXmlApplication.class, args);
	}

	private final ObjectDao cityDao;
	private final HotelMapper hotelMapper;

	public SampleXmlApplication(ObjectDao cityDao, HotelMapper hotelMapper) {
		this.cityDao = cityDao;
		this.hotelMapper = hotelMapper;
	}

	@Override
	public void run(String... args) throws Exception {
		// System.out.println(this.cityDao.selectCityById(1));
		// System.out.println(this.hotelMapper.selectByCityId(1));
		}

}
