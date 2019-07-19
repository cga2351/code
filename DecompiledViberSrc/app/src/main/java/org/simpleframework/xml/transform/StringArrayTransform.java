package org.simpleframework.xml.transform;

import java.util.regex.Pattern;

class StringArrayTransform
  implements Transform<String[]>
{
  private final Pattern pattern;
  private final String token;

  public StringArrayTransform()
  {
    this(",");
  }

  public StringArrayTransform(String paramString)
  {
    this.pattern = Pattern.compile(paramString);
    this.token = paramString;
  }

  private String[] read(String paramString1, String paramString2)
  {
    String[] arrayOfString = this.pattern.split(paramString1);
    for (int i = 0; i < arrayOfString.length; i++)
    {
      String str = arrayOfString[i];
      if (str != null)
        arrayOfString[i] = str.trim();
    }
    return arrayOfString;
  }

  private String write(String[] paramArrayOfString, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      String str = paramArrayOfString[i];
      if (str != null)
      {
        if (localStringBuilder.length() > 0)
        {
          localStringBuilder.append(paramString);
          localStringBuilder.append(' ');
        }
        localStringBuilder.append(str);
      }
    }
    return localStringBuilder.toString();
  }

  public String[] read(String paramString)
  {
    return read(paramString, this.token);
  }

  public String write(String[] paramArrayOfString)
  {
    return write(paramArrayOfString, this.token);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.StringArrayTransform
 * JD-Core Version:    0.6.2
 */