package com.viber.voip.stickers.c;

import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public abstract class c
  implements Runnable
{
  private static final Logger d = ViberEnv.getLogger();
  protected int a;
  protected Bundle b;
  protected boolean c;
  private a e;

  public c(int paramInt, Bundle paramBundle)
  {
    this.a = paramInt;
    this.b = paramBundle;
    if (this.b != null)
      this.c = paramBundle.getBoolean("is_svg");
  }

  abstract String a();

  public void a(a parama)
  {
    this.e = parama;
  }

  abstract String b();

  // ERROR //
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 52	com/viber/voip/stickers/c/c:a	()Ljava/lang/String;
    //   4: astore_1
    //   5: aload_0
    //   6: invokevirtual 54	com/viber/voip/stickers/c/c:b	()Ljava/lang/String;
    //   9: astore_2
    //   10: new 56	com/viber/voip/util/upload/b
    //   13: dup
    //   14: aload_1
    //   15: aload_2
    //   16: new 58	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   23: aload_2
    //   24: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 65
    //   29: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokespecial 71	com/viber/voip/util/upload/b:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   38: astore_3
    //   39: new 73	java/io/File
    //   42: dup
    //   43: aload_2
    //   44: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: invokevirtual 80	java/io/File:getParentFile	()Ljava/io/File;
    //   50: invokevirtual 84	java/io/File:mkdirs	()Z
    //   53: pop
    //   54: aload_3
    //   55: invokevirtual 87	com/viber/voip/util/upload/b:f	()V
    //   58: aload_0
    //   59: getfield 44	com/viber/voip/stickers/c/c:c	Z
    //   62: ifeq +19 -> 81
    //   65: aload_2
    //   66: aload_0
    //   67: getfield 32	com/viber/voip/stickers/c/c:a	I
    //   70: aload_0
    //   71: getfield 32	com/viber/voip/stickers/c/c:a	I
    //   74: iconst_1
    //   75: invokestatic 92	com/viber/voip/stickers/c/g:b	(IZ)Ljava/lang/String;
    //   78: invokestatic 95	com/viber/voip/stickers/c/g:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_0
    //   82: getfield 48	com/viber/voip/stickers/c/c:e	Lcom/viber/voip/stickers/c/c$a;
    //   85: ifnull +17 -> 102
    //   88: aload_0
    //   89: getfield 48	com/viber/voip/stickers/c/c:e	Lcom/viber/voip/stickers/c/c$a;
    //   92: aload_0
    //   93: getfield 32	com/viber/voip/stickers/c/c:a	I
    //   96: iconst_1
    //   97: invokeinterface 100 3 0
    //   102: return
    //   103: astore 5
    //   105: aload_0
    //   106: getfield 48	com/viber/voip/stickers/c/c:e	Lcom/viber/voip/stickers/c/c$a;
    //   109: ifnull -7 -> 102
    //   112: aload_0
    //   113: getfield 48	com/viber/voip/stickers/c/c:e	Lcom/viber/voip/stickers/c/c$a;
    //   116: aload_0
    //   117: getfield 32	com/viber/voip/stickers/c/c:a	I
    //   120: iconst_0
    //   121: invokeinterface 100 3 0
    //   126: return
    //   127: astore 4
    //   129: aload_0
    //   130: getfield 48	com/viber/voip/stickers/c/c:e	Lcom/viber/voip/stickers/c/c$a;
    //   133: ifnull +17 -> 150
    //   136: aload_0
    //   137: getfield 48	com/viber/voip/stickers/c/c:e	Lcom/viber/voip/stickers/c/c$a;
    //   140: aload_0
    //   141: getfield 32	com/viber/voip/stickers/c/c:a	I
    //   144: iconst_1
    //   145: invokeinterface 100 3 0
    //   150: aload 4
    //   152: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   39	81	103	com/viber/voip/util/upload/b$a
    //   39	81	127	finally
  }

  public void run()
  {
    c();
  }

  static abstract interface a
  {
    public abstract void a(int paramInt, boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.c.c
 * JD-Core Version:    0.6.2
 */