package com.viber.voip.model.a;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class b
{
  private static final Logger a = ViberEnv.getLogger();
  private static volatile d b;
  private static volatile d c;

  public static int a()
  {
    return 1;
  }

  public static int b()
  {
    return 1;
  }

  public static d c()
  {
    if (b == null);
    try
    {
      if (b == null)
        b = new f();
      return b;
    }
    finally
    {
    }
  }

  // ERROR //
  public static d d()
  {
    // Byte code:
    //   0: getstatic 35	com/viber/voip/model/a/b:c	Lcom/viber/voip/model/a/d;
    //   3: ifnonnull +48 -> 51
    //   6: ldc 25
    //   8: monitorenter
    //   9: getstatic 35	com/viber/voip/model/a/b:c	Lcom/viber/voip/model/a/d;
    //   12: ifnonnull +36 -> 48
    //   15: invokestatic 37	com/viber/voip/model/a/b:c	()Lcom/viber/voip/model/a/d;
    //   18: putstatic 35	com/viber/voip/model/a/b:c	Lcom/viber/voip/model/a/d;
    //   21: getstatic 35	com/viber/voip/model/a/b:c	Lcom/viber/voip/model/a/d;
    //   24: invokestatic 42	com/viber/voip/model/a/c:a	(Lcom/viber/voip/model/a/d;)Z
    //   27: istore_1
    //   28: iload_1
    //   29: ifeq +19 -> 48
    //   32: new 44	com/viber/voip/model/a/e
    //   35: dup
    //   36: invokestatic 50	com/viber/voip/ViberApplication:getApplication	()Landroid/app/Application;
    //   39: invokespecial 53	com/viber/voip/model/a/e:<init>	(Landroid/content/Context;)V
    //   42: getstatic 35	com/viber/voip/model/a/b:c	Lcom/viber/voip/model/a/d;
    //   45: invokestatic 56	com/viber/voip/model/a/c:a	(Lcom/viber/voip/model/a/d;Lcom/viber/voip/model/a/d;)V
    //   48: ldc 25
    //   50: monitorexit
    //   51: getstatic 35	com/viber/voip/model/a/b:c	Lcom/viber/voip/model/a/d;
    //   54: areturn
    //   55: astore_0
    //   56: ldc 25
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    //   61: astore_2
    //   62: goto -14 -> 48
    //
    // Exception table:
    //   from	to	target	type
    //   9	28	55	finally
    //   32	48	55	finally
    //   48	51	55	finally
    //   56	59	55	finally
    //   32	48	61	java/lang/Throwable
  }

  public static void e()
  {
    d locald1 = c();
    locald1.a();
    d locald2 = d();
    if (locald1 != locald2)
      locald2.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.a.b
 * JD-Core Version:    0.6.2
 */