package android.support.v4.os;

import java.util.Locale;

final class LocaleHelper
{
  static Locale forLanguageTag(String paramString)
  {
    if (paramString.contains("-"))
    {
      String[] arrayOfString2 = paramString.split("-", -1);
      if (arrayOfString2.length > 2)
        return new Locale(arrayOfString2[0], arrayOfString2[1], arrayOfString2[2]);
      if (arrayOfString2.length > 1)
        return new Locale(arrayOfString2[0], arrayOfString2[1]);
      if (arrayOfString2.length == 1)
        return new Locale(arrayOfString2[0]);
    }
    else if (paramString.contains("_"))
    {
      String[] arrayOfString1 = paramString.split("_", -1);
      if (arrayOfString1.length > 2)
        return new Locale(arrayOfString1[0], arrayOfString1[1], arrayOfString1[2]);
      if (arrayOfString1.length > 1)
        return new Locale(arrayOfString1[0], arrayOfString1[1]);
      if (arrayOfString1.length == 1)
        return new Locale(arrayOfString1[0]);
    }
    else
    {
      return new Locale(paramString);
    }
    throw new IllegalArgumentException("Can not parse language tag: [" + paramString + "]");
  }

  static String toLanguageTag(Locale paramLocale)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLocale.getLanguage());
    String str = paramLocale.getCountry();
    if ((str != null) && (!str.isEmpty()))
    {
      localStringBuilder.append("-");
      localStringBuilder.append(paramLocale.getCountry());
    }
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.os.LocaleHelper
 * JD-Core Version:    0.6.2
 */