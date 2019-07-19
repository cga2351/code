package com.viber.voip.registration.changephonenumber;

import android.os.Bundle;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;

public class b extends j
{
  private PhoneController o;

  protected void a(String paramString)
  {
    this.n.b(paramString);
  }

  protected boolean e()
  {
    return this.n.b();
  }

  public void f_(boolean paramBoolean)
  {
    this.n.a(a.b.d, paramBoolean);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.o = ViberApplication.getInstance().getEngine(false).getPhoneController();
    this.o.disconnect();
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (!this.o.isConnected())
      this.o.connect();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.changephonenumber.b
 * JD-Core Version:    0.6.2
 */