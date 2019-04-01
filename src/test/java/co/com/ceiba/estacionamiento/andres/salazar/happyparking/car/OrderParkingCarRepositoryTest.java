package co.com.ceiba.estacionamiento.andres.salazar.happyparking.car;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.estacionamiento.andres.salazar.happyparking.domain.Car;
import co.com.ceiba.estacionamiento.andres.salazar.happyparking.domain.OrderParkingCar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderParkingCarRepositoryTest {
	
	@MockBean
	private OrderParkingCarRepository repositoryParkingCar;

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindById() {
		//Arrange
		String vehiclePlateParam = "AAA321";
		Car carValue = new Car();
		carValue.setPlate(vehiclePlateParam);
		OrderParkingCar parkingOrderCar = new OrderParkingCar();
		parkingOrderCar.setOrderParkingId(vehiclePlateParam+"_"+System.currentTimeMillis());
		parkingOrderCar.setStartDate(System.currentTimeMillis());
		parkingOrderCar.setEndDate(System.currentTimeMillis());
		parkingOrderCar.setActive(true);
		parkingOrderCar.setCar(carValue);
		
		when(repositoryParkingCar.findById(vehiclePlateParam)).thenReturn(Optional.of(parkingOrderCar));
		//Act
		Optional<OrderParkingCar> orderParkinCarFound = repositoryParkingCar.findById(vehiclePlateParam);
		//Assert
		assertThat(orderParkinCarFound.get()).isInstanceOf(OrderParkingCar.class);
		assertThat(orderParkinCarFound.get()).hasFieldOrProperty("orderParkingId");
		assertThat(orderParkinCarFound.get()).hasFieldOrProperty("startDate");
		assertThat(orderParkinCarFound.get()).hasFieldOrProperty("endDate");
		assertThat(orderParkinCarFound.get()).hasFieldOrPropertyWithValue("active", true);
		assertThat(orderParkinCarFound.get()).extracting("car").extracting("plate").contains(vehiclePlateParam);
	}

}
