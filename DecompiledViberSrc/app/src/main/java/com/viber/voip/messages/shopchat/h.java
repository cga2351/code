package com.viber.voip.messages.shopchat;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.util.ViberActionRunner.be;
import com.viber.voip.util.dz;

public class h
  implements com.shopchat.library.a.b
{
  private Context a;
  private com.viber.common.b.b b;

  public h(Context paramContext, com.viber.common.b.b paramb)
  {
    this.a = paramContext;
    this.b = paramb;
  }

  public void a(String paramString1, String paramString2)
  {
    if (this.b.d())
    {
      Intent localIntent = GenericWebViewActivity.b(this.a, paramString1, paramString2);
      dz.a(this.a, localIntent);
      return;
    }
    this.a.startActivity(ViberActionRunner.be.b(this.a, paramString1));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.shopchat.h
 * JD-Core Version:    0.6.2
 */