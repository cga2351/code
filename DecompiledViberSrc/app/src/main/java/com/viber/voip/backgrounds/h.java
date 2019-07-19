package com.viber.voip.backgrounds;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.at;
import com.viber.voip.util.upload.o;
import java.io.File;
import java.io.FileFilter;

public class h
{
  private static final Logger a = ViberEnv.getLogger();

  public static void a(Context paramContext)
  {
    if (!o.c())
      return;
    b(paramContext);
    c(paramContext);
  }

  private static void b(Context paramContext)
  {
    File localFile = m.b(paramContext);
    if (!localFile.exists());
    while (true)
    {
      return;
      File[] arrayOfFile1 = localFile.listFiles(i.a);
      FileFilter localFileFilter = j.a;
      if (arrayOfFile1 != null)
      {
        int i = arrayOfFile1.length;
        for (int j = 0; j < i; j++)
        {
          File[] arrayOfFile2 = arrayOfFile1[j].listFiles(localFileFilter);
          if (arrayOfFile2 != null)
          {
            int k = arrayOfFile2.length;
            for (int m = 0; m < k; m++)
              at.f(arrayOfFile2[m]);
          }
        }
      }
    }
  }

  private static void c(Context paramContext)
  {
    File localFile = at.b(paramContext, ".backgrounds/cropped");
    if (!localFile.exists());
    while (true)
    {
      return;
      File[] arrayOfFile = localFile.listFiles(k.a);
      if (arrayOfFile != null)
      {
        int i = arrayOfFile.length;
        for (int j = 0; j < i; j++)
          at.f(arrayOfFile[j]);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.h
 * JD-Core Version:    0.6.2
 */