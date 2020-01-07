package com.ragnax.ssoorquestador.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ragnax.ssoorquestador.controller.response.RagnaxError;
import com.ragnax.ssoorquestador.exception.SSOOrquestadorException;
import com.ragnax.ssoorquestador.modelo.*;
import com.ragnax.ssoorquestador.servicio.*;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@RestController
@RequestMapping
public class SSOOrquestadorController {

	@Autowired
	SSOOrquestadorService ssoOrquestadorService;
	
//	String[] usuarioPassword = SimpleDecodificacion.desencriptarUsuarioPassword(request.getHeader("authorization"));
	/***************************************************/
	/*************** TipoMoneda *** *******************/
	/***************************************************/
	@ApiOperation(value = "obtenerBasicContext", response = BasicContext.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = BasicContext.class)
	})
	@PostMapping(value = "${servicio.app.url.obtenerBasicContext}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BasicContext>  iniciarSessionClienteAsistencia(HttpServletRequest request,  
	@ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid ConsultaSeguridad consultaSeguridad, @ApiIgnore Errors errors) 
			throws SSOOrquestadorException, Exception{

		return new ResponseEntity<>(ssoOrquestadorService.obtenerBasicContext(
				"", "", consultaSeguridad).getBasicContext(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "obtenerEnterpriseContext", response = EnterpriseContext.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = EnterpriseContext.class)
	})
	@PostMapping(value = "${servicio.app.url.obtenerEnterpriseContext}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EnterpriseContext>  obtenerEnterpriseContext(HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true) 
		@ApiIgnore Errors errors) throws SSOOrquestadorException, Exception{

		return new ResponseEntity<>(ssoOrquestadorService.obtenerEnterpriseContext(
				"", "").getEnterpriseContext(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "obtenerAutentificacionContext", response = AutentificacionContext.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = AutentificacionContext.class)
	})
	@PostMapping(value = "${servicio.app.url.obtenerAutentificacionContext}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AutentificacionContext>  obtenerAutentificacionContext(HttpServletRequest request,  
			@ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid ConsultaSeguridad consultaSeguridad, @ApiIgnore Errors errors) 
			throws SSOOrquestadorException, Exception{
		
		return new ResponseEntity<>(ssoOrquestadorService.obtenerAutentificacionContext(
				"", "", consultaSeguridad).getAutentificacionContext(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "obtenerLoginUsuario", response = BasicContext.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = BasicContext.class)
	})
	@PostMapping(value = "${servicio.app.url.obtenerLoginUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BasicContext>  obtenerLoginUsuario(HttpServletRequest request, 
			@ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid ConsultaSeguridad consultaSeguridad, @ApiIgnore Errors errors)
			throws SSOOrquestadorException, Exception{
		
		return new ResponseEntity<>(ssoOrquestadorService.obtenerLoginUsuario(
				"", "", consultaSeguridad).getBasicContext(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "obtenerSeguridadContext", response = SeguridadContext.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = SeguridadContext.class)
	})
	@PostMapping(value = "${servicio.app.url.obtenerSeguridadContext}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SeguridadContext>  obtenerSeguridadContext(HttpServletRequest request,  
			@ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid ConsultaSeguridad consultaSeguridad,
			@ApiIgnore Errors errors) throws SSOOrquestadorException, Exception {
		
		return new ResponseEntity<>(ssoOrquestadorService.obtenerSeguridadContext(
				consultaSeguridad.getNombreAplicacion(),
				consultaSeguridad.getNombreAplicacionProducto(),
				consultaSeguridad.getNombreAplicacionProductoServicio() ,
				consultaSeguridad.getMetodoHttp(), 
				"").getSeguridadContext(), HttpStatus.OK);
	}
	
}
