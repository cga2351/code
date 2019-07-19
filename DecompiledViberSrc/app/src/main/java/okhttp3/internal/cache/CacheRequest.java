package okhttp3.internal.cache;

import f.s;
import java.io.IOException;

public abstract interface CacheRequest
{
  public abstract void abort();

  public abstract s body()
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.cache.CacheRequest
 * JD-Core Version:    0.6.2
 */