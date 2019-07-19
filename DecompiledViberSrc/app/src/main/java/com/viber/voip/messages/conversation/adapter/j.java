package com.viber.voip.messages.conversation.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.integer;
import com.viber.voip.R.layout;
import com.viber.voip.backgrounds.g;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.gallery.a;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.p;
import com.viber.voip.messages.conversation.p.a;
import com.viber.voip.messages.conversation.p.c;
import com.viber.voip.ui.af.c;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.k;
import com.viber.voip.widget.CheckableImageView;
import java.util.Set;

public class j extends a
{
  private k b;
  private f c;
  private p d;
  private int e;
  private int f;
  private int g;
  private Set<Long> h;
  private View.OnLongClickListener i;
  private View.OnClickListener j;

  public j(Context paramContext, k paramk, int paramInt, p paramp, Set<Long> paramSet)
  {
    this.d = paramp;
    this.e = g.a(paramContext, null);
    this.g = com.viber.voip.util.e.j.a(paramContext, 11.0F);
    int k = paramContext.getResources().getInteger(R.integer.gallery_images_per_row);
    int m = com.viber.voip.util.e.j.a(paramContext, com.viber.voip.util.e.j.a.a) / k;
    this.b = paramk;
    this.c = new f.a().b(Integer.valueOf(R.drawable.ic_loading_picture)).a(Integer.valueOf(R.drawable.bg_loading_gallery_image)).a(m, m).e(true).c();
    this.f = paramInt;
    this.h = paramSet;
  }

  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TextView localTextView2;
    if (paramView == null)
    {
      paramView = View.inflate(paramViewGroup.getContext(), R.layout.conversation_gallery_date_item_layout, null);
      localTextView2 = (TextView)paramView.findViewById(R.id.data);
      paramView.setTag(localTextView2);
      paramView.setTag(R.id.header, new af.c());
    }
    for (TextView localTextView1 = localTextView2; ; localTextView1 = (TextView)paramView.getTag())
    {
      String str = a(paramInt)[0].G().toUpperCase();
      af.c localc = (af.c)paramView.getTag(R.id.header);
      localc.b(true);
      localc.a(true);
      localc.a(str);
      localTextView1.setText(str);
      return paramView;
    }
  }

  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    LinearLayout localLinearLayout1 = (LinearLayout)paramView;
    aa[] arrayOfaa = a(paramInt);
    LinearLayout localLinearLayout3;
    if (paramView == null)
    {
      Context localContext = paramViewGroup.getContext();
      localLinearLayout3 = new LinearLayout(localContext);
      localLinearLayout3.setOrientation(0);
      a[] arrayOfa2 = new a[this.f];
      for (int i4 = 0; i4 < this.f; i4++)
      {
        View localView = View.inflate(localContext, R.layout.conversation_gallery_item_layout, null);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, this.e);
        localLayoutParams.weight = 1.0F;
        localView.setLayoutParams(localLayoutParams);
        arrayOfa2[i4] = new a((CheckableImageView)localView, null);
        localLinearLayout3.addView(localView);
      }
      localLinearLayout3.setTag(arrayOfa2);
      localLinearLayout3.setTag(R.id.header, new af.c());
    }
    for (LinearLayout localLinearLayout2 = localLinearLayout3; ; localLinearLayout2 = localLinearLayout1)
    {
      a[] arrayOfa1 = (a[])localLinearLayout2.getTag();
      int k = 0;
      int m = this.f;
      if (k < m)
      {
        a locala = arrayOfa1[k];
        int i3 = arrayOfaa.length;
        aa localaa;
        if (k < i3)
        {
          localaa = arrayOfaa[k];
          label212: if (localaa != null)
            break label238;
          locala.a.setVisibility(4);
        }
        while (true)
        {
          k++;
          break;
          localaa = null;
          break label212;
          label238: locala.a.setPressed(a(Long.valueOf(localaa.a())));
          locala.a.setOnClickListener(this.j);
          locala.a.setOnLongClickListener(this.i);
          locala.a.setTag(Long.valueOf(localaa.a()));
          boolean bool1 = localaa.aA();
          this.b.a(localaa.bo(), locala.a, this.c, null, localaa.a(), localaa.B(), localaa.o(), localaa.q(), localaa.bx().getThumbnailEP(), localaa.aT());
          locala.a.setVisibility(0);
          CheckableImageView localCheckableImageView = locala.a;
          if ((this.h != null) && (this.h.contains(Long.valueOf(localaa.a()))));
          for (boolean bool2 = true; ; bool2 = false)
          {
            localCheckableImageView.setChecked(bool2);
            if (!bool1)
              break label440;
            locala.a.a(R.drawable.preview_media_play_selector, 48);
            break;
          }
          label440: locala.a.a(null, 48);
        }
      }
      af.c localc = (af.c)localLinearLayout2.getTag(R.id.header);
      localc.b(true);
      localc.a(false);
      localc.a(arrayOfaa[0].G().toUpperCase());
      int n = com.viber.voip.util.e.j.a(1.5F);
      int i1 = com.viber.voip.util.e.j.a(1.5F);
      if (paramInt == -1 + getCount());
      for (int i2 = this.g; ; i2 = 0)
      {
        localLinearLayout2.setPadding(n, 0, i1, i2);
        return localLinearLayout2;
      }
    }
  }

  public void a(View.OnClickListener paramOnClickListener)
  {
    this.j = paramOnClickListener;
  }

  public void a(View.OnLongClickListener paramOnLongClickListener)
  {
    this.i = paramOnLongClickListener;
  }

  public void a(Set<Long> paramSet)
  {
    this.h = paramSet;
    notifyDataSetChanged();
  }

  public aa[] a(int paramInt)
  {
    return this.d.e(paramInt).a();
  }

  public void b(int paramInt)
  {
    this.e = paramInt;
  }

  public int getCount()
  {
    return this.d.s();
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    if ((this.d.e(paramInt) instanceof p.a))
      return 0;
    return 1;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 0)
      return a(paramInt, paramView, paramViewGroup);
    return b(paramInt, paramView, paramViewGroup);
  }

  public int getViewTypeCount()
  {
    return 2;
  }

  private class a
  {
    public CheckableImageView a;

    private a(CheckableImageView arg2)
    {
      View localView;
      this.a = localView;
      j.a(j.this, localView);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.j
 * JD-Core Version:    0.6.2
 */