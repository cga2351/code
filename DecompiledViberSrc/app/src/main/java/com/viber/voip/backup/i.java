package com.viber.voip.backup;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class i<EXECUTOR extends d, BRIDGE extends m>
  implements d
{
  protected static final Logger a = ViberEnv.getLogger();
  protected final List<EXECUTOR> b = new ArrayList(2);
  private final r c;
  private volatile boolean d;
  private int e;
  private float f;
  private int g;
  private final o h = new o()
  {
    public void a(int paramAnonymousInt)
    {
      i.a(i.this, paramAnonymousInt);
    }
  };

  protected i(r paramr)
  {
    this.c = paramr;
    a(this.b, this.h);
  }

  private void b()
  {
    if (this.c != null)
    {
      int i = (int)(100.0F * (this.f / this.e));
      if (this.g < i)
      {
        this.g = i;
        this.c.a(i);
      }
    }
  }

  private void b(int paramInt)
  {
    this.f += paramInt;
    b();
  }

  protected abstract int a(BRIDGE paramBRIDGE, List<EXECUTOR> paramList)
    throws com.viber.voip.backup.c.d;

  protected abstract BRIDGE a(String paramString1, String paramString2)
    throws com.viber.voip.backup.c.d;

  public void a()
  {
    this.d = true;
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((d)localIterator.next()).a();
  }

  protected void a(int paramInt)
    throws com.viber.voip.backup.c.d
  {
  }

  protected abstract void a(EXECUTOR paramEXECUTOR, BRIDGE paramBRIDGE)
    throws com.viber.voip.backup.c.d;

  protected void a(BRIDGE paramBRIDGE)
    throws com.viber.voip.backup.c.d
  {
  }

  protected void a(BRIDGE paramBRIDGE, String paramString)
    throws com.viber.voip.backup.c.d
  {
  }

  // ERROR //
  public void a(String paramString1, String paramString2, q paramq)
    throws com.viber.voip.backup.c.d
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_1
    //   5: aload_2
    //   6: invokevirtual 104	com/viber/voip/backup/i:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/viber/voip/backup/m;
    //   9: astore 4
    //   11: aload_0
    //   12: aload 4
    //   14: aload_2
    //   15: invokevirtual 106	com/viber/voip/backup/i:a	(Lcom/viber/voip/backup/m;Ljava/lang/String;)V
    //   18: aload_0
    //   19: aload_0
    //   20: aload 4
    //   22: aload_0
    //   23: getfield 44	com/viber/voip/backup/i:b	Ljava/util/List;
    //   26: invokevirtual 108	com/viber/voip/backup/i:a	(Lcom/viber/voip/backup/m;Ljava/util/List;)I
    //   29: putfield 64	com/viber/voip/backup/i:e	I
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 64	com/viber/voip/backup/i:e	I
    //   37: invokevirtual 109	com/viber/voip/backup/i:a	(I)V
    //   40: aload_3
    //   41: ifnull +13 -> 54
    //   44: aload_3
    //   45: aload_0
    //   46: getfield 64	com/viber/voip/backup/i:e	I
    //   49: invokeinterface 112 2 0
    //   54: aload_0
    //   55: getfield 44	com/viber/voip/backup/i:b	Ljava/util/List;
    //   58: invokeinterface 84 1 0
    //   63: astore 8
    //   65: aload 8
    //   67: invokeinterface 90 1 0
    //   72: ifeq +73 -> 145
    //   75: aload 8
    //   77: invokeinterface 94 1 0
    //   82: checkcast 7	com/viber/voip/backup/d
    //   85: astore 9
    //   87: aload_0
    //   88: getfield 78	com/viber/voip/backup/i:d	Z
    //   91: ifeq +38 -> 129
    //   94: new 102	com/viber/voip/backup/c/b
    //   97: dup
    //   98: invokespecial 113	com/viber/voip/backup/c/b:<init>	()V
    //   101: athrow
    //   102: astore 7
    //   104: aload 7
    //   106: athrow
    //   107: astore 6
    //   109: aload 4
    //   111: ifnull +10 -> 121
    //   114: aload 4
    //   116: invokeinterface 116 1 0
    //   121: aload_0
    //   122: iconst_0
    //   123: invokevirtual 119	com/viber/voip/backup/i:a	(Z)V
    //   126: aload 6
    //   128: athrow
    //   129: aload_0
    //   130: aload 9
    //   132: aload 4
    //   134: invokevirtual 121	com/viber/voip/backup/i:a	(Lcom/viber/voip/backup/d;Lcom/viber/voip/backup/m;)V
    //   137: goto -72 -> 65
    //   140: astore 5
    //   142: aload 5
    //   144: athrow
    //   145: aload_0
    //   146: aload 4
    //   148: invokevirtual 123	com/viber/voip/backup/i:a	(Lcom/viber/voip/backup/m;)V
    //   151: aload 4
    //   153: ifnull +10 -> 163
    //   156: aload 4
    //   158: invokeinterface 116 1 0
    //   163: aload_0
    //   164: iconst_1
    //   165: invokevirtual 119	com/viber/voip/backup/i:a	(Z)V
    //   168: return
    //
    // Exception table:
    //   from	to	target	type
    //   3	40	102	com/viber/voip/backup/c/b
    //   44	54	102	com/viber/voip/backup/c/b
    //   54	65	102	com/viber/voip/backup/c/b
    //   65	102	102	com/viber/voip/backup/c/b
    //   129	137	102	com/viber/voip/backup/c/b
    //   145	151	102	com/viber/voip/backup/c/b
    //   3	40	107	finally
    //   44	54	107	finally
    //   54	65	107	finally
    //   65	102	107	finally
    //   104	107	107	finally
    //   129	137	107	finally
    //   142	145	107	finally
    //   145	151	107	finally
    //   3	40	140	com/viber/voip/backup/c/d
    //   44	54	140	com/viber/voip/backup/c/d
    //   54	65	140	com/viber/voip/backup/c/d
    //   65	102	140	com/viber/voip/backup/c/d
    //   129	137	140	com/viber/voip/backup/c/d
    //   145	151	140	com/viber/voip/backup/c/d
  }

  protected abstract void a(List<EXECUTOR> paramList, o paramo);

  protected void a(boolean paramBoolean)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.i
 * JD-Core Version:    0.6.2
 */