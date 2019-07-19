package com.crashlytics.android.c;

import android.content.Context;
import c.a.a.a.a.b.i;
import c.a.a.a.a.g.o;

class y
{
  private final Context a;
  private final o b;

  public y(Context paramContext, o paramo)
  {
    this.a = paramContext;
    this.b = paramo;
  }

  private String a(String paramString1, String paramString2)
  {
    return b(i.b(this.a, paramString1), paramString2);
  }

  private boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }

  private String b(String paramString1, String paramString2)
  {
    if (a(paramString1))
      return paramString2;
    return paramString1;
  }

  public String a()
  {
    return a("com.crashlytics.CrashSubmissionPromptTitle", this.b.a);
  }

  public String b()
  {
    return a("com.crashlytics.CrashSubmissionPromptMessage", this.b.b);
  }

  public String c()
  {
    return a("com.crashlytics.CrashSubmissionSendTitle", this.b.c);
  }

  public String d()
  {
    return a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.b.g);
  }

  public String e()
  {
    return a("com.crashlytics.CrashSubmissionCancelTitle", this.b.e);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.y
 * JD-Core Version:    0.6.2
 */