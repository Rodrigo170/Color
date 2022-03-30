/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utsjr.dao;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.utsjr.modelos.Admin;
import com.utsjr.modelos.Color;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Rodrigo
 */
public class Conexion {
  MongoClient mongo;
  MongoDatabase db;
  //MongoDatabase db2;
  
    public void conectar(){
        try{
            MongoClientURI uri=new MongoClientURI("mongodb+srv://rod_tel17:ErenLevix2@cluster0.lcf5e.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
            mongo=new MongoClient(uri);
            db=mongo.getDatabase("Colors");
            
            System.out.println("Conexion realizada");
        }catch(Exception ex){
            System.out.println("Error en la conexion a mongo");
        }
    }
    
     public void desconectar(){
        try{
            mongo.close();
            System.out.println("Desconeccion realizada");
        }catch(Exception ex){
            System.out.println("Error al desconectarse de mongo");
        }
        
    }
     
     public boolean isValidData(String usuario, String pass){
            Admin admin=new Admin();
      
             conectar();
            
             boolean user_found = false;
             MongoCollection col = db.getCollection("administrador");
            
             // Get the particular record from the mongodb collection   
            /*usuario=admin.getUsuario();
            pass=admin.getPassword();*/
             
                List obj = new ArrayList();
                obj.add(new BasicDBObject("usuario", usuario));
                obj.add(new BasicDBObject("password", pass));
                
                

                // Form a where query
                BasicDBObject whereQuery = new BasicDBObject();
                whereQuery.put("$and", obj);
                System.out.println("Sql query is?= " + whereQuery.toString());

                FindIterable cursor = col.find(whereQuery);
                for(Object doc : cursor) {
                    System.out.println("Found?= " + doc);
                    user_found = true;
                }
       
             desconectar();
        
        
          return user_found;
         
     }
     
      public String isValidDataJason(String usuario, String pass){
            Admin admin=new Admin();
            String json="";
             conectar();
            
             boolean user_found = false;
             MongoCollection col = db.getCollection("administrador");
            
             // Get the particular record from the mongodb collection   
            /*usuario=admin.getUsuario();
            pass=admin.getPassword();*/
             
                List obj = new ArrayList();
                obj.add(new BasicDBObject("usuario", usuario));
                obj.add(new BasicDBObject("password", pass));
                
                

                // Form a where query
                BasicDBObject whereQuery = new BasicDBObject();
                whereQuery.put("$and", obj);
                System.out.println("Sql query is?= " + whereQuery.toString());

                FindIterable cursor = col.find(whereQuery);
                for(Object doc : cursor) {
                    System.out.println("Found?= " + doc);
                    user_found = true;
                    Gson gson=new Gson();
                    json=gson.toJson(doc);
                    System.out.println("Esto: "+json);
                }
                
              
             
             
             desconectar();
        
        
          return json;
         
     }
     
     
     
     
      public String insertarColor(Color color){
           String json="";
        try{
            conectar();
            Document document=new Document()
                    .append("color", color.getColor())
                    .append("descripcion", color.getDescripcion())
                    .append("imagen", color.getImagen());
            MongoCollection<Document> collection=db.getCollection("colores1");
            collection.insertOne(document);
            System.out.println("Documento insertado correctamente...");
            Gson gson=new Gson();
            json=gson.toJson(color);
            desconectar();
            
        }catch(Exception ex){
            System.out.println("Error al insertar el registro "+ex);
        }
        
        return json;
        
    }
      
     public List<Color> mostrarColores(){
        List<Color> lista=new ArrayList<Color>();
        try{
            conectar();
            
            FindIterable<Document> rs=db.getCollection("colores1").find();
            MongoCursor<Document> iterator=rs.iterator();
            while(iterator.hasNext()){
                Document document=iterator.next();
                Color color=new Color();
                color.setId((ObjectId) document.get("_id")+"");
                color.setColor(document.getString("color"));
                color.setDescripcion(document.getString("descripcion"));
                color.setImagen(document.getString("imagen"));
                lista.add(color);
            }
            
            desconectar();
            
        }catch(Exception e){
            System.out.println("Error al extraer "+e);  
        }
        return lista;
    }
     
    public String mostrarColoresJson(){
            String json="";
            List<Color> lista=new ArrayList<Color>();
            try{
                conectar();
                FindIterable<Document> rs=db.getCollection("colores1").find();
                MongoCursor<Document> iterator=rs.iterator();
                while(iterator.hasNext()){
                    Document document=iterator.next();
                    Color color=new Color();
                    ObjectId id;
                    color.setId((ObjectId) document.get("_id")+"");
                    color.setColor(document.getString("color"));
                    color.setDescripcion(document.getString("descripcion"));
                    color.setImagen(document.getString("imagen"));
                    
                    lista.add(color);
                     
                }
                System.out.println("Efectivo");
                
                desconectar();
                
            }catch(Exception e){
                System.out.println("Error al recuperar los colores..."+e);
            }
           Gson gson=new Gson();
           json=gson.toJson(lista);
            return json;
        }
    //CONTADORES --------------------------------------------------------------------------------------------------------------------
    public int contadorColores(){
            int n=0;
            conectar();
             MongoCollection col = db.getCollection("contador");
             
             System.out.println(col.count());
             
             n=(int) col.count();
             //System.out.println(rs);
            desconectar();
        
        return n;
    }
    
    public String contadorColoresJson(){
            String json="";
            int n=0;
            conectar();
             MongoCollection col = db.getCollection("contador");
             
             System.out.println(col.count());
             
             n=(int) col.count();
             //System.out.println(rs);
            desconectar();
            
            Gson gson=new Gson();
           json=gson.toJson(n);
        
        return json;
    }
    
    
    public int contadorAmarillo(){
         int n=0;
         
        try {
        conectar();
        MongoCollection col =db.getCollection("contador");
        List obj = new ArrayList();
        obj.add(new BasicDBObject("Nombre_Color", "amarillo"));
        
        BasicDBObject query = new BasicDBObject();
        query.put("$and", obj);
        n=(int) col.count(query);
        
         desconectar();
        } catch (Exception e) {
            System.out.println("Error al contador de amarillo: "+e);
        }
         
         return n;
    }
    
    public int contadorNaranja(){
         int n=0;
         
        try {
        conectar();
        MongoCollection col =db.getCollection("contador");
        List obj = new ArrayList();
        obj.add(new BasicDBObject("Nombre_Color", "naranja"));
        
        BasicDBObject query = new BasicDBObject();
        query.put("$and", obj);
        n=(int) col.count(query);
        
         desconectar();
        } catch (Exception e) {
            System.out.println("Error al contador de naranja: "+e);
        }
         
         return n;
    }
    
    public int contadorRojo(){
         int n=0;
         
        try {
        conectar();
        MongoCollection col =db.getCollection("contador");
        List obj = new ArrayList();
        obj.add(new BasicDBObject("Nombre_Color", "rojo"));
        
        BasicDBObject query = new BasicDBObject();
        query.put("$and", obj);
        n=(int) col.count(query);
        
         desconectar();
        } catch (Exception e) {
            System.out.println("Error al contador de rojo: "+e);
        }
         
         return n;
    }
    
    public int contadorAzul(){
         int n=0;
         
        try {
        conectar();
        MongoCollection col =db.getCollection("contador");
        List obj = new ArrayList();
        obj.add(new BasicDBObject("Nombre_Color", "azul"));
        
        BasicDBObject query = new BasicDBObject();
        query.put("$and", obj);
        n=(int) col.count(query);
        
         desconectar();
        } catch (Exception e) {
            System.out.println("Error al contador de azul: "+e);
        }
         
         return n;
    }
    
    
    
    
    
    public Color bucarColor(String id){
        Color color=new Color();
        String json="";
        try {
        conectar(); 
        MongoCollection<Document> rs=db.getCollection("colores1");
        Document document = rs.find(eq("_id", new ObjectId(id))).first();
        
        if(document == null){
            System.out.println("No existe el doc");
        } else {
            color.setId((ObjectId) document.get("_id")+"");
            color.setColor(document.getString("color"));
            color.setDescripcion(document.getString("descripcion"));
            color.setImagen(document.getString("imagen"));
        }
        
        desconectar(); 
            
        } catch (Exception e) {
            System.out.println("Error al buscar: "+e);
        }
        
        return color;
    }
    
    public String bucarColorJson(String id){
        Color color=new Color();
        String json="";
        try {
        conectar(); 
        MongoCollection<Document> rs=db.getCollection("colores1");
        Document document = rs.find(eq("_id", new ObjectId(id))).first();
        
        if(document == null){
            System.out.println("No existe el doc");
        } else {
            color.setId((ObjectId) document.get("_id")+"");
            color.setColor(document.getString("color"));
            color.setDescripcion(document.getString("descripcion"));
            color.setImagen(document.getString("imagen"));
            
            //editarColorJson(color);
        }
        Gson gson=new Gson();
            json=gson.toJson(color);
        desconectar(); 
            
        } catch (Exception e) {
            System.out.println("Error al buscar: "+e);
        }
        
        return json;
    }
    
    public String editarColorJson(Color color){
        String json="";
        try {
            conectar();
            MongoCollection<Document> collection=db.getCollection("colores1");
            
            String id=color.getId();
            String colors=color.getColor();
            String descripcion=color.getDescripcion();
            String imagen=color.getImagen();
            
            ObjectId idMongo=new ObjectId(id);
            
            Document findDocument=new Document("_id",idMongo);
            
            Document updateDocument=new Document("$set", 
                    new Document()
                    .append("color", colors)
                    .append("descripcion", descripcion)
                    .append("imagen",imagen)
                    
            );
            collection.findOneAndUpdate(findDocument, updateDocument);
            
            System.out.println("Color actualizado correctamente");
            Gson gson=new Gson();
            json=gson.toJson(color);
            System.out.println("Hola");
            desconectar();
        } catch (Exception ex) {
            
            System.out.println("Error al editar el color: "+ex);
        }
        
        return json;
    }
    
    public String editarColor(Color color){
        String json="";
        try {
            conectar();
            MongoCollection<Document> collection=db.getCollection("colores1");
            System.out.println("aqui");
            String id=color.getId();
            String colors=color.getColor();
            String descripcion=color.getDescripcion();
            String imagen=color.getImagen();
            System.out.println("aqui");
            System.out.println(descripcion);
            ObjectId idMongo=new ObjectId(id);
            System.out.println("aqui");
            Document findDocument=new Document("_id",idMongo);
            
            Document updateDocument=new Document("$set", 
                    new Document()
                    .append("color", colors)
                    .append("descripcion", descripcion)
                    .append("imagen",imagen)
                    
            );
            collection.findOneAndUpdate(findDocument, updateDocument);
            
            //System.out.println("Color actualizado correctamente");
            Gson gson=new Gson();
            json=gson.toJson(color);
            desconectar();
        } catch (Exception ex) {
            
            System.out.println("Error al editar el color: "+ex);
        }
        Gson gson=new Gson();
        json=gson.toJson(color);
        return json;
    }
    
    
    
   
    
     public void borrarColor(String ide){
         String json="";
        try {
            conectar();
            MongoCollection<Document> collection=db.getCollection("colores1");
            String id=ide;
            Object idMongo=new ObjectId(id);
            
            Document findDocument = new Document("_id",idMongo);
            
            collection.findOneAndDelete(findDocument);
            Gson gson=new Gson();
            json=gson.toJson(collection);
            desconectar();
            
        } catch (Exception e) {
            System.out.println("Error al borrar: "+e);
        }
        
        //return json;
    }
    
    
    
}
