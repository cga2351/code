package okhttp3;

import f.f;
import java.nio.charset.Charset;
import okhttp3.internal.Util;

public final class Credentials
{
  public static String basic(String paramString1, String paramString2)
  {
    return basic(paramString1, paramString2, Util.ISO_8859_1);
  }

  public static String basic(String paramString1, String paramString2, Charset paramCharset)
  {
    String str = f.a(paramString1 + ":" + paramString2, paramCharset).b();
    return "Basic " + str;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.Credentials
 * JD-Core Version:    0.6.2
 */