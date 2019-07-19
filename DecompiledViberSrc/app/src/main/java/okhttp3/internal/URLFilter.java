package okhttp3.internal;

import java.io.IOException;
import java.net.URL;

public abstract interface URLFilter
{
  public abstract void checkURLPermitted(URL paramURL)
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.URLFilter
 * JD-Core Version:    0.6.2
 */