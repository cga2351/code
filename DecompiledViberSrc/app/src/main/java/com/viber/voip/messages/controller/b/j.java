package com.viber.voip.messages.controller.b;

import android.content.Context;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dv;
import java.io.File;

public class j extends a
{
  private static final Logger d = ViberEnv.getLogger();
  private final String e;
  private final Uri f;

  public j(Context paramContext, Uri paramUri)
  {
    super(null, paramContext);
    this.f = paramUri;
    this.e = paramUri.toString();
  }

  private dv l()
  {
    return dv.q;
  }

  protected File a()
  {
    return dv.h.b(this.b, this.e, false);
  }

  protected void a(Uri paramUri)
  {
  }

  protected Uri b()
  {
    return this.f;
  }

  protected String c()
  {
    return this.e;
  }

  protected dv d()
  {
    return dv.h;
  }

  protected File e()
  {
    return l().b(this.b, this.f.toString(), true);
  }

  protected Uri f()
  {
    return l().a(this.b, this.f.toString(), true);
  }

  protected boolean g()
  {
    return true;
  }

  protected void h()
  {
  }

  protected boolean j()
  {
    return false;
  }

  protected void k()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.j
 * JD-Core Version:    0.6.2
 */