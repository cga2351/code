package com.viber.voip.videoconvert.gpu.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class e
{
  public static Process a(String[] paramArrayOfString, String paramString, boolean paramBoolean)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList(Arrays.asList(paramArrayOfString));
    ProcessBuilder localProcessBuilder = new ProcessBuilder(localArrayList);
    com.viber.voip.videoconvert.e.a().a("cmdline: '" + localProcessBuilder.command().toString().replace(", ", " ") + "'");
    Process localProcess = Runtime.getRuntime().exec((String[])localArrayList.toArray(new String[localArrayList.size()]));
    if ((paramBoolean) && (localProcess != null))
    {
      a locala1 = new a(localProcess.getInputStream(), paramString + ": STDOUT", null);
      a locala2 = new a(localProcess.getErrorStream(), paramString + ": STDERR", null);
      locala1.start();
      locala2.start();
    }
    return localProcess;
  }

  private static class a extends Thread
  {
    InputStream a;
    String b;

    private a(InputStream paramInputStream, String paramString)
    {
      this.a = paramInputStream;
      this.b = paramString;
    }

    public void run()
    {
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(this.a));
        while (true)
        {
          String str = localBufferedReader.readLine();
          if (str == null)
            break;
          com.viber.voip.videoconvert.e.a().a(this.b + "> " + str);
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.a.e
 * JD-Core Version:    0.6.2
 */