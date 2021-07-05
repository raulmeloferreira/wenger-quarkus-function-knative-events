package br.com.banco.wenger.sigla.function.dto;

public class ResponseDTO {

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ResponseDTO(String data, String id) {
		super();
		this.data = data;
		this.id = id;
	}
	
	public ResponseDTO() {
		super();
	}
	private String data;
	private String id;
}
