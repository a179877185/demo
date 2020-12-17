package springboot.demo.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * excel 数据格式
 */
public class ExcelData implements Serializable {

    private static final long serialVersionUID = 4444017239100620999L;

    // 表头
    private List<String> titles;

    // 数据
    private List<Object> rows;

    private List<Map> datas;

    // 页签名称
    private String name;

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<Object> getRows() {
        return rows;
    }

    public void setRows(List<Object> rows) {
        this.rows = rows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map> getDatas() {
        return datas;
    }

    public void setDatas(List<Map> datas) {
        this.datas = datas;
    }
}
