package org.sqlite.database.sqlite;

import android.content.ContentResolver;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import org.sqlite.database.DatabaseUtils;

public class SQLiteCursor extends SQLiteAbstractWindowedCursor
{
  static final int NO_COUNT = -1;
  static final String TAG = "SQLiteCursor";
  private Map<String, Integer> mColumnNameMap;
  private final String[] mColumns;
  private int mCount = -1;
  private int mCursorWindowCapacity;
  private final SQLiteCursorDriver mDriver;
  private final SQLiteQuery mQuery;

  public SQLiteCursor(SQLiteCursorDriver paramSQLiteCursorDriver, SQLiteQuery paramSQLiteQuery)
  {
    if (paramSQLiteQuery == null)
      throw new IllegalArgumentException("query object cannot be null");
    this.mDriver = paramSQLiteCursorDriver;
    this.mColumnNameMap = null;
    this.mQuery = paramSQLiteQuery;
    this.mColumns = paramSQLiteQuery.getColumnNames();
  }

  private void awc_closeWindow()
  {
    setWindow(null);
  }

  private void fillWindow(int paramInt)
  {
    awc_clearOrCreateWindow();
    try
    {
      if (this.mCount == -1)
      {
        int j = DatabaseUtils.cursorPickFillWindowStartPosition(paramInt, 0);
        this.mCount = this.mQuery.fillWindow(this.mWindow, j, paramInt, true);
        this.mCursorWindowCapacity = this.mWindow.getNumRows();
        return;
      }
      int i = DatabaseUtils.cursorPickFillWindowStartPosition(paramInt, this.mCursorWindowCapacity);
      this.mQuery.fillWindow(this.mWindow, i, paramInt, false);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      awc_closeWindow();
      throw localRuntimeException;
    }
  }

  protected void awc_clearOrCreateWindow()
  {
    CursorWindow localCursorWindow = getSQLiteWindow();
    if (localCursorWindow == null)
    {
      setWindow(new CursorWindow());
      return;
    }
    localCursorWindow.clear();
  }

  public void close()
  {
    try
    {
      super.close();
      try
      {
        this.mQuery.close();
        this.mDriver.cursorClosed();
        return;
      }
      finally
      {
      }
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void deactivate()
  {
    super.deactivate();
    this.mDriver.cursorDeactivated();
  }

  protected void finalize()
  {
    try
    {
      if (this.mWindow != null)
        close();
      return;
    }
    finally
    {
      super.finalize();
    }
  }

  public int getColumnIndex(String paramString)
  {
    if (this.mColumnNameMap == null)
    {
      String[] arrayOfString = this.mColumns;
      int j = arrayOfString.length;
      HashMap localHashMap = new HashMap(j, 1.0F);
      for (int k = 0; k < j; k++)
        localHashMap.put(arrayOfString[k], Integer.valueOf(k));
      this.mColumnNameMap = localHashMap;
    }
    int i = paramString.lastIndexOf('.');
    if (i != -1)
      paramString = paramString.substring(i + 1);
    Integer localInteger = (Integer)this.mColumnNameMap.get(paramString);
    if (localInteger != null)
      return localInteger.intValue();
    return -1;
  }

  public String[] getColumnNames()
  {
    return this.mColumns;
  }

  public int getCount()
  {
    if (this.mCount == -1)
      fillWindow(0);
    return this.mCount;
  }

  public SQLiteDatabase getDatabase()
  {
    return this.mQuery.getDatabase();
  }

  public Uri getNotificationUri()
  {
    return null;
  }

  public boolean onMove(int paramInt1, int paramInt2)
  {
    if ((this.mWindow == null) || (paramInt2 < this.mWindow.getStartPosition()) || (paramInt2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows()))
      fillWindow(paramInt2);
    return true;
  }

  public boolean requery()
  {
    if (isClosed())
      return false;
    try
    {
      if (!this.mQuery.getDatabase().isOpen())
        return false;
    }
    finally
    {
    }
    if (this.mWindow != null)
      this.mWindow.clear();
    this.mPos = -1;
    this.mCount = -1;
    this.mDriver.cursorRequeried(this);
    try
    {
      boolean bool = super.requery();
      return bool;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
    return false;
  }

  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
  }

  public void setSelectionArguments(String[] paramArrayOfString)
  {
    this.mDriver.setBindArguments(paramArrayOfString);
  }

  public void setWindow(CursorWindow paramCursorWindow)
  {
    super.setWindow(paramCursorWindow);
    this.mCount = -1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteCursor
 * JD-Core Version:    0.6.2
 */