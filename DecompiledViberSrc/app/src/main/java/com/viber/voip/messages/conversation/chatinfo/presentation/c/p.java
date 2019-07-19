package com.viber.voip.messages.conversation.chatinfo.presentation.c;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.jni.OnlineContactInfo;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.messages.conversation.chatinfo.d.k;
import com.viber.voip.messages.conversation.chatinfo.e.a;
import com.viber.voip.messages.conversation.chatinfo.e.d;
import com.viber.voip.util.cd;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.f;
import com.viber.voip.widget.AvatarWithInitialsView;
import java.util.Map;

public class p extends g<k>
{
  private final TextView a;
  private final AvatarWithInitialsView b;
  private final TextView c;
  private final ImageView d;
  private final TextView e;
  private final View f;
  private Uri g;
  private k h;

  public p(View paramView, com.viber.voip.messages.conversation.chatinfo.presentation.b.m paramm)
  {
    super(paramView);
    this.itemView.setOnClickListener(new q(this, paramm));
    this.b = ((AvatarWithInitialsView)this.itemView.findViewById(R.id.icon));
    this.b.setFocusable(false);
    this.b.setClickable(false);
    this.a = ((TextView)paramView.findViewById(R.id.name));
    this.c = ((TextView)paramView.findViewById(R.id.onlineStatus));
    this.d = ((ImageView)paramView.findViewById(R.id.trustIcon));
    this.e = ((TextView)paramView.findViewById(R.id.groupRole));
    this.f = paramView.findViewById(R.id.adminIndicatorView);
  }

  private void a(ae paramae, d paramd)
  {
    String str1 = paramae.a(paramd.a(), paramd.b());
    if (paramae.isOwner())
    {
      if (da.a(str1))
        this.a.setText(paramd.d());
      while (true)
      {
        dj.c(this.c, 8);
        return;
        this.a.setText(String.format(paramd.e(), new Object[] { str1 }));
      }
    }
    this.a.setText(str1);
    OnlineContactInfo localOnlineContactInfo;
    String str2;
    TextView localTextView;
    if (paramd.f() != null)
    {
      localOnlineContactInfo = (OnlineContactInfo)paramd.f().get(paramae.h());
      str2 = dg.a(localOnlineContactInfo);
      localTextView = this.c;
      if (str2 == null)
        break label150;
    }
    label150: for (boolean bool = true; ; bool = false)
    {
      dj.b(localTextView, bool);
      this.c.setText(str2);
      return;
      localOnlineContactInfo = null;
      break;
    }
  }

  private void a(ae paramae, d paramd, com.viber.voip.util.e.e parame, f paramf)
  {
    String str = paramae.a(paramd.a(), paramd.b());
    this.b.a(paramae.a(str), true);
    Uri localUri = paramae.j();
    if (((this.g == null) && (localUri != null)) || ((this.g != null) && (!this.g.equals(localUri))))
    {
      parame.a(localUri, this.b, paramf);
      this.g = localUri;
    }
  }

  private void b(ae paramae, d paramd)
  {
    Map localMap = paramd.g();
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

  private void c(ae paramae, d paramd)
  {
    if (com.viber.voip.messages.m.b(paramd.b()))
    {
      int i = paramae.a();
      if (cd.c(i))
        this.e.setText(R.string.superadmin);
      while (true)
      {
        dj.c(this.f, cd.b(i));
        dj.c(this.e, cd.b(i));
        return;
        this.e.setText(R.string.admin);
      }
    }
    dj.b(this.e, false);
    dj.c(this.f, false);
  }

  public void a(k paramk, com.viber.voip.messages.conversation.chatinfo.e.e parame)
  {
    this.h = paramk;
    ae localae = paramk.a();
    d locald = parame.c();
    a locala = parame.b();
    a(localae, locald);
    a(localae, locald, locala.a(), locala.e());
    b(localae, locald);
    c(localae, locald);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.c.p
 * JD-Core Version:    0.6.2
 */