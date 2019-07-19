package org.sqlite.database.sqlite;

import android.database.CharArrayBuffer;
import android.os.Build.VERSION;

public abstract class SQLiteAbstractWindowedCursor extends SQLiteAbstractCursor
{
  protected CursorWindow mWindow;

  protected void checkPosition()
  {
    super.checkPosition();
    if (this.mWindow == null)
      throw new RuntimeException("Attempting to access a closed CursorWindow.Most probable cause: cursor is deactivated prior to calling this method.");
  }

  protected void clearOrCreateWindow()
  {
    if (this.mWindow == null)
    {
      this.mWindow = new CursorWindow();
      return;
    }
    this.mWindow.clear();
  }

  protected void closeWindow()
  {
    if (this.mWindow != null)
    {
      if (Build.VERSION.SDK_INT < 16)
        break label28;
      this.mWindow.close();
    }
    while (true)
    {
      this.mWindow = null;
      return;
      label28: this.mWindow.releaseReference();
    }
  }

  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    checkPosition();
    this.mWindow.copyStringToBuffer(this.mPos, paramInt, paramCharArrayBuffer);
  }

  public byte[] getBlob(int paramInt)
  {
    checkPosition();
    return this.mWindow.getBlob(this.mPos, paramInt);
  }

  public double getDouble(int paramInt)
  {
    checkPosition();
    return this.mWindow.getDouble(this.mPos, paramInt);
  }

  public float getFloat(int paramInt)
  {
    checkPosition();
    return this.mWindow.getFloat(this.mPos, paramInt);
  }

  public int getInt(int paramInt)
  {
    checkPosition();
    return this.mWindow.getInt(this.mPos, paramInt);
  }

  public long getLong(int paramInt)
  {
    checkPosition();
    return this.mWindow.getLong(this.mPos, paramInt);
  }

  public CursorWindow getSQLiteWindow()
  {
    return this.mWindow;
  }

  public short getShort(int paramInt)
  {
    checkPosition();
    return this.mWindow.getShort(this.mPos, paramInt);
  }

  public String getString(int paramInt)
  {
    checkPosition();
    return this.mWindow.getString(this.mPos, paramInt);
  }

  public int getType(int paramInt)
  {
    checkPosition();
    return this.mWindow.getType(this.mPos, paramInt);
  }

  public boolean hasWindow()
  {
    return this.mWindow != null;
  }

  @Deprecated
  public boolean isBlob(int paramInt)
  {
    return getType(paramInt) == 4;
  }

  @Deprecated
  public boolean isFloat(int paramInt)
  {
    return getType(paramInt) == 2;
  }

  @Deprecated
  public boolean isLong(int paramInt)
  {
    return getType(paramInt) == 1;
  }

  public boolean isNull(int paramInt)
  {
    checkPosition();
    return this.mWindow.getType(this.mPos, paramInt) == 0;
  }

  @Deprecated
  public boolean isString(int paramInt)
  {
    return getType(paramInt) == 3;
  }

  protected void onDeactivateOrClose()
  {
    closeWindow();
  }

  public void setWindow(CursorWindow paramCursorWindow)
  {
    if (paramCursorWindow != this.mWindow)
    {
      closeWindow();
      this.mWindow = paramCursorWindow;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteAbstractWindowedCursor
 * JD-Core Version:    0.6.2
 */