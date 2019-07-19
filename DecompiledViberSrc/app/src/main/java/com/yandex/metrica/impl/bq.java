package com.yandex.metrica.impl;

import com.yandex.metrica.impl.ob.gm;
import com.yandex.metrica.impl.ob.ls;
import com.yandex.metrica.impl.ob.mx;
import java.util.List;
import java.util.Map;

public class bq
  implements ar
{
  private final mx a;
  private final ls b;
  private final br c;
  private final gm d;

  public bq(mx parammx, ls paramls)
  {
    this(parammx, paramls, new br(), new gm());
  }

  bq(mx parammx, ls paramls, br parambr, gm paramgm)
  {
    this.a = parammx;
    this.b = paramls;
    this.c = parambr;
    this.d = paramgm;
  }

  public boolean a(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    if (200 == paramInt)
    {
      List localList = (List)paramMap.get("Content-Encoding");
      if ((!bw.a(localList)) && ("encrypted".equals(localList.get(0))))
        paramArrayOfByte = this.d.a(paramArrayOfByte, "hBnBQbZrmjPXEWVJ");
      if (paramArrayOfByte != null)
      {
        br.b localb = this.c.a(paramArrayOfByte);
        if (br.b.a.b == localb.m())
        {
          this.a.a(localb, this.b, paramMap);
          return true;
        }
      }
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bq
 * JD-Core Version:    0.6.2
 */