package com.yandex.mobile.ads.impl;

import android.text.TextUtils;
import com.yandex.mobile.ads.nativeads.x;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class mx
{
  private final DecimalFormat a;

  public mx()
  {
    DecimalFormatSymbols localDecimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
    localDecimalFormatSymbols.setGroupingSeparator(' ');
    this.a = new DecimalFormat("#,###,###", localDecimalFormatSymbols);
  }

  public final String a(String paramString)
    throws x
  {
    while (true)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          str1 = paramString.replaceAll(" ", "");
          Integer localInteger = Integer.valueOf(str1);
          String str2 = this.a.format(localInteger);
          return str2;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        String.format("Could not parse review count value. Review Count value is %s", new Object[] { paramString });
        new Object[] { localNumberFormatException };
        throw new x("Native Ad json has not required attributes");
      }
      String str1 = paramString;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.mx
 * JD-Core Version:    0.6.2
 */