package org.jsp.responsestructure;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ResponseStructure{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int status;
	private String message;
	private Object body;

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	public ResponseStructure(int status, String message, Object body) {
		super();
		this.status = status;
		this.message = message;
		this.body = body;
	}
	public ResponseStructure() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResponseStructure [status=" + status + ", message=" + message + ", body=" + body + "]";
	}
	
	
}
