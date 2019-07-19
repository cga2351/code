package okhttp3;

import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

public final class Challenge
{
  private final Charset charset;
  private final String realm;
  private final String scheme;

  public Challenge(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, Util.ISO_8859_1);
  }

  private Challenge(String paramString1, String paramString2, Charset paramCharset)
  {
    if (paramString1 == null)
      throw new NullPointerException("scheme == null");
    if (paramString2 == null)
      throw new NullPointerException("realm == null");
    if (paramCharset == null)
      throw new NullPointerException("charset == null");
    this.scheme = paramString1;
    this.realm = paramString2;
    this.charset = paramCharset;
  }

  public Charset charset()
  {
    return this.charset;
  }

  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof Challenge)) && (((Challenge)paramObject).scheme.equals(this.scheme)) && (((Challenge)paramObject).realm.equals(this.realm)) && (((Challenge)paramObject).charset.equals(this.charset));
  }

  public int hashCode()
  {
    return 31 * (31 * (899 + this.realm.hashCode()) + this.scheme.hashCode()) + this.charset.hashCode();
  }

  public String realm()
  {
    return this.realm;
  }

  public String scheme()
  {
    return this.scheme;
  }

  public String toString()
  {
    return this.scheme + " realm=\"" + this.realm + "\" charset=\"" + this.charset + "\"";
  }

  public Challenge withCharset(Charset paramCharset)
  {
    return new Challenge(this.scheme, this.realm, paramCharset);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.Challenge
 * JD-Core Version:    0.6.2
 */