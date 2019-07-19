package com.yandex.metrica.impl;

import android.content.Context;
import android.util.SparseArray;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.impl.ob.jk;

public abstract class ao
{
  protected abstract int a(jk paramjk);

  abstract SparseArray<a> a();

  public void a(Context paramContext)
  {
    jk localjk = new jk(paramContext);
    int i = a(localjk);
    int j = b();
    if (i < j)
    {
      if (i > 0)
      {
        SparseArray localSparseArray = a();
        for (int k = i + 1; k <= j; k++)
        {
          a locala = (a)localSparseArray.get(k);
          if (locala != null)
            locala.a(paramContext);
        }
      }
      a(localjk, j);
      localjk.j();
    }
  }

  protected abstract void a(jk paramjk, int paramInt);

  int b()
  {
    return YandexMetrica.getLibraryApiLevel();
  }

  static abstract interface a
  {
    public abstract void a(Context paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ao
 * JD-Core Version:    0.6.2
 */