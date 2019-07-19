package android.support.v4.database;

import android.database.CursorWindow;
import android.os.Build.VERSION;

public final class CursorWindowCompat
{
  public static CursorWindow create(String paramString, long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 28)
      return new CursorWindow(paramString, paramLong);
    if (Build.VERSION.SDK_INT >= 15)
      return new CursorWindow(paramString);
    return new CursorWindow(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.database.CursorWindowCompat
 * JD-Core Version:    0.6.2
 */