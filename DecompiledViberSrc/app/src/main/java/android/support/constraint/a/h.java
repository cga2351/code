package android.support.constraint.a;

import java.util.Arrays;

public class h
{
  private static int j = 1;
  private static int k = 1;
  private static int l = 1;
  private static int m = 1;
  private static int n = 1;
  public int a = -1;
  int b = -1;
  public int c = 0;
  public float d;
  float[] e = new float[7];
  a f;
  b[] g = new b[8];
  int h = 0;
  public int i = 0;
  private String o;

  public h(a parama, String paramString)
  {
    this.f = parama;
  }

  static void a()
  {
    k = 1 + k;
  }

  public final void a(b paramb)
  {
    for (int i1 = 0; i1 < this.h; i1++)
      if (this.g[i1] == paramb)
        return;
    if (this.h >= this.g.length)
      this.g = ((b[])Arrays.copyOf(this.g, 2 * this.g.length));
    this.g[this.h] = paramb;
    this.h = (1 + this.h);
  }

  public void a(a parama, String paramString)
  {
    this.f = parama;
  }

  public void b()
  {
    this.o = null;
    this.f = a.e;
    this.c = 0;
    this.a = -1;
    this.b = -1;
    this.d = 0.0F;
    this.h = 0;
    this.i = 0;
  }

  public final void b(b paramb)
  {
    int i1 = this.h;
    for (int i2 = 0; ; i2++)
      if (i2 < i1)
      {
        b localb = this.g[i2];
        int i3 = 0;
        if (localb == paramb)
        {
          while (i3 < -1 + (i1 - i2))
          {
            this.g[(i2 + i3)] = this.g[(1 + (i2 + i3))];
            i3++;
          }
          this.h = (-1 + this.h);
        }
      }
      else
      {
        return;
      }
  }

  public final void c(b paramb)
  {
    int i1 = this.h;
    for (int i2 = 0; i2 < i1; i2++)
      this.g[i2].d.a(this.g[i2], paramb, false);
    this.h = 0;
  }

  public String toString()
  {
    return "" + this.o;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a.h
 * JD-Core Version:    0.6.2
 */