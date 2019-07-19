package com.viber.voip.market.a.a;

import com.viber.voip.stickers.entity.d;
import java.util.ArrayList;
import java.util.List;

public class f
  implements c
{
  private e a;

  public f(List<? extends d> paramList)
  {
    this.a = new e(paramList);
  }

  public int a()
  {
    return this.a.a();
  }

  public a a(int paramInt)
  {
    a locala = this.a.a(paramInt - 0);
    if (locala != null)
      locala.a(paramInt);
    return locala;
  }

  public void a(List<? extends d> paramList)
  {
    this.a.a(paramList);
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt1 >= 0)
    {
      bool = false;
      if (paramInt2 >= 0)
        bool = this.a.a(paramInt1 - 0, paramInt2 - 0);
    }
    return bool;
  }

  public int b()
  {
    return this.a.b();
  }

  public List<a> c()
  {
    ArrayList localArrayList = new ArrayList();
    int i = b();
    for (int j = 0; j < i; j++)
    {
      a locala = a(j);
      if (locala.d())
        localArrayList.add(locala);
    }
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.a.a.f
 * JD-Core Version:    0.6.2
 */