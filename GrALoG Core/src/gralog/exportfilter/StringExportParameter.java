/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gralog.exportfilter;

/**
 *
 * @author viktor
 */
public class StringExportParameter extends ExportFilterParameters {
    
    public String parameter;
    
    public StringExportParameter() {
        this.parameter = "";
    }

    public StringExportParameter(String parameter) {
        this.parameter = parameter;
    }

}