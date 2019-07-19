package com.viber.voip.engagement.carousel;

import com.viber.voip.engagement.data.b;
import com.viber.voip.util.da;

public class c
  implements i
{
  private final i a;
  private String b = "";
  private String c = "";

  public c(String paramString, i parami)
  {
    this.a = parami;
    this.b = paramString;
  }

  public String a()
  {
    if (da.a(this.b))
      return this.a.a();
    return this.b;
  }

  public String a(int paramInt)
  {
    if (da.a(this.c))
      return this.a.a(paramInt);
    return this.c;
  }

  public void a(b paramb)
  {
    if (paramb == null)
    {
      this.b = "";
      this.c = "";
      return;
    }
    String str1;
    if (da.a(paramb.a()))
    {
      str1 = "";
      this.b = str1;
      if (!da.a(paramb.b()))
        break label68;
    }
    label68: for (String str2 = ""; ; str2 = paramb.b())
    {
      this.c = str2;
      return;
      str1 = paramb.a();
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.carousel.c
 * JD-Core Version:    0.6.2
 */