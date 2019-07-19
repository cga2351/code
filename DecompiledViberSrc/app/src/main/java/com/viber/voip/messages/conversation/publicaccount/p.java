package com.viber.voip.messages.conversation.publicaccount;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.ui.h;
import com.viber.voip.ui.n;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.f.b;
import com.viber.voip.widget.WrapContentAwareLinearLayoutManager;
import com.viber.voip.widget.a.c;
import java.util.ArrayList;

public class p extends h
  implements b
{
  public TextView a;
  public RecyclerView b;
  private View.OnClickListener c;
  private View.OnClickListener d;
  private n e;

  private void b(View paramView)
  {
    View.OnClickListener localOnClickListener = this.c;
    if (localOnClickListener != null)
      localOnClickListener.onClick(paramView);
  }

  public void a()
  {
    if (!e())
      return;
    d(true);
    this.a.setVisibility(8);
    this.e.a.setVisibility(8);
  }

  public void a(ArrayList<PublicAccount> paramArrayList)
  {
    if (!e())
      return;
    a(false);
    if (this.b.getAdapter() == null)
    {
      a locala = new a(this.b.getContext(), this.d, paramArrayList);
      this.b.setAdapter(locala);
      return;
    }
    ((a)this.b.getAdapter()).a(paramArrayList);
  }

  public void a(boolean paramBoolean)
  {
    if (!e())
      return;
    d(paramBoolean);
    this.e.a.setVisibility(8);
    this.a.setVisibility(0);
    this.b.setVisibility(0);
  }

  public boolean a(View paramView, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    if (!super.a(paramView, true))
      return false;
    Resources localResources = paramView.getResources();
    this.a = ((TextView)paramView.findViewById(R.id.emptyDescription));
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localResources.getString(R.string.pgroups_empty_description));
    int i = localSpannableStringBuilder.length();
    localSpannableStringBuilder.append(localResources.getString(R.string.pgroups_empty_description_link));
    localSpannableStringBuilder.setSpan(new ClickableSpan()
    {
      public void onClick(View paramAnonymousView)
      {
        p.a(p.this, paramAnonymousView);
      }

      public void updateDrawState(TextPaint paramAnonymousTextPaint)
      {
        super.updateDrawState(paramAnonymousTextPaint);
        paramAnonymousTextPaint.setUnderlineText(false);
      }
    }
    , i, localSpannableStringBuilder.length(), 33);
    this.a.setText(localSpannableStringBuilder);
    this.a.setMovementMethod(LinkMovementMethod.getInstance());
    this.a.setHighlightColor(0);
    this.b = ((RecyclerView)paramView.findViewById(R.id.pgroups_suggestion_listview));
    this.b.setLayoutManager(new WrapContentAwareLinearLayoutManager(paramView.getContext(), 0, false));
    c localc = new c(localResources.getDimensionPixelSize(R.dimen.pgroups_suggestionlist_divider_height));
    this.b.addItemDecoration(localc);
    this.b.setHasFixedSize(true);
    this.c = paramOnClickListener1;
    this.d = paramOnClickListener2;
    this.e = new n(paramView.findViewById(R.id.empty_root));
    this.e.b();
    this.e.f.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        p.a(p.this, paramAnonymousView);
      }
    });
    return true;
  }

  public void b()
  {
    if (!e())
      return;
    this.e.a.setVisibility(0);
    this.a.setVisibility(8);
    d(false);
    this.b.setVisibility(8);
  }

  public boolean c()
  {
    return (this.e != null) && (this.e.a != null) && (this.e.a.getVisibility() == 0);
  }

  public ArrayList<PublicAccount> d()
  {
    if ((this.b != null) && (this.b.getAdapter() != null))
      return ((a)this.b.getAdapter()).a();
    return null;
  }

  private static class a extends RecyclerView.Adapter<a>
  {
    private final Context a;
    private final View.OnClickListener b;
    private ArrayList<PublicAccount> c = new ArrayList();
    private final e d;
    private final f e;
    private final String f;

    public a(Context paramContext, View.OnClickListener paramOnClickListener, ArrayList<PublicAccount> paramArrayList)
    {
      this.a = paramContext;
      this.b = paramOnClickListener;
      Resources localResources = paramContext.getResources();
      this.c.addAll(paramArrayList);
      this.d = e.a(paramContext);
      this.e = new f.a().b(Integer.valueOf(R.drawable.public_suggest_background)).a(f.b.b).c();
      this.f = localResources.getString(R.string.public_groups_followers_label);
    }

    private PublicAccount a(int paramInt)
    {
      return (PublicAccount)this.c.get(paramInt);
    }

    private View b()
    {
      q localq = new q(this.a);
      localq.a();
      return localq;
    }

    public a a(ViewGroup paramViewGroup, int paramInt)
    {
      View localView = b();
      localView.setOnClickListener(this.b);
      return new a(localView);
    }

    public ArrayList<PublicAccount> a()
    {
      return this.c;
    }

    public void a(a parama, int paramInt)
    {
      PublicAccount localPublicAccount = a(paramInt);
      q localq = (q)parama.itemView;
      this.d.a(localPublicAccount.getIcon(), localq.e(), this.e, localq);
      localq.b().setText(localPublicAccount.getName());
      dj.b(localq.c(), localPublicAccount.isVerified());
      TextView localTextView = localq.d();
      String str = this.f;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = da.b(localPublicAccount.getWatchersCount());
      localTextView.setText(String.format(str, arrayOfObject));
      localq.setTag(localPublicAccount);
    }

    public void a(ArrayList<PublicAccount> paramArrayList)
    {
      if (paramArrayList != null)
      {
        this.c.clear();
        this.c.addAll(paramArrayList);
        notifyDataSetChanged();
      }
    }

    public int getItemCount()
    {
      return this.c.size();
    }

    public long getItemId(int paramInt)
    {
      return a(paramInt).getGroupID();
    }

    public static class a extends RecyclerView.ViewHolder
    {
      public a(View paramView)
      {
        super();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.p
 * JD-Core Version:    0.6.2
 */