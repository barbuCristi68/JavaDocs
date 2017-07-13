package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristian.Barbu on 7/13/2017.
 */
public class EntityManagerImpl implements EnityManager {
    @Override
    public <T> T findById(Class<T> entityClass, Long id){
        Connection connection = null;
        try {
            connection = DBManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);
        List<Field> idFields = EntityUtils.getFieldsByAnnotations(entityClass,Id.class);
        Field idField = idFields.get(0);
        List<Field> fields = EntityUtils.getFieldsByAnnotations(entityClass, Column.class);

        Condition cond = new Condition();
        cond.setColumnName(columns.get(0).getDbColumnName());
        cond.setValue(id);

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setTableName(tableName);
        queryBuilder.addQueryColumns(columns);
        queryBuilder.addCondition(cond);
        queryBuilder.setQueryType(QueryType.SELECT);
        String sql = queryBuilder.createQuery();

      try {
          Statement st = connection.createStatement();

          ResultSet resultSet = st.executeQuery(sql);

          if (resultSet.next()) {
              T instance = entityClass.newInstance();
              for (ColumnInfo ci : columns) {
                  Field f = instance.getClass().getDeclaredField(ci.getColumnName());
                  f.setAccessible(true);
                  f.set(instance, EntityUtils.castFromSqlType(resultSet.getObject(ci.getDbColumnName()),f.getType()));

              }
              return instance;

          }
      } catch (SQLException e) {
          e.printStackTrace();
          System.exit(1);
      } catch (IllegalAccessException e) {
          e.printStackTrace();
      } catch (InstantiationException e) {
          e.printStackTrace();
      } catch (NoSuchFieldException e) {
          e.printStackTrace();
      }

        return null;
    }

    @Override
    public Long getNextIdVal(String tableName, String columnIdName) {

        try {
            Connection connection = DBManager.getConnection();

            Statement statement = connection.createStatement();
            String sql = "SELECT MAX("+columnIdName +") FROM  "+tableName+ "";
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                Long result = rs.getLong(1) +1;
                return result;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




        return null;

    }

    @Override
    public <T> Object insert(T entity) {

        try {
            Connection connection = DBManager.getConnection();
            String tableName = EntityUtils.getTableName(entity.getClass());
            List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());
            Long result = null;
            for (ColumnInfo column : columns) {
                if (column.isId()) {
                    result = this.getNextIdVal(tableName, column.getDbColumnName());
                    column.setValue(result);
                } else {
                    Field f = (entity.getClass()).getDeclaredField(column.getColumnName());
                    f.setAccessible(true);
                    column.setValue(f.get(entity));
                }
            }

                QueryBuilder queryBuilder = new QueryBuilder();
                queryBuilder.setTableName(tableName);
                queryBuilder.addQueryColumns(columns);
                queryBuilder.setQueryType(QueryType.INSERT);
                String sql = queryBuilder.createQuery();

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(sql);


                return findById(entity.getClass(),result);






        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {

        try {
            Connection connection =DBManager.getConnection();

            String tableName = EntityUtils.getTableName(entityClass);
            List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);

            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setTableName(tableName);
            queryBuilder.addQueryColumns(columns);
            queryBuilder.setQueryType(QueryType.SELECT);

            String sql = queryBuilder.createQuery();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);


            List<T> list = new ArrayList<T>();

            while(resultSet.next()){
                T instance = entityClass.newInstance();
                for (ColumnInfo column : columns) {
                    Field f = instance.getClass().getDeclaredField(column.getColumnName());
                    f.setAccessible(true);
                    f.set(instance, EntityUtils.castFromSqlType(resultSet.getObject(column.getDbColumnName()),f.getType()));

                }
                list.add(instance);
            }
            return  list;


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
