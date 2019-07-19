package org.sqlite.database.sqlite;

import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.os.Bundle;

public abstract class SQLiteAbstractCursor
  implements Cursor
{
  private static final String TAG = "SQLiteAbstractCursor";

  @Deprecated
  protected boolean mClosed;
  private final ContentObservable mContentObservable = new ContentObservable();
  private final DataSetObservable mDataSetObservable = new DataSetObservable();
  private Bundle mExtras = Bundle.EMPTY;

  @Deprecated
  protected int mPos = -1;

  protected void checkPosition()
  {
    if ((-1 == this.mPos) || (getCount() == this.mPos))
      throw new CursorIndexOutOfBoundsException(this.mPos, getCount());
  }

  public void close()
  {
    try
    {
      this.mClosed = true;
      this.mContentObservable.unregisterAll();
      onDeactivateOrClose();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    String str = getString(paramInt);
    if (str != null)
    {
      char[] arrayOfChar = paramCharArrayBuffer.data;
      if ((arrayOfChar == null) || (arrayOfChar.length < str.length()))
        paramCharArrayBuffer.data = str.toCharArray();
      while (true)
      {
        paramCharArrayBuffer.sizeCopied = str.length();
        return;
        str.getChars(0, str.length(), arrayOfChar, 0);
      }
    }
    paramCharArrayBuffer.sizeCopied = 0;
  }

  public void deactivate()
  {
    onDeactivateOrClose();
  }

  protected void finalize()
  {
    try
    {
      if (!this.mClosed)
        close();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public byte[] getBlob(int paramInt)
  {
    throw new UnsupportedOperationException("getBlob is not supported");
  }

  public int getColumnCount()
  {
    return getColumnNames().length;
  }

  public int getColumnIndex(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    if (i != -1)
      paramString = paramString.substring(i + 1);
    String[] arrayOfString = getColumnNames();
    int j = arrayOfString.length;
    for (int k = 0; k < j; k++)
      if (arrayOfString[k].equalsIgnoreCase(paramString))
        return k;
    return -1;
  }

  public int getColumnIndexOrThrow(String paramString)
  {
    int i = getColumnIndex(paramString);
    if (i < 0)
      throw new IllegalArgumentException("column '" + paramString + "' does not exist");
    return i;
  }

  public String getColumnName(int paramInt)
  {
    return getColumnNames()[paramInt];
  }

  public abstract String[] getColumnNames();

  public abstract int getCount();

  public abstract double getDouble(int paramInt);

  public Bundle getExtras()
  {
    return this.mExtras;
  }

  public abstract float getFloat(int paramInt);

  public abstract int getInt(int paramInt);

  public abstract long getLong(int paramInt);

  public final int getPosition()
  {
    return this.mPos;
  }

  public abstract short getShort(int paramInt);

  public abstract String getString(int paramInt);

  public int getType(int paramInt)
  {
    return 3;
  }

  public boolean getWantsAllOnMoveCalls()
  {
    return false;
  }

  public final boolean isAfterLast()
  {
    int i = getCount();
    return (i == 0) || (this.mPos == i);
  }

  public final boolean isBeforeFirst()
  {
    return (getCount() == 0) || (this.mPos == -1);
  }

  public boolean isClosed()
  {
    return this.mClosed;
  }

  public final boolean isFirst()
  {
    return (this.mPos == 0) && (getCount() != 0);
  }

  public final boolean isLast()
  {
    int i = getCount();
    return (this.mPos == i - 1) && (i != 0);
  }

  public abstract boolean isNull(int paramInt);

  public final boolean move(int paramInt)
  {
    return moveToPosition(paramInt + this.mPos);
  }

  public final boolean moveToFirst()
  {
    return moveToPosition(0);
  }

  public final boolean moveToLast()
  {
    return moveToPosition(-1 + getCount());
  }

  public final boolean moveToNext()
  {
    return moveToPosition(1 + this.mPos);
  }

  public final boolean moveToPosition(int paramInt)
  {
    int i = getCount();
    if (paramInt >= i)
    {
      this.mPos = i;
      return false;
    }
    if (paramInt < 0)
    {
      this.mPos = -1;
      return false;
    }
    if (paramInt == this.mPos)
      return true;
    boolean bool = onMove(this.mPos, paramInt);
    if (!bool)
    {
      this.mPos = -1;
      return bool;
    }
    this.mPos = paramInt;
    return bool;
  }

  public final boolean moveToPrevious()
  {
    return moveToPosition(-1 + this.mPos);
  }

  protected void onChange(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.mContentObservable.dispatchChange(paramBoolean, null);
      return;
    }
    this.mContentObservable.dispatchChange(paramBoolean);
  }

  protected void onDeactivateOrClose()
  {
    this.mDataSetObservable.notifyInvalidated();
  }

  public boolean onMove(int paramInt1, int paramInt2)
  {
    return true;
  }

  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    this.mContentObservable.registerObserver(paramContentObserver);
  }

  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mDataSetObservable.registerObserver(paramDataSetObserver);
  }

  public boolean requery()
  {
    this.mDataSetObservable.notifyChanged();
    return true;
  }

  public Bundle respond(Bundle paramBundle)
  {
    return Bundle.EMPTY;
  }

  public void setExtras(Bundle paramBundle)
  {
    if (paramBundle == null)
      paramBundle = Bundle.EMPTY;
    this.mExtras = paramBundle;
  }

  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    if (!this.mClosed)
      this.mContentObservable.unregisterObserver(paramContentObserver);
  }

  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mDataSetObservable.unregisterObserver(paramDataSetObserver);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteAbstractCursor
 * JD-Core Version:    0.6.2
 */