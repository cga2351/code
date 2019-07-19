package com.viber.voip.messages.conversation.ui.vote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.ui.vote.a.d;
import com.viber.voip.messages.k;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.util.u;
import com.viber.voip.util.u.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public class VotePresenter extends BaseMvpPresenter<g, LocalState>
  implements com.viber.voip.messages.conversation.ui.vote.a.c, d, b.a
{
  private static final Logger a = ViberEnv.getLogger("VotePresenter");
  private final u.b<Vote, String> b = p.a;
  private final k c;
  private final com.viber.voip.analytics.story.e.c d;
  private boolean e = false;
  private Bundle f;
  private LocalState g = new LocalState();
  private a h;

  @Inject
  VotePresenter(k paramk, com.viber.voip.analytics.story.e.c paramc)
  {
    this.c = paramk;
    this.d = paramc;
  }

  private boolean g()
  {
    return (this.g.mVoteOption != null) && (this.g.mVoteOption.size() < 10);
  }

  private void h()
  {
    boolean bool1 = true;
    boolean bool2;
    int i;
    if (!TextUtils.isEmpty(this.g.mTitle))
    {
      bool2 = bool1;
      Iterator localIterator = this.g.mVoteOption.iterator();
      i = 0;
      label33: if (!localIterator.hasNext())
        break label78;
      if (TextUtils.isEmpty(((Vote)localIterator.next()).getOption()))
        break label111;
    }
    label78: label111: for (int j = i + 1; ; j = i)
    {
      i = j;
      break label33;
      bool2 = false;
      break;
      g localg = (g)this.mView;
      if ((bool2) && (i >= 2));
      while (true)
      {
        localg.d(bool1);
        return;
        bool1 = false;
      }
    }
  }

  void a()
  {
    List localList = u.a(u.a(this.g.mVoteOption, this.b), q.a);
    if (this.h == null);
    while ((TextUtils.isEmpty(this.g.mTitle)) || (u.a(localList)))
      return;
    this.c.c().a(a.a(this.h), a.b(this.h), a.c(this.h), a.d(this.h), a.e(this.h), this.g.mTitle, (String[])localList.toArray(new String[0]), false, this.f);
    this.d.d();
    ((g)this.mView).b(true);
    ((g)this.mView).c(true);
  }

  void a(Bundle paramBundle)
  {
    this.f = paramBundle;
  }

  public void a(Vote paramVote)
  {
    List localList = this.g.mVoteOption;
    int i = localList.indexOf(paramVote);
    if (i != -1)
      ((Vote)localList.get(i)).setOption(paramVote.getOption());
    ((g)this.mView).a(this.g.mVoteOption, g());
    h();
  }

  protected void a(LocalState paramLocalState)
  {
    super.onViewAttached(paramLocalState);
    if (paramLocalState != null)
      this.g = paramLocalState;
    while (true)
    {
      ((g)this.mView).a(this.g.mTitle, this.g.mVoteOption, g());
      h();
      g localg = (g)this.mView;
      boolean bool = false;
      if (paramLocalState == null)
        bool = true;
      localg.a(bool);
      return;
      ArrayList localArrayList = new ArrayList(2);
      LocalState.access$002(this.g, 0);
      while (this.g.mIdCounter < 2)
      {
        localArrayList.add(new Vote(this.g.mIdCounter));
        LocalState.access$004(this.g);
      }
      this.g.mVoteOption = localArrayList;
    }
  }

  void a(a parama)
  {
    this.h = parama;
  }

  public void a(String paramString)
  {
    this.g.mTitle = paramString;
    h();
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    ((g)this.mView);
    int i = paramInt1 - 1;
    ((g)this.mView);
    int j = paramInt2 - 1;
    if ((j >= 0) && (i >= 0) && (j < this.g.mVoteOption.size()))
    {
      Collections.swap(this.g.mVoteOption, i, j);
      ((g)this.mView).a(this.g.mVoteOption, g());
      return true;
    }
    return false;
  }

  void b()
  {
    if (!this.e)
    {
      this.e = true;
      ((g)this.mView).c(true);
    }
  }

  public void b(Vote paramVote)
  {
    List localList = this.g.mVoteOption;
    if (localList.size() > 2)
    {
      localList.remove(paramVote);
      ((g)this.mView).a(localList, g());
      h();
      return;
    }
    paramVote.setOption("");
    a(paramVote);
  }

  protected LocalState c()
  {
    return this.g;
  }

  public boolean c(Vote paramVote)
  {
    List localList = this.g.mVoteOption;
    return (!localList.isEmpty()) && (((Vote)localList.get(-1 + localList.size())).equals(paramVote));
  }

  public void d()
  {
    List localList = this.g.mVoteOption;
    if (localList.size() < 10)
    {
      Vote localVote = new Vote(this.g.mIdCounter, "");
      if (!localList.contains(localVote))
      {
        localList.add(localVote);
        ((g)this.mView).a(localList, g());
        h();
        LocalState.access$008(this.g);
        e();
      }
    }
  }

  public boolean d(Vote paramVote)
  {
    List localList = this.g.mVoteOption;
    return (localList.size() > 1) && (((Vote)localList.get(-2 + localList.size())).equals(paramVote));
  }

  public void e()
  {
    int i = -1 + this.g.mVoteOption.size();
    ((g)this.mView);
    int j = i + 1;
    if (g());
    for (int k = 1; ; k = 0)
    {
      int m = j + k;
      ((g)this.mView).a(m, j);
      return;
    }
  }

  public boolean f()
  {
    return this.g.mVoteOption.size() < 10;
  }

  static class LocalState extends State
  {
    public static final Parcelable.Creator<LocalState> CREATOR = new Parcelable.Creator()
    {
      public VotePresenter.LocalState a(Parcel paramAnonymousParcel)
      {
        return new VotePresenter.LocalState(paramAnonymousParcel, null);
      }

      public VotePresenter.LocalState[] a(int paramAnonymousInt)
      {
        return new VotePresenter.LocalState[paramAnonymousInt];
      }
    };
    private int mIdCounter = 0;
    String mTitle;
    List<Vote> mVoteOption;

    LocalState()
    {
      this.mVoteOption = new ArrayList();
    }

    private LocalState(Parcel paramParcel)
    {
      this.mIdCounter = paramParcel.readInt();
      this.mTitle = paramParcel.readString();
      this.mVoteOption = new ArrayList();
      paramParcel.readList(this.mVoteOption, getClass().getClassLoader());
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mIdCounter);
      paramParcel.writeString(this.mTitle);
      paramParcel.writeList(this.mVoteOption);
    }
  }

  static class a
  {
    private final long a;
    private final long b;
    private final int c;
    private final int d;
    private final String e;

    public a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString)
    {
      this.a = paramLong1;
      this.b = paramLong2;
      this.c = paramInt1;
      this.d = paramInt2;
      this.e = paramString;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.vote.VotePresenter
 * JD-Core Version:    0.6.2
 */