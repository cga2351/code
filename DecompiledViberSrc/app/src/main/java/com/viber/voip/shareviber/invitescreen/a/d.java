package com.viber.voip.shareviber.invitescreen.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class d extends c
  implements b.a
{
  private final a j = (a)this.a;

  public d(Context paramContext, boolean paramBoolean, b.a parama, com.viber.voip.shareviber.invitescreen.d paramd, LayoutInflater paramLayoutInflater)
  {
    super(paramContext, paramBoolean, new a(null), parama, paramd, paramLayoutInflater);
  }

  public void a(List<com.viber.voip.model.a> paramList)
  {
    notifyDataSetInvalidated();
    this.j.a(paramList);
    notifyDataSetChanged();
  }

  protected View d(int paramInt)
  {
    View localView = super.d(paramInt);
    if (paramInt == 1)
    {
      dj.b(localView.findViewById(R.id.top_divider), false);
      ((b)localView.getTag()).h.setText(R.string.title_suggested_contact);
    }
    return localView;
  }

  private static final class a
    implements com.viber.voip.contacts.a
  {
    private List<com.viber.voip.model.a> a = Collections.emptyList();

    public long a(int paramInt)
    {
      return ((com.viber.voip.model.a)this.a.get(paramInt)).getId();
    }

    public String a()
    {
      return "";
    }

    public void a(List<com.viber.voip.model.a> paramList)
    {
      this.a = new ArrayList(paramList);
    }

    public com.viber.voip.model.c c(int paramInt)
    {
      return (com.viber.voip.model.c)this.a.get(paramInt);
    }

    public int getCount()
    {
      return this.a.size();
    }

    public boolean x_()
    {
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.a.d
 * JD-Core Version:    0.6.2
 */