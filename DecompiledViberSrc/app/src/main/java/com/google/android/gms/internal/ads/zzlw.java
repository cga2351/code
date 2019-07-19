package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;

@TargetApi(21)
public final class zzlw
{
  private static final zzlw zzave = new zzlw(new int[] { 2 }, 2);
  private final int[] zzavf;
  private final int zzavg;

  private zzlw(int[] paramArrayOfInt, int paramInt)
  {
    this.zzavf = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    Arrays.sort(this.zzavf);
    this.zzavg = 2;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzlw localzzlw;
    do
    {
      return true;
      if (!(paramObject instanceof zzlw))
        return false;
      localzzlw = (zzlw)paramObject;
    }
    while ((Arrays.equals(this.zzavf, localzzlw.zzavf)) && (this.zzavg == localzzlw.zzavg));
    return false;
  }

  public final int hashCode()
  {
    return this.zzavg + 31 * Arrays.hashCode(this.zzavf);
  }

  public final String toString()
  {
    int i = this.zzavg;
    String str = Arrays.toString(this.zzavf);
    return 67 + String.valueOf(str).length() + "AudioCapabilities[maxChannelCount=" + i + ", supportedEncodings=" + str + "]";
  }

  public final boolean zzaf(int paramInt)
  {
    return Arrays.binarySearch(this.zzavf, paramInt) >= 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzlw
 * JD-Core Version:    0.6.2
 */