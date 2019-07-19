package org.sqlite.database.sqlite;

public class CustomWindowSizeSQLiteCursor extends SQLiteCursor
{
  private final int mWindowSize;

  public CustomWindowSizeSQLiteCursor(int paramInt, SQLiteCursorDriver paramSQLiteCursorDriver, SQLiteQuery paramSQLiteQuery)
  {
    super(paramSQLiteCursorDriver, paramSQLiteQuery);
    this.mWindowSize = paramInt;
  }

  protected void awc_clearOrCreateWindow()
  {
    CursorWindow localCursorWindow = getSQLiteWindow();
    if (localCursorWindow == null)
    {
      setWindow(new CursorWindow(this.mWindowSize));
      return;
    }
    localCursorWindow.clear();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.CustomWindowSizeSQLiteCursor
 * JD-Core Version:    0.6.2
 */