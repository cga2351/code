package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class MediaType
{
  private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  private static final String QUOTED = "\"([^\"]*)\"";
  private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
  private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

  @Nullable
  private final String charset;
  private final String mediaType;
  private final String subtype;
  private final String type;

  private MediaType(String paramString1, String paramString2, String paramString3, @Nullable String paramString4)
  {
    this.mediaType = paramString1;
    this.type = paramString2;
    this.subtype = paramString3;
    this.charset = paramString4;
  }

  @Nullable
  public static MediaType parse(String paramString)
  {
    Matcher localMatcher1 = TYPE_SUBTYPE.matcher(paramString);
    if (!localMatcher1.lookingAt());
    String str1;
    String str2;
    Object localObject;
    label209: 
    while (true)
    {
      return null;
      str1 = localMatcher1.group(1).toLowerCase(Locale.US);
      str2 = localMatcher1.group(2).toLowerCase(Locale.US);
      Matcher localMatcher2 = PARAMETER.matcher(paramString);
      int i = localMatcher1.end();
      localObject = null;
      while (true)
      {
        if (i >= paramString.length())
          break label211;
        localMatcher2.region(i, paramString.length());
        if (!localMatcher2.lookingAt())
          break;
        String str3 = localMatcher2.group(1);
        if ((str3 != null) && (str3.equalsIgnoreCase("charset")))
          break label121;
        i = localMatcher2.end();
      }
      label121: String str4 = localMatcher2.group(2);
      if (str4 != null)
        if ((!str4.startsWith("'")) || (!str4.endsWith("'")) || (str4.length() <= 2));
      for (str4 = str4.substring(1, -1 + str4.length()); ; str4 = localMatcher2.group(3))
      {
        if ((localObject != null) && (!str4.equalsIgnoreCase((String)localObject)))
          break label209;
        localObject = str4;
        break;
      }
    }
    label211: return new MediaType(paramString, str1, str2, (String)localObject);
  }

  @Nullable
  public Charset charset()
  {
    return charset(null);
  }

  @Nullable
  public Charset charset(@Nullable Charset paramCharset)
  {
    try
    {
      if (this.charset != null)
      {
        Charset localCharset = Charset.forName(this.charset);
        paramCharset = localCharset;
      }
      return paramCharset;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
    return paramCharset;
  }

  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof MediaType)) && (((MediaType)paramObject).mediaType.equals(this.mediaType));
  }

  public int hashCode()
  {
    return this.mediaType.hashCode();
  }

  public String subtype()
  {
    return this.subtype;
  }

  public String toString()
  {
    return this.mediaType;
  }

  public String type()
  {
    return this.type;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.MediaType
 * JD-Core Version:    0.6.2
 */