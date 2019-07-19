package com.viber.voip.messages.conversation.ui.view.b;

import android.app.Activity;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.d.ad;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.aq.b;
import com.viber.voip.messages.conversation.ui.at;
import com.viber.voip.messages.conversation.ui.presenter.SearchMessagesOptionMenuPresenter;
import com.viber.voip.messages.conversation.ui.view.n;
import com.viber.voip.ui.MenuSearchMediator;
import com.viber.voip.ui.MenuSearchMediator.ViberSearchView;
import com.viber.voip.ui.ac.a;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;

public class t extends a<SearchMessagesOptionMenuPresenter>
  implements View.OnClickListener, ad, n
{
  private static final Logger b = ViberEnv.getLogger();
  protected MenuSearchMediator a = new MenuSearchMediator(new ac.a()
  {
    public boolean onQueryTextChange(String paramAnonymousString)
    {
      return false;
    }

    public boolean onQueryTextSubmit(String paramAnonymousString)
    {
      t.a(t.this, paramAnonymousString);
      ((SearchMessagesOptionMenuPresenter)t.a(t.this)).b(paramAnonymousString);
      return false;
    }

    public boolean onSearchViewShow(boolean paramAnonymousBoolean)
    {
      t.a(t.this, paramAnonymousBoolean);
      ((SearchMessagesOptionMenuPresenter)t.b(t.this)).b(paramAnonymousBoolean);
      return true;
    }
  });
  private Menu g;
  private boolean h;
  private String i;
  private MenuItem j;
  private MenuItem k;
  private aq.b l;
  private at m;
  private TextView n;
  private TextView o;
  private TextView p;
  private ImageView q;
  private ImageView r;

  public t(SearchMessagesOptionMenuPresenter paramSearchMessagesOptionMenuPresenter, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, aq.b paramb, boolean paramBoolean)
  {
    super(paramSearchMessagesOptionMenuPresenter, paramActivity, paramConversationFragment, paramView, paramBoolean);
    this.l = paramb;
  }

  private void a(MenuInflater paramMenuInflater, Menu paramMenu)
  {
    paramMenuInflater.inflate(R.menu.menu_search_messages, paramMenu);
    this.j = paramMenu.findItem(R.id.menu_search_messages);
    this.a.a(this.j, this.h, this.i);
    this.a.b(false);
  }

  private Toolbar e()
  {
    return (Toolbar)this.c.findViewById(R.id.toolbar);
  }

  public void a()
  {
    if (this.g == null);
    Toolbar localToolbar;
    do
    {
      return;
      localToolbar = e();
    }
    while (localToolbar == null);
    localToolbar.showOverflowMenu();
    ((SearchMessagesOptionMenuPresenter)this.mPresenter).e();
  }

  public void a(int paramInt, aa paramaa)
  {
    if (this.h)
      this.a.g();
  }

  public void a(aa paramaa, int paramInt)
  {
    if (this.h)
      this.a.g();
  }

  public void a(at paramat)
  {
    this.m = paramat;
  }

  public void a(String paramString)
  {
    this.h = true;
    this.i = paramString;
    this.a.d();
    this.a.b(false);
    this.a.a(paramString);
  }

  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((this.g == null) || (this.q == null) || (this.r == null) || (this.k == null));
    do
    {
      return;
      if (!paramBoolean1)
        break;
      dj.a(this.k, true);
      dj.c(this.q, true);
      dj.c(this.r, true);
      this.q.setEnabled(paramBoolean4);
      this.r.setEnabled(paramBoolean3);
      if (this.n != null)
      {
        this.n.setEnabled(paramBoolean2);
        this.n.setText(paramString1);
      }
      if (this.o != null)
        this.o.setText(paramString3);
    }
    while (this.p == null);
    this.p.setText(paramString2);
    return;
    dj.a(this.k, false);
    dj.c(this.q, false);
    dj.c(this.r, false);
  }

  public void a(boolean paramBoolean)
  {
    MenuItem localMenuItem = this.j;
    if ((paramBoolean) && (!this.l.I()));
    for (boolean bool = true; ; bool = false)
    {
      dj.a(localMenuItem, bool);
      return;
    }
  }

  public void b()
  {
    if (this.j != null)
      this.j.setTitle(SpannableStringBuilder.valueOf(this.c.getString(R.string.menu_search)).append(" ").append(dg.a(this.c)));
  }

  public void c()
  {
    MenuSearchMediator.ViberSearchView localViberSearchView = (MenuSearchMediator.ViberSearchView)this.a.c();
    ImageView localImageView = (ImageView)localViberSearchView.findViewById(R.id.search_close_btn);
    localImageView.setEnabled(false);
    localImageView.setImageDrawable(null);
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(localViberSearchView.getContext()).inflate(R.layout.messages_search_layout, null, false);
    this.n = ((TextView)localLinearLayout.findViewById(R.id.text_current_page));
    this.o = ((TextView)localLinearLayout.findViewById(R.id.text_separator));
    this.p = ((TextView)localLinearLayout.findViewById(R.id.text_app_pages));
    this.q = ((ImageView)localLinearLayout.findViewById(R.id.image_search_down));
    this.r = ((ImageView)localLinearLayout.findViewById(R.id.image_search_up));
    if (this.k != null)
      this.k.setActionView(localLinearLayout);
    if (this.m != null)
    {
      if (this.n != null)
        this.n.setTextColor(this.m.p());
      if (this.o != null)
        this.o.setTextColor(this.m.p());
      if (this.p != null)
        this.p.setTextColor(this.m.p());
      if (this.q != null)
      {
        ImageViewCompat.setImageTintList(this.q, this.m.p());
        this.q.setOnClickListener(this);
      }
      if (this.r != null)
      {
        ImageViewCompat.setImageTintList(this.r, this.m.p());
        this.r.setOnClickListener(this);
      }
      dj.b(localViberSearchView, this.m.n());
      dj.a(e(), this.m.m());
      ((EditText)localViberSearchView.findViewById(R.id.search_src_text)).setTextColor(this.m.q());
    }
  }

  public void d()
  {
    ViberApplication.getInstance().showToast(R.string.noMessagesFound);
  }

  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == R.id.image_search_up)
      ((SearchMessagesOptionMenuPresenter)this.mPresenter).b();
    while (i1 != R.id.image_search_down)
      return;
    ((SearchMessagesOptionMenuPresenter)this.mPresenter).c();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    this.k = paramMenu.add(0, R.id.search_text, 12, "");
    this.k.setShowAsActionFlags(2);
    this.k.setVisible(false);
    a(paramMenuInflater, paramMenu);
    this.g = paramMenu;
    ((SearchMessagesOptionMenuPresenter)this.mPresenter).d();
    return false;
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    if (paramBoolean)
      ((SearchMessagesOptionMenuPresenter)this.mPresenter).d();
    while (!this.h)
      return;
    this.a.g();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.b.t
 * JD-Core Version:    0.6.2
 */