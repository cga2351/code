package com.viber.voip.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import d.c.a;
import d.d.b.h;
import java.io.Closeable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class y
{
  public static final int a(@NotNull ContentResolver paramContentResolver, @NotNull Uri paramUri, @Nullable String paramString1, @Nullable String[] paramArrayOfString, @Nullable String paramString2)
  {
    h.b(paramContentResolver, "contentResolver");
    h.b(paramUri, "contentUri");
    Closeable localCloseable = (Closeable)paramContentResolver.query(paramUri, new String[] { "COUNT(*)" }, paramString1, paramArrayOfString, paramString2);
    Throwable localThrowable1 = (Throwable)null;
    try
    {
      Cursor localCursor = (Cursor)localCloseable;
      int i;
      if (af.c(localCursor))
      {
        if (localCursor == null)
          h.a();
        i = localCursor.getInt(0);
      }
      for (int j = i; ; j = -1)
        return j;
    }
    catch (Throwable localThrowable2)
    {
      throw localThrowable2;
    }
    finally
    {
      a.a(localCloseable, localThrowable2);
    }
  }

  public static final int a(@NotNull ContentResolver paramContentResolver, @NotNull Uri paramUri, @NotNull String[] paramArrayOfString1, @Nullable String paramString1, @Nullable String[] paramArrayOfString2, @Nullable String paramString2)
  {
    h.b(paramContentResolver, "contentResolver");
    h.b(paramUri, "contentUri");
    h.b(paramArrayOfString1, "projections");
    Closeable localCloseable = (Closeable)paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    Throwable localThrowable1 = (Throwable)null;
    try
    {
      Cursor localCursor = (Cursor)localCloseable;
      int i;
      if (localCursor != null)
        i = localCursor.getCount();
      for (int j = i; ; j = -1)
        return j;
    }
    catch (Throwable localThrowable2)
    {
      throw localThrowable2;
    }
    finally
    {
      a.a(localCloseable, localThrowable2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.y
 * JD-Core Version:    0.6.2
 */