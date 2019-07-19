package com.viber.voip.registration.changephonenumber;

import android.app.Activity;
import com.viber.voip.registration.CountryCode;
import com.viber.voip.ui.aq;
import com.viber.voip.util.ag;
import com.viber.voip.util.cl;

public class a extends aq
{
  static a a = (a)cl.b(a.class);
  protected a b = a;

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof a))
      this.b = ((a)paramActivity);
  }

  public void onDetach()
  {
    super.onDetach();
    this.b = a;
  }

  static abstract interface a
  {
    public abstract void a(CountryCode paramCountryCode, String paramString, boolean paramBoolean);

    public abstract void a(a.b paramb);

    public abstract void a(a.b paramb, boolean paramBoolean);

    public abstract void a(String paramString);

    public abstract void a(boolean paramBoolean);

    @ag
    public abstract boolean a();

    public abstract void b(CountryCode paramCountryCode, String paramString, boolean paramBoolean);

    public abstract void b(String paramString);

    @ag
    public abstract boolean b();

    public abstract void c();

    public abstract void d();

    public abstract String e();

    public abstract String f();
  }

  static enum b
  {
    static
    {
      b[] arrayOfb = new b[4];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.changephonenumber.a
 * JD-Core Version:    0.6.2
 */