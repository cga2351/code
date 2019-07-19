package com.appboy.f;

import a.a.dd;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Set;

public final class j
{
  private static final String a = c.a(j.class);

  public static boolean a(double paramDouble1, double paramDouble2)
  {
    return (paramDouble1 < 90.0D) && (paramDouble1 > -90.0D) && (paramDouble2 < 180.0D) && (paramDouble2 > -180.0D);
  }

  public static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.toLowerCase(Locale.US).matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"));
  }

  public static boolean a(String paramString, dd paramdd)
  {
    if (i.c(paramString))
    {
      c.d(a, "The custom event name cannot be null or contain only whitespaces. Invalid custom event.");
      return false;
    }
    if (paramdd.h().contains(paramString))
    {
      c.d(a, "The custom event is a blacklisted custom event: " + paramString + ". Invalid custom event.");
      return false;
    }
    return true;
  }

  public static boolean a(String paramString1, String paramString2)
  {
    if (i.c(paramString1))
    {
      c.d(a, "Campaign ID cannot be null or blank");
      return false;
    }
    if (i.c(paramString2))
    {
      c.d(a, "Push story page ID cannot be null or blank");
      return false;
    }
    return true;
  }

  public static boolean a(String paramString1, String paramString2, BigDecimal paramBigDecimal, int paramInt, dd paramdd, Set<String> paramSet)
  {
    if (i.c(paramString1))
    {
      c.d(a, "The productId is empty, not logging in-app purchase to Appboy.");
      return false;
    }
    if (paramdd.j().contains(paramString1))
    {
      c.d(a, "The productId is a blacklisted productId: " + paramString1);
      return false;
    }
    if (paramString2 == null)
    {
      c.d(a, "The currencyCode is null. Expected one of " + paramSet);
      return false;
    }
    if (!paramSet.contains(paramString2))
    {
      c.d(a, "The currencyCode " + paramString2 + " is invalid. Expected one of " + paramSet);
      return false;
    }
    if (paramBigDecimal == null)
    {
      c.d(a, "The price is null.");
      return false;
    }
    if (paramInt <= 0)
    {
      c.d(a, "The requested purchase quantity of " + paramInt + " is less than zero.");
      return false;
    }
    if (paramInt > 100)
    {
      c.d(a, "The requested purchase quantity of " + paramInt + " is greater than the maximum of " + 100);
      return false;
    }
    return true;
  }

  public static boolean b(String paramString)
  {
    return (paramString != null) && (paramString.matches("^[0-9 .\\(\\)\\+\\-]+$"));
  }

  public static String c(String paramString)
  {
    String str = paramString.trim();
    if (str.length() > 255)
    {
      c.d(a, "Provided string field is too long [" + str.length() + "]. The max length is " + 255 + ", truncating provided field.");
      str = str.substring(0, 255);
    }
    return str;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.f.j
 * JD-Core Version:    0.6.2
 */