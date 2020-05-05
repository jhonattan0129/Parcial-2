package com.example.parcial2;

public class DefDB {

    public static final String nameDb = "registro";
    public static final String tabla_est = "usuario";
    public static final String col_cedula = "cedula";
    public static final String col_nombre = "nombre";
    public static final String col_estrato = "estrato";
    public static final String col_salario = "salario";
    public static final String col_educacion = "educacion";


    public static final String create_tabla_est = "CREATE TABLE IF NOT EXISTS usuario(" +
            "  cedula text ," +
            "  nombre text," +
            "  estrato text," +
            "  salario text," +
            "  educacion text" +
            ");";

}
