package com.appboy;

import a.a.au;
import a.a.ax;
import a.a.bp;
import a.a.dd;
import a.a.dh;
import com.appboy.b.g;
import com.appboy.b.h;
import com.appboy.b.i;
import com.appboy.e.b.b;
import com.appboy.f.c;
import com.appboy.f.e;
import com.appboy.f.j;

public class d
{
  private static final String a = c.a(d.class);
  private final dh b;
  private final dd c;
  private final Object d = new Object();
  private final ax e;
  private volatile String f;
  private final au g;

  d(dh paramdh, au paramau, String paramString, ax paramax, dd paramdd)
  {
    this.f = paramString;
    this.b = paramdh;
    this.e = paramax;
    this.c = paramdd;
    this.g = paramau;
  }

  public String a()
  {
    synchronized (this.d)
    {
      String str = this.f;
      return str;
    }
  }

  public void a(String paramString, double paramDouble1, double paramDouble2)
  {
    try
    {
      if (!e.a(paramString, this.c.i()))
      {
        c.d(a, "Custom location attribute key was invalid. Not setting attribute.");
        return;
      }
      if (!j.a(paramDouble1, paramDouble2))
      {
        c.d(a, "Cannot set custom location attribute due with invalid latitude '" + paramDouble1 + " and longitude '" + paramDouble2 + "'");
        return;
      }
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set custom location attribute with key '" + paramString + "' and latitude '" + paramDouble1 + "' and longitude '" + paramDouble2 + "'", localException);
      return;
    }
    paramString = j.c(paramString);
    bp localbp = bp.a(paramString, paramDouble1, paramDouble2);
    this.g.a(localbp);
  }

  public boolean a(int paramInt1, h paramh, int paramInt2)
  {
    try
    {
      boolean bool = this.b.a(paramInt1, paramh, paramInt2);
      return bool;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set date of birth to: " + paramInt1 + "-" + paramh.a() + "-" + paramInt2, localException);
    }
    return false;
  }

  public boolean a(g paramg)
  {
    try
    {
      this.b.a(paramg);
      return true;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set gender to: " + paramg, localException);
    }
    return false;
  }

  public boolean a(i parami)
  {
    try
    {
      this.b.a(parami);
      return true;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set email notification subscription to: " + parami, localException);
    }
    return false;
  }

  public boolean a(b paramb)
  {
    try
    {
      this.b.a(paramb);
      return true;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set attribution data.", localException);
    }
    return false;
  }

  public boolean a(String paramString)
  {
    try
    {
      this.b.b(paramString);
      return true;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set first name to: " + paramString, localException);
    }
    return false;
  }

  public boolean a(String paramString, double paramDouble)
  {
    try
    {
      boolean bool = this.b.a(paramString, Double.valueOf(paramDouble));
      return bool;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set custom double attribute " + paramString + ".", localException);
    }
    return false;
  }

  public boolean a(String paramString, float paramFloat)
  {
    try
    {
      boolean bool = this.b.a(paramString, Float.valueOf(paramFloat));
      return bool;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set custom float attribute " + paramString + ".", localException);
    }
    return false;
  }

  public boolean a(String paramString, int paramInt)
  {
    try
    {
      boolean bool = this.b.a(paramString, Integer.valueOf(paramInt));
      return bool;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set custom integer attribute " + paramString + ".", localException);
    }
    return false;
  }

  public boolean a(String paramString, long paramLong)
  {
    try
    {
      boolean bool = this.b.a(paramString, Long.valueOf(paramLong));
      return bool;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set custom long attribute " + paramString + ".", localException);
    }
    return false;
  }

  public boolean a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = this.b.a(paramString1, paramString2);
      return bool;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set custom string attribute " + paramString1 + ".", localException);
    }
    return false;
  }

  public boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      boolean bool = this.b.a(paramString, Boolean.valueOf(paramBoolean));
      return bool;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set custom boolean attribute " + paramString + ".", localException);
    }
    return false;
  }

  public boolean a(String paramString, String[] paramArrayOfString)
  {
    try
    {
      if (!e.a(paramString, this.c.i()))
        return false;
      paramString = j.c(paramString);
      if (paramArrayOfString != null)
        paramArrayOfString = e.a(paramArrayOfString);
      bp localbp = bp.a(paramString, paramArrayOfString);
      boolean bool = this.g.a(localbp);
      return bool;
    }
    catch (Exception localException)
    {
      c.d(a, "Failed to set custom attribute array with key: '" + paramString + "'.");
    }
    return false;
  }

  public boolean b(i parami)
  {
    try
    {
      this.b.b(parami);
      return true;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set push notification subscription to: " + parami, localException);
    }
    return false;
  }

  public boolean b(String paramString)
  {
    try
    {
      this.b.c(paramString);
      return true;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set last name to: " + paramString, localException);
    }
    return false;
  }

  public boolean b(String paramString, int paramInt)
  {
    try
    {
      if (!e.a(paramString, this.c.i()))
        return false;
      paramString = j.c(paramString);
      bp localbp = bp.a(paramString, paramInt);
      boolean bool = this.g.a(localbp);
      return bool;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to increment custom attribute " + paramString + " by " + paramInt + ".", localException);
    }
    return false;
  }

  public boolean b(String paramString, long paramLong)
  {
    try
    {
      boolean bool = this.b.a(paramString, paramLong);
      return bool;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set custom attribute " + paramString + " to " + paramLong + " seconds from epoch.", localException);
    }
    return false;
  }

  public boolean b(String paramString1, String paramString2)
  {
    try
    {
      if (!e.a(paramString1, this.c.i()))
      {
        c.d(a, "Custom attribute key was invalid. Not adding to attribute array.");
        return false;
      }
      if (e.a(paramString2))
      {
        paramString1 = j.c(paramString1);
        bp localbp = bp.b(paramString1, j.c(paramString2));
        boolean bool = this.g.a(localbp);
        return bool;
      }
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to add custom attribute with key '" + paramString1 + "'.", localException);
    }
    return false;
  }

  public boolean c(String paramString)
  {
    try
    {
      boolean bool = this.b.d(paramString);
      return bool;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set email to: " + paramString, localException);
    }
    return false;
  }

  public boolean c(String paramString1, String paramString2)
  {
    try
    {
      if (!e.a(paramString1, this.c.i()))
      {
        c.d(a, "Custom attribute key was invalid. Not removing from attribute array.");
        return false;
      }
      if (e.a(paramString2))
      {
        paramString1 = j.c(paramString1);
        bp localbp = bp.c(paramString1, j.c(paramString2));
        boolean bool = this.g.a(localbp);
        return bool;
      }
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to remove custom attribute with key '" + paramString1 + "'.", localException);
    }
    return false;
  }

  public boolean d(String paramString)
  {
    try
    {
      this.b.e(paramString);
      return true;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set country to: " + paramString, localException);
    }
    return false;
  }

  public boolean e(String paramString)
  {
    try
    {
      this.b.f(paramString);
      return true;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set home city to: " + paramString, localException);
    }
    return false;
  }

  public boolean f(String paramString)
  {
    try
    {
      this.b.g(paramString);
      return true;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set language to: " + paramString, localException);
    }
    return false;
  }

  public boolean g(String paramString)
  {
    try
    {
      boolean bool = this.b.h(paramString);
      return bool;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to set phone number to: " + paramString, localException);
    }
    return false;
  }

  public boolean h(String paramString)
  {
    return b(paramString, 1);
  }

  void i(String paramString)
  {
    synchronized (this.d)
    {
      if ((!this.f.equals("")) && (!this.f.equals(paramString)))
        throw new IllegalArgumentException("setExternalId can not be used to change the external ID of a UserCache from a non-empty value to a new value. Was: [" + this.f + "], tried to change to: [" + paramString + "]");
    }
    this.f = paramString;
    this.b.a(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.d
 * JD-Core Version:    0.6.2
 */