package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class ViewUtils
{
  @KeepForSdk
  public static String getXmlAttributeString(String paramString1, String paramString2, Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    String str1;
    if (paramAttributeSet == null)
      str1 = null;
    while (true)
    {
      String str2;
      String str3;
      TypedValue localTypedValue;
      if ((str1 != null) && (str1.startsWith("@string/")) && (paramBoolean1))
      {
        str2 = str1.substring(8);
        str3 = paramContext.getPackageName();
        localTypedValue = new TypedValue();
      }
      try
      {
        paramContext.getResources().getValue(8 + String.valueOf(str3).length() + String.valueOf(str2).length() + str3 + ":string/" + str2, localTypedValue, true);
        if (localTypedValue.string != null)
        {
          str1 = localTypedValue.string.toString();
          if ((paramBoolean2) && (str1 == null))
            Log.w(paramString3, 33 + String.valueOf(paramString2).length() + "Required XML attribute \"" + paramString2 + "\" missing");
          return str1;
          str1 = paramAttributeSet.getAttributeValue(paramString1, paramString2);
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        while (true)
        {
          Log.w(paramString3, 30 + String.valueOf(paramString2).length() + String.valueOf(str1).length() + "Could not find resource for " + paramString2 + ": " + str1);
          continue;
          String str4 = String.valueOf(localTypedValue);
          Log.w(paramString3, 28 + String.valueOf(paramString2).length() + String.valueOf(str4).length() + "Resource " + paramString2 + " was not a string: " + str4);
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.ViewUtils
 * JD-Core Version:    0.6.2
 */