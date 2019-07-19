package com.google.firebase.messaging;

import java.util.Locale;

public final class c extends Exception
{
  private final int a;

  c(String paramString)
  {
    super(paramString);
    String str;
    int j;
    if (paramString != null)
    {
      str = paramString.toLowerCase(Locale.US);
      j = -1;
    }
    switch (str.hashCode())
    {
    default:
      switch (j)
      {
      default:
        i = 0;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
      break;
    case -920906446:
    case -95047692:
    case -617027085:
    case -1743242157:
    case -1290953729:
    }
    while (true)
    {
      this.a = i;
      return;
      if (!str.equals("invalid_parameters"))
        break;
      j = 0;
      break;
      if (!str.equals("missing_to"))
        break;
      j = i;
      break;
      if (!str.equals("messagetoobig"))
        break;
      j = 2;
      break;
      if (!str.equals("service_not_available"))
        break;
      j = 3;
      break;
      if (!str.equals("toomanymessages"))
        break;
      j = 4;
      break;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.messaging.c
 * JD-Core Version:    0.6.2
 */