package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public abstract interface ReadableMapKeySetIterator
{
  public abstract boolean hasNextKey();

  public abstract String nextKey();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReadableMapKeySetIterator
 * JD-Core Version:    0.6.2
 */