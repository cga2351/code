package c.a.a.a.a.b;

import c.a.a.a.a.e.c;
import c.a.a.a.a.e.d;
import c.a.a.a.a.e.e;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class a
{
  private static final Pattern b = Pattern.compile("http(s?)://[^\\/]+", 2);
  protected final c.a.a.a.i a;
  private final String c;
  private final e d;
  private final c e;
  private final String f;

  public a(c.a.a.a.i parami, String paramString1, String paramString2, e parame, c paramc)
  {
    if (paramString2 == null)
      throw new IllegalArgumentException("url must not be null.");
    if (parame == null)
      throw new IllegalArgumentException("requestFactory must not be null.");
    this.a = parami;
    this.f = paramString1;
    this.c = a(paramString2);
    this.d = parame;
    this.e = paramc;
  }

  private String a(String paramString)
  {
    if (!i.d(this.f))
      paramString = b.matcher(paramString).replaceFirst(this.f);
    return paramString;
  }

  protected d a(Map<String, String> paramMap)
  {
    return this.d.a(this.e, a(), paramMap).a(false).a(10000).a("User-Agent", "Crashlytics Android SDK/" + this.a.a()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
  }

  protected String a()
  {
    return this.c;
  }

  protected d b()
  {
    return a(Collections.emptyMap());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.b.a
 * JD-Core Version:    0.6.2
 */