package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.f;
import com.yandex.metrica.impl.i;

public class cv extends ci
{
  public cv(ab paramab)
  {
    super(paramab);
  }

  private void a(i parami, op.a parama)
  {
    parami.c(op.a(parama));
    a().d(parami);
  }

  public boolean a(i parami)
  {
    b(parami);
    return true;
  }

  void b(i parami)
  {
    int i = 1;
    String str1 = parami.m();
    f localf1 = op.a(str1);
    String str2 = a().k();
    f localf2 = op.a(str2);
    int j;
    if (!localf1.equals(localf2))
    {
      if ((!TextUtils.isEmpty(localf1.a())) || (TextUtils.isEmpty(localf2.a())))
        break label93;
      j = i;
      if (j == 0)
        break label99;
      parami.a(str2);
      a(parami, op.a.b);
    }
    while (true)
    {
      a().a(str1);
      return;
      label93: j = 0;
      break;
      label99: if ((!TextUtils.isEmpty(localf1.a())) && (TextUtils.isEmpty(localf2.a())));
      for (int k = i; ; k = 0)
      {
        if (k == 0)
          break label146;
        a(parami, op.a.a);
        break;
      }
      label146: if ((!TextUtils.isEmpty(localf1.a())) && (!localf1.a().equals(localf2.a())));
      while (true)
      {
        if (i == 0)
          break label193;
        a(parami, op.a.c);
        break;
        i = 0;
      }
      label193: a(parami, op.a.d);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.cv
 * JD-Core Version:    0.6.2
 */