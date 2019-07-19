package com.viber.voip.calls.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.l.b;
import com.viber.voip.model.AggregatedCall;
import com.viber.voip.model.a;
import com.viber.voip.util.ae;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import java.util.Locale;

public abstract class t<I extends View, VH extends u<I>> extends ab<AggregatedCall, I, VH>
{
  private final t<I, VH>.a i = new a();
  private final RecentCallsFragmentModeManager j;
  private final java.text.DateFormat k;
  private final java.text.DateFormat l;

  public t(Context paramContext, RecentCallsFragmentModeManager paramRecentCallsFragmentModeManager, boolean paramBoolean, ab.a parama, e parame, f paramf)
  {
    super(paramContext, paramBoolean, parama, parame, paramf);
    this.j = paramRecentCallsFragmentModeManager;
    this.k = ViberApplication.getInstance().getLocaleDataCache().b();
    this.l = android.text.format.DateFormat.getTimeFormat(paramContext);
  }

  public void a(VH paramVH, AggregatedCall paramAggregatedCall, int paramInt)
  {
    int m = 1;
    paramVH.a(paramAggregatedCall);
    paramVH.a(this.i, paramAggregatedCall.getDate());
    paramVH.b(paramAggregatedCall.isViberCall());
    TextView localTextView1 = paramVH.f;
    int i1;
    label189: label219: label239: int i8;
    label273: int i9;
    if (paramAggregatedCall.isMissed())
    {
      i1 = this.g;
      localTextView1.setTextColor(i1);
      dj.b(paramVH.b, m);
      Drawable localDrawable1 = this.a.getResources().getDrawable(this.i.a(paramAggregatedCall.getType()));
      localDrawable1.setBounds(0, 0, localDrawable1.getIntrinsicWidth(), localDrawable1.getIntrinsicHeight());
      Drawable localDrawable2 = df.a(localDrawable1, dc.d(this.a, R.attr.callsRecentItemTypeNormalColor), m);
      paramVH.b.setCompoundDrawables(localDrawable2, null, null, null);
      paramVH.b.setText(this.i.b(paramAggregatedCall.getViberCallType()));
      if ((paramAggregatedCall.getContact() == null) || (paramAggregatedCall.getContact().p()))
        break label420;
      int i2 = m;
      ImageButton localImageButton = paramVH.g;
      a locala = this.i;
      if ((!paramAggregatedCall.isTypeViberOut()) && (i2 == 0))
        break label426;
      int i4 = m;
      if ((!paramAggregatedCall.isTypeViberVideo()) || (!paramVH.a()))
        break label432;
      int i6 = m;
      localImageButton.setImageDrawable(locala.a(i4, i6));
      TextView localTextView2 = paramVH.c;
      if (paramAggregatedCall.getCount() <= m)
        break label438;
      i8 = 0;
      localTextView2.setVisibility(i8);
      TextView localTextView3 = paramVH.c;
      if (!paramAggregatedCall.isMissed())
        break label445;
      i9 = this.g;
      label301: localTextView3.setTextColor(i9);
      TextView localTextView4 = paramVH.c;
      Locale localLocale = Locale.getDefault();
      Object[] arrayOfObject = new Object[m];
      arrayOfObject[0] = Integer.valueOf(paramAggregatedCall.getCount());
      localTextView4.setText(String.format(localLocale, "(%d)", arrayOfObject));
      if (paramAggregatedCall.isPrivateNumber())
        break label454;
    }
    while (true)
    {
      paramVH.c(m);
      if (this.j != null)
        paramVH.d.setActivated(this.j.c(Integer.valueOf(paramInt)));
      paramVH.d.setBackground(dc.g(this.a, R.attr.listItemActivatedBackground));
      return;
      i1 = this.h;
      break;
      label420: int i3 = 0;
      break label189;
      label426: int i5 = 0;
      break label219;
      label432: int i7 = 0;
      break label239;
      label438: i8 = 8;
      break label273;
      label445: i9 = this.h;
      break label301;
      label454: int n = 0;
    }
  }

  public boolean a(Object paramObject)
  {
    return paramObject instanceof AggregatedCall;
  }

  protected final class a
  {
    protected a()
    {
    }

    public int a(int paramInt)
    {
      if (paramInt == 3)
        return R.drawable.ic_phone_type_incoming_call;
      if (paramInt == 2)
        return R.drawable.ic_phone_type_outgoing_call;
      if ((paramInt == 1) || (paramInt == 5))
        return R.drawable.ic_phone_type_incoming_call;
      return 0;
    }

    public Drawable a(boolean paramBoolean1, boolean paramBoolean2)
    {
      Resources localResources = t.this.a.getResources();
      if (paramBoolean1)
        return localResources.getDrawable(R.drawable.ic_contacts_item_viber_out_call);
      if (paramBoolean2)
        return localResources.getDrawable(R.drawable.ic_contacts_item_video_call);
      return localResources.getDrawable(R.drawable.ic_contacts_item_voice_call);
    }

    public String a(long paramLong)
    {
      return ae.a(t.a(t.this), t.b(t.this), paramLong, false);
    }

    public String b(int paramInt)
    {
      Resources localResources = t.this.a.getResources();
      switch (paramInt)
      {
      default:
        return null;
      case 1:
      case 6:
        return localResources.getString(R.string.call_type_audio);
      case 4:
        return localResources.getString(R.string.call_type_video);
      case 2:
        return localResources.getString(R.string.call_type_vo);
      case 3:
        return localResources.getString(R.string.call_type_audio);
      case 5:
      }
      return localResources.getString(R.string.call_type_vln);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.t
 * JD-Core Version:    0.6.2
 */