package com.yandex.metrica;

import android.text.TextUtils;
import java.util.Map;

public class f
{
  private String a;
  private String b;
  private Map<String, String> c;

  public String a()
  {
    return this.a;
  }

  public void a(String paramString)
  {
    this.a = paramString;
  }

  public void a(Map<String, String> paramMap)
  {
    this.c = paramMap;
  }

  public String b()
  {
    return this.b;
  }

  public void b(String paramString)
  {
    this.b = paramString;
  }

  public Map<String, String> c()
  {
    return this.c;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof f));
    f localf;
    do
    {
      return false;
      localf = (f)paramObject;
    }
    while ((!TextUtils.equals(this.a, localf.a)) || (!TextUtils.equals(this.b, localf.b)) || ((this.c != localf.c) && (this.c != null) && (!this.c.equals(localf.c))));
    return true;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.a != null)
    {
      i = this.a.hashCode();
      j = i * 31;
      if (this.b == null)
        break label79;
    }
    label79: for (int k = this.b.hashCode(); ; k = 0)
    {
      int m = 31 * (k + j);
      Map localMap = this.c;
      int n = 0;
      if (localMap != null)
        n = this.c.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.f
 * JD-Core Version:    0.6.2
 */