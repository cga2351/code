package com.viber.backup;

import android.content.Context;
import com.google.d.a.c;
import com.google.d.c.a;
import com.google.d.f;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.p;
import com.viber.voip.registration.s.a;
import com.viber.voip.util.da;
import com.viber.voip.util.z;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class d
{
  private static final Logger a = ViberEnv.getLogger();
  private final f b;
  private final List<a> c = new ArrayList();
  private String d;

  public d(Context paramContext, f paramf)
  {
    this.b = paramf;
    this.d = (p.a(paramContext) + "_ibd");
  }

  private Type e()
  {
    return new a()
    {
    }
    .getType();
  }

  // ERROR //
  public void a()
  {
    // Byte code:
    //   0: new 70	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 54	com/viber/backup/d:d	Ljava/lang/String;
    //   8: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: invokestatic 79	com/viber/voip/util/at:f	(Ljava/io/File;)Z
    //   16: pop
    //   17: aload_0
    //   18: getfield 32	com/viber/backup/d:c	Ljava/util/List;
    //   21: invokeinterface 85 1 0
    //   26: ifeq +4 -> 30
    //   29: return
    //   30: new 87	java/io/FileWriter
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 90	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   38: astore_3
    //   39: aload_0
    //   40: getfield 34	com/viber/backup/d:b	Lcom/google/d/f;
    //   43: aload_0
    //   44: getfield 32	com/viber/backup/d:c	Ljava/util/List;
    //   47: aload_0
    //   48: invokespecial 92	com/viber/backup/d:e	()Ljava/lang/reflect/Type;
    //   51: aload_3
    //   52: invokevirtual 97	com/google/d/f:a	(Ljava/lang/Object;Ljava/lang/reflect/Type;Ljava/lang/Appendable;)V
    //   55: aload_3
    //   56: ifnull -27 -> 29
    //   59: iconst_0
    //   60: ifeq +17 -> 77
    //   63: aload_3
    //   64: invokevirtual 100	java/io/FileWriter:close	()V
    //   67: return
    //   68: astore 10
    //   70: aconst_null
    //   71: aload 10
    //   73: invokevirtual 104	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   76: return
    //   77: aload_3
    //   78: invokevirtual 100	java/io/FileWriter:close	()V
    //   81: return
    //   82: astore 8
    //   84: aload 8
    //   86: athrow
    //   87: astore 9
    //   89: aload 8
    //   91: astore 5
    //   93: aload 9
    //   95: astore 4
    //   97: aload_3
    //   98: ifnull +12 -> 110
    //   101: aload 5
    //   103: ifnull +22 -> 125
    //   106: aload_3
    //   107: invokevirtual 100	java/io/FileWriter:close	()V
    //   110: aload 4
    //   112: athrow
    //   113: astore 7
    //   115: aload 5
    //   117: aload 7
    //   119: invokevirtual 104	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   122: goto -12 -> 110
    //   125: aload_3
    //   126: invokevirtual 100	java/io/FileWriter:close	()V
    //   129: goto -19 -> 110
    //   132: astore 4
    //   134: aconst_null
    //   135: astore 5
    //   137: goto -40 -> 97
    //   140: astore 6
    //   142: return
    //
    // Exception table:
    //   from	to	target	type
    //   63	67	68	java/lang/Throwable
    //   39	55	82	java/lang/Throwable
    //   84	87	87	finally
    //   106	110	113	java/lang/Throwable
    //   39	55	132	finally
    //   30	39	140	java/io/IOException
    //   63	67	140	java/io/IOException
    //   70	76	140	java/io/IOException
    //   77	81	140	java/io/IOException
    //   106	110	140	java/io/IOException
    //   110	113	140	java/io/IOException
    //   115	122	140	java/io/IOException
    //   125	129	140	java/io/IOException
  }

  public void a(String paramString1, String paramString2)
  {
    if ((da.a(paramString1)) || (da.a(paramString2)))
      return;
    this.c.add(new a(paramString1, paramString2, null));
  }

  // ERROR //
  public void b()
  {
    // Byte code:
    //   0: new 70	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 54	com/viber/backup/d:d	Ljava/lang/String;
    //   8: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual 122	java/io/File:exists	()Z
    //   16: ifne +4 -> 20
    //   19: return
    //   20: aload_0
    //   21: getfield 32	com/viber/backup/d:c	Ljava/util/List;
    //   24: invokeinterface 125 1 0
    //   29: new 127	java/io/FileReader
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 128	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   37: astore_2
    //   38: aload_0
    //   39: getfield 34	com/viber/backup/d:b	Lcom/google/d/f;
    //   42: aload_2
    //   43: aload_0
    //   44: invokespecial 92	com/viber/backup/d:e	()Ljava/lang/reflect/Type;
    //   47: invokevirtual 131	com/google/d/f:a	(Ljava/io/Reader;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   50: checkcast 29	java/util/ArrayList
    //   53: astore 9
    //   55: aload 9
    //   57: invokestatic 136	com/viber/voip/util/u:a	(Ljava/util/Collection;)Z
    //   60: istore 10
    //   62: iload 10
    //   64: ifeq +28 -> 92
    //   67: aload_2
    //   68: ifnull -49 -> 19
    //   71: iconst_0
    //   72: ifeq +64 -> 136
    //   75: aload_2
    //   76: invokevirtual 137	java/io/FileReader:close	()V
    //   79: return
    //   80: astore 12
    //   82: aconst_null
    //   83: aload 12
    //   85: invokevirtual 104	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   88: return
    //   89: astore 5
    //   91: return
    //   92: aload_0
    //   93: getfield 32	com/viber/backup/d:c	Ljava/util/List;
    //   96: aload 9
    //   98: invokeinterface 140 2 0
    //   103: pop
    //   104: goto -37 -> 67
    //   107: astore 7
    //   109: aload 7
    //   111: athrow
    //   112: astore 8
    //   114: aload 7
    //   116: astore 4
    //   118: aload 8
    //   120: astore_3
    //   121: aload_2
    //   122: ifnull +12 -> 134
    //   125: aload 4
    //   127: ifnull +26 -> 153
    //   130: aload_2
    //   131: invokevirtual 137	java/io/FileReader:close	()V
    //   134: aload_3
    //   135: athrow
    //   136: aload_2
    //   137: invokevirtual 137	java/io/FileReader:close	()V
    //   140: return
    //   141: astore 6
    //   143: aload 4
    //   145: aload 6
    //   147: invokevirtual 104	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   150: goto -16 -> 134
    //   153: aload_2
    //   154: invokevirtual 137	java/io/FileReader:close	()V
    //   157: goto -23 -> 134
    //   160: astore_3
    //   161: aconst_null
    //   162: astore 4
    //   164: goto -43 -> 121
    //
    // Exception table:
    //   from	to	target	type
    //   75	79	80	java/lang/Throwable
    //   29	38	89	java/io/IOException
    //   75	79	89	java/io/IOException
    //   82	88	89	java/io/IOException
    //   130	134	89	java/io/IOException
    //   134	136	89	java/io/IOException
    //   136	140	89	java/io/IOException
    //   143	150	89	java/io/IOException
    //   153	157	89	java/io/IOException
    //   38	62	107	java/lang/Throwable
    //   92	104	107	java/lang/Throwable
    //   109	112	112	finally
    //   130	134	141	java/lang/Throwable
    //   38	62	160	finally
    //   92	104	160	finally
  }

  public List<a> c()
  {
    return this.c;
  }

  public void d()
  {
    File localFile = new File(this.d);
    if (localFile.exists())
      localFile.delete();
  }

  public static class a
  {

    @c(a="k")
    private final String a;

    @c(a="d")
    private final String b;

    private a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }

    public s.a a(String paramString)
    {
      try
      {
        String str = z.c(paramString, this.b);
        boolean bool = da.a(str);
        s.a locala = null;
        if (bool);
        do
        {
          return locala;
          locala = s.a.a(str);
        }
        while (locala != null);
        return locala;
      }
      catch (Exception localException)
      {
      }
      return null;
    }

    public String a()
    {
      return this.a;
    }

    public String toString()
    {
      return "IgnoredDataPiece{mKey='" + this.a + '\'' + ", mEncryptedData='" + this.b + '\'' + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.backup.d
 * JD-Core Version:    0.6.2
 */