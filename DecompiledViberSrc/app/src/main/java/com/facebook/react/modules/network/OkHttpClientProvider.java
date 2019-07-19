package com.facebook.react.modules.network;

import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.common.logging.FLog;
import java.io.File;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.ConnectionSpec.Builder;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.TlsVersion;

public class OkHttpClientProvider
{

  @Nullable
  private static OkHttpClient sClient;

  @Nullable
  private static OkHttpClientFactory sFactory;

  public static OkHttpClient createClient()
  {
    if (sFactory != null)
      return sFactory.createNewNetworkModuleClient();
    return createClientBuilder().build();
  }

  public static OkHttpClient createClient(Context paramContext)
  {
    if (sFactory != null)
      return sFactory.createNewNetworkModuleClient();
    return createClientBuilder(paramContext).build();
  }

  public static OkHttpClient.Builder createClientBuilder()
  {
    OkHttpClient.Builder localBuilder = new OkHttpClient.Builder().connectTimeout(0L, TimeUnit.MILLISECONDS).readTimeout(0L, TimeUnit.MILLISECONDS).writeTimeout(0L, TimeUnit.MILLISECONDS).cookieJar(new ReactCookieJarContainer());
    try
    {
      Security.insertProviderAt((Provider)Class.forName("org.conscrypt.OpenSSLProvider").newInstance(), 1);
      return localBuilder;
    }
    catch (Exception localException)
    {
    }
    return enableTls12OnPreLollipop(localBuilder);
  }

  public static OkHttpClient.Builder createClientBuilder(Context paramContext)
  {
    return createClientBuilder(paramContext, 10485760);
  }

  public static OkHttpClient.Builder createClientBuilder(Context paramContext, int paramInt)
  {
    OkHttpClient.Builder localBuilder = createClientBuilder();
    if (paramInt == 0)
      return localBuilder;
    return localBuilder.cache(new Cache(new File(paramContext.getCacheDir(), "http-cache"), paramInt));
  }

  public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder paramBuilder)
  {
    if (Build.VERSION.SDK_INT <= 19);
    try
    {
      paramBuilder.sslSocketFactory(new TLSSocketFactory());
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
      FLog.e("OkHttpClientProvider", "Error while enabling TLS 1.2", localException);
    }
    return paramBuilder;
  }

  public static OkHttpClient getOkHttpClient()
  {
    if (sClient == null)
      sClient = createClient();
    return sClient;
  }

  public static void setOkHttpClientFactory(OkHttpClientFactory paramOkHttpClientFactory)
  {
    sFactory = paramOkHttpClientFactory;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.OkHttpClientProvider
 * JD-Core Version:    0.6.2
 */