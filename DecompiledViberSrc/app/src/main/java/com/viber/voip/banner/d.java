package com.viber.voip.banner;

import android.content.Context;
import android.database.SQLException;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.banner.d.c;
import com.viber.voip.banner.d.f;
import com.viber.voip.banner.d.g;
import com.viber.voip.banner.d.h;
import com.viber.voip.banner.d.j;

public class d
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;

  public d(Context paramContext)
  {
    this.b = paramContext;
  }

  private com.viber.provider.b c()
  {
    return com.viber.provider.messages.b.d.a(this.b);
  }

  public int a(long paramLong)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Long.toString(paramLong);
    return c().a("remote_banners", "_id = ?", arrayOfString);
  }

  public int a(long paramLong, c paramc)
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = g.a.toString();
    arrayOfString[1] = paramc.toString();
    arrayOfString[2] = Long.toString(paramLong);
    return c().a("remote_banners", "type = ? AND position = ? AND token = ?", arrayOfString);
  }

  public long a()
  {
    com.viber.provider.b localb = c();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Long.toString(System.currentTimeMillis());
    return localb.a("remote_banners", "end_time < ?", arrayOfString);
  }

  public long a(com.viber.voip.banner.d.d paramd)
  {
    com.viber.provider.b localb = c();
    try
    {
      long l = localb.b("remote_banners", null, paramd.getContentValues());
      return l;
    }
    catch (SQLException localSQLException)
    {
    }
    return -1L;
  }

  public long a(f paramf)
  {
    com.viber.provider.b localb = c();
    String[] arrayOfString = new String[4];
    arrayOfString[0] = paramf.a().toString();
    arrayOfString[1] = paramf.i().toString();
    arrayOfString[2] = paramf.h().toString();
    arrayOfString[3] = Long.toString(System.currentTimeMillis());
    try
    {
      localb.a("remote_banners", "type = ? AND location = ? AND position = ? AND end_time > ?", arrayOfString);
      long l = localb.b("remote_banners", null, paramf.getContentValues());
      return l;
    }
    catch (SQLException localSQLException)
    {
    }
    return -1L;
  }

  public long a(g paramg)
  {
    com.viber.provider.b localb = c();
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramg.toString();
    arrayOfString[1] = Long.toString(System.currentTimeMillis());
    return localb.a("remote_banners", "type = ? AND end_time < ?", arrayOfString);
  }

  public long a(h paramh)
  {
    com.viber.provider.b localb = c();
    String[] arrayOfString = new String[3];
    arrayOfString[0] = paramh.a().toString();
    arrayOfString[1] = paramh.h().toString();
    arrayOfString[2] = Long.toString(System.currentTimeMillis());
    try
    {
      localb.a("remote_banners", "type = ? AND location = ? AND end_time > ?", arrayOfString);
      long l = localb.b("remote_banners", null, paramh.getContentValues());
      return l;
    }
    catch (SQLException localSQLException)
    {
    }
    return -1L;
  }

  // ERROR //
  public com.viber.voip.banner.d.d a(g paramg, String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokespecial 42	com/viber/voip/banner/d:c	()Lcom/viber/provider/b;
    //   7: astore 6
    //   9: iconst_4
    //   10: anewarray 34	java/lang/String
    //   13: astore 7
    //   15: aload 7
    //   17: iconst_0
    //   18: aload_1
    //   19: invokevirtual 60	com/viber/voip/banner/d/g:toString	()Ljava/lang/String;
    //   22: aastore
    //   23: aload 7
    //   25: iconst_1
    //   26: lload_3
    //   27: invokestatic 40	java/lang/Long:toString	(J)Ljava/lang/String;
    //   30: aastore
    //   31: aload 7
    //   33: iconst_2
    //   34: aload_2
    //   35: aastore
    //   36: aload 7
    //   38: iconst_3
    //   39: invokestatic 71	java/lang/System:currentTimeMillis	()J
    //   42: invokestatic 40	java/lang/Long:toString	(J)Ljava/lang/String;
    //   45: aastore
    //   46: aload 6
    //   48: ldc 44
    //   50: getstatic 129	com/viber/voip/banner/d/a:a	[Ljava/lang/String;
    //   53: ldc 131
    //   55: aload 7
    //   57: aconst_null
    //   58: aconst_null
    //   59: ldc 133
    //   61: ldc 135
    //   63: invokeinterface 138 9 0
    //   68: astore 9
    //   70: aload 9
    //   72: ifnull +32 -> 104
    //   75: aload 9
    //   77: invokeinterface 144 1 0
    //   82: ifeq +22 -> 104
    //   85: aload 9
    //   87: invokestatic 147	com/viber/voip/banner/d/a:c	(Landroid/database/Cursor;)Lcom/viber/voip/banner/d/d;
    //   90: astore 11
    //   92: aload 11
    //   94: astore 10
    //   96: aload 9
    //   98: invokestatic 152	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   101: aload 10
    //   103: areturn
    //   104: aconst_null
    //   105: astore 10
    //   107: goto -11 -> 96
    //   110: astore 8
    //   112: aload 5
    //   114: invokestatic 152	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   117: aload 8
    //   119: athrow
    //   120: astore 8
    //   122: aload 9
    //   124: astore 5
    //   126: goto -14 -> 112
    //
    // Exception table:
    //   from	to	target	type
    //   46	70	110	finally
    //   75	92	120	finally
  }

  // ERROR //
  public f a(g paramg, com.viber.voip.banner.d.b paramb, c paramc)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokespecial 42	com/viber/voip/banner/d:c	()Lcom/viber/provider/b;
    //   7: astore 5
    //   9: iconst_4
    //   10: anewarray 34	java/lang/String
    //   13: astore 6
    //   15: aload 6
    //   17: iconst_0
    //   18: aload_1
    //   19: invokevirtual 60	com/viber/voip/banner/d/g:toString	()Ljava/lang/String;
    //   22: aastore
    //   23: aload 6
    //   25: iconst_1
    //   26: aload_2
    //   27: invokevirtual 100	com/viber/voip/banner/d/b:toString	()Ljava/lang/String;
    //   30: aastore
    //   31: aload 6
    //   33: iconst_2
    //   34: aload_3
    //   35: invokevirtual 63	com/viber/voip/banner/d/c:toString	()Ljava/lang/String;
    //   38: aastore
    //   39: aload 6
    //   41: iconst_3
    //   42: invokestatic 71	java/lang/System:currentTimeMillis	()J
    //   45: invokestatic 40	java/lang/Long:toString	(J)Ljava/lang/String;
    //   48: aastore
    //   49: aload 5
    //   51: ldc 44
    //   53: getstatic 129	com/viber/voip/banner/d/a:a	[Ljava/lang/String;
    //   56: ldc 106
    //   58: aload 6
    //   60: aconst_null
    //   61: aconst_null
    //   62: ldc 133
    //   64: ldc 135
    //   66: invokeinterface 138 9 0
    //   71: astore 8
    //   73: aload 8
    //   75: ifnull +32 -> 107
    //   78: aload 8
    //   80: invokeinterface 144 1 0
    //   85: ifeq +22 -> 107
    //   88: aload 8
    //   90: invokestatic 156	com/viber/voip/banner/d/a:b	(Landroid/database/Cursor;)Lcom/viber/voip/banner/d/f;
    //   93: astore 10
    //   95: aload 10
    //   97: astore 9
    //   99: aload 8
    //   101: invokestatic 152	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   104: aload 9
    //   106: areturn
    //   107: aconst_null
    //   108: astore 9
    //   110: goto -11 -> 99
    //   113: astore 7
    //   115: aload 4
    //   117: invokestatic 152	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   120: aload 7
    //   122: athrow
    //   123: astore 7
    //   125: aload 8
    //   127: astore 4
    //   129: goto -14 -> 115
    //
    // Exception table:
    //   from	to	target	type
    //   49	73	113	finally
    //   78	95	123	finally
  }

  // ERROR //
  public h a(j paramj)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokespecial 42	com/viber/voip/banner/d:c	()Lcom/viber/provider/b;
    //   6: astore_3
    //   7: iconst_3
    //   8: anewarray 34	java/lang/String
    //   11: astore 4
    //   13: aload 4
    //   15: iconst_0
    //   16: getstatic 159	com/viber/voip/banner/d/g:b	Lcom/viber/voip/banner/d/g;
    //   19: invokevirtual 60	com/viber/voip/banner/d/g:toString	()Ljava/lang/String;
    //   22: aastore
    //   23: aload 4
    //   25: iconst_1
    //   26: aload_1
    //   27: invokevirtual 120	com/viber/voip/banner/d/j:toString	()Ljava/lang/String;
    //   30: aastore
    //   31: aload 4
    //   33: iconst_2
    //   34: invokestatic 71	java/lang/System:currentTimeMillis	()J
    //   37: invokestatic 40	java/lang/Long:toString	(J)Ljava/lang/String;
    //   40: aastore
    //   41: aload_3
    //   42: ldc 44
    //   44: getstatic 129	com/viber/voip/banner/d/a:a	[Ljava/lang/String;
    //   47: ldc 122
    //   49: aload 4
    //   51: aconst_null
    //   52: aconst_null
    //   53: ldc 133
    //   55: ldc 135
    //   57: invokeinterface 138 9 0
    //   62: astore 6
    //   64: aload 6
    //   66: ifnull +32 -> 98
    //   69: aload 6
    //   71: invokeinterface 144 1 0
    //   76: ifeq +22 -> 98
    //   79: aload 6
    //   81: invokestatic 162	com/viber/voip/banner/d/a:a	(Landroid/database/Cursor;)Lcom/viber/voip/banner/d/h;
    //   84: astore 8
    //   86: aload 8
    //   88: astore 7
    //   90: aload 6
    //   92: invokestatic 152	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   95: aload 7
    //   97: areturn
    //   98: aconst_null
    //   99: astore 7
    //   101: goto -11 -> 90
    //   104: astore 5
    //   106: aload_2
    //   107: invokestatic 152	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   110: aload 5
    //   112: athrow
    //   113: astore 5
    //   115: aload 6
    //   117: astore_2
    //   118: goto -12 -> 106
    //
    // Exception table:
    //   from	to	target	type
    //   41	64	104	finally
    //   69	86	113	finally
  }

  public void a(g paramg, long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = paramg.toString();
    arrayOfString[1] = Long.toString(paramLong);
    arrayOfString[2] = paramString;
    arrayOfString[3] = Long.toString(System.currentTimeMillis());
    com.viber.provider.b localb = c();
    if (paramBoolean);
    for (String str = "UPDATE %s SET %s=%s | (1 << %s) WHERE %s"; ; str = "UPDATE %s SET %s=%s & ~(1 << %s) WHERE %s")
    {
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = "remote_banners";
      arrayOfObject[1] = "flags";
      arrayOfObject[2] = "flags";
      arrayOfObject[3] = String.valueOf(paramInt);
      arrayOfObject[4] = "type = ? AND token = ? AND location = ? AND end_time > ?";
      localb.a(String.format(str, arrayOfObject), arrayOfString);
      return;
    }
  }

  public int b(long paramLong)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = g.b.toString();
    arrayOfString[1] = Long.toString(paramLong);
    return c().a("remote_banners", "type = ? AND token = ?", arrayOfString);
  }

  public long b()
  {
    return c().a("remote_banners", null, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.d
 * JD-Core Version:    0.6.2
 */