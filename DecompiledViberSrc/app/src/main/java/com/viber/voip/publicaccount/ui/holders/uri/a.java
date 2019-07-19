package com.viber.voip.publicaccount.ui.holders.uri;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.string;
import com.viber.voip.publicaccount.d.d;
import com.viber.voip.util.da;

public class a extends com.viber.voip.publicaccount.ui.holders.b<UriData, b>
  implements View.OnClickListener
{
  protected void a(b paramb, UriData paramUriData)
  {
    if (d.D.a(((UriData)this.a).mGroupRole, ((UriData)this.a).mPublicGroupType))
    {
      paramb.a(((UriData)this.a).mGroupUri);
      return;
    }
    paramb.b();
  }

  protected Class<b> b()
  {
    return b.class;
  }

  protected b c(View paramView)
  {
    return new c(paramView, this);
  }

  protected UriData e()
  {
    return new UriData();
  }

  public void onClick(View paramView)
  {
    da.a(paramView.getContext(), ((UriData)this.a).mGroupUri, paramView.getResources().getString(R.string.uri_copied));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.uri.a
 * JD-Core Version:    0.6.2
 */