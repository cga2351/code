package com.viber.voip.secondary;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.messages.i;
import com.viber.voip.util.dj;
import java.util.Iterator;
import java.util.List;

public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final List<SecondaryDevice> a;
  private final Context b;
  private final Resources c;
  private final LayoutInflater d;
  private final i e;
  private final com.viber.voip.ui.a.a f;
  private final SparseBooleanArray g;

  public a(Context paramContext, List<SecondaryDevice> paramList, com.viber.voip.ui.a.a parama, LayoutInflater paramLayoutInflater)
  {
    this.a = paramList;
    this.g = new SparseBooleanArray(paramList.size());
    this.d = paramLayoutInflater;
    this.c = paramContext.getResources();
    this.b = paramContext;
    this.e = new i();
    this.f = parama;
  }

  public int a(int paramInt)
  {
    if (paramInt > 0)
      return paramInt - 1;
    return -1;
  }

  public int a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    for (int i = 0; localIterator.hasNext(); i++)
      if (paramString.equals(((SecondaryDevice)localIterator.next()).getUdid()))
        return i + 1;
    return -1;
  }

  public void a(boolean paramBoolean, int paramInt, RecyclerView.ViewHolder paramViewHolder)
  {
    int i = a(paramInt);
    if (i == -1);
    do
    {
      return;
      this.g.put(i, paramBoolean);
      if ((paramViewHolder instanceof a))
      {
        if (paramBoolean)
        {
          ((a)paramViewHolder).a();
          return;
        }
        ((a)paramViewHolder).b();
        return;
      }
    }
    while (paramViewHolder != null);
    notifyItemChanged(paramInt);
  }

  public boolean a()
  {
    return this.a.isEmpty();
  }

  public SecondaryDevice b(int paramInt)
  {
    if (paramInt > 0)
      return (SecondaryDevice)this.a.get(a(paramInt));
    return null;
  }

  public boolean c(int paramInt)
  {
    int i = a(paramInt);
    return (i != -1) && (this.g.get(i));
  }

  public void d(int paramInt)
  {
    int i = a(paramInt);
    if (i != -1)
    {
      this.a.remove(i);
      this.g.delete(i);
      notifyItemRemoved(paramInt);
    }
  }

  public int getItemCount()
  {
    return 1 + this.a.size();
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt > 0)
      return 1;
    return 0;
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder.getItemViewType() != 1)
      return;
    a locala = (a)paramViewHolder;
    SecondaryDevice localSecondaryDevice = b(paramInt);
    TextView localTextView1 = locala.b;
    Resources localResources1 = this.c;
    int i = R.string.manage_secondaries_device;
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = localSecondaryDevice.getSystemName();
    arrayOfObject1[1] = localSecondaryDevice.getPlatform();
    arrayOfObject1[2] = localSecondaryDevice.getPlatformVersion();
    localTextView1.setText(localResources1.getString(i, arrayOfObject1));
    TextView localTextView2 = locala.c;
    Resources localResources2 = this.c;
    int j = R.string.manage_secondaries_location;
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = localSecondaryDevice.getLocation(this.b);
    localTextView2.setText(localResources2.getString(j, arrayOfObject2));
    TextView localTextView3 = locala.d;
    Resources localResources3 = this.c;
    int k = R.string.manage_secondaries_last_used;
    Object[] arrayOfObject3 = new Object[1];
    arrayOfObject3[0] = this.e.d(localSecondaryDevice.getLastLoginDate());
    localTextView3.setText(localResources3.getString(k, arrayOfObject3));
    if (c(paramInt))
    {
      locala.f.setVisibility(0);
      locala.e.setVisibility(8);
      return;
    }
    locala.f.setVisibility(8);
    locala.e.setVisibility(0);
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("ViewType = " + paramInt + " is not supported");
    case 0:
      return new b(this.d.inflate(R.layout.header_manage_secondaries, paramViewGroup, false));
    case 1:
    }
    return new a(this.d.inflate(R.layout.list_item_manage_secondaries, paramViewGroup, false), this.f);
  }

  public static class a extends RecyclerView.ViewHolder
  {
    final View a;
    final TextView b;
    final TextView c;
    final TextView d;
    final TextView e;
    final View f;

    a(View paramView, final com.viber.voip.ui.a.a parama)
    {
      super();
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(R.id.system_name));
      this.c = ((TextView)paramView.findViewById(R.id.location));
      this.d = ((TextView)paramView.findViewById(R.id.last_used));
      this.e = ((TextView)paramView.findViewById(R.id.deactivate));
      this.f = paramView.findViewById(R.id.progress);
      this.e.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          int i = a.a.this.getAdapterPosition();
          if ((i != -1) && (parama != null))
            parama.a(i, paramAnonymousView);
        }
      });
      int i = paramView.getResources().getDimensionPixelSize(R.dimen.manage_secondaries_deactivate_hit_space);
      dj.a(this.e, 0, i, 0, i);
    }

    void a()
    {
      dj.a(this.f, this.e, ViewCompat.isLaidOut(this.a));
    }

    void b()
    {
      dj.a(this.e, this.f, ViewCompat.isLaidOut(this.a));
    }
  }

  static class b extends RecyclerView.ViewHolder
  {
    b(View paramView)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.secondary.a
 * JD-Core Version:    0.6.2
 */