package br.com.springrstemplate.log;

import java.sql.SQLException;
import java.util.Collection;

import javax.swing.tree.ExpandVetoException;
import javax.xml.ws.http.HTTPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Controller REST onde expomos os métodos do nosso serviço ao mundo externo
 * </br></br>
 * Rest Controller where we expose our service's methods to the world
 * 
 * More about rest CRUD see this: 
 * http://www.springboottutorial.com/spring-boot-crud-rest-service-with-jpa-hibernate
 * */
@RestController
public class LogController {
	
	@Autowired
	private LogBusiness business;
	
	/**
	 * Exemplo de GET para recuperar todas as informações da entidade.
	 * Ex:GET http://localhost/logs
	 * </br></br>
	 * Example of a GET to get all itens of that entity from database
	 * @return {@link ResponseEntity} 
	 * @throws Exception 
	 */
	@GetMapping("/logs")
	public ResponseEntity<?> getAll() throws Exception{
		return new ResponseEntity<>(business.getAllLogs(), HttpStatus.OK);
	}
	
	/**
	 * Exemplo de GET com o ID da Entidade representada neste controller {@link LogEntity}.
	 * Observar que nesta caso usamos <b>@PathVariable</b>
	 * Ex: GET http://localhost/log/123
	 * </br></br>
	 * Example of a GET with a id of the respective Entity.
	 * Notice that we use <b>@PathVariable</b>.
	 * 
	 * @param id
	 * @return {@link ResponseEntity}
	 * @throws ExpandVetoException 
	 */
	@GetMapping("log/{id}")
	public ResponseEntity<?> getLog(@PathVariable String id) throws Exception{
		if ("teste".equals(id)) throw new HttpClientErrorException(HttpStatus.BAD_GATEWAY, "Id obrigatório.");
		return new ResponseEntity<>(business.getLogs(new LogEntity(id)), HttpStatus.OK);
	}
	
	/** 
	 *  Exemplo de um serviço tipo GET com parametros (ex: GET http://localhost/logs/serach?parametro=valor). Desta forma estamos passando um valor via URL e usando 
	 *  este valor para filtrar dados do banco.
	 *  Como Retorno estamos usando {@link ResponseEntity} preenchendo o conteudo do response com as informações recuperadas do banco e o 
	 *  Status HTTP correto para cada caso. 200 quando encontrado resultado e 404 quando não contrado.
	 *  Observar que neste caso usamos <b>@RequestParam</b>.
	 *  </br>
	 *  </br>	  
	 *  Example of a GET with a request param (i.e. ...<YOUR_URL>/?requetParam=blablabla). We are passing a Parameter through the URL and using it to do a 
	 *  database search. Whith {@link ResponseEntity} we return the proper HTTP status code with tha result from database, that means, 200 to OK,
	 *  null with a HTTP status 404 to NOT FOUND.
	 *  Notice the we use <b>@RequestParam</b>.
	 *  
	 *  
	 * @param request  
	 * @return {@link ResponseEntity} 
	 */
	@GetMapping("logs/search")
	public ResponseEntity<?> getLogByRequest(@RequestParam String request){
		LogEntity filter = new LogEntity();
		filter.setRequest(request);
		Collection<?> logEntities = business.getLogs(filter);
		return new ResponseEntity<>(logEntities, !logEntities.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Exemplo de um POST para salvar dados no banco e retorno os dados salvos.
	 * 	 
	 * Example of a POST to save it in database.
	 * 
	 * Ex: POST http://localhost/log
	 * body of the POST :
	 * 	 </br>{
	 * 	 </br>  "id": "mario",
	 *   </br>"userOrigem": null,
	 *   </br>"servicoUrl": null,
	 *   </br>"request": null,
	 *   </br>"response": null,
	 *   </br>"startTime": null,
	 *   </br>"endTime": null,
	 *   </br>"responseTime": null
	 *   }
	 */
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public LogEntity saveLog(@RequestBody LogEntity log) {
	 return business.save(log);
	}
	
	/**
	 * Exemplo de um PUT para Alterar dados no banco e retorno os dados salvos.
	 * 	 
	 * Example of a PUT to save it in database.
	 * 
	 * Ex: <b>PUT</b> http://localhost/log
	 * body of the PUT :
	 * 	 </br>{
	 * 	 </br>  "id": null,
	 *   </br>"userOrigem": "teste",
	 *   </br>"servicoUrl": "teste",
	 *   </br>"request": "teste",
	 *   </br>"response": "teste",
	 *   </br>"startTime": "2018-07-21T18:51:29.308",
	 *   </br>"endTime": "2018-07-21T18:51:29.308",,
	 *   </br>"responseTime": 456
	 *   }
	 */
	@PutMapping
	public ResponseEntity<?> changeLog(@RequestBody LogEntity log){
		return new ResponseEntity<>(business.save(log), HttpStatus.OK);
	} 
	/**
	 * Exemplo de deleção.
	 * </br></br>
	 * Example of a delete operation.
	 * 
	 * Ex: DETELE http://localhost:8080/logs/123
	 * @param id
	 */
	@DeleteMapping("log/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public void deleteLog(@PathVariable String id){
		business.delete(id);
	} 

}
