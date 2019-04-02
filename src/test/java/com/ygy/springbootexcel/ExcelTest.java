package com.ygy.springbootexcel;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Auther: yanguangyuan
 * @Date: 2018/12/29 15:41
 * @Description: 简单测试
 */
/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class ExcelTest {

    @Test
    public void testRead(){
        try {
            FileInputStream in = new FileInputStream("C:\\Users\\18473\\Desktop\\测试表.xlsx");
            Workbook wk = StreamingReader.builder()
                    .rowCacheSize(10)  //缓存到内存中的行数，默认是10
                    .bufferSize(4096)  //读取资源时，缓存到内存的字节大小，默认是1024
                    .open(in);  //打开资源，必须，可以是InputStream或者是File，注意：只能打开XLSX格式的文件
            Sheet sheet = wk.getSheetAt(0);
            //遍历所有的行
            for (Row row : sheet) {
                //遍历所有的列
                for (Cell cell : row) {
                    System.out.print(cell.getStringCellValue() + " ");
                }
                System.out.println(" ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
