package com.viber.voip.storage.overall;

import android.animation.LayoutTransition;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.common.d.a;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.z;
import com.viber.voip.R.id;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.t;
import com.viber.voip.util.at;
import com.viber.voip.util.dj;

class d extends com.viber.voip.mvp.core.d<ManageOverallStoragePresenter>
  implements c
{
  private final Fragment a;
  private final Runnable b;
  private final Runnable c;
  private com.viber.voip.widget.ProgressBar d;
  private View e;
  private TextView f;
  private View g;
  private android.widget.ProgressBar h;
  private final DialogCode i = DialogCode.D464_PROGRESS;
  private int j = 0;

  d(Fragment paramFragment, ManageOverallStoragePresenter paramManageOverallStoragePresenter, View paramView)
  {
    super(paramManageOverallStoragePresenter, paramView);
    this.a = paramFragment;
    ((ViewGroup)paramView).getLayoutTransition().enableTransitionType(4);
    this.d = ((com.viber.voip.widget.ProgressBar)paramView.findViewById(R.id.loading_progress));
    this.e = paramView.findViewById(R.id.manage_storage_local_data_label);
    this.f = ((TextView)paramView.findViewById(R.id.manage_storage_local_data_size));
    this.g = paramView.findViewById(R.id.manage_storage_clear_local_data);
    this.g.setOnClickListener(new e(this));
    this.b = new f(this);
    this.c = new g(this);
    this.d.postDelayed(this.b, 300L);
  }

  private void g()
  {
    if (this.h != null)
    {
      if (a.k())
        this.h.setProgress(this.j, true);
    }
    else
      return;
    this.h.setProgress(this.j);
  }

  public void a()
  {
    dj.b(this.e, true);
    dj.b(this.f, true);
    dj.b(this.g, true);
    this.d.removeCallbacks(this.b);
    this.d.postDelayed(this.c, 300L);
  }

  public void a(int paramInt)
  {
    this.j = paramInt;
    g();
  }

  public void a(long paramLong)
  {
    this.f.setText(at.a(paramLong, false));
    View localView = this.g;
    boolean bool1 = paramLong < 0L;
    boolean bool2 = false;
    if (bool1)
      bool2 = true;
    localView.setEnabled(bool2);
  }

  public void b()
  {
    FragmentManager localFragmentManager = this.a.getChildFragmentManager();
    localFragmentManager.executePendingTransactions();
    if (z.c(localFragmentManager, this.i) == null)
      t.s().a(this.a).b(this.a);
  }

  public void c()
  {
    z.b(this.a, this.i);
    this.j = 0;
    this.h = null;
  }

  public void d()
  {
    t.t().a(this.a).b(this.a);
  }

  public boolean onDialogAction(m paramm, int paramInt)
  {
    boolean bool2;
    if (paramm.a(this.i))
    {
      if ((paramInt == -1001) || (paramInt == -1000))
      {
        this.j = 0;
        this.h = null;
      }
      bool2 = true;
    }
    boolean bool1;
    do
    {
      return bool2;
      bool1 = paramm.a(DialogCode.D465);
      bool2 = false;
    }
    while (!bool1);
    if (paramInt == -1)
      ((ManageOverallStoragePresenter)this.mPresenter).c();
    return true;
  }

  public void onPrepareDialogView(m paramm, View paramView, int paramInt)
  {
    if (paramm.a(this.i))
    {
      this.h = ((android.widget.ProgressBar)paramView.findViewById(R.id.media_storage_clearing_progress));
      g();
    }
  }

  public void onStop()
  {
    this.d.removeCallbacks(this.b);
    this.d.removeCallbacks(this.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.overall.d
 * JD-Core Version:    0.6.2
 */