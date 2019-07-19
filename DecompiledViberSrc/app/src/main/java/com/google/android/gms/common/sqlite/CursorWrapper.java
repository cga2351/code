package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class CursorWrapper extends android.database.CursorWrapper
  implements CrossProcessCursor
{
  private AbstractWindowedCursor zzez;

  @KeepForSdk
  public CursorWrapper(Cursor paramCursor)
  {
    super(paramCursor);
    int i = 0;
    Cursor localCursor;
    for (Object localObject = paramCursor; (i < 10) && ((localObject instanceof android.database.CursorWrapper)); localObject = localCursor)
    {
      localCursor = ((android.database.CursorWrapper)localObject).getWrappedCursor();
      i++;
    }
    if (!(localObject instanceof AbstractWindowedCursor))
    {
      String str1 = String.valueOf(localObject.getClass().getName());
      if (str1.length() != 0);
      for (String str2 = "Unknown type: ".concat(str1); ; str2 = new String("Unknown type: "))
        throw new IllegalArgumentException(str2);
    }
    this.zzez = ((AbstractWindowedCursor)localObject);
  }

  @KeepForSdk
  public void fillWindow(int paramInt, CursorWindow paramCursorWindow)
  {
    this.zzez.fillWindow(paramInt, paramCursorWindow);
  }

  @KeepForSdk
  public CursorWindow getWindow()
  {
    return this.zzez.getWindow();
  }

  public boolean onMove(int paramInt1, int paramInt2)
  {
    return this.zzez.onMove(paramInt1, paramInt2);
  }

  @KeepForSdk
  public void setWindow(CursorWindow paramCursorWindow)
  {
    this.zzez.setWindow(paramCursorWindow);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.sqlite.CursorWrapper
 * JD-Core Version:    0.6.2
 */