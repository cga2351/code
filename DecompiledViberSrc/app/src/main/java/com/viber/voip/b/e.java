package com.viber.voip.b;

import android.support.v4.util.LruCache;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.an;

public abstract class e<K, V> extends LruCache<K, V>
  implements c<K, V>
{
  private static final Logger a = ViberEnv.getLogger();
  private String b;

  public e(a parama)
  {
    super(a(parama.toString(), parama.m, parama.n));
    this.b = parama.name();
  }

  public e(String paramString, float paramFloat)
  {
    super(a(paramString, paramFloat));
    this.b = paramString;
  }

  public e(String paramString, float paramFloat1, float paramFloat2)
  {
    super(a(paramString, paramFloat1, paramFloat2));
    this.b = paramString;
  }

  private static int a(String paramString, float paramFloat)
  {
    return a(paramString, paramFloat, -1.0F);
  }

  private static int a(String paramString, float paramFloat1, float paramFloat2)
  {
    if ((paramFloat2 != -1.0F) && (an.a()));
    while (true)
    {
      return (int)(paramFloat2 * (float)an.b());
      paramFloat2 = paramFloat1;
    }
  }

  protected abstract int sizeOf(K paramK, V paramV);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.e
 * JD-Core Version:    0.6.2
 */