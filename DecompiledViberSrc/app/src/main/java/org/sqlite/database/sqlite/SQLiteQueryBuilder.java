package org.sqlite.database.sqlite;

import android.database.Cursor;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import org.sqlite.database.DatabaseUtils;
import org.sqlite.os.CancellationSignal;

public class SQLiteQueryBuilder
{
  private static final String TAG = "SQLiteQueryBuilder";
  private static final Pattern sLimitPattern = null;
  private boolean mDistinct = false;
  private SQLiteDatabase.CursorFactory mFactory = null;
  private Map<String, String> mProjectionMap = null;
  private boolean mStrict;
  private String mTables = "";
  private StringBuilder mWhereClause = null;

  private static void appendClause(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      paramStringBuilder.append(paramString1);
      paramStringBuilder.append(paramString2);
    }
  }

  public static void appendColumns(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramArrayOfString[j];
      if (str != null)
      {
        if (j > 0)
          paramStringBuilder.append(", ");
        paramStringBuilder.append(str);
      }
    }
    paramStringBuilder.append(' ');
  }

  public static String buildQueryString(boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    int i = 48;
    if (paramArrayOfString != null)
      i += 15 * paramArrayOfString.length;
    if (paramString2 != null)
      i += paramString2.length();
    if (paramString5 != null)
      i += paramString5.length();
    if (paramString3 != null)
      i += paramString3.length();
    StringBuilder localStringBuilder = new StringBuilder(i);
    localStringBuilder.append("SELECT ");
    if (paramBoolean)
      localStringBuilder.append("DISTINCT ");
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
      appendColumns(localStringBuilder, paramArrayOfString);
    while (true)
    {
      localStringBuilder.append("FROM ");
      localStringBuilder.append(paramString1);
      appendClause(localStringBuilder, " WHERE ", paramString2);
      appendClause(localStringBuilder, " GROUP BY ", paramString3);
      appendClause(localStringBuilder, " HAVING ", paramString4);
      appendClause(localStringBuilder, " ORDER BY ", paramString5);
      appendClause(localStringBuilder, " LIMIT ", paramString6);
      return localStringBuilder.toString();
      localStringBuilder.append("* ");
    }
  }

  private String[] computeProjection(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
      if (this.mProjectionMap != null)
      {
        String[] arrayOfString = new String[paramArrayOfString.length];
        int k = paramArrayOfString.length;
        int m = 0;
        if (m < k)
        {
          String str1 = paramArrayOfString[m];
          String str2 = (String)this.mProjectionMap.get(str1);
          if (str2 != null)
            arrayOfString[m] = str2;
          while (true)
          {
            m++;
            break;
            if ((this.mStrict) || ((!str1.contains(" AS ")) && (!str1.contains(" as "))))
              break label114;
            arrayOfString[m] = str1;
          }
          label114: throw new IllegalArgumentException("Invalid column " + paramArrayOfString[m]);
        }
        paramArrayOfString = arrayOfString;
      }
    while (true)
    {
      return paramArrayOfString;
      if (this.mProjectionMap == null)
        break;
      Set localSet = this.mProjectionMap.entrySet();
      paramArrayOfString = new String[localSet.size()];
      Iterator localIterator = localSet.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!((String)localEntry.getKey()).equals("_count"))
        {
          int j = i + 1;
          paramArrayOfString[i] = ((String)localEntry.getValue());
          i = j;
        }
      }
    }
    return null;
  }

  private void validateQuerySql(SQLiteDatabase paramSQLiteDatabase, String paramString, CancellationSignal paramCancellationSignal)
  {
    paramSQLiteDatabase.getThreadSession().prepare(paramString, paramSQLiteDatabase.getThreadDefaultConnectionFlags(true), paramCancellationSignal, null);
  }

  public void appendWhere(CharSequence paramCharSequence)
  {
    if (this.mWhereClause == null)
      this.mWhereClause = new StringBuilder(16 + paramCharSequence.length());
    if (this.mWhereClause.length() == 0)
      this.mWhereClause.append('(');
    this.mWhereClause.append(paramCharSequence);
  }

  public void appendWhereEscapeString(String paramString)
  {
    if (this.mWhereClause == null)
      this.mWhereClause = new StringBuilder(16 + paramString.length());
    if (this.mWhereClause.length() == 0)
      this.mWhereClause.append('(');
    DatabaseUtils.appendEscapedSQLString(this.mWhereClause, paramString);
  }

  public String buildQuery(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String[] arrayOfString = computeProjection(paramArrayOfString);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.mWhereClause != null) && (this.mWhereClause.length() > 0));
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
      {
        localStringBuilder.append(this.mWhereClause.toString());
        localStringBuilder.append(')');
      }
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        if (i != 0)
          localStringBuilder.append(" AND ");
        localStringBuilder.append('(');
        localStringBuilder.append(paramString1);
        localStringBuilder.append(')');
      }
      return buildQueryString(this.mDistinct, this.mTables, arrayOfString, localStringBuilder.toString(), paramString2, paramString3, paramString4, paramString5);
    }
  }

  @Deprecated
  public String buildQuery(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return buildQuery(paramArrayOfString1, paramString1, paramString2, paramString3, paramString4, paramString5);
  }

  public String buildUnionQuery(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    int i = paramArrayOfString.length;
    if (this.mDistinct);
    for (String str = " UNION "; ; str = " UNION ALL ")
      for (int j = 0; j < i; j++)
      {
        if (j > 0)
          localStringBuilder.append(str);
        localStringBuilder.append(paramArrayOfString[j]);
      }
    appendClause(localStringBuilder, " ORDER BY ", paramString1);
    appendClause(localStringBuilder, " LIMIT ", paramString2);
    return localStringBuilder.toString();
  }

  public String buildUnionSubQuery(String paramString1, String[] paramArrayOfString, Set<String> paramSet, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    int i = paramArrayOfString.length;
    String[] arrayOfString = new String[i];
    int j = 0;
    if (j < i)
    {
      String str = paramArrayOfString[j];
      if (str.equals(paramString1))
        arrayOfString[j] = ("'" + paramString2 + "' AS " + paramString1);
      while (true)
      {
        j++;
        break;
        if ((j <= paramInt) || (paramSet.contains(str)))
          arrayOfString[j] = str;
        else
          arrayOfString[j] = ("NULL AS " + str);
      }
    }
    return buildQuery(arrayOfString, paramString3, paramString4, paramString5, null, null);
  }

  @Deprecated
  public String buildUnionSubQuery(String paramString1, String[] paramArrayOfString1, Set<String> paramSet, int paramInt, String paramString2, String paramString3, String[] paramArrayOfString2, String paramString4, String paramString5)
  {
    return buildUnionSubQuery(paramString1, paramArrayOfString1, paramSet, paramInt, paramString2, paramString3, paramString4, paramString5);
  }

  public String getTables()
  {
    return this.mTables;
  }

  public Cursor query(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4)
  {
    return query(paramSQLiteDatabase, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, paramString4, null, null);
  }

  public Cursor query(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return query(paramSQLiteDatabase, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, paramString4, paramString5, null);
  }

  public Cursor query(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5, CancellationSignal paramCancellationSignal)
  {
    if (this.mTables == null)
      return null;
    if ((this.mStrict) && (paramString1 != null) && (paramString1.length() > 0))
      validateQuerySql(paramSQLiteDatabase, buildQuery(paramArrayOfString1, "(" + paramString1 + ")", paramString2, paramString3, paramString4, paramString5), paramCancellationSignal);
    String str = buildQuery(paramArrayOfString1, paramString1, paramString2, paramString3, paramString4, paramString5);
    return paramSQLiteDatabase.rawQueryWithFactory(this.mFactory, str, paramArrayOfString2, paramCancellationSignal);
  }

  public void setCursorFactory(SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    this.mFactory = paramCursorFactory;
  }

  public void setDistinct(boolean paramBoolean)
  {
    this.mDistinct = paramBoolean;
  }

  public void setProjectionMap(Map<String, String> paramMap)
  {
    this.mProjectionMap = paramMap;
  }

  public void setStrict(boolean paramBoolean)
  {
    this.mStrict = paramBoolean;
  }

  public void setTables(String paramString)
  {
    this.mTables = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteQueryBuilder
 * JD-Core Version:    0.6.2
 */