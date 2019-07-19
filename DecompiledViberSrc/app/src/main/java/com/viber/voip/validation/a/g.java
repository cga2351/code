package com.viber.voip.validation.a;

import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.publicgroup.PublicGroupController;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.validation.a;
import com.viber.voip.validation.a.a;
import com.viber.voip.validation.c;

public class g extends c<String, a>
{
  private static final Logger f = ViberEnv.getLogger();
  private int g = -1;
  private bv.t h = new bv.t()
  {
    public void onValidateGroupUriReply(long paramAnonymousLong, int paramAnonymousInt)
    {
      if (paramAnonymousLong == g.a(g.this))
        o.a().b(this);
      switch (paramAnonymousInt)
      {
      default:
        return;
      case 0:
        g.a(g.this, new e(a.a.c));
        return;
      case 1:
        g.b(g.this, new e(a.a.b, R.string.pgroups_validate_uri_error_not_unique));
        return;
      case 2:
      }
      g.c(g.this, new e(a.a.d, R.string.pgroups_validate_uri_error_no_connection).a(true));
    }
  };

  protected e a(String paramString)
  {
    if (da.a(paramString))
      return new e(a.a.a);
    if (!paramString.matches("[a-z0-9\\-\\_\\.~]+"))
      return new e(a.a.b, R.string.pgroups_validate_uri_error_invalid_character);
    if (!cj.a(true))
      return new e(a.a.b, R.string.pgroups_validate_uri_error_no_connection).a(true);
    return null;
  }

  protected void b(String paramString)
  {
    o.a().a(this.h);
    Engine localEngine = ViberApplication.getInstance().getEngine(true);
    this.g = localEngine.getPhoneController().generateSequence();
    localEngine.getPublicGroupController().handleValidatePublicGroupUri(this.g, paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.validation.a.g
 * JD-Core Version:    0.6.2
 */