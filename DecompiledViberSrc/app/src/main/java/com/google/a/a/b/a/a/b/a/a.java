package com.google.a.a.b.a.a.b.a;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import com.google.a.a.c.l;
import com.google.a.a.c.m;
import com.google.a.a.c.r;
import com.google.a.a.c.s;
import com.google.a.a.c.x;
import com.google.a.a.f.ab;
import com.google.a.a.f.z;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.AccountPicker;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class a
  implements r
{
  final Context a;
  final String b;
  private final com.google.a.a.b.a.a.a.a c;
  private String d;
  private Account e;
  private ab f = ab.a;
  private com.google.a.a.f.c g;

  public a(Context paramContext, String paramString)
  {
    this.c = new com.google.a.a.b.a.a.a.a(paramContext);
    this.a = paramContext;
    this.b = paramString;
  }

  public static a a(Context paramContext, Collection<String> paramCollection)
  {
    boolean bool;
    String str1;
    if ((paramCollection != null) && (paramCollection.iterator().hasNext()))
    {
      bool = true;
      z.a(bool);
      str1 = String.valueOf(com.google.a.a.f.p.a(' ').a(paramCollection));
      if (str1.length() == 0)
        break label68;
    }
    label68: for (String str2 = "oauth2: ".concat(str1); ; str2 = new String("oauth2: "))
    {
      return new a(paramContext, str2);
      bool = false;
      break;
    }
  }

  public final Context a()
  {
    return this.a;
  }

  public a a(com.google.a.a.f.c paramc)
  {
    this.g = paramc;
    return this;
  }

  public final a a(String paramString)
  {
    this.e = this.c.a(paramString);
    if (this.e == null)
      paramString = null;
    this.d = paramString;
    return this;
  }

  public void a(com.google.a.a.c.p paramp)
  {
    a locala = new a();
    paramp.a(locala);
    paramp.a(locala);
  }

  public final Account b()
  {
    return this.e;
  }

  public final String c()
  {
    return this.d;
  }

  public final Intent d()
  {
    return AccountPicker.newChooseAccountIntent(this.e, null, new String[] { "com.google" }, true, null, null, null, null);
  }

  public String e()
    throws IOException, GoogleAuthException
  {
    if (this.g != null)
      this.g.a();
    while (true)
      try
      {
        String str = GoogleAuthUtil.getToken(this.a, this.d, this.b);
        return str;
      }
      catch (IOException localIOException)
      {
        try
        {
          if ((this.g == null) || (!com.google.a.a.f.d.a(this.f, this.g)))
            throw localIOException;
        }
        catch (InterruptedException localInterruptedException)
        {
        }
      }
  }

  class a
    implements l, x
  {
    boolean a;
    String b;

    a()
    {
    }

    public boolean a(com.google.a.a.c.p paramp, s params, boolean paramBoolean)
    {
      if ((params.d() == 401) && (!this.a))
      {
        this.a = true;
        GoogleAuthUtil.invalidateToken(a.this.a, this.b);
        return true;
      }
      return false;
    }

    public void b(com.google.a.a.c.p paramp)
      throws IOException
    {
      try
      {
        this.b = a.this.e();
        m localm = paramp.g();
        String str1 = String.valueOf(this.b);
        if (str1.length() != 0);
        for (String str2 = "Bearer ".concat(str1); ; str2 = new String("Bearer "))
        {
          localm.b(str2);
          return;
        }
      }
      catch (GooglePlayServicesAvailabilityException localGooglePlayServicesAvailabilityException)
      {
        throw new c(localGooglePlayServicesAvailabilityException);
      }
      catch (UserRecoverableAuthException localUserRecoverableAuthException)
      {
        throw new d(localUserRecoverableAuthException);
      }
      catch (GoogleAuthException localGoogleAuthException)
      {
        throw new b(localGoogleAuthException);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.b.a.a.b.a.a
 * JD-Core Version:    0.6.2
 */