package com.viber.voip.block;

import android.database.Cursor;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class r
{
  public static final String[] a = { "_id", "type", "data_1", "data_2", "data_3" };
  private static final Logger b = ViberEnv.getLogger();
  private long c;
  private int d;
  private b e;

  public r(Cursor paramCursor)
  {
    a(this, paramCursor);
  }

  private static void a(r paramr, Cursor paramCursor)
  {
    paramr.c = paramCursor.getLong(0);
    paramr.d = paramCursor.getInt(1);
    if (paramr.a() == 0)
      paramr.e = new c(Long.valueOf(paramCursor.getString(2)).longValue(), paramCursor.getString(3), paramCursor.getString(4));
    while (1 != paramr.a())
      return;
    paramr.e = new a(Integer.valueOf(paramCursor.getString(2)).intValue(), paramCursor.getString(3));
  }

  public int a()
  {
    return this.d;
  }

  public b b()
  {
    return this.e;
  }

  public static class a
    implements r.b
  {
    public int a;
    public String b;

    public a(int paramInt, String paramString)
    {
      this.a = paramInt;
      this.b = paramString;
    }
  }

  private static abstract interface b
  {
  }

  public static class c
    implements r.b
  {
    public long a;
    public String b;
    public String c;

    public c(long paramLong, String paramString1, String paramString2)
    {
      this.a = paramLong;
      this.b = paramString1;
      this.c = paramString2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.block.r
 * JD-Core Version:    0.6.2
 */