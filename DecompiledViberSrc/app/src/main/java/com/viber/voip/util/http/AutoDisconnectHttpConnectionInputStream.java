package com.viber.voip.util.http;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class AutoDisconnectHttpConnectionInputStream extends FilterInputStream
{
  private static final Logger L = ViberEnv.getLogger();
  private HttpURLConnection mConnection;

  public AutoDisconnectHttpConnectionInputStream(HttpURLConnection paramHttpURLConnection, InputStream paramInputStream)
  {
    super(paramInputStream);
    this.mConnection = paramHttpURLConnection;
  }

  public void close()
    throws IOException
  {
    try
    {
      super.close();
      if (this.mConnection == null);
    }
    catch (NullPointerException localNullPointerException)
    {
      try
      {
        this.mConnection.disconnect();
        return;
        localNullPointerException = localNullPointerException;
      }
      catch (Exception localException)
      {
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.http.AutoDisconnectHttpConnectionInputStream
 * JD-Core Version:    0.6.2
 */