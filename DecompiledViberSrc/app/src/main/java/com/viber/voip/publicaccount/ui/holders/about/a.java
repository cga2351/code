package com.viber.voip.publicaccount.ui.holders.about;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.jni.LocationInfo;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.k;
import com.viber.voip.publicaccount.d.d;
import com.viber.voip.util.da;

public class a extends com.viber.voip.publicaccount.ui.holders.b<AboutData, b>
  implements View.OnClickListener
{
  private final Resources c;
  private final a d;
  private LocationInfo e = null;

  public a(Resources paramResources, a parama)
  {
    this.c = paramResources;
    this.d = parama;
  }

  private void f()
  {
    LocationInfo localLocationInfo = ((AboutData)this.a).mLocationInfo;
    boolean bool = da.a(((AboutData)this.a).mAddress);
    b localb = (b)this.b;
    if (bool);
    for (String str = this.c.getString(R.string.message_type_location); ; str = ((AboutData)this.a).mAddress)
    {
      localb.b(str);
      if ((this.e != null) && ((localLocationInfo == null) || (!localLocationInfo.equals(this.e))))
        this.e = null;
      if ((this.e == null) && (localLocationInfo != null) && (bool))
      {
        this.e = localLocationInfo;
        ViberApplication.getInstance().getMessagesManager().d().a(localLocationInfo.lat(), localLocationInfo.lng(), ((AboutData)this.a).mGroupId, ((AboutData)this.a).mConversationId);
      }
      return;
    }
  }

  protected void a(b paramb, AboutData paramAboutData)
  {
    paramb.a(paramAboutData.mAbout);
    if (da.a(paramAboutData.mAddress))
      f();
    while (da.a(((AboutData)this.a).mWebsite))
    {
      ((b)this.b).b();
      if ((!d.i.a(((AboutData)this.a).mGroupRole, ((AboutData)this.a).mPublicGroupType)) || (!((AboutData)this.a).mIsAgeRestricted))
        break label194;
      ((b)this.b).c();
      return;
      paramb.b(paramAboutData.mAddress);
      this.e = null;
    }
    b localb = (b)this.b;
    String str = ((AboutData)this.a).mWebsite;
    boolean bool = ((AboutData)this.a).mIsPublished;
    Object localObject = null;
    if (!bool);
    while (true)
    {
      localb.a(str, (View.OnClickListener)localObject, ((AboutData)this.a).mIsPublished);
      break;
      localObject = this;
    }
    label194: ((b)this.b).d();
  }

  protected Class<b> b()
  {
    return b.class;
  }

  protected b c(View paramView)
  {
    return new c(paramView, this);
  }

  protected AboutData e()
  {
    return new AboutData();
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.location)
      this.d.b();
    while (i != R.id.website)
      return;
    this.d.c();
  }

  public static abstract interface a
  {
    public abstract void b();

    public abstract void c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.about.a
 * JD-Core Version:    0.6.2
 */