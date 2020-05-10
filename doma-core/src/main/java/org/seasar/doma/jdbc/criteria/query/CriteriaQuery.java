package org.seasar.doma.jdbc.criteria.query;

import java.lang.reflect.Method;
import java.sql.Statement;
import java.util.Objects;
import org.seasar.doma.FetchType;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.PreparedSql;
import org.seasar.doma.jdbc.SelectOptions;
import org.seasar.doma.jdbc.SqlExecutionSkipCause;
import org.seasar.doma.jdbc.SqlLogType;
import org.seasar.doma.jdbc.query.DeleteQuery;
import org.seasar.doma.jdbc.query.InsertQuery;
import org.seasar.doma.jdbc.query.SelectQuery;
import org.seasar.doma.jdbc.query.UpdateQuery;

public class CriteriaQuery implements SelectQuery, DeleteQuery, InsertQuery, UpdateQuery {

  private final Config config;
  private final PreparedSql sql;
  private final String className;
  private final String methodName;
  private int fetchSize;
  private int maxRows;
  private int queryTimeout;

  public CriteriaQuery(Config config, PreparedSql sql, String className, String methodName) {
    this.config = Objects.requireNonNull(config);
    this.sql = Objects.requireNonNull(sql);
    this.className = Objects.requireNonNull(className);
    this.methodName = Objects.requireNonNull(methodName);
  }

  @Override
  public int getFetchSize() {
    return fetchSize;
  }

  public void setFetchSize(int fetchSize) {
    this.fetchSize = fetchSize;
  }

  @Override
  public int getMaxRows() {
    return maxRows;
  }

  public void setMaxRows(int maxRows) {
    this.maxRows = maxRows;
  }

  @Override
  public int getQueryTimeout() {
    return queryTimeout;
  }

  public void setQueryTimeout(int queryTimeout) {
    this.queryTimeout = queryTimeout;
  }

  @Override
  public PreparedSql getSql() {
    return sql;
  }

  @Override
  public String getClassName() {
    return className;
  }

  @Override
  public String getMethodName() {
    return methodName;
  }

  @Override
  public Method getMethod() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Config getConfig() {
    return config;
  }

  @Override
  public void prepare() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void complete() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String comment(String sql) {
    throw new UnsupportedOperationException();
  }

  @Override
  public SelectOptions getOptions() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isResultEnsured() {
    return false;
  }

  @Override
  public boolean isResultMappingEnsured() {
    return false;
  }

  @Override
  public FetchType getFetchType() {
    return FetchType.EAGER;
  }

  @Override
  public SqlLogType getSqlLogType() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isResultStream() {
    return false;
  }

  @Override
  public void incrementVersion() {}

  @Override
  public boolean isOptimisticLockCheckRequired() {
    return false;
  }

  @Override
  public boolean isAutoGeneratedKeysSupported() {
    return false;
  }

  @Override
  public boolean isExecutable() {
    return true;
  }

  @Override
  public SqlExecutionSkipCause getSqlExecutionSkipCause() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void generateId(Statement statement) {}
}
