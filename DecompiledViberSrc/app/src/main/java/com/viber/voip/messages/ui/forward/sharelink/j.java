package com.viber.voip.messages.ui.forward.sharelink;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.messages.conversation.ai;
import com.viber.voip.mvp.core.d;
import com.viber.voip.ui.ViberEditText;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.util.ViberActionRunner.af;
import com.viber.voip.util.dj;
import com.viber.voip.util.dw;
import com.viber.voip.util.e.e;

public class j extends d<ShareLinkPresenter>
  implements View.OnClickListener, f, h
{
  private RecyclerView a;
  private ViberTextView b;
  private ViberEditText c;
  private ViberTextView d;
  private a e;
  private String f;
  private Activity g;
  private MenuItem h;

  public j(ShareLinkPresenter paramShareLinkPresenter, View paramView, Activity paramActivity, boolean paramBoolean)
  {
    super(paramShareLinkPresenter, paramView);
    this.g = paramActivity;
    c();
    b(paramBoolean);
  }

  private void b(boolean paramBoolean)
  {
    Bundle localBundle = this.g.getIntent().getExtras();
    if (localBundle != null)
    {
      this.f = localBundle.getString("share_text");
      this.b.setText(localBundle.getString("invite_link"));
    }
    this.a.setLayoutManager(new LinearLayoutManager(this.g));
    dj.a(this.b);
    this.c.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (paramAnonymousEditable != null)
          ((ShareLinkPresenter)j.a(j.this)).b(paramAnonymousEditable.toString());
      }

      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }
    });
    if (paramBoolean)
      d();
  }

  private void c()
  {
    this.a = ((RecyclerView)this.mRootView.findViewById(R.id.items_list));
    this.b = ((ViberTextView)this.mRootView.findViewById(R.id.share_link));
    this.c = ((ViberEditText)this.mRootView.findViewById(R.id.search_field));
    this.d = ((ViberTextView)this.mRootView.findViewById(R.id.counter));
    this.b.setOnClickListener(this);
  }

  private void d()
  {
    if (ViberApplication.isTablet(this.g))
      dj.a(this.g, 0.65F, 0.75F, 0.65F, 0.75F, true);
  }

  public void a()
  {
    this.g.setResult(100);
    this.g.finish();
  }

  public void a(int paramInt)
  {
    RegularConversationLoaderEntity localRegularConversationLoaderEntity = this.e.a(paramInt);
    ((ShareLinkPresenter)this.mPresenter).a(localRegularConversationLoaderEntity);
  }

  @SuppressLint({"StringFormatMatches"})
  public void a(int paramInt1, int paramInt2)
  {
    ViberTextView localViberTextView = this.d;
    Activity localActivity = this.g;
    int i = R.string.participants_count;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    localViberTextView.setText(localActivity.getString(i, arrayOfObject));
  }

  public void a(ai paramai, e parame, com.viber.voip.util.e.f paramf, ShareLinkState paramShareLinkState)
  {
    this.e = new a(parame, paramai, this.g.getLayoutInflater(), paramf, this.g, (ShareLinkPresenter)this.mPresenter);
    this.e.a(this);
    this.a.setAdapter(this.e);
  }

  public void a(String paramString)
  {
    Intent localIntent1 = ViberActionRunner.af.b(this.g, paramString);
    Intent localIntent2 = dw.a(this.g, localIntent1, this.g.getString(R.string.share_group_link), "share_type_invite_community");
    this.g.startActivity(localIntent2);
  }

  public void a(boolean paramBoolean)
  {
    dj.a(this.h, paramBoolean);
  }

  public void b()
  {
    this.e.notifyDataSetChanged();
  }

  public void onClick(View paramView)
  {
    if (paramView == this.b)
      ((ShareLinkPresenter)this.mPresenter).a(this.f);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    d();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_participant_selector, paramMenu);
    this.h = paramMenu.findItem(R.id.menu_done);
    ((ShareLinkPresenter)this.mPresenter).c();
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem == this.h)
    {
      ((ShareLinkPresenter)this.mPresenter).b();
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.forward.sharelink.j
 * JD-Core Version:    0.6.2
 */