package com.viber.voip.widget.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import com.viber.voip.R.drawable;
import com.viber.voip.ui.ap;

public class d extends ap<c>
{
  public d(Context paramContext)
  {
    super(paramContext);
  }

  protected c a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return new c();
    case 1:
    }
    return new b();
  }

  protected abstract class a
    implements c
  {
    protected a()
    {
    }
  }

  protected class b extends d.a
  {
    protected b()
    {
      super();
    }

    public Drawable a()
    {
      return ContextCompat.getDrawable(d.b(d.this), R.drawable.undobar_dark);
    }
  }

  protected class c extends d.a
  {
    protected c()
    {
      super();
    }

    public Drawable a()
    {
      return ContextCompat.getDrawable(d.a(d.this), R.drawable.undobar);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.c.d
 * JD-Core Version:    0.6.2
 */