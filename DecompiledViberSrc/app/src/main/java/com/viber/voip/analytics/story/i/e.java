package com.viber.voip.analytics.story.i;

import com.viber.voip.analytics.g;
import com.viber.voip.analytics.g.a.a;
import java.util.List;

public class e
  implements c
{
  private static final a.a[] a = arrayOfa;
  private final g b;

  static
  {
    a.a[] arrayOfa = new a.a[1];
    arrayOfa[0] = a.a.i;
  }

  public e(g paramg)
  {
    this.b = paramg;
  }

  public void a(String paramString)
  {
    this.b.a(b.b(paramString));
  }

  public void a(String paramString, List<String> paramList, boolean paramBoolean)
  {
    this.b.a(b.a(paramList, paramBoolean));
    this.b.a(a.a(paramString));
  }

  public void a(String paramString, boolean paramBoolean)
  {
    this.b.a(b.a(paramString, paramBoolean));
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 205929663:
    case 1563103722:
    case 85080:
    }
    while (true)
      switch (i)
      {
      default:
        return;
        if (paramString.equals("Sticker Market"))
        {
          i = 0;
          continue;
          if (paramString.equals("Viber Out"))
          {
            i = 1;
            continue;
            if (paramString.equals("VLN"))
              i = 2;
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      }
    this.b.a(b.a(a));
    return;
    this.b.a(b.b(a));
    return;
    this.b.a(b.c(a));
  }

  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.b.a(b.a(paramString));
    this.b.a(a.a(paramBoolean1, paramBoolean2, paramBoolean3));
  }

  public void b(String paramString)
  {
    this.b.a(b.c(paramString));
  }

  public void c(String paramString)
  {
    this.b.a(b.d(paramString));
  }

  public void d(String paramString)
  {
    this.b.a(b.e(paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.i.e
 * JD-Core Version:    0.6.2
 */