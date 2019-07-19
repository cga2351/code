package com.viber.voip.messages.conversation.ui.spam.a;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.common.ui.ShapeImageView;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.model.entity.h;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import java.util.ArrayList;
import java.util.List;

public class a extends RecyclerView.Adapter<a>
{
  private final List<h> a = new ArrayList();

  public a a(ViewGroup paramViewGroup, int paramInt)
  {
    return new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.common_community_item, paramViewGroup, false));
  }

  public void a(a parama, int paramInt)
  {
    parama.a((h)this.a.get(paramInt));
  }

  public void a(List<h> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }

  public int getItemCount()
  {
    return this.a.size();
  }

  public static class a extends RecyclerView.ViewHolder
  {
    private final TextView a;
    private final ShapeImageView b;

    a(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(R.id.community_name));
      this.b = ((ShapeImageView)paramView.findViewById(R.id.community_picture));
    }

    public void a(h paramh)
    {
      this.a.setText(paramh.o());
      int i = dc.a(this.a.getContext(), R.attr.conversationsListItemDefaultCommunityImage);
      e.a(this.itemView.getContext()).a(paramh.q(), this.b, f.a().f().a(Integer.valueOf(i)).b(Integer.valueOf(i)).c());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.spam.a.a
 * JD-Core Version:    0.6.2
 */