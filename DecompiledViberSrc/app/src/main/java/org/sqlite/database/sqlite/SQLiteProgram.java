package org.sqlite.database.sqlite;

import java.util.Arrays;
import org.sqlite.database.DatabaseUtils;
import org.sqlite.os.CancellationSignal;

public abstract class SQLiteProgram extends SQLiteClosable
{
  private static final String[] EMPTY_STRING_ARRAY = new String[0];
  private final Object[] mBindArgs;
  private final String[] mColumnNames;
  private final SQLiteDatabase mDatabase;
  private final int mNumParameters;
  private final boolean mReadOnly;
  private final String mSql;
  protected final int mSqlType;

  SQLiteProgram(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    this.mDatabase = paramSQLiteDatabase;
    this.mSql = paramString.trim();
    this.mSqlType = DatabaseUtils.getSqlStatementType(this.mSql);
    switch (this.mSqlType)
    {
    default:
      if (this.mSqlType != i)
        break;
    case 4:
    case 5:
    case 6:
    }
    while (true)
    {
      SQLiteStatementInfo localSQLiteStatementInfo = new SQLiteStatementInfo();
      paramSQLiteDatabase.getThreadSession().prepare(this.mSql, paramSQLiteDatabase.getThreadDefaultConnectionFlags(i), paramCancellationSignal, localSQLiteStatementInfo);
      this.mReadOnly = localSQLiteStatementInfo.readOnly;
      this.mColumnNames = localSQLiteStatementInfo.columnNames;
      for (this.mNumParameters = localSQLiteStatementInfo.numParameters; (paramArrayOfObject != null) && (paramArrayOfObject.length > this.mNumParameters); this.mNumParameters = 0)
      {
        throw new IllegalArgumentException("Too many bind arguments.  " + paramArrayOfObject.length + " arguments were provided but the statement needs " + this.mNumParameters + " arguments.");
        this.mReadOnly = false;
        this.mColumnNames = EMPTY_STRING_ARRAY;
      }
      int j = 0;
    }
    if (this.mNumParameters != 0)
    {
      this.mBindArgs = new Object[this.mNumParameters];
      if (paramArrayOfObject != null)
        System.arraycopy(paramArrayOfObject, 0, this.mBindArgs, 0, paramArrayOfObject.length);
      return;
    }
    this.mBindArgs = null;
  }

  private void bind(int paramInt, Object paramObject)
  {
    if ((paramInt < 1) || (paramInt > this.mNumParameters))
      throw new IllegalArgumentException("Cannot bind argument at index " + paramInt + " because the index is out of range.  The statement has " + this.mNumParameters + " parameters.");
    this.mBindArgs[(paramInt - 1)] = paramObject;
  }

  public void bindAllArgsAsStrings(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
      for (int i = paramArrayOfString.length; i != 0; i--)
        bindString(i, paramArrayOfString[(i - 1)]);
  }

  public void bindBlob(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("the bind value at index " + paramInt + " is null");
    bind(paramInt, paramArrayOfByte);
  }

  public void bindDouble(int paramInt, double paramDouble)
  {
    bind(paramInt, Double.valueOf(paramDouble));
  }

  public void bindLong(int paramInt, long paramLong)
  {
    bind(paramInt, Long.valueOf(paramLong));
  }

  public void bindNull(int paramInt)
  {
    bind(paramInt, null);
  }

  public void bindString(int paramInt, String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("the bind value at index " + paramInt + " is null");
    bind(paramInt, paramString);
  }

  public void clearBindings()
  {
    if (this.mBindArgs != null)
      Arrays.fill(this.mBindArgs, null);
  }

  final Object[] getBindArgs()
  {
    return this.mBindArgs;
  }

  final String[] getColumnNames()
  {
    return this.mColumnNames;
  }

  protected final int getConnectionFlags()
  {
    return this.mDatabase.getThreadDefaultConnectionFlags(this.mReadOnly);
  }

  final SQLiteDatabase getDatabase()
  {
    return this.mDatabase;
  }

  protected final SQLiteSession getSession()
  {
    return this.mDatabase.getThreadSession();
  }

  final String getSql()
  {
    return this.mSql;
  }

  @Deprecated
  public final int getUniqueId()
  {
    return -1;
  }

  protected void onAllReferencesReleased()
  {
    clearBindings();
  }

  protected final void onCorruption()
  {
    this.mDatabase.onCorruption();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteProgram
 * JD-Core Version:    0.6.2
 */