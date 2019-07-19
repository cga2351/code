package com.viber.voip.messages.b.a;

import android.net.Uri;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.messages.m;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.widget.AvatarWithInitialsView;

class a extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private final TextView a;
  private final AvatarWithInitialsView b;
  private final View c;
  private final View d;
  private final e e;
  private final f f;
  private final b.a g;
  private ae h;

  public a(View paramView, e parame, f paramf, b.a parama)
  {
    super(paramView);
    this.e = parame;
    this.f = paramf;
    this.g = parama;
    this.b = ((AvatarWithInitialsView)paramView.findViewById(R.id.mention_contact_icon));
    this.a = ((TextView)paramView.findViewById(R.id.mention_contact_name));
    this.c = paramView.findViewById(R.id.divider);
    this.d = paramView.findViewById(R.id.adminIndicatorView);
  }

  public void a(ae paramae, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool1 = true;
    this.h = paramae;
    Uri localUri = paramae.j();
    String str1 = paramae.a(paramInt2, paramInt1);
    String str2 = paramae.a(str1);
    this.a.setText(str1);
    boolean bool2;
    label71: View localView2;
    if (da.a(str2))
    {
      this.b.a(null, false);
      View localView1 = this.c;
      if (paramBoolean)
        break label148;
      bool2 = bool1;
      dj.b(localView1, bool2);
      localView2 = this.d;
      if ((!m.b(paramInt1)) || (!cd.b(paramae.a())))
        break label154;
    }
    while (true)
    {
      dj.b(localView2, bool1);
      this.e.a(localUri, this.b, this.f);
      this.itemView.setOnClickListener(this);
      return;
      this.b.a(str2, bool1);
      break;
      label148: bool2 = false;
      break label71;
      label154: bool1 = false;
    }
  }

  public void onClick(View paramView)
  {
    if ((this.g != null) && (this.h != null))
      this.g.a(this.h);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.b.a.a
 * JD-Core Version:    0.6.2
 */