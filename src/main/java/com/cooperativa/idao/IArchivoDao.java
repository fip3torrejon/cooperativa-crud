/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperativa.idao;

import com.cooperativa.model.*;
import java.util.List;

/**
 *
 * @author Felipe Torrejon (ftorrejon@cooperativa.cl)
 */
public interface IArchivoDao {
  public boolean crearArchivo(Archivo archivo);
  public boolean crearPrograma(String idArchivo, Programa programa);
  public boolean crearAudio(String idArchivo, String idPrograma, Audio audio);
  public List<Archivo> obtenerTodos();
  public List<Archivo> buscar(String cadenaBusqueda);
  public boolean modificarArchivo(Archivo archivo);
  public boolean modificarPrograma(String idArchivo, Programa programa);
  public boolean modificarAudio(String idArchivo, String idPrograma, Audio audio);
  public boolean eliminarArchivo(String archivo);
  public boolean eliminarPrograma(String idArchivo, String programa);
  public boolean eliminarAudio(String idArchivo, String idPrograma, String idAudio);
}
