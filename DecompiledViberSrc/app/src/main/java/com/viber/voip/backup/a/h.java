package com.viber.voip.backup.a;

import com.viber.voip.registration.af;
import com.viber.voip.util.da;

public class h
  implements f<g>
{
  private final af a;

  public h(af paramaf)
  {
    this.a = paramaf;
  }

  public g a()
  {
    String str1 = this.a.l();
    String str2 = this.a.g();
    if ((da.a(str1)) || (da.a(str2)))
      return null;
    return new g(str1, str2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.a.h
 * JD-Core Version:    0.6.2
 */