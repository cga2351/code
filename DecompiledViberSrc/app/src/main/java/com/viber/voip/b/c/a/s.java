package com.viber.voip.b.c.a;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.provider.messages.b.d;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.c.a.a.a;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.util.dv;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class s extends c
{
  private static final Logger d = ViberEnv.getLogger();

  public s(Context paramContext)
  {
    super(paramContext);
  }

  // ERROR //
  private boolean a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokespecial 28	com/viber/voip/b/c/a/s:f	()Lcom/viber/provider/b;
    //   6: astore 6
    //   8: iconst_1
    //   9: anewarray 30	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: ldc 32
    //   16: aastore
    //   17: astore 7
    //   19: iconst_2
    //   20: anewarray 30	java/lang/String
    //   23: astore 8
    //   25: aload 8
    //   27: iconst_0
    //   28: new 34	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   35: ldc 38
    //   37: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: invokevirtual 48	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   44: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: aastore
    //   51: aload 8
    //   53: iconst_1
    //   54: new 34	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   61: ldc 38
    //   63: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 48	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   70: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: aastore
    //   77: aload 6
    //   79: ldc 53
    //   81: aload 7
    //   83: ldc 55
    //   85: aload 8
    //   87: aconst_null
    //   88: aconst_null
    //   89: aconst_null
    //   90: invokeinterface 60 8 0
    //   95: astore 9
    //   97: aload 9
    //   99: ifnull +46 -> 145
    //   102: aload 9
    //   104: invokeinterface 66 1 0
    //   109: ifeq +36 -> 145
    //   112: aload 9
    //   114: iconst_0
    //   115: invokeinterface 70 2 0
    //   120: istore 11
    //   122: iload 11
    //   124: iconst_1
    //   125: if_icmpne +14 -> 139
    //   128: iconst_1
    //   129: istore 12
    //   131: aload 9
    //   133: invokestatic 75	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   136: iload 12
    //   138: ireturn
    //   139: iconst_0
    //   140: istore 12
    //   142: goto -11 -> 131
    //   145: aload 9
    //   147: invokestatic 75	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   150: iconst_1
    //   151: ireturn
    //   152: astore 4
    //   154: aconst_null
    //   155: astore 5
    //   157: aload 5
    //   159: invokestatic 75	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   162: goto -12 -> 150
    //   165: astore_3
    //   166: aload_2
    //   167: invokestatic 75	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   170: aload_3
    //   171: athrow
    //   172: astore_3
    //   173: aload 9
    //   175: astore_2
    //   176: goto -10 -> 166
    //   179: astore 10
    //   181: aload 9
    //   183: astore 5
    //   185: goto -28 -> 157
    //
    // Exception table:
    //   from	to	target	type
    //   2	97	152	java/lang/Exception
    //   2	97	165	finally
    //   102	122	172	finally
    //   102	122	179	java/lang/Exception
  }

  private b f()
  {
    return d.a(ViberApplication.getApplication());
  }

  public void a()
  {
    this.b = new f(new a(), 256);
    this.b.b(true);
  }

  protected void b()
  {
    if (this.a);
    List localList;
    label88: 
    do
    {
      do
      {
        return;
        ab.b().p();
      }
      while (this.a);
      localList = this.b.a(dv.e.a(this.c));
      Iterator localIterator = localList.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          break label88;
        if (this.a)
          break;
        if (!a((File)localIterator.next()))
          localIterator.remove();
      }
    }
    while (this.a);
    this.b.a(localList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.s
 * JD-Core Version:    0.6.2
 */