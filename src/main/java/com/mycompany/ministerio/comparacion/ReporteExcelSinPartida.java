package com.mycompany.ministerio.comparacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.poi.ss.usermodel.Row;

public class ReporteExcelSinPartida extends ReporteExcelSubparcial {
    
    private int[] columnasaldos = {11, 12};
    
    public ReporteExcelSinPartida(String ruta, ResultSet resultSet) {
        super(ruta, resultSet);
    }
    
    @Override
    public void exportarExcel() throws SQLException {
        generarCabezera();
        generarObjetos();
        super.setearObjetos();
        super.generarAncho(this.columnasaldos);
        super.generarDocumento();
    }
    
    private void generarCabezera() throws SQLException {

        int columnCount = getResultSet().getMetaData().getColumnCount();
        Row row = getSheet().createRow(0);

        for (int i = 1; i <= columnCount; i++) {
            getDatos().put("1", new Object[]{
                getCOLUMNA_SAF(),
                getCOLUMNA_PROGRAMA(),
                getCOLUMNA_SUBPROGRAMA(),
                getCOLUMNA_PROYECTO(),
                getCOLUMNA_ACTIVIDAD(),
                getCOLUMNA_OBRA(),
                getCOLUMNA_FUENTE(),
                getCOLUMNA_INCISO(),
                getCOLUMNA_PRINCIPAL(),
                getCOLUMNA_PARCIAL(),
                getCOLUMNA_SUBPARCIAL(),
                getCOLUMNA_LIBERAMIENTO(),
                getCOLUMNA_SALDO()
            });
        }
    }
    
    private void generarObjetos() throws SQLException {

        int columnCount = getResultSet().getMetaData().getColumnCount();

        while (getResultSet().next()) {
            getDatos().put(String.valueOf(getResultSet().getRow()) + 1, new Object[]{
                Integer.valueOf(getResultSet().getString(1)),
                Integer.valueOf(getResultSet().getString(2)),
                Integer.valueOf(getResultSet().getString(3)),
                Integer.valueOf(getResultSet().getString(4)),
                Integer.valueOf(getResultSet().getString(5)),
                Integer.valueOf(getResultSet().getString(6)),
                Integer.valueOf(getResultSet().getString(7)),
                Integer.valueOf(getResultSet().getString(8)),
                Integer.valueOf(getResultSet().getString(9)),
                Integer.valueOf(getResultSet().getString(10)),
                Integer.valueOf(getResultSet().getString(11)),
                getResultSet().getDouble(12),
                getResultSet().getDouble(13),
            });
        }
    }
    
}
