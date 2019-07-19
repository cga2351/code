package com.viber.service.contacts.sync.a;

import com.viber.voip.settings.d.p;

public class c
{
  private b a;

  public c(b paramb)
  {
    this.a = paramb;
  }

  private void a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
      this.a.b();
      return;
    case 1:
      this.a.c();
      return;
    case 2:
      this.a.d();
      return;
    case 3:
      this.a.f();
      return;
    case 4:
    }
    this.a.e();
  }

  public boolean a()
  {
    return a(new int[] { 0, 1, 2, 3, 4 });
  }

  public boolean a(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfInt[j];
      if (!b())
        return false;
      a(k);
    }
    return true;
  }

  public boolean b()
  {
    return d.p.g.d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.contacts.sync.a.c
 * JD-Core Version:    0.6.2
 */