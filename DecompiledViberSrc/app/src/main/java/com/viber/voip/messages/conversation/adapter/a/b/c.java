package com.viber.voip.messages.conversation.adapter.a.b;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.jni.OnlineContactInfo;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.adapter.r;
import com.viber.voip.messages.conversation.adapter.s;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.messages.m;
import com.viber.voip.util.ca;
import com.viber.voip.util.cd;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.f;
import com.viber.voip.widget.AvatarWithInitialsView;
import java.util.Map;

public class c extends r
{
  public AvatarWithInitialsView a;
  public TextView b;
  public TextView c;
  public ImageView d;
  private final com.viber.voip.util.e.e e;
  private final f f;
  private final com.viber.voip.messages.conversation.adapter.a.c.a.e g;
  private TextView h;
  private View i;
  private Uri j;

  public c(com.viber.voip.util.e.e parame, f paramf, com.viber.voip.messages.conversation.adapter.a.c.a.e parame1, View paramView)
  {
    super(paramView);
    this.e = parame;
    this.f = paramf;
    this.g = parame1;
    this.a = ((AvatarWithInitialsView)paramView.findViewById(R.id.icon));
    this.a.setFocusable(false);
    this.a.setClickable(false);
    this.b = ((TextView)paramView.findViewById(R.id.name));
    this.c = ((TextView)paramView.findViewById(R.id.onlineStatus));
    this.d = ((ImageView)paramView.findViewById(R.id.trustIcon));
    this.h = ((TextView)paramView.findViewById(R.id.groupRole));
    this.i = paramView.findViewById(R.id.adminIndicatorView);
  }

  private void a(ae paramae)
  {
    Map localMap = this.g.h();
    if (localMap != null)
    {
      PeerTrustState.PeerTrustEnum localPeerTrustEnum = (PeerTrustState.PeerTrustEnum)localMap.get(paramae.h());
      if (localPeerTrustEnum != null)
      {
        ImageView localImageView = this.d;
        if (localPeerTrustEnum == PeerTrustState.PeerTrustEnum.SECURE_TRUSTED);
        for (boolean bool = true; ; bool = false)
        {
          dj.c(localImageView, bool);
          return;
        }
      }
    }
    dj.c(this.d, false);
  }

  private void b(ae paramae)
  {
    if (this.h == null)
      return;
    if (m.b(this.g.e()))
    {
      int k = paramae.a();
      if (cd.c(k))
        this.h.setText(R.string.superadmin);
      while (true)
      {
        dj.c(this.i, cd.b(k));
        dj.c(this.h, cd.b(k));
        return;
        this.h.setText(R.string.admin);
      }
    }
    dj.b(this.h, false);
    dj.c(this.i, false);
  }

  public void a(s params)
  {
    super.a(params);
    ae localae = (ae)params;
    String str1 = localae.a(this.g.c(), this.g.e());
    if (localae.isOwner())
      if (!TextUtils.isEmpty(str1))
      {
        this.b.setText(String.format(this.g.f(), new Object[] { str1 }));
        dj.c(this.c, 8);
      }
    do
    {
      Uri localUri = localae.j();
      this.a.a(localae.a(str1), true);
      if (!ca.b(this.j, localUri))
      {
        this.e.a(localUri, this.a, this.f);
        this.j = localUri;
      }
      b(localae);
      a(localae);
      return;
      this.b.setText(this.g.b());
      break;
      this.b.setText(str1);
    }
    while (this.c == null);
    OnlineContactInfo localOnlineContactInfo;
    label205: String str2;
    TextView localTextView;
    if (this.g.g() != null)
    {
      localOnlineContactInfo = (OnlineContactInfo)this.g.g().get(localae.h());
      str2 = dg.a(localOnlineContactInfo);
      localTextView = this.c;
      if (str2 == null)
        break label251;
    }
    label251: for (boolean bool = true; ; bool = false)
    {
      dj.b(localTextView, bool);
      this.c.setText(str2);
      break;
      localOnlineContactInfo = null;
      break label205;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.a.b.c
 * JD-Core Version:    0.6.2
 */