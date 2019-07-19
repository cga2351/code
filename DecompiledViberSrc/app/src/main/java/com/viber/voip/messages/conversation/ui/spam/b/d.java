package com.viber.voip.messages.conversation.ui.spam.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.d.c;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.extras.map.BalloonLayout;
import com.viber.voip.model.entity.m;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;

public class d
  implements e
{
  protected ConversationItemLoaderEntity a;
  protected m b;
  protected final Context c;
  protected final ViewGroup d;
  boolean e;
  View f;
  TextView g;
  ImageView h;
  TextView i;
  TextView j;
  private final View.OnClickListener k;
  private TextView l;

  public d(Context paramContext, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    this.c = paramContext;
    this.d = paramViewGroup;
    this.k = paramOnClickListener;
  }

  private void a()
  {
    this.f = LayoutInflater.from(this.c).inflate(c(), this.d, false);
    this.f.findViewById(R.id.show_conversation_btn).setOnClickListener(this.k);
    this.j = ((TextView)this.f.findViewById(R.id.block_btn));
    this.j.setOnClickListener(this.k);
    BalloonLayout localBalloonLayout = (BalloonLayout)this.f.findViewById(R.id.overlay_content);
    if (localBalloonLayout != null)
      localBalloonLayout.setMaxWidth(this.f.getContext().getResources().getDimensionPixelSize(R.dimen.conversation_spam_overlay_width));
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.a = paramConversationItemLoaderEntity;
  }

  public void a(m paramm)
  {
    this.b = paramm;
  }

  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  public void b()
  {
    if ((this.c == null) || (this.a == null) || (this.b == null))
      return;
    if (this.g == null)
    {
      this.g = ((TextView)this.f.findViewById(R.id.overlay_message));
      this.h = ((ImageView)this.f.findViewById(R.id.photo));
      this.i = ((TextView)this.f.findViewById(R.id.overlay_viber_name));
      this.l = ((TextView)this.f.findViewById(R.id.overlay_phone_number));
    }
    com.viber.voip.util.e.e.a(this.c).a(null, this.b.p(), this.h, f.b(this.c).f().a(true).c());
    int n;
    label286: TextView localTextView3;
    Context localContext3;
    int i1;
    if (!TextUtils.isEmpty(this.b.getViberName()))
    {
      TextView localTextView4 = this.i;
      Context localContext4 = this.g.getContext();
      int i2 = R.string.spam_overlay_name_text;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.b.getViberName();
      localTextView4.setText(localContext4.getString(i2, arrayOfObject2));
      dj.b(this.i, true);
      TextView localTextView1 = this.l;
      Context localContext1 = this.g.getContext();
      int m = R.string.spam_overlay_phone_text;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = c.a(this.b.getNumber());
      localTextView1.setText(localContext1.getString(m, arrayOfObject1));
      TextView localTextView2 = this.g;
      Context localContext2 = this.g.getContext();
      if (!this.a.isGroupBehavior())
        break label349;
      n = R.string.spam_banner_text_groups;
      localTextView2.setText(localContext2.getString(n));
      localTextView3 = this.j;
      localContext3 = this.g.getContext();
      if (!this.e)
        break label357;
      i1 = R.string.spam_banner_delete_and_close_btn;
    }
    while (true)
    {
      localTextView3.setText(localContext3.getString(i1));
      return;
      dj.b(this.i, false);
      break;
      label349: n = R.string.spam_banner_text_1on1;
      break label286;
      label357: if (this.a.isGroupBehavior())
        i1 = R.string.spam_banner_block_btn;
      else
        i1 = R.string.block;
    }
  }

  protected int c()
  {
    return R.layout.spam_overlay_layout;
  }

  public boolean d()
  {
    if ((this.d == null) || (this.f == null));
    while (true)
    {
      return false;
      for (int m = -1 + this.d.getChildCount(); m >= 0; m--)
        if (this.d.getChildAt(m) == this.f)
          return true;
    }
  }

  public void e()
  {
    if ((this.c == null) || (this.d == null));
    do
    {
      return;
      if (this.f == null)
        a();
      b();
    }
    while (d());
    this.d.addView(this.f);
  }

  public void f()
  {
    if ((this.d != null) && (this.f != null))
      this.d.removeView(this.f);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.spam.b.d
 * JD-Core Version:    0.6.2
 */