package com.viber.voip.analytics.story.c;

import com.viber.voip.analytics.g;
import org.jetbrains.annotations.NotNull;

public class e
  implements c
{
  private final g a;

  public e(g paramg)
  {
    this.a = paramg;
  }

  public void a(String paramString, long paramLong)
  {
    this.a.a(b.a(paramString, paramLong));
  }

  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.a.a(b.a(paramString1, paramString2));
    this.a.a(a.a(paramString3));
  }

  public void b(String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    this.a.a(b.b(paramString1, paramString2));
    this.a.a(a.b(paramString3));
  }

  public void c(String paramString1, String paramString2, @NotNull String paramString3)
  {
    this.a.a(b.c(paramString1, paramString2));
    this.a.a(a.a(paramString3, paramString2));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.c.e
 * JD-Core Version:    0.6.2
 */