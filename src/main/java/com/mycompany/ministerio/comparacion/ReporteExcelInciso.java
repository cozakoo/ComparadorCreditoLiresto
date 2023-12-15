package com.mycompany.ministerio.comparacion;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

// REPORTE A NIVEL DE INCISO - NIVEL 1
class ReporteExcelInciso {

    //NOMBRE DE LAS COLUMNAS EN MI EXCEL
    final String COLUMNA_SAF = "Saf";
    final String COLUMNA_PROGRAMA = "Prog";
    final String COLUMNA_SUBPROGRAMA = "Subp";
    final String COLUMNA_PROYECTO = "Proy";
    final String COLUMNA_ACTIVIDAD = "Act";
    final String COLUMNA_OBRA = "Obr";
    final String COLUMNA_FUENTE = "Fte";
    final String COLUMNA_INCISO = "INC";
    final String COLUMNA_DISPONIBLE = "Cred. Disp";
    final String COLUMNA_LIBERAMIENTO = "Lib";
    final String COLUMNA_SALDO = "Saldo";

    //ANCHO DE LAS COLUMNAS EN MI EXCEL
    final int ANCHO_MIN = 1487;
    final int ANCHO_MAXIMO = 4097;

    private String ruta;
    private ResultSet resultSet;
    private Workbook workbook;
    private Sheet sheet;
    private Map<String, Object[]> datos;
    private CellStyler cellStyle;
    private int[] columnasaldos = {8, 9, 10};

    public ReporteExcelInciso(String ruta, ResultSet resultSet) {

        this.ruta = ruta;
        this.resultSet = resultSet;
        //Crear libro de trabajo en blanco
        this.workbook = new HSSFWorkbook();
        //Crea hoja nueva
        this.datos = new LinkedHashMap<String, Object[]>();
        this.sheet = this.workbook.createSheet("Reporte");
        this.cellStyle = new CellStyler(this.workbook.createCellStyle(), this.workbook.createFont());
    }

    public void exportarExcel() throws SQLException {
        generarCabezera();
        generarObjetos();
        setearObjetos();
        generarAncho(this.columnasaldos);
        generarDocumento();
    }

    private void generarCabezera() throws SQLException {

        int columnCount = resultSet.getMetaData().getColumnCount();
        Row row = sheet.createRow(0);

        for (int i = 1; i <= columnCount; i++) {
            datos.put("1", new Object[]{
                this.COLUMNA_SAF,
                this.COLUMNA_PROGRAMA,
                this.COLUMNA_SUBPROGRAMA,
                this.COLUMNA_PROYECTO,
                this.COLUMNA_ACTIVIDAD,
                this.COLUMNA_OBRA,
                this.COLUMNA_FUENTE,
                this.COLUMNA_INCISO,
                this.COLUMNA_DISPONIBLE,
                this.COLUMNA_LIBERAMIENTO,
                this.COLUMNA_SALDO,});
        }
    }

    private void generarObjetos() throws SQLException {

        int columnCount = resultSet.getMetaData().getColumnCount();

        while (resultSet.next()) {
            // FALTA: crear un generador de objetos con distintos atributos
            datos.put(String.valueOf(resultSet.getRow()) + 1, new Object[]{
                Integer.valueOf(resultSet.getString(1)),
                Integer.valueOf(resultSet.getString(2)),
                Integer.valueOf(resultSet.getString(3)),
                Integer.valueOf(resultSet.getString(4)),
                Integer.valueOf(resultSet.getString(5)),
                Integer.valueOf(resultSet.getString(6)),
                Integer.valueOf(resultSet.getString(7)),
                Integer.valueOf(resultSet.getString(8)),
                resultSet.getDouble(9),
                resultSet.getDouble(10),
                resultSet.getDouble(11)
            });
        }
        
        
        
    }

    public void generarDocumento() {
        try {
            //Se genera el documento
            FileOutputStream out = new FileOutputStream(new File(this.ruta));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setearObjetos() throws SQLException {
        //Iterar sobre datos para escribir en la hoja
        Set<String> keyset = this.datos.keySet();
        int numeroRenglon = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(numeroRenglon++);
            Object[] arregloObjetos = datos.get(key);
            int numeroCelda = 0;
            for (Object obj : arregloObjetos) {
                Cell cell = row.createCell(numeroCelda++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }else if (obj instanceof Double){
                    System.out.println((Double)obj);
                    cell.setCellValue((Double) obj);
                }
                generarStyle(row, cell);
            }

        }
    }

    private void generarStyle(Row row, Cell cell) throws SQLException {

        if (row.getRowNum() == 0) {
            cellStyle.styleCabecera();
            cell.setCellStyle(cellStyle.getCellstyle());
        }
    }

    public void generarAncho(int[] columna_saldos) throws SQLException {
        
        int columnCount = resultSet.getMetaData().getColumnCount();
        boolean encontro_columna;
        //damos tamano a la columna

        for (int i = 1; i <= columnCount; i++) {
            encontro_columna = Arrays.stream(columna_saldos).boxed().collect(Collectors.toSet()).contains(i);

            if (encontro_columna) {
                sheet.setColumnWidth(i, this.ANCHO_MAXIMO);
            } else {
                sheet.setColumnWidth(i, this.ANCHO_MIN);
            }
        }
    }

    public String getCOLUMNA_ACTIVIDAD() {
        return COLUMNA_ACTIVIDAD;
    }

    public String getCOLUMNA_DISPONIBLE() {
        return COLUMNA_DISPONIBLE;
    }

    public String getCOLUMNA_FUENTE() {
        return COLUMNA_FUENTE;
    }

    public String getCOLUMNA_INCISO() {
        return COLUMNA_INCISO;
    }

    public String getCOLUMNA_LIBERAMIENTO() {
        return COLUMNA_LIBERAMIENTO;
    }

    public String getCOLUMNA_OBRA() {
        return COLUMNA_OBRA;
    }

    public String getCOLUMNA_PROGRAMA() {
        return COLUMNA_PROGRAMA;
    }

    public String getCOLUMNA_PROYECTO() {
        return COLUMNA_PROYECTO;
    }

    public String getCOLUMNA_SAF() {
        return COLUMNA_SAF;
    }

    public String getCOLUMNA_SALDO() {
        return COLUMNA_SALDO;
    }

    public String getCOLUMNA_SUBPROGRAMA() {
        return COLUMNA_SUBPROGRAMA;
    }

    public int getANCHO_MAXIMO() {
        return ANCHO_MAXIMO;
    }

    public int getANCHO_MIN() {
        return ANCHO_MIN;
    }

    public Sheet getSheet() {
        return sheet;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public Map<String, Object[]> getDatos() {
        return datos;
    }
}
