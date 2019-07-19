package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.e;
import com.yandex.metrica.impl.i;

public class cy extends ci
{
  public cy(ab paramab)
  {
    super(paramab);
  }

  public boolean a(i parami)
  {
    String str1 = a().H();
    String str2 = parami.t();
    a().b(str2);
    if (!TextUtils.equals(str1, str2))
      a().a(e.a());
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.cy
 * JD-Core Version:    0.6.2
 */