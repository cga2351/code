package com.viber.voip.videoconvert.gpu.d;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaFormat;
import com.viber.voip.videoconvert.e;
import com.viber.voip.videoconvert.gpu.encoders.c.b;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

@TargetApi(16)
public class a
  implements b
{
  SortedSet<Integer> a;
  MediaCodecInfo b;
  int c;
  int d;

  public a(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt)
  {
    this.b = paramMediaCodecInfo;
    MediaCodecInfo.CodecCapabilities localCodecCapabilities = this.b.getCapabilitiesForType(paramString);
    this.a = new TreeSet();
    for (int k : localCodecCapabilities.colorFormats)
      this.a.add(Integer.valueOf(k));
    this.c = paramInt;
  }

  public int a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      switch (localInteger.intValue())
      {
      default:
        break;
      case 19:
      case 20:
      case 21:
      case 39:
      case 2130706433:
      case 2130706688:
      case 2141391872:
      case 2141391873:
      case 2141391874:
      case 2141391875:
      case 2141391876:
        this.d = localInteger.intValue();
        return localInteger.intValue();
      }
    }
    this.d = this.c;
    return this.c;
  }

  protected void a(int paramInt)
  {
    this.a.remove(Integer.valueOf(paramInt));
  }

  public void a(MediaFormat paramMediaFormat)
  {
    try
    {
      this.d = paramMediaFormat.getInteger("color-format");
      e.a().a("encoder colorspace updated to " + this.d);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public int b()
  {
    return this.d;
  }

  public c.b c()
  {
    int i = b();
    c.b localb = c.b.f;
    switch (i)
    {
    default:
      throw new RuntimeException("Unknown encoder colorspace used, value=" + i);
    case 21:
      localb = c.b.f;
    case 2130708361:
      return localb;
    case 19:
    }
    return c.b.e;
  }

  public int d()
  {
    return 1;
  }

  public int e()
  {
    return 1;
  }

  public int f()
  {
    return 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.d.a
 * JD-Core Version:    0.6.2
 */