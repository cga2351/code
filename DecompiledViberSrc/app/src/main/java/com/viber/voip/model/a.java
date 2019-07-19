package com.viber.voip.model;

import android.content.Context;
import android.net.Uri;
import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;

public abstract interface a extends c
{
  public abstract void a(Context paramContext, a parama);

  public abstract long e();

  public abstract TreeMap<String, f> f();

  public abstract Uri g();

  public abstract Set<String> h();

  public abstract boolean i();

  public static abstract interface a
  {
    public abstract void a(Collection<f> paramCollection);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.a
 * JD-Core Version:    0.6.2
 */