package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.b.a;
import java.util.Set;

@KeepForSdk
public abstract interface e
{
  @KeepForSdk
  public abstract <T> T a(Class<T> paramClass);

  @KeepForSdk
  public abstract <T> Set<T> b(Class<T> paramClass);

  @KeepForSdk
  public abstract <T> a<T> c(Class<T> paramClass);

  @KeepForSdk
  public abstract <T> a<Set<T>> d(Class<T> paramClass);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.components.e
 * JD-Core Version:    0.6.2
 */