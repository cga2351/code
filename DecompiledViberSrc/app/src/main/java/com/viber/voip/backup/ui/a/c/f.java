package com.viber.voip.backup.ui.a.c;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.m.g;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.x;
import com.viber.voip.ui.aq;
import com.viber.voip.util.ax;

public abstract class f<VIEW extends e> extends aq
  implements m.c, m.g
{
  private static final Logger a = ViberEnv.getLogger();
  private com.viber.voip.backup.ui.a.b.b b;
  private com.viber.voip.backup.ui.a.a.d c;
  private VIEW d;
  private Activity e;
  private com.viber.voip.backup.ui.a.b.f f;

  protected abstract com.viber.voip.backup.ui.a.a.d a(VIEW paramVIEW, com.viber.voip.backup.ui.a.b.b paramb);

  protected void a(View paramView)
  {
    com.viber.voip.backup.ui.a.b.a locala = new com.viber.voip.backup.ui.a.b.a(this.e, this, c.a(getContext()));
    com.viber.voip.backup.b.b localb = new com.viber.voip.backup.b.b(this.e, com.viber.voip.backup.f.b());
    localb.a(new com.viber.backup.drive.d(com.viber.backup.a.d.a(this.e.getApplicationContext()), new com.viber.voip.backup.b.b(this.e, new com.viber.backup.drive.a(d.x.a))));
    this.b = new com.viber.voip.backup.ui.a.b.b(this.e, this, locala, localb);
    this.d = b(paramView);
    this.c = a(this.d, this.b);
    this.f = this.d;
  }

  protected abstract VIEW b(View paramView);

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!this.b.a(paramInt1, paramInt2, paramIntent))
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.e = paramActivity;
  }

  public void onDetach()
  {
    this.e = null;
    super.onDetach();
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    this.f.b(paramm, paramInt);
  }

  public void onDialogListAction(m paramm, int paramInt)
  {
    this.f.a(paramm, paramInt);
  }

  public void onPause()
  {
    super.onPause();
    ax.a(getFragmentManager());
    this.c.e();
  }

  public void onResume()
  {
    super.onResume();
    this.d.l();
  }

  public void onStart()
  {
    super.onStart();
    this.c.j();
  }

  public void onStop()
  {
    super.onStop();
    this.c.k();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a(paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.c.f
 * JD-Core Version:    0.6.2
 */