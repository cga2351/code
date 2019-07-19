package com.viber.voip.storage.repository;

import com.viber.provider.b;
import dagger.a;

public class t
{
  private final a<b> a;

  public t(a<b> parama)
  {
    this.a = parama;
  }

  // ERROR //
  public void a(long paramLong, int[] paramArrayOfInt, java.lang.String[] paramArrayOfString, com.viber.voip.util.d.a<android.database.Cursor> parama)
  {
    // Byte code:
    //   0: getstatic 21	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   3: astore 8
    //   5: iconst_2
    //   6: anewarray 4	java/lang/Object
    //   9: astore 9
    //   11: aload 9
    //   13: iconst_0
    //   14: iconst_4
    //   15: newarray int
    //   17: dup
    //   18: iconst_0
    //   19: iconst_2
    //   20: iastore
    //   21: dup
    //   22: iconst_1
    //   23: bipush 8
    //   25: iastore
    //   26: dup
    //   27: iconst_2
    //   28: bipush 9
    //   30: iastore
    //   31: dup
    //   32: iconst_3
    //   33: iconst_0
    //   34: iastore
    //   35: invokestatic 26	com/viber/voip/s/a:a	([I)Ljava/lang/String;
    //   38: aastore
    //   39: aload 9
    //   41: iconst_1
    //   42: aload_3
    //   43: invokestatic 26	com/viber/voip/s/a:a	([I)Ljava/lang/String;
    //   46: aastore
    //   47: aload 8
    //   49: ldc 28
    //   51: aload 9
    //   53: invokestatic 34	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   56: astore 10
    //   58: iconst_1
    //   59: anewarray 30	java/lang/String
    //   62: astore 11
    //   64: aload 11
    //   66: iconst_0
    //   67: lload_1
    //   68: invokestatic 40	java/lang/Long:toString	(J)Ljava/lang/String;
    //   71: aastore
    //   72: aload_0
    //   73: getfield 14	com/viber/voip/storage/repository/t:a	Ldagger/a;
    //   76: invokeinterface 46 1 0
    //   81: checkcast 48	com/viber/provider/b
    //   84: ldc 50
    //   86: aload 4
    //   88: aload 10
    //   90: aload 11
    //   92: aconst_null
    //   93: aconst_null
    //   94: aconst_null
    //   95: invokeinterface 53 8 0
    //   100: astore 12
    //   102: aload 12
    //   104: astore 7
    //   106: aload 7
    //   108: invokestatic 59	com/viber/voip/util/af:c	(Landroid/database/Cursor;)Z
    //   111: ifeq +26 -> 137
    //   114: aload 5
    //   116: aload 7
    //   118: invokeinterface 64 2 0
    //   123: aload 7
    //   125: invokeinterface 70 1 0
    //   130: istore 13
    //   132: iload 13
    //   134: ifne -20 -> 114
    //   137: aload 7
    //   139: invokestatic 73	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   142: return
    //   143: astore 6
    //   145: aconst_null
    //   146: astore 7
    //   148: aload 7
    //   150: invokestatic 73	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   153: aload 6
    //   155: athrow
    //   156: astore 6
    //   158: goto -10 -> 148
    //
    // Exception table:
    //   from	to	target	type
    //   0	102	143	finally
    //   106	114	156	finally
    //   114	132	156	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.t
 * JD-Core Version:    0.6.2
 */