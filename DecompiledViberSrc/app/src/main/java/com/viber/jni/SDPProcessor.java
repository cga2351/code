package com.viber.jni;

import com.viber.common.b.h;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.g.a.b;
import com.viber.voip.settings.d.m;
import com.viber.voip.util.n;
import com.viber.voip.util.u.b;
import java.util.Arrays;
import java.util.List;

public class SDPProcessor
{
  private final long native_handle;

  public SDPProcessor(String paramString)
  {
    this.native_handle = newSDPProcessor_native(paramString);
  }

  private static native String generate_native(long paramLong, int paramInt);

  private static native long newSDPProcessor_native(String paramString);

  private String patchOpusBitrateAndPTime(String paramString)
  {
    String str1 = d.m.x.d();
    String str2 = d.m.z.d();
    if (g.a().a(a.b.k))
    {
      str1 = "6000";
      str2 = "120";
    }
    return paramString.replaceAll("maxaveragebitrate=12000", "maxaveragebitrate=" + str1).replaceAll("ptime=60", "ptime=" + str2).replaceAll("maxptime=100", "maxptime=120");
  }

  private static native void releaseSDPProcessor_native(long paramLong);

  private static native void setVideoCodecsOrder_native(long paramLong, int[] paramArrayOfInt);

  private static native int[] videoCodecsOrder_native(long paramLong);

  public void dispose()
  {
    if (0L != this.native_handle)
      releaseSDPProcessor_native(this.native_handle);
  }

  public String generate()
  {
    return patchOpusBitrateAndPTime(generate(kCodecId.kCodecId_Unknown));
  }

  public String generate(kCodecId paramkCodecId)
  {
    return generate_native(this.native_handle, paramkCodecId.ordinal());
  }

  public void setVideoCodecsOrder(List<kCodecId> paramList)
  {
    int[] arrayOfInt = new int[paramList.size()];
    for (int i = 0; i < paramList.size(); i++)
      arrayOfInt[i] = ((kCodecId)paramList.get(i)).ordinal();
    setVideoCodecsOrder_native(this.native_handle, arrayOfInt);
  }

  public List<kCodecId> videoCodecsOrder()
  {
    return Arrays.asList(n.a(kCodecId.class, n.a(videoCodecsOrder_native(this.native_handle)), new u.b()
    {
      public SDPProcessor.kCodecId transform(Integer paramAnonymousInteger)
      {
        return SDPProcessor.kCodecId.values()[paramAnonymousInteger.intValue()];
      }
    }));
  }

  public static enum kCodecId
  {
    static
    {
      kCodecId_PCMA = new kCodecId("kCodecId_PCMA", 1);
      kCodecId_PCMU = new kCodecId("kCodecId_PCMU", 2);
      kCodecId_ISAC = new kCodecId("kCodecId_ISAC", 3);
      kCodecId_ILBC = new kCodecId("kCodecId_ILBC", 4);
      kCodecId_OPUS = new kCodecId("kCodecId_OPUS", 5);
      kCodecId_CN = new kCodecId("kCodecId_CN", 6);
      kCodecId_DTMF = new kCodecId("kCodecId_DTMF", 7);
      kCodecId_VP8 = new kCodecId("kCodecId_VP8", 8);
      kCodecId_VP9 = new kCodecId("kCodecId_VP9", 9);
      kCodecId_H264 = new kCodecId("kCodecId_H264", 10);
      kCodecId[] arrayOfkCodecId = new kCodecId[11];
      arrayOfkCodecId[0] = kCodecId_Unknown;
      arrayOfkCodecId[1] = kCodecId_PCMA;
      arrayOfkCodecId[2] = kCodecId_PCMU;
      arrayOfkCodecId[3] = kCodecId_ISAC;
      arrayOfkCodecId[4] = kCodecId_ILBC;
      arrayOfkCodecId[5] = kCodecId_OPUS;
      arrayOfkCodecId[6] = kCodecId_CN;
      arrayOfkCodecId[7] = kCodecId_DTMF;
      arrayOfkCodecId[8] = kCodecId_VP8;
      arrayOfkCodecId[9] = kCodecId_VP9;
      arrayOfkCodecId[10] = kCodecId_H264;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.SDPProcessor
 * JD-Core Version:    0.6.2
 */