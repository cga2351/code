package com.viber.voip.ads.b.a.a;

import android.os.Handler;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.ads.b.a.a.a.e;

public class ab
  implements l<e>
{
  private final Handler a;

  public ab(Handler paramHandler)
  {
    this.a = paramHandler;
  }

  public int a()
  {
    return 2147483647;
  }

  public void a(e parame, com.viber.voip.ads.b.b.a.c paramc)
  {
    a locala = a.a(parame.a);
    this.a.post(new ac(paramc, locala, parame));
  }

  public static enum a
  {
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final String g;

    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }

    private a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
    {
      this.c = paramInt1;
      this.d = paramInt2;
      this.e = paramInt3;
      this.f = paramInt4;
      this.g = paramString;
    }

    public static a a(com.viber.voip.ads.b.b.b.c paramc)
    {
      switch (ab.1.a[paramc.ordinal()])
      {
      default:
        return a;
      case 1:
        return a;
      case 2:
      }
      return b;
    }

    public int a()
    {
      return this.c;
    }

    public int b()
    {
      return this.d;
    }

    public int c()
    {
      return this.e;
    }

    public int d()
    {
      return this.f;
    }

    public String e()
    {
      return this.g;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.a.a.ab
 * JD-Core Version:    0.6.2
 */