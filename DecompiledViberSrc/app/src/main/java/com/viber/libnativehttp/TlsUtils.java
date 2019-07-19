package com.viber.libnativehttp;

import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLContext;
import okhttp3.ConnectionSpec;
import okhttp3.ConnectionSpec.Builder;
import okhttp3.OkHttpClient.Builder;
import okhttp3.TlsVersion;

public class TlsUtils
{
  public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder paramBuilder)
  {
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT < 22));
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLSv1.2");
      localSSLContext.init(null, null, null);
      paramBuilder.sslSocketFactory(new Tls12SocketFactory(localSSLContext.getSocketFactory()));
      ConnectionSpec.Builder localBuilder = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS);
      TlsVersion[] arrayOfTlsVersion = new TlsVersion[1];
      arrayOfTlsVersion[0] = TlsVersion.TLS_1_2;
      ConnectionSpec localConnectionSpec = localBuilder.tlsVersions(arrayOfTlsVersion).build();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localConnectionSpec);
      localArrayList.add(ConnectionSpec.COMPATIBLE_TLS);
      localArrayList.add(ConnectionSpec.CLEARTEXT);
      paramBuilder.connectionSpecs(localArrayList);
      return paramBuilder;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramBuilder;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.libnativehttp.TlsUtils
 * JD-Core Version:    0.6.2
 */