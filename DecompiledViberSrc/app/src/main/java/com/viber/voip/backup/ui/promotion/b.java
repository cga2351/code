package com.viber.voip.backup.ui.promotion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.o;
import com.viber.voip.backup.f;
import com.viber.voip.schedule.p.a;
import com.viber.voip.settings.d.j;
import com.viber.voip.settings.d.x;
import com.viber.voip.ui.aq;

public class b extends aq
{
  private a a;
  private AutoBackupPromotionPresenter b;
  private com.viber.voip.backup.ui.a.b.b c;

  public static b a()
  {
    return new b();
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!this.c.a(paramInt1, paramInt2, paramIntent))
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public boolean onBackPressed()
  {
    return this.b.f();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    com.viber.voip.backup.auto.b localb = new com.viber.voip.backup.auto.b(d.j.k);
    com.viber.voip.backup.auto.d locald = new com.viber.voip.backup.auto.d(d.j.j);
    com.viber.voip.backup.b localb1 = new com.viber.voip.backup.b(requireContext(), d.j.g, localb, locald, p.a.a);
    com.viber.voip.backup.ui.a.b.a locala = new com.viber.voip.backup.ui.a.b.a(getActivity(), this, com.viber.common.permission.c.a(getContext()));
    com.viber.voip.backup.b.b localb2 = new com.viber.voip.backup.b.b(getActivity(), f.b());
    localb2.a(new com.viber.backup.drive.d(com.viber.backup.a.d.a(getActivity().getApplicationContext()), new com.viber.voip.backup.b.b(getActivity(), new com.viber.backup.drive.a(d.x.a))));
    this.c = new com.viber.voip.backup.ui.a.b.b(getActivity(), this, locala, localb2);
    com.viber.voip.analytics.story.g.a locala1 = g.a().c().c();
    this.b = new AutoBackupPromotionPresenter(localb1, this.c, locala1, new c(getActivity()));
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    paramMenuInflater.inflate(R.menu.menu_auto_backup_promotion, paramMenu);
    this.a.a(paramMenu.findItem(R.id.menu_done));
    this.b.c();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_auto_backup_promotion, paramViewGroup, false);
  }

  public void onDestroyView()
  {
    this.b.g();
    super.onDestroyView();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("presenter_state", this.b.e());
  }

  public void onStart()
  {
    super.onStart();
    this.b.a();
  }

  public void onStop()
  {
    super.onStop();
    this.b.b();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    int i = R.string.backup_autobackup_subtitle_path;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = getString(R.string.more);
    arrayOfObject[1] = getString(R.string.pref_settings_title);
    arrayOfObject[2] = getString(R.string.settings_account);
    arrayOfObject[3] = getString(R.string.pref_category_backup_and_restore);
    String str = getString(i, arrayOfObject);
    ((TextView)paramView.findViewById(R.id.auto_backup_promotion_subtitle)).setText(getString(R.string.backup_autobackup_subtitle, new Object[] { str }));
    this.a = new a(paramView.getContext(), paramView);
    AutoBackupPromotionPresenter localAutoBackupPromotionPresenter = this.b;
    a locala = this.a;
    if (paramBundle != null);
    for (Parcelable localParcelable = paramBundle.getParcelable("presenter_state"); ; localParcelable = null)
    {
      localAutoBackupPromotionPresenter.a(locala, localParcelable);
      return;
    }
  }

  private class a
    implements MenuItem.OnMenuItemClickListener, a.a, d
  {
    private final a b;
    private final RecyclerView c;
    private MenuItem d;

    public a(Context paramView, View arg3)
    {
      Object localObject;
      this.c = ((RecyclerView)localObject.findViewById(R.id.auto_backup_periods_list));
      this.c.setHasFixedSize(true);
      DividerItemDecoration localDividerItemDecoration = new DividerItemDecoration(paramView, 1);
      localDividerItemDecoration.setDrawable(ContextCompat.getDrawable(localObject.getContext(), R.drawable.divider_horizontal));
      this.c.addItemDecoration(localDividerItemDecoration);
      this.b = new a(this, b.this.getLayoutInflater());
      this.c.setAdapter(this.b);
    }

    public void a()
    {
      FragmentActivity localFragmentActivity = b.this.getActivity();
      b localb = b.this;
      int i = R.string.backup_autobackup_promo_back_warning;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = b.this.getString(R.string.done).toUpperCase();
      Toast.makeText(localFragmentActivity, localb.getString(i, arrayOfObject), 0).show();
    }

    public void a(int paramInt)
    {
      b.a(b.this).a(paramInt);
    }

    public void a(int paramInt, int[] paramArrayOfInt)
    {
      this.b.a(paramInt, paramArrayOfInt);
    }

    public void a(MenuItem paramMenuItem)
    {
      if (this.d != null)
        this.d.setOnMenuItemClickListener(null);
      this.d = paramMenuItem;
      if (this.d != null)
        this.d.setOnMenuItemClickListener(this);
    }

    public void a(boolean paramBoolean)
    {
      if (this.d != null)
        this.d.setEnabled(paramBoolean);
    }

    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      if (this.d == paramMenuItem)
        b.a(b.this).d();
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.promotion.b
 * JD-Core Version:    0.6.2
 */