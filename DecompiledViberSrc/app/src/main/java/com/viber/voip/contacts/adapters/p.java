package com.viber.voip.contacts.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.viber.common.ui.b.b;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.contacts.ui.ParticipantSelector;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.util.da;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.widget.AvatarWithInitialsView;
import java.util.ArrayList;
import java.util.Set;

public class p extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final Context a;
  private final ParticipantSelector b;
  private final e c;
  private final f d;
  private final ArrayList<ParticipantSelector.Participant> e = new ArrayList();
  private final int f;
  private final int g;
  private final View.OnClickListener h;
  private boolean i = true;

  public p(Context paramContext, ParticipantSelector paramParticipantSelector, View.OnClickListener paramOnClickListener)
  {
    this.a = paramContext;
    this.b = paramParticipantSelector;
    this.c = e.a(paramContext);
    this.d = f.b(paramContext);
    Resources localResources = paramContext.getResources();
    this.f = localResources.getDimensionPixelSize(R.dimen.compose_list_left_right_padding);
    this.g = localResources.getDimensionPixelOffset(R.dimen.compose_participant_avatar_height);
    this.h = paramOnClickListener;
  }

  public static int b(int paramInt)
  {
    return paramInt - 1;
  }

  public static int c(int paramInt)
  {
    return paramInt + 1;
  }

  private boolean e(int paramInt)
  {
    return (f(paramInt)) || (g(paramInt));
  }

  private boolean f(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < 1);
  }

  private boolean g(int paramInt)
  {
    int j = getItemCount();
    return (paramInt >= j - 1) && (paramInt < j);
  }

  public ParticipantSelector.Participant a(int paramInt)
  {
    ParticipantSelector.Participant localParticipant = null;
    if (paramInt >= 0)
    {
      int j = this.e.size();
      localParticipant = null;
      if (paramInt < j)
      {
        localParticipant = (ParticipantSelector.Participant)this.e.remove(paramInt);
        if (this.i)
        {
          if (this.e.size() <= 0)
            break label60;
          notifyItemRemoved(c(paramInt));
        }
      }
    }
    return localParticipant;
    label60: notifyDataSetChanged();
    return localParticipant;
  }

  public void a()
  {
    this.e.clear();
    if (this.i)
      notifyDataSetChanged();
  }

  public void a(ParticipantSelector.Participant paramParticipant)
  {
    if (!this.e.contains(paramParticipant))
    {
      this.e.add(paramParticipant);
      if (this.i)
      {
        if (this.e.size() > 1)
          notifyItemInserted(this.e.size());
      }
      else
        return;
      notifyDataSetChanged();
      return;
    }
    b(paramParticipant);
  }

  public void a(Set<ParticipantSelector.Participant> paramSet)
  {
    if (paramSet != null)
      this.e.addAll(paramSet);
  }

  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public int b()
  {
    return this.e.size();
  }

  public void b(ParticipantSelector.Participant paramParticipant)
  {
    int j = this.e.indexOf(paramParticipant);
    this.e.remove(j);
    this.e.add(j, paramParticipant);
    if (this.i)
      notifyItemChanged(c(j));
  }

  public void c(ParticipantSelector.Participant paramParticipant)
  {
    a(this.e.indexOf(paramParticipant));
  }

  public ParticipantSelector.Participant d(int paramInt)
  {
    return (ParticipantSelector.Participant)this.e.get(paramInt);
  }

  public int getItemCount()
  {
    int j = this.e.size();
    if (j > 0);
    for (int k = 2; ; k = 0)
      return k + j;
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    if (e(paramInt))
      return 0;
    return 1;
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    default:
      return;
    case 1:
    }
    a locala = (a)paramViewHolder;
    AvatarWithInitialsView localAvatarWithInitialsView = (AvatarWithInitialsView)locala.itemView;
    ParticipantSelector.Participant localParticipant = d(b(paramInt));
    locala.a(this.b.i().contains(localParticipant));
    if (!da.a(localParticipant.getDisplayName()))
      localAvatarWithInitialsView.a(localParticipant.getInitialDisplayName(), true);
    while (true)
    {
      this.c.a(localParticipant.getPhotoUri(), localAvatarWithInitialsView, this.d);
      return;
      localAvatarWithInitialsView.a(null, false);
    }
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default:
      View localView = new View(paramViewGroup.getContext());
      localView.setLayoutParams(new RecyclerView.LayoutParams(this.f, this.g));
      return new b(localView);
    case 1:
    }
    AvatarWithInitialsView localAvatarWithInitialsView = new AvatarWithInitialsView(this.a);
    localAvatarWithInitialsView.setShape(b.b.e);
    localAvatarWithInitialsView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localAvatarWithInitialsView.setLayoutParams(new RecyclerView.LayoutParams(this.g, this.g));
    localAvatarWithInitialsView.setSelector(ContextCompat.getDrawable(this.a, R.drawable.big_avatar_pressed_selector));
    localAvatarWithInitialsView.setOnClickListener(this.h);
    return new a(localAvatarWithInitialsView);
  }

  public static class a extends RecyclerView.ViewHolder
  {
    private boolean a;

    public a(AvatarWithInitialsView paramAvatarWithInitialsView)
    {
      super();
    }

    public void a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }

    public boolean a()
    {
      return this.a;
    }
  }

  public static class b extends RecyclerView.ViewHolder
  {
    public b(View paramView)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.adapters.p
 * JD-Core Version:    0.6.2
 */