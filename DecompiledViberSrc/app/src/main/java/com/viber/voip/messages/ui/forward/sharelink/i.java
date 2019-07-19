package com.viber.voip.messages.ui.forward.sharelink;

import android.net.Uri;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.widget.AvatarWithInitialsView;

public class i extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private AvatarWithInitialsView a;
  private ViberTextView b;
  private View c;
  private f d;
  private e e;
  private com.viber.voip.util.e.f f;
  private TextView g;

  public i(View paramView, f paramf, e parame, com.viber.voip.util.e.f paramf1, String paramString)
  {
    super(paramView);
    this.a = ((AvatarWithInitialsView)paramView.findViewById(R.id.avatar));
    this.b = ((ViberTextView)paramView.findViewById(R.id.name));
    this.c = paramView.findViewById(R.id.selection_indicator);
    this.d = paramf;
    this.e = parame;
    this.f = paramf1;
    this.g = ((TextView)paramView.findViewById(R.id.header));
    this.g.setText(paramString);
    paramView.setOnClickListener(this);
  }

  public void a(String paramString1, Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    this.b.setText(paramString1);
    this.e.a(paramUri, this.a, this.f);
    dj.b(this.c, paramBoolean1);
    if (!da.a(paramString2))
      dg.a(this.b, paramString2, 2147483647);
    dj.b(this.g, paramBoolean2);
  }

  public void onClick(View paramView)
  {
    this.d.a(getAdapterPosition());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.forward.sharelink.i
 * JD-Core Version:    0.6.2
 */