package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class zzaw extends zzfm
{
  private final SSLSocketFactory zzamo;

  public zzaw(zzfn paramzzfn)
  {
    super(paramzzfn);
    if (Build.VERSION.SDK_INT < 19);
    for (zzfy localzzfy = new zzfy(); ; localzzfy = null)
    {
      this.zzamo = localzzfy;
      return;
    }
  }

  private static byte[] zzb(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    InputStream localInputStream = null;
    ByteArrayOutputStream localByteArrayOutputStream;
    try
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localInputStream = paramHttpURLConnection.getInputStream();
      byte[] arrayOfByte1 = new byte[1024];
      while (true)
      {
        int i = localInputStream.read(arrayOfByte1);
        if (i <= 0)
          break;
        localByteArrayOutputStream.write(arrayOfByte1, 0, i);
      }
    }
    finally
    {
      if (localInputStream != null)
        localInputStream.close();
    }
    byte[] arrayOfByte2 = localByteArrayOutputStream.toByteArray();
    if (localInputStream != null)
      localInputStream.close();
    return arrayOfByte2;
  }

  @VisibleForTesting
  protected final HttpURLConnection zzb(URL paramURL)
    throws IOException
  {
    URLConnection localURLConnection = paramURL.openConnection();
    if (!(localURLConnection instanceof HttpURLConnection))
      throw new IOException("Failed to obtain HTTP connection");
    if ((this.zzamo != null) && ((localURLConnection instanceof HttpsURLConnection)))
      ((HttpsURLConnection)localURLConnection).setSSLSocketFactory(this.zzamo);
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURLConnection;
    localHttpURLConnection.setDefaultUseCaches(false);
    localHttpURLConnection.setConnectTimeout(60000);
    localHttpURLConnection.setReadTimeout(61000);
    localHttpURLConnection.setInstanceFollowRedirects(false);
    localHttpURLConnection.setDoInput(true);
    return localHttpURLConnection;
  }

  public final boolean zzfb()
  {
    zzcl();
    ConnectivityManager localConnectivityManager = (ConnectivityManager)getContext().getSystemService("connectivity");
    try
    {
      NetworkInfo localNetworkInfo2 = localConnectivityManager.getActiveNetworkInfo();
      localNetworkInfo1 = localNetworkInfo2;
      if ((localNetworkInfo1 != null) && (localNetworkInfo1.isConnected()))
        return true;
    }
    catch (SecurityException localSecurityException)
    {
      while (true)
        NetworkInfo localNetworkInfo1 = null;
    }
    return false;
  }

  protected final boolean zzgy()
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzaw
 * JD-Core Version:    0.6.2
 */