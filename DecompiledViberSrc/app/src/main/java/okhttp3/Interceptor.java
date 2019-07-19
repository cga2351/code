package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public abstract interface Interceptor
{
  public abstract Response intercept(Chain paramChain)
    throws IOException;

  public static abstract interface Chain
  {
    public abstract Call call();

    public abstract int connectTimeoutMillis();

    @Nullable
    public abstract Connection connection();

    public abstract Response proceed(Request paramRequest)
      throws IOException;

    public abstract int readTimeoutMillis();

    public abstract Request request();

    public abstract Chain withConnectTimeout(int paramInt, TimeUnit paramTimeUnit);

    public abstract Chain withReadTimeout(int paramInt, TimeUnit paramTimeUnit);

    public abstract Chain withWriteTimeout(int paramInt, TimeUnit paramTimeUnit);

    public abstract int writeTimeoutMillis();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.Interceptor
 * JD-Core Version:    0.6.2
 */