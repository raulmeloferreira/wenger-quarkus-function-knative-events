package br.com.banco.wenger.sigla.function.dto;

public class RequestDTO {

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public RequestDTO(String data) {
		super();
		this.data = data;
	}
	
	public RequestDTO() {
		super();
	}

	private String data;
}
