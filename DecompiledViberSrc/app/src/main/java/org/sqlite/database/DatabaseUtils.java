package org.sqlite.database;

import java.util.Locale;
import org.sqlite.database.sqlite.SQLiteDatabase;
import org.sqlite.database.sqlite.SQLiteStatement;

public final class DatabaseUtils
{
  public static final int STATEMENT_ABORT = 6;
  public static final int STATEMENT_ATTACH = 3;
  public static final int STATEMENT_BEGIN = 4;
  public static final int STATEMENT_COMMIT = 5;
  public static final int STATEMENT_DDL = 8;
  public static final int STATEMENT_OTHER = 99;
  public static final int STATEMENT_PRAGMA = 7;
  public static final int STATEMENT_SELECT = 1;
  public static final int STATEMENT_UNPREPARED = 9;
  public static final int STATEMENT_UPDATE = 2;

  public static void appendEscapedSQLString(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('\'');
    if (paramString.indexOf('\'') != -1)
    {
      int i = paramString.length();
      for (int j = 0; j < i; j++)
      {
        char c = paramString.charAt(j);
        if (c == '\'')
          paramStringBuilder.append('\'');
        paramStringBuilder.append(c);
      }
    }
    paramStringBuilder.append(paramString);
    paramStringBuilder.append('\'');
  }

  public static int cursorPickFillWindowStartPosition(int paramInt1, int paramInt2)
  {
    return Math.max(paramInt1 - paramInt2 / 3, 0);
  }

  public static int findRowIdColumnIndex(String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
      if (paramArrayOfString[j].equals("_id"))
        return j;
    return -1;
  }

  public static int getSqlStatementType(String paramString)
  {
    String str1 = paramString.trim();
    if (str1.length() < 3);
    String str2;
    do
    {
      return 99;
      str2 = str1.substring(0, 3).toUpperCase(Locale.ROOT);
      if (str2.equals("SEL"))
        return 1;
      if ((str2.equals("INS")) || (str2.equals("UPD")) || (str2.equals("REP")) || (str2.equals("DEL")))
        return 2;
      if (str2.equals("COM"))
        return 5;
      if (str2.equals("END"))
        return 5;
      if (str2.equals("ROL"))
        return 6;
      if (str2.equals("BEG"))
        return 4;
      if (str2.equals("PRA"))
        return 7;
      if ((str2.equals("CRE")) || (str2.equals("DRO")) || (str2.equals("ALT")))
        return 8;
      if ((str2.equals("ANA")) || (str2.equals("DET")))
        return 9;
    }
    while (!str2.equals("ATT"));
    return 3;
  }

  public static int getTypeOfObject(Object paramObject)
  {
    int i = 3;
    if (paramObject == null)
      i = 0;
    do
    {
      do
        return i;
      while ((paramObject instanceof String));
      if (((paramObject instanceof Long)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Short)) || ((paramObject instanceof Byte)))
        return 1;
      if ((paramObject instanceof byte[]))
        return 4;
    }
    while ((!(paramObject instanceof Float)) && (!(paramObject instanceof Double)));
    return 2;
  }

  public static long longForQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    SQLiteStatement localSQLiteStatement = paramSQLiteDatabase.compileStatement(paramString);
    try
    {
      long l = longForQuery(localSQLiteStatement, paramArrayOfString);
      return l;
    }
    finally
    {
      localSQLiteStatement.close();
    }
  }

  public static long longForQuery(SQLiteStatement paramSQLiteStatement, String[] paramArrayOfString)
  {
    paramSQLiteStatement.bindAllArgsAsStrings(paramArrayOfString);
    return paramSQLiteStatement.simpleQueryForLong();
  }

  public static String stringForQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    SQLiteStatement localSQLiteStatement = paramSQLiteDatabase.compileStatement(paramString);
    try
    {
      String str = stringForQuery(localSQLiteStatement, paramArrayOfString);
      return str;
    }
    finally
    {
      localSQLiteStatement.close();
    }
  }

  public static String stringForQuery(SQLiteStatement paramSQLiteStatement, String[] paramArrayOfString)
  {
    paramSQLiteStatement.bindAllArgsAsStrings(paramArrayOfString);
    return paramSQLiteStatement.simpleQueryForString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.DatabaseUtils
 * JD-Core Version:    0.6.2
 */