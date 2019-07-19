package org.simpleframework.xml.transform;

import java.util.Locale;
import java.util.regex.Pattern;

class LocaleTransform
  implements Transform<Locale>
{
  private final Pattern pattern = Pattern.compile("_");

  private Locale read(String[] paramArrayOfString)
    throws Exception
  {
    String[] arrayOfString = { "", "", "" };
    for (int i = 0; i < arrayOfString.length; i++)
      if (i < paramArrayOfString.length)
        arrayOfString[i] = paramArrayOfString[i];
    return new Locale(arrayOfString[0], arrayOfString[1], arrayOfString[2]);
  }

  public Locale read(String paramString)
    throws Exception
  {
    String[] arrayOfString = this.pattern.split(paramString);
    if (arrayOfString.length < 1)
      throw new InvalidFormatException("Invalid locale %s", new Object[] { paramString });
    return read(arrayOfString);
  }

  public String write(Locale paramLocale)
  {
    return paramLocale.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.LocaleTransform
 * JD-Core Version:    0.6.2
 */