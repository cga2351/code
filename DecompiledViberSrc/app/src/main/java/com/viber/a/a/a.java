package com.viber.a.a;

import android.content.Context;
import com.viber.common.d.e;
import com.viber.common.d.e.a;
import com.viber.dexshared.Logger;
import com.viber.dexshared.LoggerFactoryHelper;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.p;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.util.bj;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private static int b = 14;

  private static void a(int paramInt, File paramFile)
  {
    if (paramFile.exists())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        long l = System.currentTimeMillis() - 1000L * (60 * (60 * (paramInt * 24)));
        int i = arrayOfFile.length;
        for (int j = 0; j < i; j++)
        {
          File localFile = arrayOfFile[j];
          if ((localFile.lastModified() >= l) || (localFile.delete()));
        }
      }
    }
  }

  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      File localFile1 = ViberEnv.getLoggerFactory().getLoggerConfig().a();
      if (localFile1 == null)
        return;
      File localFile2 = localFile1.getParentFile();
      File localFile3 = new File(localFile2, "crash");
      b(localFile3);
      a(localFile2);
      String str = ViberApplication.getInstance().getHardwareParameters().getUdid();
      File localFile4 = new File(localFile2.getParentFile(), "viber_" + p.f() + "_" + str + "_log.zip");
      new e.a().a(paramContext.getString(b.t)).b("").c(paramString1).a(paramString2).a(paramContext, localFile2, localFile4, "com.viber.voip.provider.file").a().a(paramContext, "media/image", paramContext.getString(R.string.msg_options_take_video));
      a(localFile1, localFile3);
      return;
    }
    catch (Exception localException)
    {
      a.a(localException, "Unable to prepare logs for sending.");
    }
  }

  private static void a(File paramFile)
  {
    File localFile1 = new File("/data/anr/traces.txt");
    File localFile2;
    if (localFile1.exists())
      localFile2 = new File(paramFile, "system-anrs.txt");
    try
    {
      bj.a(localFile1, localFile2);
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  private static void a(File paramFile1, File paramFile2)
  {
    if (paramFile2.exists())
    {
      String[] arrayOfString = paramFile2.list(new FilenameFilter()
      {
        public boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          return paramAnonymousString.endsWith(".stacktrace");
        }
      });
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
        new File(paramFile2, arrayOfString[j]).delete();
    }
    a(b, paramFile1);
  }

  private static void b(File paramFile)
    throws IOException
  {
    if (paramFile == null)
      return;
    b(new File(p.h()), paramFile);
  }

  private static void b(File paramFile1, File paramFile2)
    throws IOException
  {
    if (paramFile1.isDirectory())
    {
      if (!paramFile2.exists())
        paramFile2.mkdir();
      String[] arrayOfString = paramFile1.list();
      for (int i = 0; i < arrayOfString.length; i++)
        b(new File(paramFile1, arrayOfString[i]), new File(paramFile2, arrayOfString[i]));
    }
    if (paramFile1.exists())
      bj.a(paramFile1, paramFile2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.a.a.a
 * JD-Core Version:    0.6.2
 */