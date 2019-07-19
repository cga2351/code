package com.viber.voip.backup.ui.a.c;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.m;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.BackupInfo;
import com.viber.voip.backup.p;
import com.viber.voip.backup.ui.a.a.d;
import com.viber.voip.backup.ui.a.b.f;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.t;
import com.viber.voip.util.at;

public abstract class e<PRESENTER extends d>
  implements f, b.a
{
  private static final Logger h = ViberEnv.getLogger();
  protected Activity a;
  protected Fragment b;
  protected p c;
  protected Resources d;
  protected View e;
  protected i f;
  protected PRESENTER g;

  public e(Activity paramActivity, Fragment paramFragment, View paramView, Resources paramResources, p paramp)
  {
    this.a = paramActivity;
    this.b = paramFragment;
    this.e = paramView;
    this.d = paramResources;
    this.c = paramp;
    k();
  }

  private void a(b paramb)
  {
    this.f.a(paramb);
  }

  protected b a()
  {
    return null;
  }

  protected void a(int paramInt1, int paramInt2)
  {
    if (!this.a.isFinishing())
      Toast.makeText(this.a, paramInt1, paramInt2).show();
  }

  public void a(m paramm, int paramInt)
  {
  }

  public void a(PRESENTER paramPRESENTER)
  {
    this.g = paramPRESENTER;
  }

  public void a(a parama)
  {
    this.g.a(parama);
  }

  public void a(a parama)
  {
    this.f.a(parama);
  }

  public void a(CharSequence paramCharSequence)
  {
    ad.a(paramCharSequence.toString()).d();
  }

  public void a(boolean paramBoolean, a[] paramArrayOfa)
  {
    int i = paramArrayOfa.length;
    for (int j = 0; j < i; j++)
      b(paramArrayOfa[j]).c(paramBoolean);
  }

  protected b b()
  {
    return null;
  }

  protected b b(a parama)
  {
    return this.f.a(parama);
  }

  public void b(m paramm, int paramInt)
  {
  }

  public void b(BackupInfo paramBackupInfo)
  {
    b localb = b(a.h);
    Resources localResources1 = this.d;
    int i = R.string.backup_last_backup_label;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = this.c.a(paramBackupInfo.getUpdateTime());
    localb.a(localResources1.getString(i, arrayOfObject1));
    Resources localResources2 = this.d;
    int j = R.string.backup_size_label;
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = at.a(paramBackupInfo.getSize());
    localb.b(localResources2.getString(j, arrayOfObject2));
    localb.a(true);
  }

  public void b(boolean paramBoolean, a[] paramArrayOfa)
  {
    int i = paramArrayOfa.length;
    for (int j = 0; j < i; j++)
      b(paramArrayOfa[j]).d(paramBoolean);
  }

  protected b c()
  {
    return null;
  }

  public void c(boolean paramBoolean, a[] paramArrayOfa)
  {
    a(paramBoolean, paramArrayOfa);
    b(paramBoolean, paramArrayOfa);
  }

  protected b d()
  {
    return null;
  }

  protected b e()
  {
    return null;
  }

  protected b f()
  {
    return null;
  }

  protected b g()
  {
    return null;
  }

  protected abstract i h();

  protected void k()
  {
    this.f = h();
    a(g());
    a(f());
    a(a());
    a(b());
    a(e());
    a(d());
    a(c());
  }

  public void l()
  {
    this.g.i();
  }

  protected void m()
  {
    b localb = b(a.h);
    Resources localResources = this.d;
    int i = R.string.backup_last_backup_label;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.d.getString(R.string.backup_no_backup_placeholder);
    localb.a(localResources.getString(i, arrayOfObject));
    localb.a(false);
  }

  public void n()
  {
    t.j().a(this.b).b(this.b);
  }

  public void o()
  {
    if (!this.a.isFinishing())
      ad.a().a(this.a);
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[7];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.c.e
 * JD-Core Version:    0.6.2
 */