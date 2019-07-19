package com.viber.voip.videoconvert;

import android.util.Log;
import java.util.logging.Logger;

public class e
{
  private static e b = null;
  private Logger a = Logger.getLogger("ViberVideoConverter");

  public static e a()
  {
    try
    {
      if (b == null)
        b = new e();
      return b;
    }
    finally
    {
    }
  }

  public void a(String paramString)
  {
    this.a.info(paramString);
  }

  public void a(Throwable paramThrowable)
  {
    String[] arrayOfString = Log.getStackTraceString(paramThrowable).split("\\r?\\n");
    String str1 = "Exception caught: " + paramThrowable.getMessage() + " ";
    int i = arrayOfString.length;
    int j = 1;
    Object localObject = str1;
    int k = 0;
    while (k < i)
    {
      String str2 = arrayOfString[k].trim();
      if (str2.startsWith("at "))
      {
        localObject = (String)localObject + new String(new char[j]).replace("", "  ") + str2;
        j++;
      }
      String str3 = (String)localObject + str2 + "\n";
      k++;
      localObject = str3;
    }
    this.a.warning((String)localObject);
  }

  public void b(String paramString)
  {
    this.a.info(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.e
 * JD-Core Version:    0.6.2
 */