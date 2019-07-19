package com.viber.voip.messages.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.plurals;
import com.viber.voip.messages.conversation.community.search.Group;
import com.viber.voip.util.av;
import com.viber.voip.util.da;
import com.viber.voip.util.dc;
import com.viber.voip.util.dg;
import com.viber.voip.util.dx;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.b;
import java.util.ArrayList;
import java.util.List;

public class bh extends BaseAdapter
{
  private final LayoutInflater a;
  private final e b;
  private final Drawable c;
  private final List<Group> d;
  private final f e;
  private String f = "";

  bh(Context paramContext, e parame, LayoutInflater paramLayoutInflater)
  {
    this.b = parame;
    this.a = paramLayoutInflater;
    this.d = new ArrayList();
    this.e = f.a(dc.a(paramContext, R.attr.conversationsListItemDefaultCommunityImage), f.b.b);
    this.c = ContextCompat.getDrawable(paramContext, R.drawable.ic_chat_list_verified_account);
    if (this.c != null)
      this.c.setBounds(0, 0, this.c.getIntrinsicWidth(), this.c.getIntrinsicHeight());
  }

  public Group a(int paramInt)
  {
    return (Group)this.d.get(paramInt);
  }

  public void a()
  {
    this.d.clear();
    this.f = "";
    notifyDataSetChanged();
  }

  public void a(String paramString, List<Group> paramList)
  {
    a();
    this.f = paramString;
    this.d.addAll(paramList);
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return this.d.size();
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null);
    for (Object localObject = null; ; localObject = paramView.getTag())
    {
      if ((paramView == null) || (localObject == null) || (!(localObject instanceof a)))
      {
        paramView = this.a.inflate(R.layout.search_community_result_item, paramViewGroup, false);
        paramView.setTag(new a(paramView, this.b, this.e));
      }
      ((a)paramView.getTag()).a(this.f, a(paramInt), this.c);
      return paramView;
    }
  }

  public static class a
  {
    private final ImageView a;
    private final TextView b;
    private final TextView c;
    private e d;
    private f e;
    private Group f;

    a(View paramView, e parame, f paramf)
    {
      this.a = ((ImageView)paramView.findViewById(R.id.community_icon));
      this.b = ((TextView)paramView.findViewById(R.id.name));
      this.c = ((TextView)paramView.findViewById(R.id.description));
      this.d = parame;
      this.e = paramf;
    }

    public Group a()
    {
      return this.f;
    }

    public void a(String paramString, Group paramGroup, Drawable paramDrawable)
    {
      this.f = paramGroup;
      this.b.setText(paramGroup.getName());
      if (av.d(paramGroup.getFl(), 1));
      while (true)
      {
        TextViewCompat.setCompoundDrawablesRelative(this.b, null, null, paramDrawable, null);
        this.b.setCompoundDrawables(null, null, paramDrawable, null);
        dg.a(this.b, paramString, paramGroup.getName().length());
        int i = paramGroup.getNumWchrs() + paramGroup.getNumSpkrs();
        Resources localResources = this.c.getContext().getResources();
        int j = R.plurals.view_community_followers_likes_header;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = da.b(i);
        String str = localResources.getQuantityString(j, i, arrayOfObject);
        this.c.setText(str);
        this.d.a(dx.g(paramGroup.getIcn()), this.a, this.e);
        return;
        paramDrawable = null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.bh
 * JD-Core Version:    0.6.2
 */