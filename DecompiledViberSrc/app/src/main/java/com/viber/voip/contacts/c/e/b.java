package com.viber.voip.contacts.c.e;

import android.content.Context;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.util.bq;

public class b extends bq
{
  private static b c;

  private b(Context paramContext)
  {
    super(paramContext.getContentResolver(), av.a(av.e.c));
  }

  public static b a(Context paramContext)
  {
    if (c == null)
      c = new b(paramContext);
    return c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.e.b
 * JD-Core Version:    0.6.2
 */