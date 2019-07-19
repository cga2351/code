package twitter4j.internal.http;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

public final class HttpParameter
  implements Serializable, Comparable
{
  private static final String GIF = "image/gif";
  private static final String JPEG = "image/jpeg";
  private static final String OCTET = "application/octet-stream";
  private static final String PNG = "image/png";
  private static final long serialVersionUID = -8708108746980739212L;
  private File file = null;
  private InputStream fileBody = null;
  private String name = null;
  private String value = null;

  public HttpParameter(String paramString, double paramDouble)
  {
    this.name = paramString;
    this.value = String.valueOf(paramDouble);
  }

  public HttpParameter(String paramString, int paramInt)
  {
    this.name = paramString;
    this.value = String.valueOf(paramInt);
  }

  public HttpParameter(String paramString, long paramLong)
  {
    this.name = paramString;
    this.value = String.valueOf(paramLong);
  }

  public HttpParameter(String paramString, File paramFile)
  {
    this.name = paramString;
    this.file = paramFile;
  }

  public HttpParameter(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.value = paramString2;
  }

  public HttpParameter(String paramString1, String paramString2, InputStream paramInputStream)
  {
    this.name = paramString1;
    this.file = new File(paramString2);
    this.fileBody = paramInputStream;
  }

  public HttpParameter(String paramString, boolean paramBoolean)
  {
    this.name = paramString;
    this.value = String.valueOf(paramBoolean);
  }

  static boolean containsFile(List<HttpParameter> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      if (((HttpParameter)localIterator.next()).isFile())
        return true;
    return false;
  }

  public static boolean containsFile(HttpParameter[] paramArrayOfHttpParameter)
  {
    if (paramArrayOfHttpParameter == null);
    while (true)
    {
      return false;
      int i = paramArrayOfHttpParameter.length;
      for (int j = 0; j < i; j++)
        if (paramArrayOfHttpParameter[j].isFile())
          return true;
    }
  }

  public static String encode(String paramString)
  {
    try
    {
      String str2 = URLEncoder.encode(paramString, "UTF-8");
      str1 = str2;
      StringBuilder localStringBuilder = new StringBuilder(str1.length());
      int i = 0;
      if (i < str1.length())
      {
        char c = str1.charAt(i);
        if (c == '*')
          localStringBuilder.append("%2A");
        while (true)
        {
          i++;
          break;
          if (c == '+')
          {
            localStringBuilder.append("%20");
          }
          else if ((c == '%') && (i + 1 < str1.length()) && (str1.charAt(i + 1) == '7') && (str1.charAt(i + 2) == 'E'))
          {
            localStringBuilder.append('~');
            i += 2;
          }
          else
          {
            localStringBuilder.append(c);
          }
        }
      }
      return localStringBuilder.toString();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        String str1 = null;
    }
  }

  public static String encodeParameters(HttpParameter[] paramArrayOfHttpParameter)
  {
    if (paramArrayOfHttpParameter == null)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramArrayOfHttpParameter.length; i++)
    {
      if (paramArrayOfHttpParameter[i].isFile())
        throw new IllegalArgumentException("parameter [" + paramArrayOfHttpParameter[i].name + "]should be text");
      if (i != 0)
        localStringBuilder.append("&");
      localStringBuilder.append(encode(paramArrayOfHttpParameter[i].name)).append("=").append(encode(paramArrayOfHttpParameter[i].value));
    }
    return localStringBuilder.toString();
  }

  public static HttpParameter[] getParameterArray(String paramString, int paramInt)
  {
    return getParameterArray(paramString, String.valueOf(paramInt));
  }

  public static HttpParameter[] getParameterArray(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    return getParameterArray(paramString1, String.valueOf(paramInt1), paramString2, String.valueOf(paramInt2));
  }

  public static HttpParameter[] getParameterArray(String paramString1, String paramString2)
  {
    HttpParameter[] arrayOfHttpParameter = new HttpParameter[1];
    arrayOfHttpParameter[0] = new HttpParameter(paramString1, paramString2);
    return arrayOfHttpParameter;
  }

  public static HttpParameter[] getParameterArray(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HttpParameter[] arrayOfHttpParameter = new HttpParameter[2];
    arrayOfHttpParameter[0] = new HttpParameter(paramString1, paramString2);
    arrayOfHttpParameter[1] = new HttpParameter(paramString3, paramString4);
    return arrayOfHttpParameter;
  }

  public int compareTo(Object paramObject)
  {
    HttpParameter localHttpParameter = (HttpParameter)paramObject;
    int i = this.name.compareTo(localHttpParameter.name);
    if (i == 0)
      i = this.value.compareTo(localHttpParameter.value);
    return i;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    HttpParameter localHttpParameter;
    do
    {
      return true;
      if (!(paramObject instanceof HttpParameter))
        return false;
      localHttpParameter = (HttpParameter)paramObject;
      if (this.file != null)
      {
        if (this.file.equals(localHttpParameter.file));
      }
      else
        while (localHttpParameter.file != null)
          return false;
      if (this.fileBody != null)
      {
        if (this.fileBody.equals(localHttpParameter.fileBody));
      }
      else
        while (localHttpParameter.fileBody != null)
          return false;
      if (!this.name.equals(localHttpParameter.name))
        return false;
      if (this.value == null)
        break;
    }
    while (this.value.equals(localHttpParameter.value));
    while (true)
    {
      return false;
      if (localHttpParameter.value == null)
        break;
    }
  }

  public String getContentType()
  {
    if (!isFile())
      throw new IllegalStateException("not a file");
    String str1 = this.file.getName();
    if (-1 == str1.lastIndexOf("."))
      return "application/octet-stream";
    String str2 = str1.substring(1 + str1.lastIndexOf(".")).toLowerCase();
    if (str2.length() == 3)
    {
      if ("gif".equals(str2))
        return "image/gif";
      if ("png".equals(str2))
        return "image/png";
      if ("jpg".equals(str2))
        return "image/jpeg";
      return "application/octet-stream";
    }
    if (str2.length() == 4)
    {
      if ("jpeg".equals(str2))
        return "image/jpeg";
      return "application/octet-stream";
    }
    return "application/octet-stream";
  }

  public File getFile()
  {
    return this.file;
  }

  public InputStream getFileBody()
  {
    return this.fileBody;
  }

  public String getName()
  {
    return this.name;
  }

  public String getValue()
  {
    return this.value;
  }

  public boolean hasFileBody()
  {
    return this.fileBody != null;
  }

  public int hashCode()
  {
    int i = 31 * this.name.hashCode();
    int j;
    int k;
    if (this.value != null)
    {
      j = this.value.hashCode();
      k = 31 * (j + i);
      if (this.file == null)
        break label92;
    }
    label92: for (int m = this.file.hashCode(); ; m = 0)
    {
      int n = 31 * (m + k);
      InputStream localInputStream = this.fileBody;
      int i1 = 0;
      if (localInputStream != null)
        i1 = this.fileBody.hashCode();
      return n + i1;
      j = 0;
      break;
    }
  }

  public boolean isFile()
  {
    return this.file != null;
  }

  public String toString()
  {
    return "PostParameter{name='" + this.name + '\'' + ", value='" + this.value + '\'' + ", file=" + this.file + ", fileBody=" + this.fileBody + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.http.HttpParameter
 * JD-Core Version:    0.6.2
 */