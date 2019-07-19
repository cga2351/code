package me.leolin.shortcutbadger.a;

import android.database.Cursor;

public class b
{
  public static void a(Cursor paramCursor)
  {
    if ((paramCursor != null) && (!paramCursor.isClosed()))
      paramCursor.close();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.leolin.shortcutbadger.a.b
 * JD-Core Version:    0.6.2
 */