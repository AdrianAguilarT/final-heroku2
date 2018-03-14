/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.finalheroku;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ControladorMensajes {
    
    @Autowired RepositorioMensajito repoMensa;
    
    //Buscar Todos
    @CrossOrigin
   @RequestMapping(value="/mensajito",method=RequestMethod.GET,
           headers={"Accept=application/json"})
   public ArrayList<Mensajito> hola(){
    
       return (ArrayList<Mensajito>) repoMensa.findAll();
   }
   
   
   //Buscar por ID
    @CrossOrigin
   @RequestMapping(value="/mensajito",method=RequestMethod.GET,
           headers={"Accept=application/json"})
   public Mensajito hola(@PathVariable String id){
    
       return repoMensa.findOne(id);
   }
   
   //Actualizar
   @CrossOrigin
   @RequestMapping(value="/mensajito/{id}/{titulo}/{cuerpo}", method=RequestMethod.PUT,
           headers ={"Accept=application/json"})
   public Estatus actualizar(@PathVariable String id,@PathVariable String titulo, @PathVariable String cuerpo){
          repoMensa.save(new Mensajito(id,titulo, cuerpo));
          return new Estatus(true, "Actualizado con Ã©xito");
       
   }
   
   
   //Guardar
   /*
   @CrossOrigin
   @RequestMapping(value="/mensajito/{titulo}/{cuerpo}", method=RequestMethod.POST,
           headers ={"Accept=application/json"})
   public Estatus guardar(@PathVariable String titulo, @PathVariable String cuerpo){
          repoMensa.save(new Mensajito(titulo, cuerpo));
          return new Estatus(true, "Guardado con Ã©xito");
       
   }*/
   
   //Guardar con JSON
   @CrossOrigin
   @RequestMapping(value="/mensajito", method=RequestMethod.POST,
           headers ={"Accept=application/json"})
   public Estatus guardarJSON(@RequestBody String json)throws Exception{
       ObjectMapper maper=new ObjectMapper();
       Mensajito mensa=maper.readValue(json, Mensajito.class);
          repoMensa.save(mensa);
          return new Estatus(true, "Guardado con Éxito");
       
   }
   
   //Borrar
   @CrossOrigin
   @RequestMapping(value="/mensajito/{id}", method = RequestMethod.DELETE,
           headers = {"Accept=application/json"})
           public Estatus borrarMensaje(@PathVariable String id){
               
               Estatus estatus=new Estatus(true, "Borrado con exito");
               repoMensa.delete(new Mensajito(id));
               
               return estatus;
           }
    
}






