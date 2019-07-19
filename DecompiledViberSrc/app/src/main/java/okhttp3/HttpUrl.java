package okhttp3;

import f.c;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

public final class HttpUrl
{
  static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
  static final String FRAGMENT_ENCODE_SET = "";
  static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
  static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
  static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
  static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
  static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
  static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
  static final String QUERY_ENCODE_SET = " \"'<>#";
  static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

  @Nullable
  private final String fragment;
  final String host;
  private final String password;
  private final List<String> pathSegments;
  final int port;

  @Nullable
  private final List<String> queryNamesAndValues;
  final String scheme;
  private final String url;
  private final String username;

  HttpUrl(Builder paramBuilder)
  {
    this.scheme = paramBuilder.scheme;
    this.username = percentDecode(paramBuilder.encodedUsername, false);
    this.password = percentDecode(paramBuilder.encodedPassword, false);
    this.host = paramBuilder.host;
    this.port = paramBuilder.effectivePort();
    this.pathSegments = percentDecode(paramBuilder.encodedPathSegments, false);
    if (paramBuilder.encodedQueryNamesAndValues != null);
    for (List localList = percentDecode(paramBuilder.encodedQueryNamesAndValues, true); ; localList = null)
    {
      this.queryNamesAndValues = localList;
      String str1 = paramBuilder.encodedFragment;
      String str2 = null;
      if (str1 != null)
        str2 = percentDecode(paramBuilder.encodedFragment, false);
      this.fragment = str2;
      this.url = paramBuilder.toString();
      return;
    }
  }

  static String canonicalize(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset)
  {
    int i = paramInt1;
    while (i < paramInt2)
    {
      int j = paramString1.codePointAt(i);
      if ((j < 32) || (j == 127) || ((j >= 128) && (paramBoolean4)) || (paramString2.indexOf(j) != -1) || ((j == 37) && ((!paramBoolean1) || ((paramBoolean2) && (!percentEncoded(paramString1, i, paramInt2))))) || ((j == 43) && (paramBoolean3)))
      {
        c localc = new c();
        localc.a(paramString1, paramInt1, i);
        canonicalize(localc, paramString1, i, paramInt2, paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramCharset);
        return localc.r();
      }
      i += Character.charCount(j);
    }
    return paramString1.substring(paramInt1, paramInt2);
  }

  static String canonicalize(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    return canonicalize(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, null);
  }

  static String canonicalize(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset)
  {
    return canonicalize(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramCharset);
  }

  static void canonicalize(c paramc, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Charset paramCharset)
  {
    c localc = null;
    if (paramInt1 < paramInt2)
    {
      int i = paramString1.codePointAt(paramInt1);
      if ((paramBoolean1) && ((i == 9) || (i == 10) || (i == 12) || (i == 13)));
      while (true)
      {
        paramInt1 += Character.charCount(i);
        break;
        if ((i == 43) && (paramBoolean3))
        {
          if (paramBoolean1);
          for (String str = "+"; ; str = "%2B")
          {
            paramc.a(str);
            break;
          }
        }
        if ((i < 32) || (i == 127) || ((i >= 128) && (paramBoolean4)) || (paramString2.indexOf(i) != -1) || ((i == 37) && ((!paramBoolean1) || ((paramBoolean2) && (!percentEncoded(paramString1, paramInt1, paramInt2))))))
        {
          if (localc == null)
            localc = new c();
          if ((paramCharset == null) || (paramCharset.equals(Util.UTF_8)))
            localc.a(i);
          while (!localc.f())
          {
            int j = 0xFF & localc.i();
            paramc.b(37);
            paramc.b(HEX_DIGITS[(0xF & j >> 4)]);
            paramc.b(HEX_DIGITS[(j & 0xF)]);
            continue;
            localc.a(paramString1, paramInt1, paramInt1 + Character.charCount(i), paramCharset);
          }
        }
        else
        {
          paramc.a(i);
        }
      }
    }
  }

  public static int defaultPort(String paramString)
  {
    if (paramString.equals("http"))
      return 80;
    if (paramString.equals("https"))
      return 443;
    return -1;
  }

  @Nullable
  public static HttpUrl get(URI paramURI)
  {
    return parse(paramURI.toString());
  }

  @Nullable
  public static HttpUrl get(URL paramURL)
  {
    return parse(paramURL.toString());
  }

  static HttpUrl getChecked(String paramString)
    throws MalformedURLException, UnknownHostException
  {
    Builder localBuilder = new Builder();
    HttpUrl.Builder.ParseResult localParseResult = localBuilder.parse(null, paramString);
    switch (1.$SwitchMap$okhttp3$HttpUrl$Builder$ParseResult[localParseResult.ordinal()])
    {
    default:
      throw new MalformedURLException("Invalid URL: " + localParseResult + " for " + paramString);
    case 1:
      return localBuilder.build();
    case 2:
    }
    throw new UnknownHostException("Invalid host: " + paramString);
  }

  static void namesAndValuesToQueryString(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int i = paramList.size();
    for (int j = 0; j < i; j += 2)
    {
      String str1 = (String)paramList.get(j);
      String str2 = (String)paramList.get(j + 1);
      if (j > 0)
        paramStringBuilder.append('&');
      paramStringBuilder.append(str1);
      if (str2 != null)
      {
        paramStringBuilder.append('=');
        paramStringBuilder.append(str2);
      }
    }
  }

  @Nullable
  public static HttpUrl parse(String paramString)
  {
    Builder localBuilder = new Builder();
    HttpUrl.Builder.ParseResult localParseResult1 = localBuilder.parse(null, paramString);
    HttpUrl.Builder.ParseResult localParseResult2 = HttpUrl.Builder.ParseResult.SUCCESS;
    HttpUrl localHttpUrl = null;
    if (localParseResult1 == localParseResult2)
      localHttpUrl = localBuilder.build();
    return localHttpUrl;
  }

  static void pathSegmentsToString(StringBuilder paramStringBuilder, List<String> paramList)
  {
    int i = paramList.size();
    for (int j = 0; j < i; j++)
    {
      paramStringBuilder.append('/');
      paramStringBuilder.append((String)paramList.get(j));
    }
  }

  static String percentDecode(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    for (int i = paramInt1; i < paramInt2; i++)
    {
      int j = paramString.charAt(i);
      if ((j == 37) || ((j == 43) && (paramBoolean)))
      {
        c localc = new c();
        localc.a(paramString, paramInt1, i);
        percentDecode(localc, paramString, i, paramInt2, paramBoolean);
        return localc.r();
      }
    }
    return paramString.substring(paramInt1, paramInt2);
  }

  static String percentDecode(String paramString, boolean paramBoolean)
  {
    return percentDecode(paramString, 0, paramString.length(), paramBoolean);
  }

  private List<String> percentDecode(List<String> paramList, boolean paramBoolean)
  {
    int i = paramList.size();
    ArrayList localArrayList = new ArrayList(i);
    int j = 0;
    if (j < i)
    {
      String str1 = (String)paramList.get(j);
      if (str1 != null);
      for (String str2 = percentDecode(str1, paramBoolean); ; str2 = null)
      {
        localArrayList.add(str2);
        j++;
        break;
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }

  static void percentDecode(c paramc, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramInt1;
    if (i < paramInt2)
    {
      int j = paramString.codePointAt(i);
      if ((j == 37) && (i + 2 < paramInt2))
      {
        int k = Util.decodeHexDigit(paramString.charAt(i + 1));
        int m = Util.decodeHexDigit(paramString.charAt(i + 2));
        if ((k == -1) || (m == -1))
          break label120;
        paramc.b(m + (k << 4));
        i += 2;
      }
      while (true)
      {
        i += Character.charCount(j);
        break;
        if ((j == 43) && (paramBoolean))
          paramc.b(32);
        else
          label120: paramc.a(j);
      }
    }
  }

  static boolean percentEncoded(String paramString, int paramInt1, int paramInt2)
  {
    return (paramInt1 + 2 < paramInt2) && (paramString.charAt(paramInt1) == '%') && (Util.decodeHexDigit(paramString.charAt(paramInt1 + 1)) != -1) && (Util.decodeHexDigit(paramString.charAt(paramInt1 + 2)) != -1);
  }

  static List<String> queryStringToNamesAndValues(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i <= paramString.length())
    {
      int j = paramString.indexOf('&', i);
      if (j == -1)
        j = paramString.length();
      int k = paramString.indexOf('=', i);
      if ((k == -1) || (k > j))
      {
        localArrayList.add(paramString.substring(i, j));
        localArrayList.add(null);
      }
      while (true)
      {
        i = j + 1;
        break;
        localArrayList.add(paramString.substring(i, k));
        localArrayList.add(paramString.substring(k + 1, j));
      }
    }
    return localArrayList;
  }

  @Nullable
  public String encodedFragment()
  {
    if (this.fragment == null)
      return null;
    int i = 1 + this.url.indexOf('#');
    return this.url.substring(i);
  }

  public String encodedPassword()
  {
    if (this.password.isEmpty())
      return "";
    int i = 1 + this.url.indexOf(':', 3 + this.scheme.length());
    int j = this.url.indexOf('@');
    return this.url.substring(i, j);
  }

  public String encodedPath()
  {
    int i = this.url.indexOf('/', 3 + this.scheme.length());
    int j = Util.delimiterOffset(this.url, i, this.url.length(), "?#");
    return this.url.substring(i, j);
  }

  public List<String> encodedPathSegments()
  {
    int i = this.url.indexOf('/', 3 + this.scheme.length());
    int j = Util.delimiterOffset(this.url, i, this.url.length(), "?#");
    ArrayList localArrayList = new ArrayList();
    while (i < j)
    {
      int k = i + 1;
      i = Util.delimiterOffset(this.url, k, j, '/');
      localArrayList.add(this.url.substring(k, i));
    }
    return localArrayList;
  }

  @Nullable
  public String encodedQuery()
  {
    if (this.queryNamesAndValues == null)
      return null;
    int i = 1 + this.url.indexOf('?');
    int j = Util.delimiterOffset(this.url, i, this.url.length(), '#');
    return this.url.substring(i, j);
  }

  public String encodedUsername()
  {
    if (this.username.isEmpty())
      return "";
    int i = 3 + this.scheme.length();
    int j = Util.delimiterOffset(this.url, i, this.url.length(), ":@");
    return this.url.substring(i, j);
  }

  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof HttpUrl)) && (((HttpUrl)paramObject).url.equals(this.url));
  }

  @Nullable
  public String fragment()
  {
    return this.fragment;
  }

  public int hashCode()
  {
    return this.url.hashCode();
  }

  public String host()
  {
    return this.host;
  }

  public boolean isHttps()
  {
    return this.scheme.equals("https");
  }

  public Builder newBuilder()
  {
    Builder localBuilder = new Builder();
    localBuilder.scheme = this.scheme;
    localBuilder.encodedUsername = encodedUsername();
    localBuilder.encodedPassword = encodedPassword();
    localBuilder.host = this.host;
    if (this.port != defaultPort(this.scheme));
    for (int i = this.port; ; i = -1)
    {
      localBuilder.port = i;
      localBuilder.encodedPathSegments.clear();
      localBuilder.encodedPathSegments.addAll(encodedPathSegments());
      localBuilder.encodedQuery(encodedQuery());
      localBuilder.encodedFragment = encodedFragment();
      return localBuilder;
    }
  }

  @Nullable
  public Builder newBuilder(String paramString)
  {
    Builder localBuilder = new Builder();
    if (localBuilder.parse(this, paramString) == HttpUrl.Builder.ParseResult.SUCCESS)
      return localBuilder;
    return null;
  }

  public String password()
  {
    return this.password;
  }

  public List<String> pathSegments()
  {
    return this.pathSegments;
  }

  public int pathSize()
  {
    return this.pathSegments.size();
  }

  public int port()
  {
    return this.port;
  }

  @Nullable
  public String query()
  {
    if (this.queryNamesAndValues == null)
      return null;
    StringBuilder localStringBuilder = new StringBuilder();
    namesAndValuesToQueryString(localStringBuilder, this.queryNamesAndValues);
    return localStringBuilder.toString();
  }

  @Nullable
  public String queryParameter(String paramString)
  {
    if (this.queryNamesAndValues == null);
    while (true)
    {
      return null;
      int i = 0;
      int j = this.queryNamesAndValues.size();
      while (i < j)
      {
        if (paramString.equals(this.queryNamesAndValues.get(i)))
          return (String)this.queryNamesAndValues.get(i + 1);
        i += 2;
      }
    }
  }

  public String queryParameterName(int paramInt)
  {
    if (this.queryNamesAndValues == null)
      throw new IndexOutOfBoundsException();
    return (String)this.queryNamesAndValues.get(paramInt * 2);
  }

  public Set<String> queryParameterNames()
  {
    if (this.queryNamesAndValues == null)
      return Collections.emptySet();
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    int i = 0;
    int j = this.queryNamesAndValues.size();
    while (i < j)
    {
      localLinkedHashSet.add(this.queryNamesAndValues.get(i));
      i += 2;
    }
    return Collections.unmodifiableSet(localLinkedHashSet);
  }

  public String queryParameterValue(int paramInt)
  {
    if (this.queryNamesAndValues == null)
      throw new IndexOutOfBoundsException();
    return (String)this.queryNamesAndValues.get(1 + paramInt * 2);
  }

  public List<String> queryParameterValues(String paramString)
  {
    if (this.queryNamesAndValues == null)
      return Collections.emptyList();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = this.queryNamesAndValues.size();
    while (i < j)
    {
      if (paramString.equals(this.queryNamesAndValues.get(i)))
        localArrayList.add(this.queryNamesAndValues.get(i + 1));
      i += 2;
    }
    return Collections.unmodifiableList(localArrayList);
  }

  public int querySize()
  {
    if (this.queryNamesAndValues != null)
      return this.queryNamesAndValues.size() / 2;
    return 0;
  }

  public String redact()
  {
    return newBuilder("/...").username("").password("").build().toString();
  }

  @Nullable
  public HttpUrl resolve(String paramString)
  {
    Builder localBuilder = newBuilder(paramString);
    if (localBuilder != null)
      return localBuilder.build();
    return null;
  }

  public String scheme()
  {
    return this.scheme;
  }

  public String toString()
  {
    return this.url;
  }

  @Nullable
  public String topPrivateDomain()
  {
    if (Util.verifyAsIpAddress(this.host))
      return null;
    return PublicSuffixDatabase.get().getEffectiveTldPlusOne(this.host);
  }

  public URI uri()
  {
    String str = newBuilder().reencodeForUri().toString();
    try
    {
      URI localURI1 = new URI(str);
      return localURI1;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      try
      {
        URI localURI2 = URI.create(str.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
        return localURI2;
      }
      catch (Exception localException)
      {
      }
      throw new RuntimeException(localURISyntaxException);
    }
  }

  public URL url()
  {
    try
    {
      URL localURL = new URL(this.url);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new RuntimeException(localMalformedURLException);
    }
  }

  public String username()
  {
    return this.username;
  }

  public static final class Builder
  {

    @Nullable
    String encodedFragment;
    String encodedPassword = "";
    final List<String> encodedPathSegments = new ArrayList();

    @Nullable
    List<String> encodedQueryNamesAndValues;
    String encodedUsername = "";

    @Nullable
    String host;
    int port = -1;

    @Nullable
    String scheme;

    public Builder()
    {
      this.encodedPathSegments.add("");
    }

    private Builder addPathSegments(String paramString, boolean paramBoolean)
    {
      int i = 0;
      int j = Util.delimiterOffset(paramString, i, paramString.length(), "/\\");
      if (j < paramString.length());
      for (boolean bool = true; ; bool = false)
      {
        push(paramString, i, j, bool, paramBoolean);
        i = j + 1;
        if (i <= paramString.length())
          break;
        return this;
      }
    }

    private static String canonicalizeHost(String paramString, int paramInt1, int paramInt2)
    {
      return Util.canonicalizeHost(HttpUrl.percentDecode(paramString, paramInt1, paramInt2, false));
    }

    private boolean isDot(String paramString)
    {
      return (paramString.equals(".")) || (paramString.equalsIgnoreCase("%2e"));
    }

    private boolean isDotDot(String paramString)
    {
      return (paramString.equals("..")) || (paramString.equalsIgnoreCase("%2e.")) || (paramString.equalsIgnoreCase(".%2e")) || (paramString.equalsIgnoreCase("%2e%2e"));
    }

    private static int parsePort(String paramString, int paramInt1, int paramInt2)
    {
      try
      {
        int i = Integer.parseInt(HttpUrl.canonicalize(paramString, paramInt1, paramInt2, "", false, false, false, true, null));
        if ((i > 0) && (i <= 65535))
          return i;
        return -1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
      return -1;
    }

    private void pop()
    {
      if ((((String)this.encodedPathSegments.remove(-1 + this.encodedPathSegments.size())).isEmpty()) && (!this.encodedPathSegments.isEmpty()))
      {
        this.encodedPathSegments.set(-1 + this.encodedPathSegments.size(), "");
        return;
      }
      this.encodedPathSegments.add("");
    }

    private static int portColonOffset(String paramString, int paramInt1, int paramInt2)
    {
      int i = paramInt1;
      if (i < paramInt2);
      switch (paramString.charAt(i))
      {
      default:
      case '[':
        while (true)
        {
          i++;
          break label46;
          break;
          label46: i++;
          if (i < paramInt2)
            if (paramString.charAt(i) != ']');
        }
        i = paramInt2;
      case ':':
      }
      return i;
    }

    private void push(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      String str = HttpUrl.canonicalize(paramString, paramInt1, paramInt2, " \"<>^`{}|/\\?#", paramBoolean2, false, false, true, null);
      if (isDot(str));
      while (true)
      {
        return;
        if (isDotDot(str))
        {
          pop();
          return;
        }
        if (((String)this.encodedPathSegments.get(-1 + this.encodedPathSegments.size())).isEmpty())
          this.encodedPathSegments.set(-1 + this.encodedPathSegments.size(), str);
        while (paramBoolean1)
        {
          this.encodedPathSegments.add("");
          return;
          this.encodedPathSegments.add(str);
        }
      }
    }

    private void removeAllCanonicalQueryParameters(String paramString)
    {
      for (int i = -2 + this.encodedQueryNamesAndValues.size(); ; i -= 2)
        if (i >= 0)
        {
          if (paramString.equals(this.encodedQueryNamesAndValues.get(i)))
          {
            this.encodedQueryNamesAndValues.remove(i + 1);
            this.encodedQueryNamesAndValues.remove(i);
            if (this.encodedQueryNamesAndValues.isEmpty())
              this.encodedQueryNamesAndValues = null;
          }
        }
        else
          return;
    }

    private void resolvePath(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt1 == paramInt2)
        return;
      int i = paramString.charAt(paramInt1);
      label51: int j;
      label54: int k;
      if ((i == 47) || (i == 92))
      {
        this.encodedPathSegments.clear();
        this.encodedPathSegments.add("");
        paramInt1++;
        j = paramInt1;
        if (j < paramInt2)
        {
          k = Util.delimiterOffset(paramString, j, paramInt2, "/\\");
          if (k >= paramInt2)
            break label133;
        }
      }
      label133: for (boolean bool = true; ; bool = false)
      {
        push(paramString, j, k, bool, true);
        if (bool)
          k++;
        j = k;
        break label54;
        break;
        this.encodedPathSegments.set(-1 + this.encodedPathSegments.size(), "");
        break label51;
      }
    }

    private static int schemeDelimiterOffset(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt2 - paramInt1 < 2);
      int j;
      int k;
      label127: 
      do
        while (true)
        {
          return -1;
          int i = paramString.charAt(paramInt1);
          if (((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)))
            for (j = paramInt1 + 1; j < paramInt2; j++)
            {
              k = paramString.charAt(j);
              if (((k < 97) || (k > 122)) && ((k < 65) || (k > 90)) && ((k < 48) || (k > 57)) && (k != 43) && (k != 45) && (k != 46))
                break label127;
            }
        }
      while (k != 58);
      return j;
    }

    private static int slashCount(String paramString, int paramInt1, int paramInt2)
    {
      int i = 0;
      while (paramInt1 < paramInt2)
      {
        int j = paramString.charAt(paramInt1);
        if ((j != 92) && (j != 47))
          break;
        i++;
        paramInt1++;
      }
      return i;
    }

    public Builder addEncodedPathSegment(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("encodedPathSegment == null");
      push(paramString, 0, paramString.length(), false, true);
      return this;
    }

    public Builder addEncodedPathSegments(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("encodedPathSegments == null");
      return addPathSegments(paramString, true);
    }

    public Builder addEncodedQueryParameter(String paramString1, @Nullable String paramString2)
    {
      if (paramString1 == null)
        throw new NullPointerException("encodedName == null");
      if (this.encodedQueryNamesAndValues == null)
        this.encodedQueryNamesAndValues = new ArrayList();
      this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(paramString1, " \"'<>#&=", true, false, true, true));
      List localList = this.encodedQueryNamesAndValues;
      if (paramString2 != null);
      for (String str = HttpUrl.canonicalize(paramString2, " \"'<>#&=", true, false, true, true); ; str = null)
      {
        localList.add(str);
        return this;
      }
    }

    public Builder addPathSegment(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("pathSegment == null");
      push(paramString, 0, paramString.length(), false, false);
      return this;
    }

    public Builder addPathSegments(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("pathSegments == null");
      return addPathSegments(paramString, false);
    }

    public Builder addQueryParameter(String paramString1, @Nullable String paramString2)
    {
      if (paramString1 == null)
        throw new NullPointerException("name == null");
      if (this.encodedQueryNamesAndValues == null)
        this.encodedQueryNamesAndValues = new ArrayList();
      this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(paramString1, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
      List localList = this.encodedQueryNamesAndValues;
      if (paramString2 != null);
      for (String str = HttpUrl.canonicalize(paramString2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true); ; str = null)
      {
        localList.add(str);
        return this;
      }
    }

    public HttpUrl build()
    {
      if (this.scheme == null)
        throw new IllegalStateException("scheme == null");
      if (this.host == null)
        throw new IllegalStateException("host == null");
      return new HttpUrl(this);
    }

    int effectivePort()
    {
      if (this.port != -1)
        return this.port;
      return HttpUrl.defaultPort(this.scheme);
    }

    public Builder encodedFragment(@Nullable String paramString)
    {
      if (paramString != null);
      for (String str = HttpUrl.canonicalize(paramString, "", true, false, false, false); ; str = null)
      {
        this.encodedFragment = str;
        return this;
      }
    }

    public Builder encodedPassword(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("encodedPassword == null");
      this.encodedPassword = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
      return this;
    }

    public Builder encodedPath(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("encodedPath == null");
      if (!paramString.startsWith("/"))
        throw new IllegalArgumentException("unexpected encodedPath: " + paramString);
      resolvePath(paramString, 0, paramString.length());
      return this;
    }

    public Builder encodedQuery(@Nullable String paramString)
    {
      if (paramString != null);
      for (List localList = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(paramString, " \"'<>#", true, false, true, true)); ; localList = null)
      {
        this.encodedQueryNamesAndValues = localList;
        return this;
      }
    }

    public Builder encodedUsername(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("encodedUsername == null");
      this.encodedUsername = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
      return this;
    }

    public Builder fragment(@Nullable String paramString)
    {
      if (paramString != null);
      for (String str = HttpUrl.canonicalize(paramString, "", false, false, false, false); ; str = null)
      {
        this.encodedFragment = str;
        return this;
      }
    }

    public Builder host(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("host == null");
      String str = canonicalizeHost(paramString, 0, paramString.length());
      if (str == null)
        throw new IllegalArgumentException("unexpected host: " + paramString);
      this.host = str;
      return this;
    }

    ParseResult parse(@Nullable HttpUrl paramHttpUrl, String paramString)
    {
      int i = Util.skipLeadingAsciiWhitespace(paramString, 0, paramString.length());
      int j = Util.skipTrailingAsciiWhitespace(paramString, i, paramString.length());
      label63: int n;
      int i1;
      int i2;
      label112: int i3;
      if (schemeDelimiterOffset(paramString, i, j) != -1)
        if (paramString.regionMatches(true, i, "https:", 0, 6))
        {
          this.scheme = "https";
          i += "https:".length();
          int k = slashCount(paramString, i, j);
          if ((k < 2) && (paramHttpUrl != null) && (paramHttpUrl.scheme.equals(this.scheme)))
            break label674;
          int m = i + k;
          n = 0;
          i1 = 0;
          i2 = m;
          i3 = Util.delimiterOffset(paramString, i2, j, "@/\\?#");
          if (i3 == j)
            break label283;
        }
      int i9;
      int i8;
      int i10;
      label283: for (int i4 = paramString.charAt(i3); ; i4 = -1)
        switch (i4)
        {
        default:
          i9 = n;
          i8 = i2;
          i10 = i1;
          n = i9;
          i1 = i10;
          i2 = i8;
          break label112;
          if (paramString.regionMatches(true, i, "http:", 0, 5))
          {
            this.scheme = "http";
            i += "http:".length();
            break label63;
          }
          return ParseResult.UNSUPPORTED_SCHEME;
          if (paramHttpUrl != null)
          {
            this.scheme = paramHttpUrl.scheme;
            break label63;
          }
          return ParseResult.MISSING_SCHEME;
        case 64:
        case -1:
        case 35:
        case 47:
        case 63:
        case 92:
        }
      if (n == 0)
      {
        int i11 = Util.delimiterOffset(paramString, i2, i3, ':');
        String str = HttpUrl.canonicalize(paramString, i2, i11, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
        if (i1 != 0)
          str = this.encodedUsername + "%40" + str;
        this.encodedUsername = str;
        if (i11 != i3)
        {
          n = 1;
          this.encodedPassword = HttpUrl.canonicalize(paramString, i11 + 1, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
        }
        i1 = 1;
      }
      while (true)
      {
        i8 = i3 + 1;
        i9 = n;
        i10 = i1;
        break;
        this.encodedPassword = (this.encodedPassword + "%40" + HttpUrl.canonicalize(paramString, i2, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
      }
      int i5 = portColonOffset(paramString, i2, i3);
      if (i5 + 1 < i3)
      {
        this.host = canonicalizeHost(paramString, i2, i5);
        this.port = parsePort(paramString, i5 + 1, i3);
        if (this.port == -1)
          return ParseResult.INVALID_PORT;
      }
      else
      {
        this.host = canonicalizeHost(paramString, i2, i5);
        this.port = HttpUrl.defaultPort(this.scheme);
      }
      if (this.host == null)
        return ParseResult.INVALID_HOST;
      i = i3;
      int i6 = Util.delimiterOffset(paramString, i, j, "?#");
      resolvePath(paramString, i, i6);
      int i7;
      if ((i6 < j) && (paramString.charAt(i6) == '?'))
      {
        i7 = Util.delimiterOffset(paramString, i6, j, '#');
        this.encodedQueryNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(paramString, i6 + 1, i7, " \"'<>#", true, false, true, true, null));
      }
      while (true)
      {
        if ((i7 < j) && (paramString.charAt(i7) == '#'))
          this.encodedFragment = HttpUrl.canonicalize(paramString, i7 + 1, j, "", true, false, false, false, null);
        return ParseResult.SUCCESS;
        label674: this.encodedUsername = paramHttpUrl.encodedUsername();
        this.encodedPassword = paramHttpUrl.encodedPassword();
        this.host = paramHttpUrl.host;
        this.port = paramHttpUrl.port;
        this.encodedPathSegments.clear();
        this.encodedPathSegments.addAll(paramHttpUrl.encodedPathSegments());
        if ((i != j) && (paramString.charAt(i) != '#'))
          break;
        encodedQuery(paramHttpUrl.encodedQuery());
        break;
        i7 = i6;
      }
    }

    public Builder password(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("password == null");
      this.encodedPassword = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
      return this;
    }

    public Builder port(int paramInt)
    {
      if ((paramInt <= 0) || (paramInt > 65535))
        throw new IllegalArgumentException("unexpected port: " + paramInt);
      this.port = paramInt;
      return this;
    }

    public Builder query(@Nullable String paramString)
    {
      if (paramString != null);
      for (List localList = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(paramString, " \"'<>#", false, false, true, true)); ; localList = null)
      {
        this.encodedQueryNamesAndValues = localList;
        return this;
      }
    }

    Builder reencodeForUri()
    {
      int i = this.encodedPathSegments.size();
      for (int j = 0; j < i; j++)
      {
        String str2 = (String)this.encodedPathSegments.get(j);
        this.encodedPathSegments.set(j, HttpUrl.canonicalize(str2, "[]", true, true, false, true));
      }
      if (this.encodedQueryNamesAndValues != null)
      {
        int k = this.encodedQueryNamesAndValues.size();
        for (int m = 0; m < k; m++)
        {
          String str1 = (String)this.encodedQueryNamesAndValues.get(m);
          if (str1 != null)
            this.encodedQueryNamesAndValues.set(m, HttpUrl.canonicalize(str1, "\\^`{|}", true, true, true, true));
        }
      }
      if (this.encodedFragment != null)
        this.encodedFragment = HttpUrl.canonicalize(this.encodedFragment, " \"#<>\\^`{|}", true, true, false, false);
      return this;
    }

    public Builder removeAllEncodedQueryParameters(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("encodedName == null");
      if (this.encodedQueryNamesAndValues == null)
        return this;
      removeAllCanonicalQueryParameters(HttpUrl.canonicalize(paramString, " \"'<>#&=", true, false, true, true));
      return this;
    }

    public Builder removeAllQueryParameters(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("name == null");
      if (this.encodedQueryNamesAndValues == null)
        return this;
      removeAllCanonicalQueryParameters(HttpUrl.canonicalize(paramString, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
      return this;
    }

    public Builder removePathSegment(int paramInt)
    {
      this.encodedPathSegments.remove(paramInt);
      if (this.encodedPathSegments.isEmpty())
        this.encodedPathSegments.add("");
      return this;
    }

    public Builder scheme(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("scheme == null");
      if (paramString.equalsIgnoreCase("http"))
      {
        this.scheme = "http";
        return this;
      }
      if (paramString.equalsIgnoreCase("https"))
      {
        this.scheme = "https";
        return this;
      }
      throw new IllegalArgumentException("unexpected scheme: " + paramString);
    }

    public Builder setEncodedPathSegment(int paramInt, String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("encodedPathSegment == null");
      String str = HttpUrl.canonicalize(paramString, 0, paramString.length(), " \"<>^`{}|/\\?#", true, false, false, true, null);
      this.encodedPathSegments.set(paramInt, str);
      if ((isDot(str)) || (isDotDot(str)))
        throw new IllegalArgumentException("unexpected path segment: " + paramString);
      return this;
    }

    public Builder setEncodedQueryParameter(String paramString1, @Nullable String paramString2)
    {
      removeAllEncodedQueryParameters(paramString1);
      addEncodedQueryParameter(paramString1, paramString2);
      return this;
    }

    public Builder setPathSegment(int paramInt, String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("pathSegment == null");
      String str = HttpUrl.canonicalize(paramString, 0, paramString.length(), " \"<>^`{}|/\\?#", false, false, false, true, null);
      if ((isDot(str)) || (isDotDot(str)))
        throw new IllegalArgumentException("unexpected path segment: " + paramString);
      this.encodedPathSegments.set(paramInt, str);
      return this;
    }

    public Builder setQueryParameter(String paramString1, @Nullable String paramString2)
    {
      removeAllQueryParameters(paramString1);
      addQueryParameter(paramString1, paramString2);
      return this;
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.scheme);
      localStringBuilder.append("://");
      if ((!this.encodedUsername.isEmpty()) || (!this.encodedPassword.isEmpty()))
      {
        localStringBuilder.append(this.encodedUsername);
        if (!this.encodedPassword.isEmpty())
        {
          localStringBuilder.append(':');
          localStringBuilder.append(this.encodedPassword);
        }
        localStringBuilder.append('@');
      }
      if (this.host.indexOf(':') != -1)
      {
        localStringBuilder.append('[');
        localStringBuilder.append(this.host);
        localStringBuilder.append(']');
      }
      while (true)
      {
        int i = effectivePort();
        if (i != HttpUrl.defaultPort(this.scheme))
        {
          localStringBuilder.append(':');
          localStringBuilder.append(i);
        }
        HttpUrl.pathSegmentsToString(localStringBuilder, this.encodedPathSegments);
        if (this.encodedQueryNamesAndValues != null)
        {
          localStringBuilder.append('?');
          HttpUrl.namesAndValuesToQueryString(localStringBuilder, this.encodedQueryNamesAndValues);
        }
        if (this.encodedFragment != null)
        {
          localStringBuilder.append('#');
          localStringBuilder.append(this.encodedFragment);
        }
        return localStringBuilder.toString();
        localStringBuilder.append(this.host);
      }
    }

    public Builder username(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("username == null");
      this.encodedUsername = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
      return this;
    }

    static enum ParseResult
    {
      static
      {
        MISSING_SCHEME = new ParseResult("MISSING_SCHEME", 1);
        UNSUPPORTED_SCHEME = new ParseResult("UNSUPPORTED_SCHEME", 2);
        INVALID_PORT = new ParseResult("INVALID_PORT", 3);
        INVALID_HOST = new ParseResult("INVALID_HOST", 4);
        ParseResult[] arrayOfParseResult = new ParseResult[5];
        arrayOfParseResult[0] = SUCCESS;
        arrayOfParseResult[1] = MISSING_SCHEME;
        arrayOfParseResult[2] = UNSUPPORTED_SCHEME;
        arrayOfParseResult[3] = INVALID_PORT;
        arrayOfParseResult[4] = INVALID_HOST;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.HttpUrl
 * JD-Core Version:    0.6.2
 */