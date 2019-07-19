package com.viber.voip.backgrounds.ui;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.z;
import com.viber.voip.backgrounds.a.a;
import com.viber.voip.model.entity.h;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.d;
import com.viber.voip.ui.dialogs.f;
import com.viber.voip.util.cj;
import javax.inject.Inject;

public class CommunitySelectBackgroundActivity extends BackgroundGalleryActivity
  implements m.c, c
{

  @Inject
  CommunitySelectBackgroundPresenter g;

  private Bundle b(int paramInt)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putInt("bg_id", paramInt);
    return localBundle;
  }

  private Bundle c(Uri paramUri, String paramString)
  {
    Bundle localBundle = new Bundle(3);
    localBundle.putParcelable("custom_uri", paramUri);
    localBundle.putString("custom_img_change_type", paramString);
    return localBundle;
  }

  public void a(int paramInt)
  {
    d.l().a(this).a(b(paramInt)).a(this);
  }

  protected void a(Uri paramUri, String paramString)
  {
    this.g.a(paramUri, paramString);
  }

  protected void a(h paramh)
  {
    this.g.a(paramh);
  }

  public void a(boolean paramBoolean)
  {
    z.a(getSupportFragmentManager(), DialogCode.D_PROGRESS);
    if (paramBoolean)
      finish();
    while (!cj.c(this))
      return;
    f.d().d();
  }

  protected boolean a()
  {
    return false;
  }

  public void b()
  {
    ad.b().b(true).a(this).a(this);
  }

  public void b(Uri paramUri, String paramString)
  {
    d.l().a(this).a(c(paramUri, paramString)).a(this);
  }

  public void c()
  {
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    CommunitySelectBackgroundPresenter localCommunitySelectBackgroundPresenter = this.g;
    if (paramBundle != null);
    for (Parcelable localParcelable = paramBundle.getParcelable("presenter_state"); ; localParcelable = null)
    {
      localCommunitySelectBackgroundPresenter.a(this, localParcelable);
      return;
    }
  }

  protected void onDestroy()
  {
    this.g.a();
    super.onDestroy();
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D1036)) && (-1 == paramInt))
    {
      localBundle = (Bundle)paramm.d();
      localUri = (Uri)localBundle.getParcelable("custom_uri");
      if (localUri != null)
      {
        str = localBundle.getString("custom_img_change_type");
        localCommunitySelectBackgroundPresenter = this.g;
        if (str == null)
          str = "Gallery";
        localCommunitySelectBackgroundPresenter.b(localUri, str);
      }
    }
    while ((!paramm.a(DialogCode.D_PROGRESS)) || (-1000 != paramInt))
    {
      Bundle localBundle;
      Uri localUri;
      String str;
      CommunitySelectBackgroundPresenter localCommunitySelectBackgroundPresenter;
      return;
      this.g.a(localBundle.getInt("bg_id"));
      return;
    }
    this.g.c();
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.g.a(this.b.a(paramInt));
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("presenter_state", this.g.b());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.ui.CommunitySelectBackgroundActivity
 * JD-Core Version:    0.6.2
 */