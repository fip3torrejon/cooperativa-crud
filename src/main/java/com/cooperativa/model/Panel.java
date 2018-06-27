/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperativa.model;

import java.util.ArrayList;

/**
 *
 * @author Felipe Torrejon (ftorrejon@cooperativa.cl)
 */
public class Panel extends Audio{
  
  public ArrayList<String> panelista;
  public ArrayList<String> tema;

  public Panel() {
    super("Panel");
  }

  public ArrayList<String> getPanelista() {
    return panelista;
  }

  public ArrayList<String> getTema() {
    return tema;
  }
  
  /**
   * Método para agregar Panelista a la lista de Panelistas.
   * @param p - String que se almacenará en la lista de panelistas.
   * @return boolean - Valor que verifica que el String se insertó correctamente en la lista.
   */
  public boolean agregarPanelista(Personaje p) {
    return true;
  }
  
  /**
   * Método para agregar un tema a la lista de Temas
   * @param t - String que se va a agregar a la lista de Temas
   * @return boolean - Valor que confirma que el String se agregó satisfactoriamente  a la lista.
   */
  public boolean agregarTema(String t) {
    return true;
  }
  
  
}
