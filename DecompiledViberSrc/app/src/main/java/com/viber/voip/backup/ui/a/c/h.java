package com.viber.voip.backup.ui.a.c;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.p;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.t;
import com.viber.voip.widget.ProgressBar;

public class h extends e<com.viber.voip.backup.ui.a.a.e>
  implements View.OnClickListener
{
  private static final Logger h = ViberEnv.getLogger();
  private ViberTextView i;
  private Button j;

  public h(Activity paramActivity, Fragment paramFragment, View paramView, Resources paramResources, p paramp)
  {
    super(paramActivity, paramFragment, paramView, paramResources, paramp);
    this.i = ((ViberTextView)paramView.findViewById(R.id.restore_header));
    this.j = ((Button)paramView.findViewById(R.id.btn_skip));
    this.j.setOnClickListener(this);
  }

  private void a(boolean paramBoolean)
  {
    ViberTextView localViberTextView = this.i;
    if (paramBoolean);
    for (int k = R.string.backup_restore_description; ; k = R.string.backup_restore_no_permission_description)
    {
      localViberTextView.setText(k);
      return;
    }
  }

  public void a(int paramInt)
  {
    b localb = b(a.e);
    Resources localResources = this.d;
    int k = R.string.backup_restore_progress_preparing_label;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    localb.b(localResources.getString(k, arrayOfObject));
    localb.b(paramInt);
  }

  public void a(String paramString)
  {
    t.b(paramString).a(this.b).b(this.b);
  }

  public void b(int paramInt)
  {
    b localb = b(a.e);
    Resources localResources = this.d;
    int k = R.string.backup_restore_progress_downloading_label;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    localb.b(localResources.getString(k, arrayOfObject));
    localb.b(paramInt);
  }

  public void b(m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D435d))
    {
      ((com.viber.voip.backup.ui.a.a.e)this.g).a(a.i);
      if (paramInt == -1)
      {
        a(a.k);
        return;
      }
      a(a.g);
      return;
    }
    super.b(paramm, paramInt);
  }

  protected b d()
  {
    View localView = this.e.findViewById(R.id.restore_action);
    return new b(a.e, this, localView, (ViberTextView)localView.findViewById(R.id.restore_action_title), (ViberTextView)localView.findViewById(R.id.restore_action_state), (ProgressBar)this.e.findViewById(R.id.restore_action_progress));
  }

  protected b f()
  {
    View localView = this.e.findViewById(R.id.backup_select_account_container);
    return new b(a.g, this, localView, (ViberTextView)localView.findViewById(R.id.restore_action_connect_to_drive_title), (ViberTextView)localView.findViewById(R.id.restore_action_connect_to_drive_subtitle));
  }

  protected b g()
  {
    View localView = this.e.findViewById(R.id.backup_info_container);
    return new b(a.h, this, localView, (ViberTextView)localView.findViewById(R.id.backup_last_time), (ViberTextView)localView.findViewById(R.id.backup_last_size));
  }

  protected i h()
  {
    return new i(this)
    {
      public void a()
      {
        h.this.m();
        h.a(h.this, false);
        h localh = h.this;
        a[] arrayOfa = new a[1];
        arrayOfa[0] = a.g;
        localh.c(true, arrayOfa);
        h.a(h.this).setVisibility(0);
      }

      public void b()
      {
        h.a(h.this, false);
        h localh1 = h.this;
        a[] arrayOfa1 = new a[1];
        arrayOfa1[0] = a.g;
        localh1.a(true, arrayOfa1);
        h localh2 = h.this;
        a[] arrayOfa2 = new a[1];
        arrayOfa2[0] = a.g;
        localh2.b(false, arrayOfa2);
        h.a(h.this).setVisibility(0);
      }

      public void c()
      {
        a();
      }

      public void d()
      {
        h.a(h.this, true);
        h localh = h.this;
        a[] arrayOfa = new a[2];
        arrayOfa[0] = a.h;
        arrayOfa[1] = a.e;
        localh.c(true, arrayOfa);
        b localb = a(a.e);
        localb.a(false);
        localb.a(h.this.d.getString(R.string.backup_restore_action_restore));
        localb.b(true);
        localb.b(0);
        h.a(h.this).setVisibility(0);
      }

      public void e()
      {
        h.a(h.this, true);
        h localh = h.this;
        a[] arrayOfa = new a[2];
        arrayOfa[0] = a.h;
        arrayOfa[1] = a.e;
        localh.c(true, arrayOfa);
        b localb = a(a.e);
        localb.a(h.this.d.getString(R.string.backup_restore_action_restoring_progress));
        localb.a(true);
        localb.b(true);
        h.a(h.this).setVisibility(4);
      }

      public void f()
      {
      }

      public void g()
      {
      }
    };
  }

  public void i()
  {
    t.k().b(this.b);
    this.j.setEnabled(true);
  }

  public void j()
  {
    this.j.setEnabled(true);
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.btn_skip)
      a(a.j);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.c.h
 * JD-Core Version:    0.6.2
 */