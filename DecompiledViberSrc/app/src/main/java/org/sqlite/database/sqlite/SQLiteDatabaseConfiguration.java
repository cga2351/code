package org.sqlite.database.sqlite;

import java.util.ArrayList;
import java.util.Locale;

public final class SQLiteDatabaseConfiguration
{
  public static final String MEMORY_DB_PATH = ":memory:";
  public final ArrayList<SQLiteCustomFunction> customFunctions = new ArrayList();
  public boolean foreignKeyConstraintsEnabled;
  public final String label;
  public Locale locale;
  boolean mEnableJournalSizeLimit;
  public int maxSqlCacheSize;
  public int openFlags;
  public final String path;

  public SQLiteDatabaseConfiguration(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null)
      throw new IllegalArgumentException("path must not be null.");
    this.mEnableJournalSizeLimit = paramBoolean;
    this.path = paramString;
    this.label = paramString;
    this.openFlags = paramInt;
    this.maxSqlCacheSize = 50;
    this.locale = Locale.getDefault();
  }

  public SQLiteDatabaseConfiguration(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    if (paramSQLiteDatabaseConfiguration == null)
      throw new IllegalArgumentException("other must not be null.");
    this.path = paramSQLiteDatabaseConfiguration.path;
    this.label = paramSQLiteDatabaseConfiguration.label;
    updateParametersFrom(paramSQLiteDatabaseConfiguration);
  }

  public boolean isEnableJournalSizeLimit()
  {
    return this.mEnableJournalSizeLimit;
  }

  public boolean isInMemoryDb()
  {
    return this.path.equalsIgnoreCase(":memory:");
  }

  public void updateParametersFrom(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    if (paramSQLiteDatabaseConfiguration == null)
      throw new IllegalArgumentException("other must not be null.");
    if (!this.path.equals(paramSQLiteDatabaseConfiguration.path))
      throw new IllegalArgumentException("other configuration must refer to the same database.");
    this.mEnableJournalSizeLimit = paramSQLiteDatabaseConfiguration.mEnableJournalSizeLimit;
    this.openFlags = paramSQLiteDatabaseConfiguration.openFlags;
    this.maxSqlCacheSize = paramSQLiteDatabaseConfiguration.maxSqlCacheSize;
    this.locale = paramSQLiteDatabaseConfiguration.locale;
    this.foreignKeyConstraintsEnabled = paramSQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled;
    this.customFunctions.clear();
    this.customFunctions.addAll(paramSQLiteDatabaseConfiguration.customFunctions);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteDatabaseConfiguration
 * JD-Core Version:    0.6.2
 */