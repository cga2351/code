package com.viber.voip.backup.ui.a.c;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.View;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.j.a;
import com.viber.common.dialogs.m;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.p;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.t;
import com.viber.voip.util.at;

public abstract class d<PRESENTER extends com.viber.voip.backup.ui.a.a.b> extends e<PRESENTER>
{
  private static final Logger h = ViberEnv.getLogger();

  public d(Activity paramActivity, Fragment paramFragment, View paramView, Resources paramResources, p paramp)
  {
    super(paramActivity, paramFragment, paramView, paramResources, paramp);
  }

  public void a(int paramInt)
  {
    b localb = b(a.d);
    Resources localResources = this.d;
    int i = R.string.backup_backup_progress_preparing_label;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    localb.b(localResources.getString(i, arrayOfObject));
    localb.b(paramInt);
  }

  public void a(int paramInt, int[] paramArrayOfInt)
  {
    t.a(paramInt, paramArrayOfInt).a(this.b).b(this.b);
  }

  public void a(long paramLong, int paramInt)
  {
    long l = ()((float)paramLong * (paramInt / 100.0F));
    b localb = b(a.d);
    Resources localResources = this.d;
    int i = R.string.backup_backup_progress_uploading_label;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = at.a(l);
    arrayOfObject[1] = at.a(paramLong);
    arrayOfObject[2] = Integer.valueOf(paramInt);
    localb.b(localResources.getString(i, arrayOfObject));
    localb.b(paramInt);
  }

  public void a(m paramm, int paramInt)
  {
    if (paramm.c() == DialogCode.D_SELECT_AUTO_BACKUP_PERIOD)
    {
      ((com.viber.voip.backup.ui.a.a.b)this.g).a(paramInt);
      paramm.dismiss();
      return;
    }
    super.a(paramm, paramInt);
  }

  public void a(com.viber.voip.backup.a parama)
  {
    b(a.b).a(parama.c());
  }

  public void b(m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D437))
      ((com.viber.voip.backup.ui.a.a.b)this.g).a(a.i);
  }

  public void i()
  {
    t.e().d();
  }

  public void j()
  {
    a(R.string.backup_export_complete, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.c.d
 * JD-Core Version:    0.6.2
 */