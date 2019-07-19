package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.util.LongSparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.plurals;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Poll;
import com.viber.voip.flatbuffers.model.msginfo.PollUiOptions;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.d.w;
import com.viber.voip.messages.conversation.adapter.e.h;
import com.viber.voip.messages.conversation.adapter.e.h.b;
import com.viber.voip.messages.conversation.adapter.e.l;
import com.viber.voip.messages.conversation.adapter.t;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.f;
import com.viber.voip.messages.conversation.adapter.x;
import com.viber.voip.messages.conversation.adapter.z;
import com.viber.voip.messages.ui.view.AnimatedLikesView;
import com.viber.voip.messages.ui.view.AnimatedLikesView.a;
import com.viber.voip.messages.ui.view.AnimatedLikesView.b;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.ViberActionRunner.bn;
import com.viber.voip.util.da;
import com.viber.voip.util.dc;
import com.viber.voip.util.dg;

public class bm extends e<a, i>
  implements Runnable
{
  private static final Logger a = ViberEnv.getLogger();
  private final LinearLayout b;
  private final TextView c;
  private final TextView d;
  private final z<t> e;
  private final w f;
  private aa g;

  public bm(LinearLayout paramLinearLayout, TextView paramTextView1, TextView paramTextView2, z<t> paramz, w paramw, f paramf)
  {
    this.b = paramLinearLayout;
    this.c = paramTextView1;
    this.d = paramTextView2;
    this.e = paramz;
    this.f = paramw;
    this.c.setMovementMethod(new l(this.c, paramf));
  }

  private void a(PollUiOptions[] paramArrayOfPollUiOptions, int paramInt1, int paramInt2, i parami)
  {
    int i = paramArrayOfPollUiOptions.length;
    int j = 0;
    if (j < i)
    {
      PollUiOptions localPollUiOptions = paramArrayOfPollUiOptions[j];
      View localView1 = this.e.a(t.a);
      a locala;
      View localView2;
      if (localView1 == null)
      {
        View localView3 = LayoutInflater.from(this.b.getContext()).inflate(R.layout.vote_option_item, this.b, false);
        locala = new a(localView3);
        localView3.setTag(locala);
        localView2 = localView3;
      }
      while (true)
      {
        locala.a(localPollUiOptions, this.g.ao(), paramInt1, paramInt2, parami);
        this.b.addView(localView2);
        j++;
        break;
        if ((localView1.getTag() instanceof a))
        {
          locala = (a)localView1.getTag();
          localView2 = localView1;
        }
        else
        {
          locala = new a(localView1);
          localView1.setTag(locala);
          localView2 = localView1;
        }
      }
    }
  }

  public void a()
  {
    super.a();
    int i = this.b.getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = this.b.getChildAt(j);
      a locala = (a)localView.getTag();
      if (locala != null)
        locala.a();
      this.e.a(t.a, localView);
    }
    this.b.removeAllViews();
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    this.g = parama.c();
    this.c.setText(this.g.a(parami.V(), parami.U(), parami.W().a(this.g), parami.k(), parami.h()));
    if ((parami.c(this.g.y())) && (!da.a(parami.f())))
      dg.b(this.c, parami.f(), this.c.getText().length());
    PollUiOptions[] arrayOfPollUiOptions = this.g.bx().getPoll().getOptions();
    int i = arrayOfPollUiOptions.length;
    int j = 0;
    int k = 0;
    int m = 0;
    while (j < i)
    {
      PollUiOptions localPollUiOptions = arrayOfPollUiOptions[j];
      m += localPollUiOptions.getLikesCount();
      k = Math.max(k, localPollUiOptions.getLikesCount());
      j++;
    }
    a(arrayOfPollUiOptions, m, k, parami);
    TextView localTextView = this.d;
    Resources localResources = parami.az().getResources();
    int n = R.plurals.votes_total;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(m);
    localTextView.setText(localResources.getQuantityString(n, m, arrayOfObject));
  }

  public void run()
  {
    if (this.g != null)
      ViberActionRunner.bn.a(this.b.getContext(), this.g, 0, 2);
  }

  class a
    implements View.OnClickListener, h.b<Integer>
  {
    private final View b;
    private final TextView c;
    private final AnimatedLikesView d;
    private final TextView e;
    private final ProgressBar f;
    private PollUiOptions g;
    private h<Integer> h;

    a(View arg2)
    {
      Object localObject;
      this.b = localObject;
      this.c = ((TextView)localObject.findViewById(R.id.option_text));
      this.d = ((AnimatedLikesView)localObject.findViewById(R.id.like_view));
      this.d.setOnClickListener(this);
      this.b.setOnClickListener(this);
      this.d.setStrokeColor(dc.d(this.b.getContext(), R.attr.conversationVoteLikeStrokeColor));
      this.d.a(true);
      this.d.setCounterTextColor(dc.d(this.b.getContext(), R.attr.conversationVoteOptionColor));
      this.e = ((TextView)localObject.findViewById(R.id.percentage_text));
      this.f = ((ProgressBar)localObject.findViewById(R.id.progress));
    }

    private void a(int paramInt1, int paramInt2, i parami)
    {
      if (this.g == null)
        return;
      Integer localInteger = (Integer)parami.aA().get(this.g.getToken());
      int i = (int)(100.0F * (this.g.getLikesCount() / paramInt2));
      parami.aA().put(this.g.getToken(), Integer.valueOf(i));
      b();
      this.h = parami.d(this.g.getToken());
      if ((localInteger != null) && (localInteger.intValue() != i))
      {
        if (this.h != null)
          parami.e(this.g.getToken());
        long l = this.g.getToken();
        Integer[] arrayOfInteger = new Integer[2];
        arrayOfInteger[0] = localInteger;
        arrayOfInteger[1] = Integer.valueOf(i);
        this.h = parami.a(l, arrayOfInteger);
        this.h.a(this);
        this.h.start();
        return;
      }
      if ((this.h != null) && (!this.h.a()))
      {
        this.h.a(this);
        return;
      }
      this.f.setProgress(i);
    }

    private void a(PollUiOptions paramPollUiOptions)
    {
      if (paramPollUiOptions.isLiked())
      {
        this.d.a(AnimatedLikesView.a.f);
        return;
      }
      this.d.a(AnimatedLikesView.a.e);
    }

    private void b()
    {
      if (this.h == null)
        return;
      this.h.a(null);
      this.h = null;
    }

    void a()
    {
      b();
    }

    void a(PollUiOptions paramPollUiOptions, boolean paramBoolean, int paramInt1, int paramInt2, i parami)
    {
      int i;
      int j;
      label54: String str;
      label102: AnimatedLikesView localAnimatedLikesView;
      if ((this.g != null) && (this.g.getToken() != paramPollUiOptions.getToken()))
      {
        i = 1;
        this.g = paramPollUiOptions;
        View localView = this.b;
        Context localContext1 = this.b.getContext();
        if (!paramBoolean)
          break label226;
        j = R.attr.conversationVoteOptionIncomingBackground;
        localView.setBackground(dc.g(localContext1, j));
        this.c.setText(this.g.getName());
        if (this.g.getLikesCountForUi() <= 0)
          break label234;
        str = da.b(this.g.getLikesCountForUi());
        localAnimatedLikesView = this.d;
        if (!this.g.isLiked())
          break label241;
      }
      label226: label234: label241: for (AnimatedLikesView.b localb = AnimatedLikesView.b.b; ; localb = AnimatedLikesView.b.a)
      {
        localAnimatedLikesView.a(str, localb);
        if (i != 0)
          this.d.a();
        int k = (int)(100.0F * (this.g.getLikesCount() / paramInt1));
        TextView localTextView = this.e;
        Context localContext2 = this.e.getContext();
        int m = R.string.restore_percents_format;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(k);
        localTextView.setText(localContext2.getString(m, arrayOfObject));
        a(paramInt1, paramInt2, parami);
        return;
        i = 0;
        break;
        j = R.attr.conversationVoteOptionOutgoingBackground;
        break label54;
        str = "";
        break label102;
      }
    }

    public void a(Integer paramInteger)
    {
      if (paramInteger.intValue() != this.f.getProgress())
        this.f.setProgress(paramInteger.intValue());
    }

    public void onClick(View paramView)
    {
      if (this.g == null)
        return;
      if (paramView == this.d)
      {
        a(this.g);
        w localw = bm.b(bm.this);
        if (!this.g.isLiked());
        for (boolean bool = true; ; bool = false)
        {
          localw.a(bool, this.g.getToken(), bm.a(bm.this));
          return;
        }
      }
      bm.b(bm.this).a(this.g.getToken());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.bm
 * JD-Core Version:    0.6.2
 */