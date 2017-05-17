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

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import online.edirect.connector.dao.CityDao;
import online.edirect.connector.domain.Hotel;
import online.edirect.connector.mapper.HotelMapper;

@SpringBootApplication
public class SampleXmlApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SampleXmlApplication.class, args);
	}

	private final CityDao cityDao;

	private final HotelMapper hotelMapper;

	public SampleXmlApplication(CityDao cityDao, HotelMapper hotelMapper) {
		this.cityDao = cityDao;
		this.hotelMapper = hotelMapper;
	}

	@Override
	public void run(String... args) throws Exception {
		// System.out.println(this.cityDao.selectCityById(1));
		// System.out.println(this.hotelMapper.selectByCityId(1));
		List<Hotel> hotels = cityDao.getList("selectAllCities", 1);
		Hotel hotel = new Hotel();
		hotel.setCity(2L);
		hotel.setName("Stamford");
//		hotelMapper.saveHotel(hotel);
		hotels.forEach(System.out::println);
	}

}
