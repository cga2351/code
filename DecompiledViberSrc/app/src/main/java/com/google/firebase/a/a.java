package com.google.firebase.a;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class a<T>
{
  private final Class<T> a;
  private final T b;

  @KeepForSdk
  public Class<T> a()
  {
    return this.a;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = this.b;
    return String.format("Event{type: %s, payload: %s}", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.a.a
 * JD-Core Version:    0.6.2
 */