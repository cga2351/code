package com.viber.voip.videoconvert.gpu.b;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import com.viber.voip.videoconvert.e;
import com.viber.voip.videoconvert.gpu.a.c;
import com.viber.voip.videoconvert.gpu.a.c.a;
import java.util.Iterator;
import java.util.List;

@TargetApi(16)
public abstract class a extends b
{
  protected static boolean a(List<String> paramList)
  {
    c localc = new c();
    a locala = new a(paramList);
    localc.a(locala);
    if (localc.b())
    {
      e.a().b("found blacklisted media codec: " + locala.a);
      return true;
    }
    return false;
  }

  public static final class a
    implements c.a
  {
    public String a = new String();
    private List<String> b;

    public a(List<String> paramList)
    {
      this.b = paramList;
    }

    public boolean a(MediaCodecInfo paramMediaCodecInfo)
    {
      String str = paramMediaCodecInfo.getName();
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
        if (str.startsWith((String)localIterator.next()))
        {
          this.a = str;
          return true;
        }
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.b.a
 * JD-Core Version:    0.6.2
 */