package com.crashlytics.android.a;

import android.content.Context;
import c.a.a.a.c;
import c.a.a.a.l;

class r
{
  private final Context a;
  private final t b;
  private q c;

  public r(Context paramContext)
  {
    this(paramContext, new t());
  }

  public r(Context paramContext, t paramt)
  {
    this.a = paramContext;
    this.b = paramt;
  }

  public q a()
  {
    if (this.c == null)
      this.c = k.a(this.a);
    return this.c;
  }

  public void a(ad paramad)
  {
    q localq = a();
    if (localq == null)
      c.g().a("Answers", "Firebase analytics logging was enabled, but not available...");
    s locals;
    do
    {
      return;
      locals = this.b.a(paramad);
      if (locals == null)
      {
        c.g().a("Answers", "Fabric event was not mappable to Firebase event: " + paramad);
        return;
      }
      localq.a(locals.a(), locals.b());
    }
    while (!"levelEnd".equals(paramad.g));
    localq.a("post_score", locals.b());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.r
 * JD-Core Version:    0.6.2
 */