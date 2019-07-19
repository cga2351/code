package com.yandex.metrica.impl;

import android.content.Context;
import com.yandex.metrica.impl.ob.od;
import com.yandex.metrica.impl.ob.y;
import java.util.concurrent.Executor;

public class aq
{
  private Executor a;

  public aq()
  {
    this(ak.a);
  }

  public aq(Executor paramExecutor)
  {
    this.a = paramExecutor;
  }

  public ap a(Context paramContext, y paramy)
  {
    ap localap = new ap(paramContext, paramy, this.a);
    localap.setName(od.c("YMM-NC[" + paramy + "]"));
    localap.start();
    return localap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.aq
 * JD-Core Version:    0.6.2
 */