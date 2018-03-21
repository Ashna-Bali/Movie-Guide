package com.example.ashna.movieguide.database.tables;

/**
 * Created by ASHNA on 26-10-2017.
 */

public interface DbConsts {

    String TYPE_INT = " INTEGER ";
    String TYPE_TEXT = " TEXT ";
    String TYPE_REAL = " REAL ";
    String TYPE_FLOAT = " FLOAT ";
    String TYPE_BOOL = " BOOLEAN ";
    String TYPE_PK = " PRIMARY KEY ";
    String TYPE_AI = " AUTOINCREMENT ";

    String CMD_CREATE_TABLE_INE = " CREATE TABLE IF NOT EXISTS ";
    String CMD_ALTER_TABLE = " ALTER TABLE ";
    String CMD_ADD_COLUMN = " ADD COLUMN ";

    String LBR = " ( ";
    String RBR = " ) ";
    String COMMA = " , ";
    String SEMI = " ; ";
    String LIC = " '";
    String RIC = "' ";
    String AND = " AND ";
}
