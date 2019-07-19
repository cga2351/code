package com.viber.voip.util;

import android.net.TrafficStats;
import android.os.Process;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.e;
import java.util.Iterator;
import java.util.Set;

public class de
{
  private static long a(long paramLong)
  {
    return paramLong / 1048576L;
  }

  public static void a()
  {
    e.e("upload_url_list");
    e.e("download_url_list");
    e.e("request_url_list");
  }

  private static void a(Logger paramLogger, String paramString1, String paramString2, String paramString3)
  {
    Iterator localIterator = e.a(paramString2).iterator();
    while (localIterator.hasNext())
      ((String)localIterator.next());
  }

  public static void a(String paramString, long paramLong)
  {
  }

  public static long b()
  {
    return a(TrafficStats.getUidTxBytes(Process.myUid()));
  }

  public static long c()
  {
    return a(TrafficStats.getUidRxBytes(Process.myUid()));
  }

  public static void d()
  {
    Logger localLogger = ViberEnv.getLogger("Traffic info");
    a(localLogger, "Downloaded urls", "download_url_list", "bytes");
    a(localLogger, "Uploaded urls", "upload_url_list", "bytes");
    a(localLogger, "Request urls", "request_url_list", "times");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.de
 * JD-Core Version:    0.6.2
 */