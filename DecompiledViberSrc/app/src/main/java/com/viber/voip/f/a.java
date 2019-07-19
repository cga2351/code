package com.viber.voip.f;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.io.File;

public class a
{
  private static final Logger a = ViberEnv.getLogger();

  public static void a(Context paramContext)
  {
    a(paramContext.getDir("working", 0));
    a(paramContext.getDir("optimized", 0));
  }

  private static void a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
        a(new File(paramFile, arrayOfString[j]));
    }
    paramFile.delete();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.f.a
 * JD-Core Version:    0.6.2
 */