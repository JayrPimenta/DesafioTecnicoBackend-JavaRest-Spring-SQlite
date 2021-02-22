package com.project.desafio.config;

import java.sql.Types;

import org.hibernate.dialect.Dialect;

public class SQliteDialect extends Dialect {

	
	public SQliteDialect() {

		registerColumnType(Types.INTEGER, "integer");
		registerColumnType(Types.FLOAT, "float");
		registerColumnType(Types.DOUBLE, "double");
		registerColumnType(Types.NUMERIC, "numeric");
		registerColumnType(Types.CHAR, "char");
		registerColumnType(Types.VARCHAR, "varchar");
		registerColumnType(Types.DATE, "date");
		registerColumnType(Types.TIME, "time");
		registerColumnType(Types.TIMESTAMP, "timestamp");
		registerColumnType(Types.BOOLEAN, "integer");
		
	}
	
	public boolean supportsIdentityColumns() {
        return true;
    }
	
	public boolean hasDataTypeInIdentityColumn() {
		return false;
	}
	
	public String getIdentityColumnString() {
        return "integer";
    }
	
	public String getIdentitySelectString() {
		return "select last_insert_rowid()";
	}
	
	@Override
	public boolean supportsLimit() {
		return true;
	}
	
	@Override
	protected String getLimitString(String query, boolean hasOffset) {
		return new StringBuffer(query.length() + 20).append(query).append(hasOffset ? "limit ? offset ?" : "limit ?").toString();
	}
	
	public boolean supportsTemporaryTables() {
		return true;	
	}
	
	public String getCreateTemporaryTableString() {
		return "Tabela temporaria não existe";
	}
	
	public boolean dropTemporaryTableAfterUse() {
		return false;
	}
	
	@Override
	public boolean supportsCurrentTimestampSelection() {
		return true;
	}
	
	@Override
	public boolean isCurrentTimestampSelectStringCallable() {
		return false;
	}
	
	@Override
	public String getCurrentTimestampSelectString() {
		return "select current_timestamp";
	}
	
	@Override
	public boolean supportsUnionAll() {
		return true;
	}
	
	@Override
	public boolean hasAlterTable() {
		return false;
	}
	
	@Override
	public boolean dropConstraints() {
		return false;
	}
	
	@Override
	public String getAddColumnString() {
		return "add column";
	}
	
	@Override
	public String getForUpdateString() {
		return "";
	}
	
	@Override
	public boolean supportsOuterJoinForUpdate() {
		return false;
	}
	
	@Override
	public String getDropForeignKeyString() {
		throw new UnsupportedOperationException("No add foreign key syntax supported by SQlite");
	}
	
	@Override
	public String getAddForeignKeyConstraintString(String constraintName, String[] foreignKey, String referencedTable, String[] primaryKey, boolean referencesPrimaryKey) {	
		throw new UnsupportedOperationException("No add foreign key syntax supported by SQlite");
	}

	@Override
	public String getAddPrimaryKeyConstraintString(String constraintName) {
		throw new UnsupportedOperationException("No add primary key syntax supported by SQlite");
	}
	
	@Override
	public boolean supportsIfExistsBeforeTableName() {
		return true;
	}
	
	@Override
	public boolean supportsCascadeDelete() {
		return false;
	}
	
}
