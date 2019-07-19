package com.microsoft.codepush.react;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;

class k
{
  private long a;
  private long b;

  public k(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }

  public WritableMap a()
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    if (this.a < 2147483647L)
    {
      localWritableNativeMap.putInt("totalBytes", (int)this.a);
      localWritableNativeMap.putInt("receivedBytes", (int)this.b);
      return localWritableNativeMap;
    }
    localWritableNativeMap.putDouble("totalBytes", this.a);
    localWritableNativeMap.putDouble("receivedBytes", this.b);
    return localWritableNativeMap;
  }

  public boolean b()
  {
    return this.a == this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.microsoft.codepush.react.k
 * JD-Core Version:    0.6.2
 */