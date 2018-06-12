package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.model.Document;
import com.ecommerce.microcommerce.model.Operations;

import com.ecommerce.microcommerce.model.account.account;
import com.ecommerce.microcommerce.model.account.accountRepository;
import com.ecommerce.microcommerce.model.kpi.kpialpha;
import com.ecommerce.microcommerce.model.kpi.kpialphaRepository;
import com.ecommerce.microcommerce.model.dim.dim;
import com.ecommerce.microcommerce.model.dim.dimRepository;
import com.ecommerce.microcommerce.model.config.config;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
public class ProductController {

    @Autowired
    kpialphaRepository r;

    @Autowired
    accountRepository a;

    @Autowired
    dimRepository dimr;

    @RequestMapping(value="/Documents", method=RequestMethod.GET)
    public String listeDocuments() {
        return "Un exemple de document";
    }

    //Notice that {id} means variable
    /*
    @GetMapping(value="/Documents/{id}")
    public String detailDocument(@PathVariable int id) {
        return "Details of document:"+id;
    }
    */

    @GetMapping(value="/Documents/{id}")
    public Document detailDocument(@PathVariable int id) {
        Document d = new Document(id+"", 5+"", new Date(), new String("Document Content Details"));
        return d;//Objects are formatted as JSON files
    }

    @GetMapping(value="/documentProcessing")
    public String documentProcessing() throws InvalidFormatException {

        String toShow = "", rowContent = "";
        Workbook wb = null;
        try {
            String fileLocation = "/root/Downloads/hplFile.xls";
            FileInputStream file = new FileInputStream(new File(fileLocation));
            Workbook workbook = new HSSFWorkbook(file);

            Sheet sheet = workbook.getSheetAt(2);
            Map<Integer, List<String>> data = new HashMap<>();
            Map<String, Integer> colMid = new HashMap<>();
            int i = 0;
            int RowBeginId = 10;
            int RowEndId = 40;
            int AccountColId = 2;
            colMid.put("AccountColId", AccountColId);
            int Dim1ColId = 4;
            colMid.put("Dim1ColId", Dim1ColId);
            int Dim1DescColId = 5;
            colMid.put("Dim1DescColId", Dim1DescColId);
            int Dim2ColId = 6;
            colMid.put("Dim2ColId", Dim2ColId);
            int Dim2DescColId = 7;
            colMid.put("Dim2DescColId", Dim2DescColId);
            int Dim3ColId = 8;
            colMid.put("Dim3ColId", Dim3ColId);
            int Dim3DescColId = 8;
            colMid.put("Dim3DescColId", Dim3DescColId);
            int Dim4ColId = 9;
            colMid.put("Dim4ColId", Dim4ColId);
            int Dim4DescColId = 10;
            colMid.put("Dim4DescColId", Dim4DescColId);
            int Dim5ColId = 11;
            colMid.put("Dim5ColId", Dim5ColId);
            int Dim5DescColId = 12;
            colMid.put("Dim5DescColId", Dim5DescColId);
            int Dim6ColId = 13;
            colMid.put("Dim6ColId", Dim6ColId);
            int Dim6DescColId = 14;
            colMid.put("Dim6DescColId", Dim6DescColId);
            int DepartmentId = 23;
            colMid.put("DepartmentId", DepartmentId);

            Row row = null; Cell cell = null;

            toShow += "Acc|D1|Dd1|D2|Dd2|D3|Dd3|D4|Dd4|D5|Dd5|D6|Dd6|Dep"+"\n\n";

            for(int rowId=RowBeginId; rowId<=RowEndId; rowId++){
                //get the row
                row = sheet.getRow(rowId);
                data.put(i, new ArrayList<String>());

                //get cspecific cells row.
                for(int cellid : colMid.values()){

                    cell = row.getCell(cellid);
                    //rowContent += cell.getCellType()+" | ";

                    //rowContent += cell.getStringCellValue()+" | ";
                    switch (cell.getCellType()) {
                        case 1: rowContent += cell.getStringCellValue()+" | "; break;
                        //case 2: rowContent += (cell.getCellFormula()).toString()+" | "+"\n"; break;
                        //2 text formula
                        //case 3: toShow += cell.getNumericCellValue()+""+"\n"; break;
                        //case BOOLEAN: ...break;
                        //case FORMULA: ...break;
                        default: rowContent += cell.getCellType()+" | "+"\n\n"; break;
                            //data.get(new Integer(i)).add(" ");
                    }

                }

                toShow += rowContent+"\n";
                rowContent = "";
                //index++;
            }

            //WorkbookFactory wbk = WorkbookFactory.create(file);
            //wb = workbook;


        }
        catch(FileNotFoundException e){
            e.getMessage();
        }
        catch(IOException e){
            e.getMessage();
        }

        return toShow;
    }

    @PostMapping(value="/HPLProcessing")
    public String HPLProcessing(@RequestBody config cf) throws InvalidFormatException{

        String toShow = "", rowContent = "";
        Workbook wb = null;
        Operations op = new Operations();
        //
        List<account> listAccounts;
        List<dim> listDimensions;

        Integer accountid = 0;
        account kpiAccount = null;

        Integer dimid = 0;
        dim kpiDimension = null;

        try {
            String fileLocation = "/root/Downloads/GRSHPL.xlsx";
            FileInputStream file = new FileInputStream(new File(fileLocation));
            Workbook workbook = new XSSFWorkbook(file);

            Sheet sheet = workbook.getSheetAt(4);

            Map<Integer, List<String>> data = new HashMap<>();

            Map<String, Integer> colMid = new HashMap<>();

            //Map<Integer, Map<String, String> mp > idata = new HashMap<>();

            int i = 0;
            int RowBeginId = cf.getRowBeginIndex();//31; //32 -> 826 real | 31 -> 825 file
            int RowEndId = cf.getRowEndIndex();//825;
            int AccountColId = 1;
            colMid.put("AccountColId", AccountColId);
            int Dim1ColId = 3;
            colMid.put("Dim1ColId", Dim1ColId);
            int Dim1DescColId = 4;
            colMid.put("Dim1DescColId", Dim1DescColId);
            int Dim2ColId = 5;
            colMid.put("Dim2ColId", Dim2ColId);
            int Dim2DescColId = 6;
            colMid.put("Dim2DescColId", Dim2DescColId);
            int Dim3ColId = 7;
            colMid.put("Dim3ColId", Dim3ColId);
            int Dim3DescColId = 8;
            colMid.put("Dim3DescColId", Dim3DescColId);
            int Dim4ColId = 9;
            colMid.put("Dim4ColId", Dim4ColId);
            int Dim4DescColId = 10;
            colMid.put("Dim4DescColId", Dim4DescColId);
            int Dim5ColId = 11;
            colMid.put("Dim5ColId", Dim5ColId);
            int Dim5DescColId = 12;
            colMid.put("Dim5DescColId", Dim5DescColId);
            int DepartmentColId = 27;
            colMid.put("DepartmentColId", DepartmentColId);
            int ReportingTeamColId = 28;
            colMid.put("ReportingTeamColId", ReportingTeamColId);

            /*
            int ConsolidationColId = 13;
            colMid.put("Dim5DescColId", Dim5DescColId);

            int DepartmentId = 16;
            colMid.put("DepartmentId", DepartmentId);
            int TeamId = 17;
            colMid.put("TeamId", TeamId);
            */

            Row row = null; Cell cell = null;
            String account = "", dim1 = "", dim1desc = "", dim2 = "", dim2desc = "";
            String dim3 = "", dim3desc = "", dim4 = "", dim4desc = "", dim5 = "", dim5desc = "";
            String department = "", reporting_team = "";
            boolean cns = false;

            toShow += "Acc|D1|Dd1|D2|Dd2|D3|Dd3|D4|Dd4|D5|Dd5|Dep|Team"+"\n\n";

            for(int rowId=RowBeginId; rowId<=RowEndId; rowId++){
                //get the row
                row = sheet.getRow(rowId);
                data.put(i, new ArrayList<String>());

                //get specific cells by Id.
                for(int cellid : colMid.values()){

                    cell = row.getCell(cellid);

                    switch(cellid){
                        case 1: account = cell.getStringCellValue(); break;
                        case 3 : dim1 = cell.getStringCellValue(); break;
                        case 4: dim1desc = cell.getStringCellValue(); break;
                        case 5: dim2 = cell.getStringCellValue(); break;
                        case 6: dim2desc = cell.getStringCellValue(); break;
                        case 7: dim3 = cell.getStringCellValue(); break;
                        case 8: dim3desc = cell.getStringCellValue(); break;
                        case 9: dim4 = cell.getStringCellValue(); break;
                        case 10: dim4desc = cell.getStringCellValue(); break;
                        case 11: dim5 = cell.getStringCellValue(); break;
                        case 12: dim5desc = cell.getStringCellValue(); break;
                        case 27: department = cell.getStringCellValue(); break;
                        case 28: reporting_team = cell.getStringCellValue(); break;
                        default: break;
                    }

                    //cns = op.checknstore(account, dim, dim1desc, dim2, dim2desc, dim3, dim3desc, dim4, dim4desc, dim5, dim5desc, department, reporting_team);

                    //rowContent += cell.getCellType()+" | ";
                    //rowContent += cell.getStringCellValue()+" | ";
                    switch (cell.getCellType()) {
                        case 1: rowContent += cellid+" : "+cell.getStringCellValue()+" | "; break;
                        case 2: rowContent += cellid+" : "+cell.getStringCellValue()+" | "; break;
                        //case 2: rowContent += (cell.getCellFormula()).toString()+" | "+"\n"; break;
                        //2 text formula
                        //case 3: toShow += cell.getNumericCellValue()+""+"\n"; break;
                        //case BOOLEAN: ...break;
                        //case FORMULA: ...break;
                        default: rowContent += cell.getCellType()+" | "+"\n\n"; break;
                        //data.get(new Integer(i)).add(" ");
                    }
                }
/*
                account
                case 3 : dim = cell.getStringCellValue(); break;
                case 4: dim1desc = cell.getStringCellValue(); break;
                case 5: dim2 = cell.getStringCellValue(); break;
                case 6: dim2desc = cell.getStringCellValue(); break;
                case 7: dim3 = cell.getStringCellValue(); break;
                case 8: dim3desc = cell.getStringCellValue(); break;
                case 9: dim4 = cell.getStringCellValue(); break;
                case 10: dim4desc = cell.getStringCellValue(); break;
                case 11: dim5 = cell.getStringCellValue(); break;
                case 12: dim5desc = cell.getStringCellValue(); break;
                case 27: department = cell.getStringCellValue(); break;
                case 28: reporting_team = cell.getStringCellValue(); break;
                default: break;
*/

                //check account
                listAccounts = a.findByAccountCode(account);
                System.out.println("\n LIST ACCOUNTS SIZE for the given account "+ account+" --- "+listAccounts.size());
                //check account existance
                if(listAccounts.size()==0) {
                    kpiAccount = new account(account, "account descr");
                    a.save(kpiAccount);
                    accountid = kpiAccount.getAccountId();
                }
                else{
                    kpiAccount = a.findByAccountCode(account).get(0);
                    accountid = kpiAccount.getAccountId();
                }
                //check dimension 1
                listDimensions = dimr.findByDimDescription(dim1desc);//.findByDimDescription(dim1desc);
                System.out.println("\n LIST DIMENSIONS SIZE for a given dim1 value "+ dim1desc+" --- "+listDimensions.size()+" can take 0 OR 1");
                //check dimension existance
                if(listDimensions.size()==0) {
                    kpiDimension = new dim("1", dim1, dim1desc);
                    dimr.save(kpiDimension);
                    dimid = kpiDimension.getDimId();
                }
                else{
                    kpiDimension = dimr.findByDimDescription(dim1desc).get(0);
                    dimid = kpiDimension.getDimId();
                }
                kpialpha kp =  new kpialpha(kpiDimension, 0, 0, 0, 0, 0, 0, 0, 0, kpiAccount);
                //kp.setKpiAccount(accountid);

                kp.setKpiDim1(kpiDimension);
                kp.setKpiDim2Id(0);
                kp.setKpiDim3Id(0);
                kp.setKpiDim4Id(0);
                kp.setKpiDim5Id(0);
                kp.setKpiReportId(0);
                kp.setKpiDeptId(0);

                //kp.setKpi_date_modif(new String("00-00-00"));
                //kp.setKpi_date_ajout(new String("00-00-00");

                kp.setKpiActif(1);//.setKpi_actif(1);
                kp.setKpiOrder(0);

                r.save(kp);
                /*
                kpialphaService s = new kpialphaService();
                s.addKpialpha(kp);
                */
                //k = toShow += rowContent+"\n";
                rowContent = "";

            }
/*
            //check and update db
            String urlms = "jdbc:mysql://localhost:3306/smart_budget";//fileWatcher2
            MySQLConnect ms_connection = null;
            Connection ms_dbconnect = null;
            Statement ms_instruction = null;

            ms_connection = new MySQLConnect();
            ms_dbconnect = ms_connection.Connect(urlms, "root", "kpi@123");
            Statement instruction = null;
            int ret = 0;
            try {
                instruction = ms_dbconnect.createStatement();
                String insertRequest = "INSERT INTO changelog(USER, DATE) VALUES ('HamzaChanger', '2018-06-03')";
                ret  = instruction.executeUpdate(insertRequest);

            } catch (SQLException e) {
                e.printStackTrace();
            }
*/

            //System.out.println(kp.toString());

            //kpialphaService kservice = new kpialphaService();

            ArrayList<kpialpha> kpis = new ArrayList<>();
            r.findAll().forEach(kpis::add);

            //kpis.forEach(System.out::print);

            toShow = kpis.toString();
        }
        catch(FileNotFoundException e){
            e.getMessage();
        }
        catch(IOException e){
            e.getMessage();
        }

        return toShow;

    }

    /*

    cell = row.getCell(13);
            cell.setCellValue(9999.99);
            //cell.setCellStyle();
            file.close();

            //Open FileOutputStream to write updates
            FileOutputStream output_file = new FileOutputStream(new File(fileLocation));
            //write changes
            workbook.write(output_file);
            //close the stream
            output_file.close();

     */
    @GetMapping(value="/Consolidate")
    public String Consolidate() {
        String opStatus = "Operation has been executed well !!";
        //opStatus = "Operation has been executed well":
        try {
            String fileLocation = "/root/Downloads/GRSHPL.xlsx";
            FileInputStream file = new FileInputStream(new File(fileLocation));
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(4);
            Cell cell = null;

            //Retrieve the row and check for null
            int row = 41;
            XSSFRow sheetrow = sheet.getRow(row);
            if(sheetrow == null){
                sheetrow = sheet.createRow(row);
            }
            //Update the value of cell
            int col = 16;
            cell = sheetrow.getCell(col);
            if(cell == null){
                cell = sheetrow.createCell(col);
            }
            cell.setCellValue(999988.25);

            file.close();

            FileOutputStream outFile =new FileOutputStream(new File(fileLocation));
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return opStatus;
    }
    /*
    @GetMapping(value="/Documents/{id}")
    public void processDocument() {
        SQLContext sqlContext = sparkSession.sqlContext;
        Dataframe df = sqlContext.read
                .format("org.zuinnote.spark.office.excel")
                .option("read.locale.bcp47", "us")  // example to set the locale to us
                .load("/home/user/office/input");
        long totalCount = df.count;
        // print to screen
        System.out.println("Total number of rows in Excel: "+totalCount);
        df.printSchema();
        // print formattedValues
        df.show();
    }
    */
/*
    SQLContext sqlContext = sparkSession.sqlContext;
    Dataframe df = sqlContext.read
            .format("org.zuinnote.spark.office.excel")
            .option("read.locale.bcp47", "us")  // example to set the locale to us
            .load("/home/user/office/input");
    long totalCount = df.count;
    // print to screen
   System.out.println("Total number of rows in Excel: "+totalCount);
   df.printSchema();
    // print formattedValues
df.show();
*/

}
