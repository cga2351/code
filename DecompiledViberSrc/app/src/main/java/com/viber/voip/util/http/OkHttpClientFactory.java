package com.viber.voip.util.http;

import com.viber.dexshared.Logger;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;

public abstract interface OkHttpClientFactory
{
  public abstract OkHttpClient.Builder createBuilder();

  public abstract OkHttpClient.Builder createBuilder(Type paramType);

  public abstract OkHttpClient createClient();

  public abstract OkHttpClient createClient(Type paramType);

  public abstract void logRequests(OkHttpClient.Builder paramBuilder, Logger paramLogger);

  public static enum Type
  {
    static
    {
      ABSTRACT_OK_HTTP_UPLOAD_TASK = new Type("ABSTRACT_OK_HTTP_UPLOAD_TASK", 1);
      MEDIA_SHARE = new Type("MEDIA_SHARE", 2);
      QUICK_REQUEST = new Type("QUICK_REQUEST", 3);
      NATIVE_HTTP = new Type("NATIVE_HTTP", 4);
      DIRECT = new Type("DIRECT", 5);
      REACT = new Type("REACT", 6);
      GZIP_AWARE = new Type("GZIP_AWARE", 7);
      Type[] arrayOfType = new Type[8];
      arrayOfType[0] = DEFAULT;
      arrayOfType[1] = ABSTRACT_OK_HTTP_UPLOAD_TASK;
      arrayOfType[2] = MEDIA_SHARE;
      arrayOfType[3] = QUICK_REQUEST;
      arrayOfType[4] = NATIVE_HTTP;
      arrayOfType[5] = DIRECT;
      arrayOfType[6] = REACT;
      arrayOfType[7] = GZIP_AWARE;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.http.OkHttpClientFactory
 * JD-Core Version:    0.6.2
 */