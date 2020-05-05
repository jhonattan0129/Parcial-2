package com.example.parcial2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioController {

    private BaseDatos db;

    public UsuarioController(Context context) {
        this.db = new BaseDatos(context);
    }

    public long agregarUsuario(Usuario e){
        long id = 0;
        try{

            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(DefDB.col_cedula,e.cedula);
            valores.put(DefDB.col_nombre,e.nombre);
            valores.put(DefDB.col_estrato,e.estrato);
            valores.put(DefDB.col_salario,e.salario);
            valores.put(DefDB.col_educacion,e.educacion);
            id = database.insert(DefDB.tabla_est,null, valores);
            return id;
        }
        catch (Exception ex){
            System.out.println("Error al insertar");
            return 0;
        }
    }

    public boolean buscarU(String cod){
        String[] args = new String[] {cod};
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor c = database.query(DefDB.tabla_est, null, "cedula=?", args, null, null, null);
        if (c.getCount()>0) {
            database.close();
            return true;
        }
        else{
            database.close();
            return false;}

    }




    public Cursor allUsuarios() {
        try {
            SQLiteDatabase database = db.getWritableDatabase();
            Cursor cur = database.rawQuery("select cedula as _id, nombre, estrato, salario, educacion from  usuario", null);
            return cur;
        } catch (Exception ex) {
            System.out.println("Error al consultar");
            return null;
        }
    }

    public Cursor buscarUsuario(String w) {
        try {
            String[] args = new String[] {w};
            SQLiteDatabase database = db.getReadableDatabase();
            Cursor c = database.rawQuery("select cedula as _id, nombre, estrato, salario, educacion from  usuario where cedula = ?", args);
            return c;
        } catch (Exception ex) {
            System.out.println("Error al consultar");
            return null;
        }
    }

    public boolean eliminarUsuario(String ced){
        boolean estado = false;
        SQLiteDatabase database = db.getReadableDatabase();
        database.execSQL("delete from usuario where cedula = "+ced);
        if(!buscarU(ced)){
            estado= true;
        }
        return estado;
    }

    public long actualizarUsuario(Usuario e){

        try{
            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues valores = new ContentValues();
            System.out.println(e.toString());
            String[] args = new String[] {e.cedula};
            valores.put(DefDB.col_nombre,e.nombre);
            valores.put(DefDB.col_estrato,e.estrato);
            valores.put(DefDB.col_salario,e.salario);
            valores.put(DefDB.col_educacion,e.educacion);
            long id = database.update(DefDB.tabla_est, valores,"cedula="+e.cedula,null);
            database.close();
            return id;
        }
        catch (Exception ex){
            System.out.println("Error al actualizar");
            return 0;
        }

    }
}