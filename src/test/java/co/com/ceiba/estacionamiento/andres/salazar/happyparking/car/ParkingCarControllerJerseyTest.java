package co.com.ceiba.estacionamiento.andres.salazar.happyparking.car;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.estacionamiento.andres.salazar.happyparking.domain.Car;
import co.com.ceiba.estacionamiento.andres.salazar.happyparking.domain.HappyParkingResponse;
import co.com.ceiba.estacionamiento.andres.salazar.happyparking.domain.OrderParkingCar;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ParkingCarControllerJerseyTest {
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@MockBean
	private OrderParkingCarRepository orderParkingCarRepository;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIn() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetInThrowsBusinessException() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetInThrowsSystemException() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetInVehicleThatWasAlreadyIn() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetInCarNoSpaceAvalible() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindVehicles() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFindVehiclesThrowsSystemException() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOut() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetOutThrowsSystemException() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetOutVehicleThatWasNotInThere() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFindVehicle() {
		String vehiclePlateParam = "AAA321";
		
		Car carValue = new Car();
		carValue.setPlate(vehiclePlateParam);
		
		OrderParkingCar parkingOrderCar = new OrderParkingCar();
		parkingOrderCar.setOrderParkingId(vehiclePlateParam+"_"+System.currentTimeMillis());
		parkingOrderCar.setStartDate(System.currentTimeMillis());
		parkingOrderCar.setEndDate(System.currentTimeMillis());
		parkingOrderCar.setActive(true);
		parkingOrderCar.setCar(carValue);
		
		when(orderParkingCarRepository.findById(vehiclePlateParam)).thenReturn(Optional.of(parkingOrderCar));
		
		ResponseEntity<HappyParkingResponse> entity = this.restTemplate.
				getForEntity("/parkinglot/cars/AAA321", HappyParkingResponse.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isInstanceOf(HappyParkingResponse.class);
        assertThat(((HappyParkingResponse) entity.getBody()).getHttpStatus()).isEqualTo(HttpStatus.OK);
        assertThat(((HappyParkingResponse) entity.getBody()).getContent()).extracting("car").extracting("plate").contains(vehiclePlateParam);
	}
	
	@Test
	public void testFindVehicleNotFound() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFindVehicleThrowsSystemException() {
		fail("Not yet implemented");
	}
	
}
