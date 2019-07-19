package com.viber.voip.messages.conversation.ui.vote;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.recyclerview.a.a;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import com.viber.voip.R.anim;
import com.viber.voip.R.id;
import com.viber.voip.av.f;
import com.viber.voip.util.dj;
import java.util.List;

class h extends com.viber.voip.mvp.core.d<VotePresenter>
  implements g
{
  private final View a;
  private final View b;
  private final Animation c;
  private final Animation d;
  private final Handler e;
  private final ItemTouchHelper f;
  private s g;
  private final a<s.b> h = new android.support.v7.recyclerview.a.a.a(new f()).a(av.f.b).a();
  private final d.a i;
  private final RecyclerView j;

  h(VotePresenter paramVotePresenter, View paramView, d.a parama)
  {
    super(paramVotePresenter, paramView);
    Context localContext = paramView.getContext();
    this.e = new Handler();
    this.i = parama;
    View localView = paramView.findViewById(R.id.collapse_panel_button);
    d(localView);
    localView.setOnClickListener(new i(this));
    paramView.findViewById(R.id.top_panel_space_view).setOnClickListener(new j(this));
    this.b = paramView.findViewById(R.id.create_vote_btn);
    this.b.setOnClickListener(new k(this));
    this.j = ((RecyclerView)paramView.findViewById(R.id.vote_options));
    this.f = new ItemTouchHelper(new b((b.a)this.mPresenter));
    this.f.attachToRecyclerView(this.j);
    this.j.setHasFixedSize(false);
    this.a = paramView.findViewById(R.id.panel_body_view);
    dj.c(this.a, false);
    this.c = AnimationUtils.loadAnimation(localContext, R.anim.long_bottom_slide_in);
    this.c.setInterpolator(com.viber.voip.ui.b.c.c);
    this.c.setAnimationListener(new com.viber.voip.ui.b.a.a()
    {
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        dj.c(h.a(h.this), true);
      }
    });
    this.d = AnimationUtils.loadAnimation(localContext, R.anim.long_bottom_slide_out);
    this.d.setInterpolator(com.viber.voip.ui.b.c.d);
    this.d.setAnimationListener(new com.viber.voip.ui.b.a.a()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        h.b(h.this);
      }
    });
  }

  private void c()
  {
    dj.b(this.a, false);
    this.i.a();
  }

  private void d(View paramView)
  {
    if (!com.viber.common.d.c.a());
    ViewGroup.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = paramView.getLayoutParams();
    }
    while (!(localLayoutParams instanceof FrameLayout.LayoutParams));
    ((FrameLayout.LayoutParams)localLayoutParams).gravity = 8388627;
  }

  public void a(int paramInt)
  {
    View localView = this.j.getLayoutManager().findViewByPosition(paramInt);
    if (localView != null)
    {
      RecyclerView.ViewHolder localViewHolder = this.j.getChildViewHolder(localView);
      if ((localViewHolder instanceof com.viber.voip.messages.conversation.ui.vote.a.b))
        ((com.viber.voip.messages.conversation.ui.vote.a.b)localViewHolder).a();
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    if (this.g == null)
      return;
    this.e.postDelayed(new n(this, paramInt1, paramInt2), 100L);
  }

  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.f.startDrag(paramViewHolder);
  }

  public void a(String paramString, List<Vote> paramList, boolean paramBoolean)
  {
    this.g = new s(this.j.getContext(), this, (com.viber.voip.messages.conversation.ui.vote.a.d)this.mPresenter, (com.viber.voip.messages.conversation.ui.vote.a.c)this.mPresenter, this.h, 1, paramString);
    this.j.setAdapter(this.g);
    this.g.a(paramList, paramBoolean);
  }

  public void a(List<Vote> paramList, boolean paramBoolean)
  {
    if (this.g != null)
      this.g.a(paramList, paramBoolean);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int k = this.mRootView.getContext().getResources().getInteger(17694720);
      this.e.postDelayed(new l(this), k);
      return;
    }
    dj.b(this.a, true);
  }

  public void b(boolean paramBoolean)
  {
    this.i.a(paramBoolean);
  }

  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.e.post(new m(this));
      return;
    }
    c();
  }

  public void d(boolean paramBoolean)
  {
    this.b.setEnabled(paramBoolean);
  }

  public boolean onBackPressed()
  {
    ((VotePresenter)this.mPresenter).b();
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.vote.h
 * JD-Core Version:    0.6.2
 */