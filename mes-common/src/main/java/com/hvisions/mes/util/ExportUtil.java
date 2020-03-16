package com.hvisions.mes.util;

import org.apache.poi.hssf.usermodel.*;

/**
 * @description: 导入，导出工具类
 * @author: Bruce
 * @version:
 * @date: 2019-12-20 15:14
 */
public class ExportUtil {

    public static HSSFWorkbook excelOut() {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();

        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_LEFT);

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("xuhao");

        return wb;
    }



}
