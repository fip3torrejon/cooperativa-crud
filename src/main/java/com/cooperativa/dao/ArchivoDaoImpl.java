/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperativa.dao;

import com.connection.Conexion;
import com.cooperativa.model.*;
import com.mongodb.MongoException;
import com.mongodb.MongoClient;
import java.util.List;
import com.cooperativa.idao.IArchivoDao;
import org.bson.Document;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.FindOptions;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;


/**
 *
 * @author Felipe Torrejon (ftorrejon@cooperativa.cl)
 */
public class ArchivoDaoImpl implements IArchivoDao {

  @Override
  public boolean crearArchivo(Archivo archivo) {
    boolean registrado = false;
    
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      final Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      datastore.ensureIndexes(true);
      
      if(datastore.createQuery(Archivo.class).filter("_id", archivo.getId()).count() > 0) {
        throw new MongoException("ID ya existe");
      }
      datastore.save(archivo);
      registrado = true;
    
    } catch (MongoException e) {
      System.out.println("ERROR: Clase ArchivoDaoImpl, método crearArchivo");
      e.printStackTrace();
    }
    
    cliente.close();
    
    return registrado;
    
  }
  
  @Override
  public boolean insertarPrograma(String idArchivo, Programa programa) {
    boolean registrado = false;
    
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      final Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      datastore.ensureIndexes(true);
      
      Query<Archivo> updateQuery = datastore.createQuery(Archivo.class)
              .filter("_id ==", idArchivo);
            
      UpdateOperations updateOperations = datastore.createUpdateOperations(Archivo.class)
              .push("programas", programa);
      
      registrado = datastore.updateFirst(updateQuery, updateOperations).getUpdatedExisting();
      
    } catch (MongoException e) {
      System.out.println("ERROR: Clase ArchivoDaoImpl, método insertarPrograma");
      e.printStackTrace();
      return registrado;
    }
    
    cliente.close();
    
    return registrado;
  }
  
  @Override
  public boolean insertarAudio(String idArchivo, String idPrograma, Audio audio) {
    boolean registrado = false;
    
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      final Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      datastore.ensureIndexes(true);
      
      Query<Archivo> updateQuery = datastore.createQuery(Archivo.class)
              .filter("_id ==", idArchivo)
              .filter("programas.idPrograma ==", idPrograma);
      
      UpdateOperations updateOperations = datastore.createUpdateOperations(Archivo.class)
              .push("programas.$.fragmentos", audio);
      
      registrado = datastore.updateFirst(updateQuery, updateOperations).getUpdatedExisting();
      
    } catch (MongoException e) {
      System.out.println("ERROR: Clase ArchivoDaoImpl, método insertarAudio");
      e.printStackTrace();
      return registrado;
    }
    
    cliente.close();
    
    return registrado;
  }

  @Override
  public List<Archivo> obtenerTodos() {
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    List<Archivo> resultado = null;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      final Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      
      final Query<Archivo> consulta = datastore.createQuery(Archivo.class);
      resultado = consulta.asList();
      
    } catch (MongoException e){
      System.out.println("ERROR: Clase ArchivoDaoImpl, método obtenerTodos");
      e.printStackTrace();
    }
    
    cliente.close();
    return resultado;
  }
  
  @Override
  public Archivo buscarPorId(String idArchivo){
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    Archivo archivo = null;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      final Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      
      archivo = datastore.createQuery(Archivo.class)
              .filter("_id ==", idArchivo)
              .get();
      
    } catch (Exception e) {
      System.out.print("ERROR: Clase ArchivoDaoImpl, método buscarPorId");
      e.printStackTrace();
    }
    
    cliente.close();
    return archivo;
  }
  
  public Archivo buscarUltimoPorUsuario(String usuario){
    Conexion conexion = new Conexion();
    MongoClient  cliente = null;
    Morphia morphia = null;
    Archivo archivo = null;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      final Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      
      Query<Archivo> consulta = datastore.createQuery(Archivo.class)
              .filter("responsableIngreso ==", usuario)
              .order("-fechaIngreso");
      FindOptions opciones = new FindOptions()
              .limit(1);
      
      archivo = consulta.get(opciones);
      
    } catch (Exception e){
      System.out.print("ERROR: Clase ArchivoDaoImpl, método buscarUltimoPorUsuario");
    }
    cliente.close();
    return archivo;
            
  }
  
  @Override
  public boolean modificarArchivo(Archivo archivo){
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    boolean archivoActualizado = false;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      final Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      
      Query<Archivo> updateQuery = datastore.createQuery(Archivo.class)
              .filter("_id ==",archivo.getId());
      
      UpdateOperations updateOperations = datastore.createUpdateOperations(Archivo.class)
              .set("responsableDigitalizacion", archivo.getResponsableDigitalizacion())
              .set("codigoSoporte", archivo.getCodigoSoporte())
              .set("tipoSoporte", archivo.getTipoSoporte())
              .set("descripcionExterior", archivo.getDescripcionExterior())
              .set("nombreArchivo", archivo.getNombreArchivo())
              .set("tamanhoArchivo", archivo.getTamanhoArchivo())
              .set("duracionArchivo", archivo.getDuracionArchivo())
              .set("fechaDigitalizacion", archivo.getFechaDigitalizacion());
      
      archivoActualizado = datastore.updateFirst(updateQuery, updateOperations).getUpdatedExisting();
      
    } catch (MongoException e){
      System.out.println("ERROR: Clase ArchivoDaoImpl, método modificarArchivo");
      e.printStackTrace();
    }
    
    cliente.close();
    return archivoActualizado;
  }
  
  public boolean modificarCampoArchivo(String idArchivo, String campo, Object objetoModificado){
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    boolean archivoActualizado = false;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      final Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      
      Query<Archivo> updateQuery = datastore.createQuery(Archivo.class)
              .filter("_id ==",idArchivo);
      
      UpdateOperations updateOperations = datastore.createUpdateOperations(Archivo.class)
              .set(campo, objetoModificado.toString());
      
      
    } catch (MongoException e) {
      System.out.println("ERROR: Clase ArchivoDaoImpl, método modificarCampoArchivo");
      
    }
    
    cliente.close();
    return archivoActualizado;
  }
  
  @Override
  public boolean modificarPrograma(String idArchivo, int indicePrograma, Programa programa){
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    boolean programaActualizado = false;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      final Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      
      Query<Archivo> updateQuery = datastore.createQuery(Archivo.class)
              .filter("_id ==", idArchivo);
      
      String programaAModificar = "programas." + indicePrograma;
      UpdateOperations updateOperations = datastore.createUpdateOperations(Archivo.class)
              .set(programaAModificar + ".idPrograma", programa.getIdPrograma())
              .set(programaAModificar + ".alturaInicio", programa.getAlturaInicio())
              .set(programaAModificar + ".nombrePrograma", programa.getNombrePrograma())
              .set(programaAModificar + ".fechaEmision", programa.getFechaEmision());
      
      programaActualizado = datastore.updateFirst(updateQuery, updateOperations).getUpdatedExisting();
      
    } catch (MongoException e){
      System.out.println("ERROR: Clase ArchivoDaoImpl, método modificarPrograma");
      e.printStackTrace();
    }
    
    cliente.close();
    
    return programaActualizado;
  }
  
  public boolean modificarCampoPrograma(String idArchivo, int indicePrograma, String campo, Object objetoModificado){
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    boolean programaActualizado = false;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      final Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      
      Query<Archivo> updateQuery = datastore.createQuery(Archivo.class)
              .filter("_id ==", idArchivo);
      
      String programaAModificar = "programas." + indicePrograma;
      UpdateOperations updateOperations = datastore.createUpdateOperations(Archivo.class)
              .set(programaAModificar + "." + campo, objetoModificado.toString());
      
      programaActualizado = datastore.updateFirst(updateQuery, updateOperations).getUpdatedExisting();
      
    } catch (MongoException e){
      System.out.println("ERROR: Clase ArchivoDaoImpl, método modificarCampoPrograma");
      e.printStackTrace();
    }
    
    cliente.close();
    return programaActualizado;
    
  }

  @Override
  public boolean modificarAudio(String idArchivo, int indicePrograma, int indiceAudio, Audio audio) {
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    boolean audioActualizado = false;
    
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      final Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      
      Query<Archivo> updateQuery = datastore.createQuery(Archivo.class)
              .filter("_id ==", idArchivo);
      
      UpdateOperations updateOperation = datastore.createUpdateOperations(Archivo.class)
              .set("programas." + indicePrograma + ".fragmentos." + indiceAudio, audio);
      
      audioActualizado = datastore.updateFirst(updateQuery, updateOperation).getUpdatedExisting();
      
    } catch (MongoException e) {
      System.out.println("ERROR: Clase ArchivoDaoImpl, método actualizar");
      e.printStackTrace();
    }
    
    cliente.close();
    return audioActualizado;
  }
  
  public boolean modificarCampoAudio(String idArchivo, int indicePrograma, int indiceAudio, String campo, Object objetoModificado){
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    boolean programaActualizado = false;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      final Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      
      Query<Archivo> updateQuery = datastore.createQuery(Archivo.class)
              .filter("_id ==", idArchivo);
      
      UpdateOperations updateOperations = datastore.createUpdateOperations(Archivo.class)
              .set("programas." + indicePrograma + ".fragmentos." + indiceAudio + "." + campo, objetoModificado.toString());
      
      programaActualizado = datastore.updateFirst(updateQuery, updateOperations).getUpdatedExisting();
      
    } catch (MongoException e){
      System.out.println("ERROR: Clase ArchivoDaoImpl, método modificarCampoPrograma");
      e.printStackTrace();
    }
    
    cliente.close();
    return programaActualizado;
    
  }

  @Override
  public List<Archivo> buscar(String cadenaBusqueda) {
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    List<Archivo> resultado = null;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      final Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      
      final Query<Archivo> consulta = datastore.createQuery(Archivo.class);
      
      resultado = consulta
              .search(cadenaBusqueda)
              .asList();
      
    } catch (MongoException e){
      System.out.println("ERROR: Clase ArchivoDaoImpl, método buscar");
      e.printStackTrace();
    }
    
    return resultado;
  }
  
  @Override
  public boolean eliminarArchivo(String idArchivo) {
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    boolean audioEliminado = false;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      
      final Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      
      final Query<Archivo> deleteQuery = datastore.createQuery(Archivo.class);
      
      audioEliminado = datastore.delete(deleteQuery).isUpdateOfExisting();
      
    } catch (MongoException e){
      System.out.println("ERROR: Clase ArchivoDaoImpl, método eliminarArchivo");
      e.printStackTrace();
    }
    
    cliente.close();
    return audioEliminado;
  } 
  
  @Override
  public boolean eliminarPrograma(String idArchivo, String idPrograma) {
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    boolean programaEliminado = false;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      
      Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      
      Query<Archivo> updateQuery = datastore.createQuery(Archivo.class)
              .filter("_id ==", idArchivo);
      
      UpdateOperations updateOperations = datastore.createUpdateOperations(Archivo.class)
              .removeAll("programas", new Document("programa", idPrograma));
      
      programaEliminado = datastore.updateFirst(updateQuery, updateOperations).getUpdatedExisting();
      
    } catch (MongoException e) {
      System.out.println("ERROR: Clase ArchivoDaoImpl, método eliminarPrograma");
      e.printStackTrace();
    }
    
    cliente.close();
    return programaEliminado;
  }
  
  @Override
  public boolean eliminarAudio(String idArchivo, int indicePrograma, String idAudio) {
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    boolean audioEliminado = false;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      
      Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      
      Query<Archivo> updateQuery = datastore.createQuery(Archivo.class)
              .filter("_id ==", idArchivo);
      
      UpdateOperations updateOperations = datastore.createUpdateOperations(Archivo.class)
              .removeAll("programas." + indicePrograma + ".fragmentos", new Document("idAudio",idAudio));
      
      audioEliminado = datastore.updateFirst(updateQuery, updateOperations).getUpdatedExisting();
      
    } catch (MongoException e) {
      System.out.println("ERROR: Clase ArchivoDaoImpl, método eliminarAudio");
      e.printStackTrace();
    }
    
    cliente.close();
    return audioEliminado;
  } 
  
  @Override
  public boolean agregarCambio(String idArchivo, Cambio cambio){
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    boolean cambioAgregado = false;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      
      Query<Archivo> updateQuery = datastore.createQuery(Archivo.class)
              .filter("_id ==", idArchivo);
      
      UpdateOperations updateOperations = datastore.createUpdateOperations(Archivo.class)
              .push("historialCambios", cambio);
      
      cambioAgregado = datastore.updateFirst(updateQuery, updateOperations).getUpdatedExisting();
      
    } catch (MongoException e) {
      System.out.println("ERROR: Clase ArchivoDaoImpl, método agregarCambio");
      e.printStackTrace();
    }
    
    cliente.close();
    return cambioAgregado;
  }
  
  @Override
  public boolean modificarCambio(String idArchivo, int indiceCambio, Cambio cambio) {
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    boolean cambioModificado = false;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      
      Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      
      Query<Archivo> updateQuery = datastore.createQuery(Archivo.class)
              .filter("_id ==", idArchivo);
      UpdateOperations updateOperations = datastore.createUpdateOperations(Archivo.class)
              .set("historialCambios." + indiceCambio, cambio);
      
      cambioModificado = datastore.updateFirst(updateQuery, updateOperations).getUpdatedExisting();
      
    } catch (MongoException e) {
      System.out.println("ERROR: Clase ArchivoDaoImpl, método modificarCambio");
      e.printStackTrace();
    }
    
    cliente.close();
    
    return cambioModificado;
    
  }
  
  @Override
  public List<Cambio> listarCambios(String idArchivo) {
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    List<Cambio> resultado = null;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      
      Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      
      Query<Archivo> consulta = datastore.createQuery(Archivo.class)
              .filter("_id ==", idArchivo);
      FindOptions opciones = new FindOptions()
              .limit(1);
      resultado = consulta.get(opciones).getHistorialCambios();
      
    } catch (Exception e) {
      System.out.println("ERROR: Clase ArchivoDaoImpl, método listarCambios");
      e.printStackTrace();
    }
    
    cliente.close();
    return resultado;
    
  }
  
  @Override
  public boolean eliminarCambio(String idArchivo, String idCambio) {
    Conexion conexion = new Conexion();
    MongoClient cliente = null;
    Morphia morphia = null;
    boolean cambioEliminado = false;
    
    try {
      cliente = conexion.conectar();
      morphia = new Morphia();
      morphia.mapPackage("com.cooperativa.model");
      
      Datastore datastore = morphia.createDatastore(cliente, "cooperativa");
      
      Query<Archivo> consulta = datastore.createQuery(Archivo.class)
              .filter("_id ==", idArchivo);
      
      UpdateOperations updateOperations = datastore.createUpdateOperations(Archivo.class)
              .removeAll("historialCambios", new Document("idCambio", idCambio));
      
      cambioEliminado = datastore.updateFirst(consulta, updateOperations).getUpdatedExisting();
      
    } catch (MongoException e) {
      System.out.println("ERROR: Clase ArchivoDaoImpl, método eliminarCambio");
      e.printStackTrace();
    }
    
    cliente.close();
    return cambioEliminado;
  }
}
