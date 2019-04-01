package co.com.ceiba.estacionamiento.andres.salazar.happyparking.domain;

public class OrderParkingCar {

	private String orderParkingId;
	private Long startDate;
	private Long endDate;
	private boolean active;
	private Car car;

	public Long getStartDate() {
		return startDate;
	}

	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}

	public Long getEndDate() {
		return endDate;
	}

	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getOrderParkingId() {
		return orderParkingId;
	}

	public void setOrderParkingId(String orderParkingId) {
		this.orderParkingId = orderParkingId;
	}

}
