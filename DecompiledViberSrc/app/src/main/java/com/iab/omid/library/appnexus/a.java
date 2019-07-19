package com.iab.omid.library.appnexus;

import android.content.Context;
import com.iab.omid.library.appnexus.b.c;

public class a
{
  private boolean a;

  private void b(String paramString, Context paramContext)
  {
    c(paramString);
    com.iab.omid.library.appnexus.d.e.a(paramContext, "Application Context cannot be null");
  }

  private void c(String paramString)
  {
    com.iab.omid.library.appnexus.d.e.a(paramString, "Version cannot be null");
    if (!paramString.matches("[0-9]+\\.[0-9]+\\.[0-9]+.*"))
      throw new IllegalArgumentException("Invalid version format : " + paramString);
  }

  String a()
  {
    return "1.1.3-Appnexus";
  }

  void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  boolean a(String paramString)
  {
    return b(a()) == b(paramString);
  }

  boolean a(String paramString, Context paramContext)
  {
    b(paramString, paramContext);
    if (a(paramString))
    {
      if (!b())
      {
        a(true);
        com.iab.omid.library.appnexus.b.e.a().a(paramContext);
        com.iab.omid.library.appnexus.b.b.a().a(paramContext);
        com.iab.omid.library.appnexus.d.b.a(paramContext);
        c.a().a(paramContext);
      }
      return true;
    }
    return false;
  }

  int b(String paramString)
  {
    c(paramString);
    return Integer.parseInt(paramString.split("\\.", 2)[0]);
  }

  boolean b()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.a
 * JD-Core Version:    0.6.2
 */