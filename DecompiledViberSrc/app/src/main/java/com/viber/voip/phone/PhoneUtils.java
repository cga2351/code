package com.viber.voip.phone;

import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneNumberUtils;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import java.util.Locale;

public final class PhoneUtils
{
  private static final int FORMATTING_TYPE_INVALID = -1;
  private static final SpannableStringBuilder S_EDITABLE;
  private static int sFormattingType;

  static
  {
    if (!PhoneUtils.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      S_EDITABLE = new SpannableStringBuilder();
      sFormattingType = -1;
      return;
    }
  }

  private PhoneUtils()
  {
    if (!$assertionsDisabled)
      throw new AssertionError();
  }

  public static String formatPhoneNumber(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return "";
    if (sFormattingType == -1)
      sFormattingType = PhoneNumberUtils.getFormatTypeForLocale(Locale.getDefault());
    S_EDITABLE.clear();
    S_EDITABLE.append(paramString);
    PhoneNumberUtils.formatNumber(S_EDITABLE, sFormattingType);
    return S_EDITABLE.toString();
  }

  public static String getInitialNumber(Intent paramIntent, Context paramContext)
  {
    try
    {
      String str = PhoneNumberUtils.getNumberFromIntent(paramIntent, paramContext);
      return str;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.PhoneUtils
 * JD-Core Version:    0.6.2
 */