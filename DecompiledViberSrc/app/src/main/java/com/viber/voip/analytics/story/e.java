package com.viber.voip.analytics.story;

import android.support.v4.util.ArrayMap;
import com.viber.voip.analytics.story.k.a;

public class e extends f
{
  private boolean c = false;
  private boolean d = false;

  public e()
  {
    this(true);
  }

  public e(String paramString)
  {
    this(true, paramString);
  }

  public e(boolean paramBoolean)
  {
    super(paramBoolean);
  }

  public e(boolean paramBoolean, String paramString)
  {
    this(paramBoolean);
    a("key_property_name", paramString);
  }

  public e a(a parama)
  {
    b(parama);
    return this;
  }

  public e a(Class paramClass, f.a parama)
  {
    return (e)super.b(paramClass, parama);
  }

  public e a(String paramString, Object paramObject)
  {
    this.a.put(paramString, paramObject);
    return this;
  }

  e a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }

  public boolean a()
  {
    return this.c;
  }

  public String toString()
  {
    return getClass().getSimpleName() + ": properties=" + this.a + ", enabled=" + b() + ", isPurchaseEvent=" + this.c + ", isRegistrationEvent=" + this.d;
  }

  public static class a
  {
    public static e a(String paramString1, String paramString2, String paramString3, int paramInt)
    {
      return a(paramString1, paramString2, paramString3, paramInt, true);
    }

    public static e a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
    {
      return new e(paramBoolean).a(true).a("key_property_product_id", paramString1).a("key_property_price", paramString3).a("key_property_currency", paramString2).a("key_property_quantity", Integer.valueOf(paramInt));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.e
 * JD-Core Version:    0.6.2
 */