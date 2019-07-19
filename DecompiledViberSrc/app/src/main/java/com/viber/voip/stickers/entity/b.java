package com.viber.voip.stickers.entity;

import android.content.Context;
import com.viber.voip.stickers.c.g;
import com.viber.voip.util.av;
import com.viber.voip.util.da;
import com.viber.voip.util.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class b
  implements a
{
  private final int a;
  private ArrayList<Sticker> b;
  private int c;
  private float d;
  private int e;
  private int f;
  private float g = 1.0F;
  private boolean h;
  private String i;
  private c j;

  public b(int paramInt)
  {
    this(paramInt, null);
  }

  public b(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.i = paramString;
    a(new ArrayList());
  }

  private boolean G()
  {
    return t();
  }

  private String H()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(isDefault: ").append(o()).append(", ").append("isNew: ").append(d()).append(", ").append("isDeployed: ").append(g()).append(", ").append("isPromo: ").append(h()).append(", ").append("isEmoticonsPackage: ").append(k()).append(", ").append("isDoodlePackage: ").append(E()).append(", ").append("isSvg: ").append(m()).append(", ").append("isPromoShouldBeDownloaded: ").append(i()).append(", ").append("isUpdateRequired: ").append(j()).append(")");
    return localStringBuilder.toString();
  }

  public int A()
  {
    return this.c;
  }

  public float B()
  {
    return this.g;
  }

  public float C()
  {
    return this.d;
  }

  public boolean D()
  {
    return e() == 400;
  }

  public boolean E()
  {
    return av.c(this.c, 8);
  }

  public boolean F()
  {
    return this.a > 0;
  }

  public int a()
  {
    return this.e;
  }

  public File a(Context paramContext)
  {
    return g.a(paramContext, this.a);
  }

  public void a(float paramFloat)
  {
    this.g = paramFloat;
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
  }

  public void a(c paramc)
  {
    this.j = paramc;
    this.i = null;
  }

  public void a(String paramString)
  {
    y().b(paramString);
  }

  public void a(ArrayList<Sticker> paramArrayList)
  {
    this.b = paramArrayList;
  }

  public void a(boolean paramBoolean)
  {
    this.c = av.a(this.c, 1, paramBoolean);
  }

  public void a(String[] paramArrayOfString)
  {
    y().a(paramArrayOfString);
  }

  public int b()
  {
    return this.f;
  }

  public void b(float paramFloat)
  {
    this.d = paramFloat;
  }

  public void b(int paramInt)
  {
    this.e = paramInt;
  }

  public void b(boolean paramBoolean)
  {
    this.c = av.a(this.c, 2, paramBoolean);
  }

  public void c(int paramInt)
  {
    this.f = paramInt;
  }

  public void c(boolean paramBoolean)
  {
    this.c = av.a(this.c, 3, paramBoolean);
  }

  public boolean c()
  {
    return this.f == 0;
  }

  public void d(boolean paramBoolean)
  {
    this.c = av.a(this.c, 7, paramBoolean);
  }

  public boolean d()
  {
    return (av.c(this.c, 1)) && (!D());
  }

  public int e()
  {
    return this.a;
  }

  public void e(boolean paramBoolean)
  {
    this.c = av.a(this.c, 8, paramBoolean);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    b localb;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localb = (b)paramObject;
    }
    while (this.a == localb.a);
    return false;
  }

  public String f()
  {
    return y().b();
  }

  public void f(boolean paramBoolean)
  {
    this.c = av.a(this.c, 4, paramBoolean);
  }

  public void g(boolean paramBoolean)
  {
    this.c = av.a(this.c, 9, paramBoolean);
  }

  public boolean g()
  {
    return av.c(this.c, 2);
  }

  public void h(boolean paramBoolean)
  {
    this.c = av.a(this.c, 6, paramBoolean);
  }

  public boolean h()
  {
    return av.c(this.c, 3);
  }

  public int hashCode()
  {
    return 31 + this.a;
  }

  public void i(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public boolean i()
  {
    return av.c(this.c, 4);
  }

  public boolean j()
  {
    return av.c(this.c, 9);
  }

  public boolean k()
  {
    return av.c(this.c, 7);
  }

  public boolean l()
  {
    return (k()) || (E());
  }

  public boolean m()
  {
    return (x() != null) && ((n.a(x(), "svg")) || (n.a(x(), "asvg")));
  }

  public boolean n()
  {
    return (x() != null) && (n.a(x(), "mp3"));
  }

  public boolean o()
  {
    return av.c(this.c, 6);
  }

  public boolean p()
  {
    return (g()) || ((!h()) && (G())) || (s()) || (D());
  }

  public long q()
  {
    return y().e();
  }

  public c.a r()
  {
    return y().d();
  }

  public boolean s()
  {
    return (h()) && (G()) && ((v()) || (!n())) && (w());
  }

  public boolean t()
  {
    return (!da.a(f())) && (x() != null) && (x().length > 0);
  }

  public String toString()
  {
    return "StickerPackage [id=" + e() + ", packageName=" + f() + ", flags=" + H() + ", thumbFactor=" + this.d + ", menuPosition=" + this.e + ", visibility=" + this.f + ", isInDatabase=" + this.h + ", isVisible()=" + c() + ", isOnBoard()=" + D() + ", formats = " + Arrays.toString(x()) + " ]";
  }

  public boolean u()
  {
    return new File(g.k(e())).exists();
  }

  public boolean v()
  {
    return (n()) && (new File(g.j(e())).exists());
  }

  public boolean w()
  {
    return new File(g.b(e(), m())).exists();
  }

  public String[] x()
  {
    return y().f();
  }

  public c y()
  {
    if (this.j == null)
    {
      if (!da.a(this.i))
      {
        this.j = c.a(this.i);
        this.i = null;
      }
      if (this.j == null)
        this.j = new c();
    }
    return this.j;
  }

  public String z()
  {
    return y().a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.entity.b
 * JD-Core Version:    0.6.2
 */