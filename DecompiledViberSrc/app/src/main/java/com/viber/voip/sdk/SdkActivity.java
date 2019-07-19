package com.viber.voip.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import com.viber.voip.ViberApplication;
import com.viber.voip.block.k;
import com.viber.voip.block.k.a;
import com.viber.voip.contacts.c.c.c.a;
import com.viber.voip.contacts.ui.ContactsFragment.a;
import com.viber.voip.contacts.ui.ContactsFragment.b;
import com.viber.voip.contacts.ui.ContactsFragment.d;
import com.viber.voip.messages.extras.a.e;
import com.viber.voip.messages.ui.bk.a;
import com.viber.voip.permissions.f;
import com.viber.voip.permissions.l;
import com.viber.voip.permissions.m;
import com.viber.voip.phone.call.DialerPendingController;
import com.viber.voip.user.more.MoreFragment.Callbacks;
import com.viber.voip.w;
import com.viber.voip.w.a;
import com.viber.voip.z;
import javax.inject.Inject;

public abstract class SdkActivity extends AppCompatActivity
  implements k.a, c.a, ContactsFragment.a, ContactsFragment.b, ContactsFragment.d, bk.a, l, MoreFragment.Callbacks, w.a, z
{

  @Inject
  protected com.viber.voip.app.b a;

  @Inject
  com.viber.common.permission.c b;

  @Inject
  w c;

  @Inject
  com.viber.voip.contacts.c.c.b d;

  @Inject
  k e;

  @Inject
  dagger.a<DialerPendingController> f;

  @Inject
  dagger.a<e> g;

  @Inject
  dagger.a<com.viber.voip.messages.extras.c.a> h;

  @Inject
  dagger.a<com.viber.voip.messages.d.b> i;

  @Inject
  dagger.a<com.viber.voip.analytics.story.d.c> j;

  @Inject
  dagger.a<com.viber.voip.analytics.story.b.c> k;
  private final com.viber.common.permission.b l;

  public SdkActivity()
  {
    Pair[] arrayOfPair = new Pair[4];
    arrayOfPair[0] = m.a(58);
    arrayOfPair[1] = m.a(39);
    arrayOfPair[2] = m.a(78);
    arrayOfPair[3] = m.a(94);
    this.l = new f(this, arrayOfPair)
    {
      public void onPermissionsDenied(int paramAnonymousInt, boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString1, String[] paramAnonymousArrayOfString2, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
        case 94:
        }
        do
        {
          super.onPermissionsDenied(paramAnonymousInt, paramAnonymousBoolean, paramAnonymousArrayOfString1, paramAnonymousArrayOfString2, paramAnonymousObject);
          return;
        }
        while (!paramAnonymousBoolean);
      }

      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
        case 58:
        case 39:
        }
        do
        {
          do
            return;
          while (!(paramAnonymousObject instanceof String));
          ((DialerPendingController)SdkActivity.this.f.get()).handlePendingDial((String)paramAnonymousObject, false, false);
          return;
        }
        while (!(paramAnonymousObject instanceof String));
        ((DialerPendingController)SdkActivity.this.f.get()).handlePendingDial((String)paramAnonymousObject, true, false);
      }
    };
  }

  protected abstract Fragment a();

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ((e)this.g.get()).a(this, paramInt1, paramInt2, paramIntent);
    ((com.viber.voip.messages.extras.c.a)this.h.get()).a(paramInt1, paramInt2, paramIntent);
  }

  public void onBackPressed()
  {
    Fragment localFragment = a();
    if (((localFragment instanceof com.viber.voip.app.a)) && (((com.viber.voip.app.a)localFragment).onBackPressed()))
      return;
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    ViberApplication.getInstance().getAppComponent().a(this);
    super.onCreate(paramBundle);
  }

  protected void onPause()
  {
    super.onPause();
    e.d(this);
    this.d.b(this);
    this.e.b(this);
  }

  protected void onResume()
  {
    super.onResume();
    e.c(this);
    this.d.a(this);
    this.e.a(this);
  }

  public boolean onSearchRequested()
  {
    Fragment localFragment = a();
    if (((localFragment instanceof com.viber.voip.b)) && (((com.viber.voip.b)localFragment).onActivitySearchRequested()))
      return true;
    return super.onSearchRequested();
  }

  protected void onStart()
  {
    super.onStart();
    this.c.a(this);
    this.b.a(this.l);
  }

  protected void onStop()
  {
    super.onStop();
    this.c.a();
    this.b.b(this.l);
  }

  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new c(this, paramArrayOfIntent, paramBundle), paramArrayOfIntent);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new a(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    com.viber.common.app.a.a(new b(this, paramIntent, paramInt), new Intent[] { paramIntent });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sdk.SdkActivity
 * JD-Core Version:    0.6.2
 */