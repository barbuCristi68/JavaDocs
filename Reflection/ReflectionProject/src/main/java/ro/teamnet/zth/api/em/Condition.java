package ro.teamnet.zth.api.em;

/**
 * Created by Cristian.Barbu on 7/12/2017.
 */
public class Condition {
    private String columnName;
    private Object value;

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getColumnName() {

        return columnName;
    }

    public Object getValue() {
        return value;
    }
}
