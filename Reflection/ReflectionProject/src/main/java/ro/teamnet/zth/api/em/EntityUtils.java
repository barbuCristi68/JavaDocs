package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristian.Barbu on 7/12/2017.
 */
public class EntityUtils {
    private EntityUtils(){
        throw new UnsupportedOperationException();
    }

    public static String getTableName(Class entity){
        Table x = (Table) entity.getAnnotation(Table.class);
        if(!x.getClass().getName().equals(null))
            return x.name();
        return entity.getName();
    }

    public static List<ColumnInfo> getColumns(Class entity){
        List<ColumnInfo> list = new ArrayList<ColumnInfo>();
        Field[] fields = entity.getDeclaredFields();
        for(Field f:fields){
                ColumnInfo cli = new ColumnInfo();
                cli.setColumnName(f.getName());
                cli.setColumnType(f.getType());
                if(f.isAnnotationPresent(Id.class)) {
                    cli.setId(true);
                    Id annon =f.getAnnotation(Id.class);
                    cli.setDbColumnName(annon.name());
                }
                else{
                    cli.setId(false);
                    Column annon = f.getAnnotation(Column.class);
                    cli.setDbColumnName(annon.name());
                }

                list.add(cli);


        }

        return list;
    }

    public static Object castFromSqlType(Object value, Class wantedType){

        if(value instanceof BigDecimal) {

            if (wantedType.getClass().equals(Integer.class))
                return (Integer) value;
            if (wantedType.getClass().equals(Long.class))
                return (Long) value;
            if (wantedType.getClass().equals(Float.class))
                return (Float) value;
            if (wantedType.getClass().equals(Double.class))
                return (Double) value;
            else return null;
        }
        return value;

    }

    public static List<Field> getFieldsByAnnotations(Class clazz, Class annotation){
        List<Field> list = new ArrayList<Field>();
        Field[] fil = clazz.getDeclaredFields();
        for(Field it:fil){
            if(it.getAnnotation(annotation)!= null)
                list.add(it);
        }
        return list;
    }

    public static Object getSqlValue(Object object){
        Field[] f = object.getClass().getDeclaredFields();
        for(Field it:f){
            if(it.isAnnotationPresent(Id.class))
                it.setAccessible(true);
                return it.getType();
        }
            return object;
    }

}
