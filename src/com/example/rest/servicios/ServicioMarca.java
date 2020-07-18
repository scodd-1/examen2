package com.example.rest.servicios;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.dao.MarcaModel;
import com.example.rest.dao.ProductoModel;
import com.example.rest.entidades.Marca;
import com.example.rest.entidades.Producto;


@Path("/servicios")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ServicioMarca {
	private static final Log log = LogFactory.getLog(ServicioMarca.class);
	
		private MarcaModel daoMarca = new MarcaModel();
		private ProductoModel daoPro = new ProductoModel();

	
	@GET
	@Path("/marca")
	public Response listarMarcaTodos() {
		log.info("listars marca rest ");
		return Response.ok(daoMarca.listarMarcaTodos()).build();
	}

	@POST
	@Path("/marca")
	public Response registraMarca(Marca obj) {
		log.info("Registra marca " + obj.getIdMarca());
		if (daoMarca.insertaMarca(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@PUT
	@Path("/marca")
	public Response atualizaMarca(Marca obj) {
		log.info("Actualiza marca " + obj.getIdMarca());
		if (daoMarca.actualizaMarca(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@DELETE
	@Path("/marca/{idMarca}")
	public Response eliminaMarca(@PathParam("idMarca") int id) {
		log.info("Elimina marca " + id);
		if (daoMarca.eliminaMarca(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	// Crud de producto

	@GET
	@Path("/producto")
	public Response listarproductoTodos() {
		log.info("listar producto rest ");
		return Response.ok(daoPro.listarproductoTodos()).build();
	}
	@POST
	@Path("/producto")
	public Response registraproducto(Producto obj) {
		log.info("Registra producto " + obj.getIdProducto());
		if (daoPro.insertaproducto(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	@PUT
	@Path("/producto")
	public Response atualizatipoproducto(Producto obj) {
		log.info("Actualiza producto " + obj.getIdProducto());
		if (daoPro.actualizaproducto(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	@DELETE
	@Path("/producto/{idproducto}")
	public Response eliminaproducto(@PathParam("idProducto") int id) {
		log.info("Elimina producto " + id);
		if (daoPro.eliminaproducto(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
}