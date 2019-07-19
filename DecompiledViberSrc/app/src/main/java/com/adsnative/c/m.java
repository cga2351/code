package com.adsnative.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.EnumSet;
import java.util.Iterator;

public class m
{
  private static final a a = new a()
  {
    public void a(String paramAnonymousString, l paramAnonymousl)
    {
    }

    public void b(String paramAnonymousString, l paramAnonymousl)
    {
    }
  };
  private EnumSet<l> b;
  private a c;
  private boolean d;
  private boolean e;

  public m(EnumSet<l> paramEnumSet, a parama)
  {
    this.b = EnumSet.copyOf(paramEnumSet);
    this.c = parama;
    this.d = false;
    this.e = false;
  }

  private void a(String paramString1, l paraml, String paramString2, Throwable paramThrowable)
  {
    if (paramString2 == null)
      throw new NullPointerException("Message is null");
    if (paraml == null)
      paraml = l.e;
    i.b(paramString2, paramThrowable);
    this.c.b(paramString1, paraml);
  }

  public void a(Context paramContext, String paramString)
  {
    if (paramContext == null)
      throw new NullPointerException("Context is null");
    a(paramContext, paramString, true);
  }

  public boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a(paramString, null, "Attempted to handle empty url.", null);
      return false;
    }
    l locall = l.e;
    Uri localUri = Uri.parse(paramString);
    Iterator localIterator = this.b.iterator();
    Object localObject1 = locall;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = (l)localIterator.next();
      if (!((l)localObject2).a(localUri))
        break label180;
      try
      {
        ((l)localObject2).a(this, paramContext, localUri, paramBoolean);
        if ((!this.d) && (!this.e) && (!l.a.equals(localObject2)))
        {
          this.c.a(localUri.toString(), (l)localObject2);
          this.d = true;
        }
        return true;
      }
      catch (f localf)
      {
        i.b(localf.getMessage(), localf);
      }
    }
    while (true)
    {
      localObject1 = localObject2;
      break;
      a(paramString, (l)localObject1, "Link ignored. Unable to handle url: " + paramString, null);
      return false;
      label180: localObject2 = localObject1;
    }
  }

  public static abstract interface a
  {
    public abstract void a(String paramString, l paraml);

    public abstract void b(String paramString, l paraml);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.c.m
 * JD-Core Version:    0.6.2
 */