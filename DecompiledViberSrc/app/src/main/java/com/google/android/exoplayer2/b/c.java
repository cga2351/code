package com.google.android.exoplayer2.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

@TargetApi(21)
public final class c
{
  public static final c a = new c(new int[] { 2 }, 8);
  private final int[] b;
  private final int c;

  public c(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt != null)
    {
      this.b = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
      Arrays.sort(this.b);
    }
    while (true)
    {
      this.c = paramInt;
      return;
      this.b = new int[0];
    }
  }

  public static c a(Context paramContext)
  {
    return a(paramContext.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
  }

  @SuppressLint({"InlinedApi"})
  static c a(Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0))
      return a;
    return new c(paramIntent.getIntArrayExtra("android.media.extra.ENCODINGS"), paramIntent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
  }

  public int a()
  {
    return this.c;
  }

  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.b, paramInt) >= 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    c localc;
    do
    {
      return true;
      if (!(paramObject instanceof c))
        return false;
      localc = (c)paramObject;
    }
    while ((Arrays.equals(this.b, localc.b)) && (this.c == localc.c));
    return false;
  }

  public int hashCode()
  {
    return this.c + 31 * Arrays.hashCode(this.b);
  }

  public String toString()
  {
    return "AudioCapabilities[maxChannelCount=" + this.c + ", supportedEncodings=" + Arrays.toString(this.b) + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.c
 * JD-Core Version:    0.6.2
 */