package com.viber.voip.gdpr.ui.iabconsent;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.gdpr.a.a.a;
import com.viber.voip.gdpr.a.a.b;
import com.viber.voip.util.ck;
import com.viber.voip.util.dj;
import java.util.List;

public class j extends com.viber.voip.mvp.core.d<ManageConsentPresenter>
  implements MenuItem.OnMenuItemClickListener, i
{
  private final Activity a;
  private final q b;
  private final q c;
  private final int d;
  private MenuItem e;
  private d f;

  protected j(ManageConsentPresenter paramManageConsentPresenter, View paramView, Fragment paramFragment, int paramInt)
  {
    super(paramManageConsentPresenter, paramView);
    this.d = paramInt;
    paramFragment.setHasOptionsMenu(true);
    this.a = paramFragment.getActivity();
    this.f = paramManageConsentPresenter;
    RecyclerView localRecyclerView = (RecyclerView)paramView.findViewById(R.id.list);
    ck localck = new ck(this.a);
    localck.a(new q(R.layout.manage_ads_description, k.a, Integer.valueOf(R.string.gdpr_consent_manage_ads_description), paramFragment.getLayoutInflater()));
    localck.a(new q(R.layout.manage_ads_header, l.a, Integer.valueOf(R.string.gdpr_consent_manage_ads_purposes), paramFragment.getLayoutInflater()));
    this.b = new q(R.layout.manage_ads_item, new m(this), paramFragment.getLayoutInflater());
    localck.a(this.b);
    localck.a(new q(R.layout.manage_ads_header, n.a, Integer.valueOf(R.string.gdpr_consent_manage_ads_partners), paramFragment.getLayoutInflater()));
    this.c = new q(R.layout.manage_ads_item, new o(this), paramFragment.getLayoutInflater());
    localck.a(this.c);
    localRecyclerView.setAdapter(localck);
  }

  public void a()
  {
    this.a.finish();
  }

  public void a(List<p> paramList)
  {
    this.b.a(paramList);
  }

  public void b(List<r> paramList)
  {
    this.c.a(paramList);
  }

  public boolean onBackPressed()
  {
    return this.d == 1;
  }

  public boolean onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_edit_options, paramMenu);
    this.e = paramMenu.findItem(R.id.menu_done);
    this.e.setOnMenuItemClickListener(this);
    MenuItem localMenuItem = this.e;
    if (this.d == 1);
    for (boolean bool = true; ; bool = false)
    {
      localMenuItem.setVisible(bool);
      return true;
    }
  }

  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (paramMenuItem == this.e)
      this.f.a(this.d);
    return true;
  }

  public void onStop()
  {
    if (this.d == 2)
      this.f.a(this.d);
  }

  private static class a extends q.a<Integer>
  {
    private TextView a;

    public a(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(R.id.body));
      this.a.setMovementMethod(LinkMovementMethod.getInstance());
      this.a.setHighlightColor(0);
    }

    public void a(Integer paramInteger)
    {
      this.a.setText(Html.fromHtml(this.itemView.getContext().getString(paramInteger.intValue())));
    }
  }

  private static class b extends q.a<Integer>
  {
    private TextView a;

    public b(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(R.id.body));
    }

    public void a(Integer paramInteger)
    {
      this.a.setText(paramInteger.intValue());
    }
  }

  private static abstract class c<T> extends q.a<T>
    implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
  {
    protected final TextView a;
    protected final TextView b;
    protected final CheckBox c;

    public c(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(R.id.item_name));
      this.b = ((TextView)paramView.findViewById(R.id.item_summary));
      this.c = ((CheckBox)paramView.findViewById(R.id.check_box));
      this.c.setOnCheckedChangeListener(this);
      paramView.setOnClickListener(this);
    }

    public void onClick(View paramView)
    {
      CheckBox localCheckBox;
      if (paramView == this.itemView)
      {
        localCheckBox = this.c;
        if (this.c.isChecked())
          break label31;
      }
      label31: for (boolean bool = true; ; bool = false)
      {
        localCheckBox.setChecked(bool);
        return;
      }
    }
  }

  private static class d extends j.c<p>
  {
    private p d;

    public d(View paramView, d paramd)
    {
      super();
    }

    public void a(p paramp)
    {
      this.d = paramp;
      this.b.setVisibility(8);
      this.a.setText(paramp.a().b());
      this.c.setChecked(paramp.b());
    }

    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (this.d != null)
        this.d.a(paramBoolean);
    }
  }

  private static class e extends j.c<r>
  {
    private final d d;
    private r e;

    public e(View paramView, d paramd)
    {
      super();
      this.d = paramd;
      this.b.setText(R.string.gdpr_consent_manage_ads_policy);
      dj.a(this.b, true);
      this.b.setOnClickListener(this);
    }

    public void a(r paramr)
    {
      this.e = paramr;
      this.b.setVisibility(0);
      this.a.setText(paramr.a().a());
      this.c.setChecked(paramr.b());
    }

    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (this.e != null)
        this.e.a(paramBoolean);
    }

    public void onClick(View paramView)
    {
      super.onClick(paramView);
      if ((paramView == this.b) && (this.e != null) && (this.d != null))
        this.d.a(this.e.a());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.ui.iabconsent.j
 * JD-Core Version:    0.6.2
 */