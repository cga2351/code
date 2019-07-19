package com.viber.voip.videoconvert.gpu.a;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(16)
public class c
{
  private List<a> a = new ArrayList();

  public List<MediaCodecInfo> a()
  {
    int i = MediaCodecList.getCodecCount();
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    MediaCodecInfo localMediaCodecInfo;
    if (j < i)
    {
      localMediaCodecInfo = MediaCodecList.getCodecInfoAt(j);
      Iterator localIterator = this.a.iterator();
      do
        if (!localIterator.hasNext())
          break;
      while (((a)localIterator.next()).a(localMediaCodecInfo));
    }
    for (int k = 0; ; k = 1)
    {
      if (k != 0)
        localArrayList.add(localMediaCodecInfo);
      j++;
      break;
      return localArrayList;
    }
  }

  public void a(a parama)
  {
    this.a.add(parama);
  }

  public boolean b()
  {
    return !a().isEmpty();
  }

  public static abstract interface a
  {
    public abstract boolean a(MediaCodecInfo paramMediaCodecInfo);
  }

  public static class b
    implements c.a
  {
    public boolean a(MediaCodecInfo paramMediaCodecInfo)
    {
      return !paramMediaCodecInfo.isEncoder();
    }
  }

  public static class c
    implements c.a
  {
    public boolean a(MediaCodecInfo paramMediaCodecInfo)
    {
      return paramMediaCodecInfo.isEncoder();
    }
  }

  public static class d
    implements c.a
  {
    private String a;

    public d(String paramString)
    {
      this.a = paramString;
    }

    public boolean a(MediaCodecInfo paramMediaCodecInfo)
    {
      String[] arrayOfString = paramMediaCodecInfo.getSupportedTypes();
      for (int i = 0; ; i++)
      {
        int j = arrayOfString.length;
        boolean bool = false;
        if (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(this.a))
            bool = true;
        }
        else
          return bool;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.a.c
 * JD-Core Version:    0.6.2
 */