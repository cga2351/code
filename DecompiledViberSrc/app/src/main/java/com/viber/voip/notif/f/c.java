package com.viber.voip.notif.f;

import android.content.Context;
import android.graphics.Bitmap;
import com.viber.voip.R.drawable;
import com.viber.voip.util.dq;

public class c
  implements d
{
  private final Context a;

  c(Context paramContext)
  {
    this.a = paramContext;
  }

  public int a()
  {
    return 1;
  }

  Bitmap a(int paramInt)
  {
    if (paramInt > 0)
      return dq.a(this.a.getResources(), paramInt);
    return null;
  }

  public g a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 <= 0) && (paramInt1 > 0))
      paramInt2 = R.drawable.bg_wear_default;
    return new a(paramInt1, paramInt2);
  }

  private class a
    implements g
  {
    private final int b;
    private final int c;

    public a(int paramInt1, int arg3)
    {
      this.b = paramInt1;
      int i;
      this.c = i;
    }

    public Bitmap a()
    {
      return c.this.a(this.b);
    }

    public Bitmap b()
    {
      return c.this.a(this.c);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.f.c
 * JD-Core Version:    0.6.2
 */