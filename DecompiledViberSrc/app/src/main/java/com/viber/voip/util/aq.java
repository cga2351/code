package com.viber.voip.util;

import android.os.Handler;
import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.settings.d.r;
import java.util.ArrayList;
import java.util.List;

public final class aq
{
  private static final Logger a = ViberEnv.getLogger();
  private static final List<String> b = new ArrayList(1);

  static
  {
    b.add("Z2560");
  }

  public static void a()
  {
    if (d.r.v.d() == 0)
    {
      if (!an.d())
        d.r.v.a(1);
    }
    else
      return;
    av.e.f.a().post(new Runnable()
    {
      // ERROR //
      public void run()
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_1
        //   2: new 19	java/io/File
        //   5: dup
        //   6: ldc 21
        //   8: invokespecial 24	java/io/File:<init>	(Ljava/lang/String;)V
        //   11: astore_2
        //   12: aload_2
        //   13: invokevirtual 28	java/io/File:exists	()Z
        //   16: ifeq +163 -> 179
        //   19: aconst_null
        //   20: astore 5
        //   22: new 30	java/io/BufferedReader
        //   25: dup
        //   26: new 32	java/io/FileReader
        //   29: dup
        //   30: aload_2
        //   31: invokespecial 35	java/io/FileReader:<init>	(Ljava/io/File;)V
        //   34: invokespecial 38	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   37: astore 6
        //   39: aload 6
        //   41: invokevirtual 42	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   44: astore 9
        //   46: aload 9
        //   48: ifnull +126 -> 174
        //   51: aload 9
        //   53: ldc 44
        //   55: invokevirtual 50	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   58: ifeq -19 -> 39
        //   61: invokestatic 54	com/viber/voip/util/aq:b	()Ljava/util/List;
        //   64: invokeinterface 60 1 0
        //   69: astore 10
        //   71: aload 10
        //   73: invokeinterface 65 1 0
        //   78: ifeq +96 -> 174
        //   81: aload 9
        //   83: aload 10
        //   85: invokeinterface 69 1 0
        //   90: checkcast 46	java/lang/String
        //   93: invokevirtual 50	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   96: istore 11
        //   98: iload 11
        //   100: ifeq -29 -> 71
        //   103: iconst_0
        //   104: istore_3
        //   105: aload 6
        //   107: invokestatic 74	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
        //   110: getstatic 80	com/viber/voip/settings/d$r:v	Lcom/viber/common/b/d;
        //   113: astore 4
        //   115: iload_3
        //   116: ifeq +39 -> 155
        //   119: aload 4
        //   121: iload_1
        //   122: invokevirtual 85	com/viber/common/b/d:a	(I)V
        //   125: return
        //   126: astore 13
        //   128: aload 5
        //   130: invokestatic 74	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
        //   133: iload_1
        //   134: istore_3
        //   135: goto -25 -> 110
        //   138: astore 12
        //   140: aconst_null
        //   141: astore 6
        //   143: aload 12
        //   145: astore 8
        //   147: aload 6
        //   149: invokestatic 74	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
        //   152: aload 8
        //   154: athrow
        //   155: iconst_2
        //   156: istore_1
        //   157: goto -38 -> 119
        //   160: astore 8
        //   162: goto -15 -> 147
        //   165: astore 7
        //   167: aload 6
        //   169: astore 5
        //   171: goto -43 -> 128
        //   174: iload_1
        //   175: istore_3
        //   176: goto -71 -> 105
        //   179: iload_1
        //   180: istore_3
        //   181: goto -71 -> 110
        //
        // Exception table:
        //   from	to	target	type
        //   22	39	126	java/lang/Exception
        //   22	39	138	finally
        //   39	46	160	finally
        //   51	71	160	finally
        //   71	98	160	finally
        //   39	46	165	java/lang/Exception
        //   51	71	165	java/lang/Exception
        //   71	98	165	java/lang/Exception
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.aq
 * JD-Core Version:    0.6.2
 */