package com.viber.voip.videoconvert.gpu.b;

import com.viber.voip.videoconvert.gpu.a.a;
import com.viber.voip.videoconvert.gpu.encoders.c;
import com.viber.voip.videoconvert.gpu.f.d.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public abstract class b
  implements e
{
  protected static boolean a(String paramString)
  {
    if (!com.viber.voip.videoconvert.gpu.a.d.a(paramString, false));
    while (true)
    {
      return false;
      String[] arrayOfString = { com.viber.voip.videoconvert.gpu.a.d.a(paramString) };
      try
      {
        Process localProcess = com.viber.voip.videoconvert.gpu.a.e.a(arrayOfString, "AvailabilityChecker", true);
        if (localProcess != null)
        {
          localProcess.waitFor();
          return true;
        }
      }
      catch (IOException localIOException)
      {
        return false;
      }
      catch (InterruptedException localInterruptedException)
      {
      }
    }
    return false;
  }

  public static boolean b(List<a> paramList)
  {
    a locala = new a();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      if (((a)localIterator.next()).equals(locala))
        return true;
    return false;
  }

  protected c a(c paramc, com.viber.voip.videoconvert.gpu.f.d paramd, d.a parama, com.viber.voip.videoconvert.gpu.e.b paramb, com.viber.voip.videoconvert.gpu.receivers.b paramb1)
  {
    paramb.a(paramd, parama);
    paramc.a(paramb);
    paramc.a(paramb1);
    return paramc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.b.b
 * JD-Core Version:    0.6.2
 */