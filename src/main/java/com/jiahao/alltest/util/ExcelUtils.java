package com.jiahao.alltest.util;

import com.jiahao.alltest.entity.CompanyInfo;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * @author jiahao
 * @className: ExcelUtils
 * @Description: excel文件操作工具类
 * @date: 2021/6/23 23:01
 **/
public class ExcelUtils {

    private static final Logger log = LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * 文件的导入
     * @param fileName 文件的绝对路径
     * @return excel数据集合
     */
    public static List<Object[]> importExcel(String fileName) {
        log.info("导入解析开始，fileName:{}",fileName);
        try {
            List<Object[]> list = new ArrayList<>();
            InputStream inputStream = new FileInputStream(fileName);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            //获取sheet的行数
            int rows = sheet.getPhysicalNumberOfRows();
            for (int i = 0; i < rows; i++) {
                //过滤表头行
//                if (i == 0) {
//                    continue;
//                }
                //获取当前行的数据
                Row row = sheet.getRow(i);
                Object[] objects = new Object[row.getPhysicalNumberOfCells()];
                int index = 0;
                for (Cell cell : row) {
                    if (cell.getCellType().equals(CellType.NUMERIC)) {
                        objects[index] = (int) cell.getNumericCellValue();
                    }
                    if (cell.getCellType().equals(CellType.STRING)) {
                        objects[index] = cell.getStringCellValue();
                    }
                    if (cell.getCellType().equals(CellType.BOOLEAN)) {
                        objects[index] = cell.getBooleanCellValue();
                    }
                    if (cell.getCellType().equals(CellType.ERROR)) {
                        objects[index] = cell.getErrorCellValue();
                    }
                    index++;
                }
                list.add(objects);
            }
            log.info("导入文件解析成功！");
            return list;
        }catch (Exception e){
            log.info("导入文件解析失败！");
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        // 文件的导入测试
//        List<Object[]> objects = importExcel("D:\\test\\高考成绩表.xlsx");
//
//        int yuwen_index = 0, shuxue_index = 0, yingwen_index = 0, name_index = 0;
//        // 获取各科成绩的下标
//        for (int i = 0; i < objects.get(0).length; i++) {
//            if("语文".equals(objects.get(0)[i])) {
//                yuwen_index = i;
//            }
//            if("数学".equals(objects.get(0)[i])) {
//                shuxue_index = i;
//            }
//            if("英文".equals(objects.get(0)[i])) {
//                yingwen_index = i;
//            }
//            if("姓名".equals(objects.get(0)[i])) {
//                name_index = i;
//            }
//        }
//
//        Map<String, Integer> nameSocre = new HashMap<>();
//        for (Object[] objects1 : objects) {
//            if("序号".equals(objects1[0])) {
//                continue;
//            }
//            int sum = 0;
//            String name = "";
//            for (int i = 1; i < objects1.length; i++) {
//                if(i == yuwen_index || i == shuxue_index || i == yingwen_index) {
//                    sum += (int)objects1[i];
//                }
//                if(i == name_index) {
//                    name = (String)objects1[i];
//                }
//                nameSocre.put(name, sum);
//            }
//        }
//
//        Iterator<String> iterator = nameSocre.keySet().iterator();
//        while(iterator.hasNext()){
//            String name = iterator.next();
//            log.info("name:{}, sum:{}", name, nameSocre.get(name));
//        }


        // 导出测试
        List<CompanyInfo> companyInfoLis = new ArrayList<>();
        ExcelUtils2.writeExcel(companyInfoLis, CompanyInfo.class, "导出测试");


    }

}
