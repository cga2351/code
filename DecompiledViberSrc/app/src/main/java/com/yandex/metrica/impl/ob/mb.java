package com.yandex.metrica.impl.ob;

import java.util.Collections;
import java.util.List;

public class mb
{
  public final List<me> a;
  public final String b;
  public final long c;
  public final boolean d;
  public final boolean e;

  public mb(List<me> paramList, String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = Collections.unmodifiableList(paramList);
    this.b = paramString;
    this.c = paramLong;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }

  public String toString()
  {
    return "SdkFingerprintingState{sdkItemList=" + this.a + ", etag='" + this.b + '\'' + ", lastAttemptTime=" + this.c + ", hasFirstCollectionOccurred=" + this.d + ", shouldRetry=" + this.e + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.mb
 * JD-Core Version:    0.6.2
 */