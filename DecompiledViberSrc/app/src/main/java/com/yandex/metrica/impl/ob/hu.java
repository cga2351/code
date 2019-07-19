package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;

public class hu
{
  private final fl a;
  private final ho b;

  public hu(Context paramContext)
  {
    this(fj.a(paramContext).h(), new ho(paramContext));
  }

  hu(fl paramfl, ho paramho)
  {
    this.a = paramfl;
    this.b = paramho;
  }

  public void a(hv paramhv)
  {
    String str = this.b.a(paramhv);
    if (!TextUtils.isEmpty(str))
      this.a.a(paramhv.b(), str);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hu
 * JD-Core Version:    0.6.2
 */