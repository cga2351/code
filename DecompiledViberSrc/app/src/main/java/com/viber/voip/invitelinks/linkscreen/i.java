package com.viber.voip.invitelinks.linkscreen;

import android.app.Activity;
import com.viber.voip.util.ViberActionRunner.ab;

class i
{
  private final Activity a;

  public i(Activity paramActivity)
  {
    this.a = paramActivity;
  }

  public void a()
  {
    if (!this.a.isFinishing())
      this.a.finish();
  }

  public void b()
  {
    this.a.startActivity(ViberActionRunner.ab.a(this.a));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.linkscreen.i
 * JD-Core Version:    0.6.2
 */