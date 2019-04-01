package co.com.ceiba.estacionamiento.andres.salazar.happyparking.domain;

import org.springframework.http.HttpStatus;

public class HappyParkingResponse {
	
	private HttpStatus httpStatus;
	private Object content;
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	public Object getContent() {
		return content;
	}
	
	public void setContent(Object content) {
		this.content = content;
	}

	

}
