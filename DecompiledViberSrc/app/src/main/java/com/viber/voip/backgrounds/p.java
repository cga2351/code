package com.viber.voip.backgrounds;

import android.net.Uri;
import com.viber.voip.ViberApplication;
import com.viber.voip.util.as;
import com.viber.voip.util.av;
import com.viber.voip.util.da;
import com.viber.voip.util.dv;
import java.io.File;
import java.util.Formatter;
import java.util.Locale;

public class p
  implements q, Comparable<p>
{
  public int a;
  public int b;
  public String c;
  public int d;
  public int e;
  public int f;
  protected String g;
  public Uri h;
  public Uri i;
  private File j;

  public p(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, false, null);
  }

  public p(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    this.a = paramInt1;
    this.f = paramInt2;
    this.c = paramString;
    b(paramBoolean);
    boolean bool;
    String str1;
    label82: String str2;
    if ((paramBoolean) && (!da.a(paramString)))
    {
      bool = true;
      c(bool);
      this.g = a(paramInt1);
      File localFile = m.a(paramInt2, ViberApplication.getApplication());
      this.j = m.b(paramInt2, ViberApplication.getApplication());
      if (!paramBoolean)
        break label197;
      str1 = "_tail";
      this.h = Uri.fromFile(new File(localFile, a(str1)));
      this.d = g.b;
      this.e = g.b;
      if (!paramBoolean)
        break label204;
      str2 = "_tail";
      label126: if (!bool)
        break label211;
    }
    label197: label204: label211: for (String str3 = str2 + "_color" + paramString; ; str3 = str2)
    {
      this.i = Uri.fromFile(new File(this.j, a(str3, this.d, this.e)));
      return;
      bool = false;
      break;
      str1 = "_orig";
      break label82;
      str2 = "_thumb";
      break label126;
    }
  }

  private static String a(int paramInt)
  {
    Formatter localFormatter = new Formatter();
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    String str = localFormatter.format(localLocale, "%08d", arrayOfObject).toString();
    localFormatter.close();
    return str;
  }

  private String a(String paramString)
  {
    return as.a.a(m.a + this.g + paramString);
  }

  private String a(String paramString, int paramInt1, int paramInt2)
  {
    return as.c.a(m.a + this.g + "_scaled" + paramString + "_" + paramInt1 + "x" + paramInt2);
  }

  public int a(p paramp)
  {
    return this.a - paramp.a;
  }

  public Uri a()
  {
    return this.h;
  }

  public final Uri a(boolean paramBoolean)
  {
    dv localdv;
    if (b())
      localdv = dv.N;
    while (true)
    {
      return localdv.a(ViberApplication.getApplication(), f(), false);
      if (paramBoolean)
        localdv = dv.M;
      else
        localdv = dv.L;
    }
  }

  public void b(boolean paramBoolean)
  {
    this.b = av.a(this.b, 2, paramBoolean);
  }

  public boolean b()
  {
    return av.c(this.b, 2);
  }

  public void c(boolean paramBoolean)
  {
    this.b = av.a(this.b, 3, paramBoolean);
  }

  public boolean c()
  {
    return av.c(this.b, 3);
  }

  public String d()
  {
    if (c())
      return "c";
    if (b())
      return "t";
    return "";
  }

  public void e()
  {
    this.j.mkdirs();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    p localp;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localp = (p)paramObject;
    }
    while (this.a == localp.a);
    return false;
  }

  String f()
  {
    return this.g + "_cr";
  }

  public int hashCode()
  {
    return 31 + this.a;
  }

  public String toString()
  {
    return "DefaultBackground{ id=" + this.a + ", packageId=" + this.f + ", origPath='" + this.h + '\'' + ", thumbHeight=" + this.e + ", thumbWidth=" + this.d + ", isTile=" + b() + ", isColor=" + c() + ", colorHex=" + this.c + ", thumbPathHighQuality=" + this.i + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.p
 * JD-Core Version:    0.6.2
 */