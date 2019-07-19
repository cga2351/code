package com.viber.voip.phone.conf;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ConferenceCallDebugUtils
{
  private static final Logger L = ViberEnv.getLogger();

  public static String pollRemoteSdpFromFile(String paramString)
  {
    try
    {
      File localFile = new File("/sdcard/remote_sdp.txt");
      FileInputStream localFileInputStream = new FileInputStream(localFile);
      byte[] arrayOfByte = new byte[(int)localFile.length()];
      localFileInputStream.read(arrayOfByte);
      localFileInputStream.close();
      String str = new String(arrayOfByte);
      return str;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      while (true)
        try
        {
          Thread.sleep(1000L);
        }
        catch (InterruptedException localInterruptedException)
        {
        }
    }
    catch (Exception localException)
    {
    }
    return paramString;
  }

  public static void saveLocalSdpToFile(String paramString)
  {
    try
    {
      PrintWriter localPrintWriter = new PrintWriter(new FileOutputStream("/sdcard/local_sdp.txt"));
      localPrintWriter.print(paramString);
      localPrintWriter.close();
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.conf.ConferenceCallDebugUtils
 * JD-Core Version:    0.6.2
 */