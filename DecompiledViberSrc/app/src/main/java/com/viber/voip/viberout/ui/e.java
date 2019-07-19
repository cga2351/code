package com.viber.voip.viberout.ui;

import android.os.Handler;
import android.text.TextUtils;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.billing.IabProductId;
import com.viber.voip.billing.b.g;
import com.viber.voip.billing.b.j;
import com.viber.voip.billing.f;

public class e
  implements b.j
{
  private final Handler a = av.a(av.e.a);
  private final boolean b;
  private final boolean c;
  private final a d;

  public e(boolean paramBoolean1, boolean paramBoolean2, a parama)
  {
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = parama;
  }

  public void a(b.g paramg)
  {
    if (!this.d.a())
      return;
    this.d.b();
    if (paramg.c() != null)
    {
      this.d.c();
      return;
    }
    f[] arrayOff = paramg.d();
    if ((arrayOff != null) && (arrayOff.length > 1))
    {
      final a locala = this.d.d();
      if (locala.a(paramg))
      {
        this.a.post(new Runnable()
        {
          public void run()
          {
            if (e.a(e.this).a())
              e.a(e.this).a(locala);
          }
        });
        return;
      }
      this.d.c();
      return;
    }
    IabProductId localIabProductId;
    String str3;
    String str2;
    String str1;
    if ((arrayOff != null) && (arrayOff.length > 0))
    {
      localIabProductId = arrayOff[0].b();
      if (localIabProductId == null)
        break label224;
      str3 = localIabProductId.getProviderId();
      str2 = localIabProductId.getJson();
      str1 = localIabProductId.toString();
    }
    while (true)
    {
      if (("credit_card".equals(str3)) && (!TextUtils.isEmpty(str1)))
      {
        CreditCardCheckoutWebActivity.a(str1, this.c);
        this.d.e();
        return;
        localIabProductId = null;
        break;
      }
      if (!TextUtils.isEmpty(str2))
      {
        ViberOutDialogs.a(str2, this.b, this.c);
        this.d.e();
        return;
      }
      this.d.f();
      return;
      label224: str1 = null;
      str2 = null;
      str3 = null;
    }
  }

  public static abstract interface a
  {
    public abstract void a(a parama);

    public abstract boolean a();

    public abstract void b();

    public abstract void c();

    public abstract a d();

    public abstract void e();

    public abstract void f();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.e
 * JD-Core Version:    0.6.2
 */