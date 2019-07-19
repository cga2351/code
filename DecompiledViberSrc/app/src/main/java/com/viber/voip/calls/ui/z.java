package com.viber.voip.calls.ui;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.drawable;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.model.AggregatedCall;
import com.viber.voip.model.a;
import com.viber.voip.phone.PhoneUtils;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.x;
import com.viber.voip.widget.AvatarWithInitialsView;

public class z extends t<AvatarWithInitialsView, u<AvatarWithInitialsView>>
{
  private final boolean i;

  public z(Context paramContext, RecentCallsFragmentModeManager paramRecentCallsFragmentModeManager, boolean paramBoolean1, ab.a parama, e parame, f paramf, boolean paramBoolean2)
  {
    super(paramContext, paramRecentCallsFragmentModeManager, paramBoolean1, parama, parame, paramf);
    this.i = paramBoolean2;
  }

  public u<AvatarWithInitialsView> a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return new u(paramLayoutInflater.inflate(R.layout.item_recent_call, paramViewGroup, false));
  }

  public void a(u<AvatarWithInitialsView> paramu, AggregatedCall paramAggregatedCall, int paramInt)
  {
    boolean bool1 = true;
    super.a(paramu, paramAggregatedCall, paramInt);
    a locala = paramAggregatedCall.getContact();
    boolean bool2;
    label137: label161: boolean bool3;
    if ((locala != null) && (!da.a(locala.v())))
    {
      bool2 = bool1;
      if (bool2)
      {
        String str3 = x.a(locala, paramAggregatedCall.getNumber());
        paramu.f.setText(str3);
        paramu.a(str3);
      }
      String str1 = PhoneUtils.formatPhoneNumber(paramAggregatedCall.getNumber());
      if (("-2".equals(str1)) || ("-1".equals(str1)))
        break label312;
      if (!bool2)
      {
        paramu.f.setText(dg.a(str1));
        paramu.a(str1);
      }
      paramu.b(paramAggregatedCall.getCanonizedNumber());
      if (locala == null)
        break label356;
      ((AvatarWithInitialsView)paramu.e).a(locala.m(), bool1);
      Uri localUri = x.a(locala);
      this.d.a(localUri, (ImageView)paramu.e, this.e);
      if ((locala == null) || (locala.p()))
        break label371;
      bool3 = bool1;
      label207: if ((!this.b) || (this.f) || (paramAggregatedCall.isTypeViberOut()) || (paramAggregatedCall.isPrivateNumber()) || (bool3) || (this.i))
        break label377;
    }
    while (true)
    {
      paramu.d(bool1);
      if ((!this.f) && (!this.i) && (!paramAggregatedCall.isTypeViberOut()) && (!bool3))
        paramu.g.setImageDrawable(this.a.getResources().getDrawable(R.drawable.ic_contacts_item_voice_call));
      return;
      bool2 = false;
      break;
      label312: if (locala == null)
      {
        String str2 = paramu.f.getContext().getString(R.string.unknown);
        paramu.f.setText(str2);
        paramu.a(str2);
      }
      paramu.b("");
      break label137;
      label356: ((AvatarWithInitialsView)paramu.e).a(null, false);
      break label161;
      label371: bool3 = false;
      break label207;
      label377: bool1 = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.z
 * JD-Core Version:    0.6.2
 */