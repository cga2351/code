package com.viber.voip.calls.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.i.c.g;
import com.viber.voip.model.Call;
import com.viber.voip.util.ViberActionRunner.o;
import com.viber.voip.util.dj;
import java.util.List;

public class e extends com.viber.voip.contacts.ui.list.c<GroupCallDetailsPresenter>
  implements View.OnClickListener, d
{
  private Handler b;
  private com.viber.voip.util.e.e c;
  private LayoutInflater d;
  private RecyclerView e;
  private View f;
  private com.viber.voip.ui.h.g g;
  private b h;
  private i i;
  private final com.viber.voip.app.b j;

  protected e(GroupCallDetailsPresenter paramGroupCallDetailsPresenter, View paramView, Fragment paramFragment, Handler paramHandler, com.viber.voip.util.e.e parame, com.viber.common.permission.c paramc, com.viber.voip.app.b paramb)
  {
    super(paramGroupCallDetailsPresenter, paramView, paramFragment, paramc, 146);
    this.j = paramb;
    this.b = paramHandler;
    this.c = parame;
    this.d = paramFragment.getLayoutInflater();
    this.f = paramView.findViewById(R.id.start_group_call_btn);
    this.f.setOnClickListener(this);
    a(false);
    this.e = ((RecyclerView)paramView.findViewById(R.id.recycler_view));
    b();
  }

  private void b()
  {
    this.g = new com.viber.voip.ui.h.g(this.d);
    Context localContext = this.mRootView.getContext();
    int k = localContext.getResources().getDimensionPixelSize(R.dimen.chat_info_left_padding);
    this.g.a(new a(localContext, k, k));
    this.g.a(new l());
    com.viber.voip.util.e.f localf = com.viber.voip.util.e.f.b(localContext);
    com.viber.voip.ui.h.g localg = this.g;
    com.viber.voip.util.e.e locale = this.c;
    GroupCallDetailsPresenter localGroupCallDetailsPresenter = (GroupCallDetailsPresenter)this.mPresenter;
    localGroupCallDetailsPresenter.getClass();
    localg.a(new h(locale, localf, f.a(localGroupCallDetailsPresenter)));
    this.h = new b();
    this.g.a(this.h);
    this.i = new i(new k(localContext.getString(R.string.participants)));
    this.g.a(this.i);
    this.e.setAdapter(this.g);
  }

  public void a(Bundle paramBundle)
  {
    long l = paramBundle.getLong("aggregated_hash", 0L);
    ConferenceInfo localConferenceInfo = (ConferenceInfo)paramBundle.getParcelable("conference_info");
    String str = paramBundle.getString("analytics_entry_point", "");
    ((GroupCallDetailsPresenter)this.mPresenter).a(str);
    if ((l != 0L) && (localConferenceInfo != null))
      ((GroupCallDetailsPresenter)this.mPresenter).a(l, localConferenceInfo);
  }

  public void a(ConferenceParticipant paramConferenceParticipant)
  {
    ViberActionRunner.o.a(this.a.getContext(), paramConferenceParticipant.getMemberId(), paramConferenceParticipant.getName(), paramConferenceParticipant.getImage());
  }

  public void a(String paramString)
  {
    ((AppCompatActivity)this.a.getActivity()).getSupportActionBar().a(paramString);
  }

  public void a(List<ConferenceParticipant> paramList, List<Call> paramList1)
  {
    this.b.post(new g(this, paramList, paramList1));
  }

  public void a(boolean paramBoolean)
  {
    View localView = this.f;
    if ((paramBoolean) && (c.g.a.e()));
    for (boolean bool = true; ; bool = false)
    {
      dj.b(localView, bool);
      return;
    }
  }

  public void close()
  {
    if (!this.j.a(this.mRootView.getContext()))
      super.close();
  }

  public void closeOnSuccess()
  {
    if (!this.j.a(this.mRootView.getContext()))
      super.closeOnSuccess();
  }

  public void onClick(View paramView)
  {
    if (R.id.start_group_call_btn == paramView.getId())
      a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.e
 * JD-Core Version:    0.6.2
 */