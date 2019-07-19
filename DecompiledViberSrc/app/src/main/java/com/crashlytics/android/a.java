package com.crashlytics.android;

import c.a.a.a.c;
import c.a.a.a.i;
import c.a.a.a.j;
import com.crashlytics.android.a.b;
import com.crashlytics.android.c.l;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class a extends i<Void>
  implements j
{
  public final b a;
  public final com.crashlytics.android.b.a b;
  public final l c;
  public final Collection<? extends i> d;

  public a()
  {
    this(new b(), new com.crashlytics.android.b.a(), new l());
  }

  a(b paramb, com.crashlytics.android.b.a parama, l paraml)
  {
    this.a = paramb;
    this.b = parama;
    this.c = paraml;
    this.d = Collections.unmodifiableCollection(Arrays.asList(new i[] { paramb, parama, paraml }));
  }

  public static void a(String paramString)
  {
    g();
    e().c.a(paramString);
  }

  public static void a(String paramString, int paramInt)
  {
    g();
    e().c.a(paramString, paramInt);
  }

  public static void a(String paramString1, String paramString2)
  {
    g();
    e().c.a(paramString1, paramString2);
  }

  public static void a(Throwable paramThrowable)
  {
    g();
    e().c.a(paramThrowable);
  }

  public static a e()
  {
    return (a)c.a(a.class);
  }

  private static void g()
  {
    if (e() == null)
      throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
  }

  public String a()
  {
    return "2.9.9.32";
  }

  public String b()
  {
    return "com.crashlytics.sdk.android:crashlytics";
  }

  public Collection<? extends i> c()
  {
    return this.d;
  }

  protected Void d()
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a
 * JD-Core Version:    0.6.2
 */