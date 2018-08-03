package br.com.springrstemplate.log;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Entidade de banco 
 *</br></br>
 * Database entity
 */
@Entity
@Table(name="NCL_WS_SOAP_LOG")
public class LogEntity{
	
	@Id
	@Column(name="UUID")
	private String id;
//	@Column(name="")
//	private String user;
	@Column(name="USUARIO_ORIGEM")
	private String userOrigem;
	@Column(name="SERVICO_URL")
	private String servicoUrl;
	@Column(name="REQUEST")
	private String request;
	@Column(name="RESPONSE")
	private String response;
	@Column(name="TIMESTAMP_INICIO")
	private Date startTime;
	@Column(name="TIMESTAMP_FIM")
	private Date endTime;
	@Column(name="TEMPO_RESPOSTA")
	private Long responseTime;
	
	public LogEntity() {}
	
	public LogEntity(String id) {
		this.id = id;
	}
	public LogEntity(String id, String request) {
		this.id = id;
		this.request = request;
	}
	
	

	public LogEntity(String id, String userOrigem, String servicoUrl, String request, String response,
			Date startTime, Date endTime, Long responseTime) {
		super();
		this.id = id;
		this.userOrigem = userOrigem;
		this.servicoUrl = servicoUrl;
		this.request = request;
		this.response = response;
		this.startTime = startTime;
		this.endTime = endTime;
		this.responseTime = responseTime;
	}



	public String getServicoUrl() {
		return servicoUrl;
	}
	public void setServicoUrl(String servicoUrl) {
		this.servicoUrl = servicoUrl;
	}
	
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Long getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(Long responseTime) {
		this.responseTime = responseTime;
	}
//	public String getUser() {
//		return user;
//	}
//	public void setUser(String user) {
//		this.user = user;
//	}
	public String getUserOrigem() {
		return userOrigem;
	}
	public void setUserOrigem(String userOrigem) {
		this.userOrigem = userOrigem;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
