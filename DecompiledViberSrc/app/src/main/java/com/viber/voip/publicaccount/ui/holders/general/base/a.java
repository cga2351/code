package com.viber.voip.publicaccount.ui.holders.general.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Address;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView.OnEditorActionListener;
import com.viber.dexshared.Logger;
import com.viber.jni.LocationInfo;
import com.viber.voip.R.id;
import com.viber.voip.R.integer;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.messages.extras.b.a.b;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.cb;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.validation.FormValidator;
import com.viber.voip.validation.FormValidator.a;
import com.viber.voip.validation.FormValidator.b;
import com.viber.voip.validation.a.i;
import com.viber.voip.widget.ViewWithDescription.a;
import com.viber.voip.widget.ad;

public abstract class a<D extends GeneralData, V extends e> extends PublicAccountEditUIHolder<D, V>
  implements View.OnClickListener, cb
{
  private static final Logger h = ViberEnv.getLogger();
  protected final Fragment c;
  protected final Handler d;
  protected final Handler e;
  protected final boolean f;
  protected final TextView.OnEditorActionListener g;
  private Context i;
  private final com.viber.voip.publicaccount.ui.holders.d j;
  private FormValidator k;

  protected a(Fragment paramFragment, com.viber.voip.publicaccount.ui.holders.d paramd, boolean paramBoolean)
  {
    this.c = paramFragment;
    this.d = av.e.a.a();
    this.e = av.e.f.a();
    this.j = paramd;
    this.f = paramBoolean;
    this.i = ViberApplication.getApplication();
    this.g = e();
  }

  private void a(Intent paramIntent)
  {
    if (paramIntent != null)
      a(paramIntent.getIntExtra("extra_location_lat", 0) / 1000000.0D, paramIntent.getIntExtra("extra_location_lon", 0) / 1000000.0D);
  }

  private void a(String paramString)
  {
    ((e)this.b).a(paramString);
    GeneralData localGeneralData;
    boolean bool;
    if (!da.a(paramString))
    {
      ((GeneralData)this.a).mLocationStatus = ViewWithDescription.a.a;
      ((e)this.b).a(((GeneralData)this.a).mLocationStatus);
      localGeneralData = (GeneralData)this.a;
      if ((((GeneralData)this.a).mLocationInfo != null) && (!da.a(((GeneralData)this.a).mCountryCode)))
        bool = true;
    }
    for (localGeneralData.mValidLocation = bool; ; ((GeneralData)this.a).mValidLocation = false)
    {
      g();
      return;
      bool = false;
      break;
    }
  }

  private void j()
  {
    GeneralData localGeneralData = (GeneralData)this.a;
    if (da.a(((GeneralData)this.a).mAddress));
    for (ViewWithDescription.a locala = ViewWithDescription.a.d; ; locala = ViewWithDescription.a.a)
    {
      localGeneralData.mLocationStatus = locala;
      ((e)this.b).a(((GeneralData)this.a).mLocationStatus);
      ViberApplication.getInstance().getLocationManager().a(1, new b(this));
      return;
    }
  }

  protected V a(V paramV)
  {
    paramV.a(new InputFilter.LengthFilter(this.c.getResources().getInteger(R.integer.public_group_about_max_length)), this.g);
    paramV.a(this, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (cj.a(true))
          a.a(a.this);
      }
    });
    paramV.a(this.g);
    paramV.b(this.g);
    return paramV;
  }

  public void a()
  {
    super.a();
    if (this.k != null)
      this.k.b();
  }

  protected void a(double paramDouble1, double paramDouble2)
  {
    a(paramDouble1, paramDouble2, null);
  }

  protected void a(final double paramDouble1, double paramDouble2, final Bundle paramBundle)
  {
    if (!cj.b(ViberApplication.getApplication()))
    {
      FragmentActivity localFragmentActivity = this.c.getActivity();
      if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
        localFragmentActivity.runOnUiThread(new c(this));
      return;
    }
    ViberApplication.getInstance().getLocationManager().a(1, paramDouble1, paramDouble2, true, true, new a.b()
    {
      protected String a(Address paramAnonymousAddress)
      {
        String str = UserManager.from(ViberApplication.getApplication()).getRegistrationValues().e().toUpperCase();
        if ((paramAnonymousAddress == null) || (da.a(paramAnonymousAddress.getCountryCode())))
          return str;
        return paramAnonymousAddress.getCountryCode();
      }

      public void a(Address paramAnonymousAddress, String paramAnonymousString)
      {
        FragmentActivity localFragmentActivity = a.this.c.getActivity();
        if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
        {
          ((GeneralData)a.c(a.this)).mCountryCode = a(paramAnonymousAddress);
          if (((GeneralData)a.d(a.this)).mCountryCode == null)
          {
            ((GeneralData)a.e(a.this)).mAddress = null;
            ((GeneralData)a.f(a.this)).mLocationInfo = null;
            a.a(a.this, "");
            return;
          }
          ((GeneralData)a.g(a.this)).mAddress = paramAnonymousString;
          ((GeneralData)a.h(a.this)).mLocationInfo = new LocationInfo((int)(10000000.0D * paramDouble1), (int)(10000000.0D * paramBundle));
          ((GeneralData)a.i(a.this)).mLocationStatus = ViewWithDescription.a.a;
          ((e)a.k(a.this)).a(((GeneralData)a.j(a.this)).mLocationStatus);
          if ((this.c != null) && (!da.a(this.c.getString("countryName"))))
          {
            a.a(a.this, this.c.getString("countryName"));
            return;
          }
          a locala = a.this;
          if (da.a(paramAnonymousString))
            paramAnonymousString = a.this.c.getString(R.string.message_type_location);
          a.a(locala, paramAnonymousString);
          return;
        }
        a.a(a.this, "");
      }
    });
  }

  protected void a(D paramD, V paramV)
  {
    paramV.b(paramD);
    paramD.mValidatorState = this.k.a();
  }

  protected final void a(V paramV, D paramD)
  {
    FormValidator.a locala = new FormValidator.a();
    a(paramV, paramD, locala);
    locala.a(new com.viber.voip.validation.d()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        a.this.g();
      }
    });
    this.k = locala.a();
    paramV.a(paramD);
    if (paramD.mValidatorState != null)
      this.k.a(paramD.mValidatorState);
    this.d.post(new Runnable()
    {
      public void run()
      {
        a.b(a.this).c();
      }
    });
    a(((GeneralData)this.a).mAddress);
    j();
  }

  protected void a(V paramV, D paramD, FormValidator.a parama)
  {
    com.viber.voip.validation.a.a locala = new com.viber.voip.validation.a.a(this.i);
    locala.a(this.e);
    locala.a(400L);
    i locali = new i();
    locali.a(this.e);
    locali.a(400L);
    com.viber.voip.validation.a.b localb = new com.viber.voip.validation.a.b();
    localb.a(this.e);
    localb.a(400L);
    if (this.f);
    for (FormValidator.b localb1 = FormValidator.b.b; ; localb1 = FormValidator.b.a)
    {
      parama.a(locala, localb1).a(locali, localb1).a(localb, localb1);
      paramV.a(locala, locali, localb);
      return;
    }
  }

  public boolean a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 102)
    {
      if (paramInt2 != 0)
        a(paramIntent);
      return true;
    }
    return false;
  }

  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    g();
  }

  protected TextView.OnEditorActionListener e()
  {
    return new ad();
  }

  protected boolean f()
  {
    return (this.k.e()) && (((GeneralData)this.a).mValidLocation);
  }

  protected void g()
  {
    boolean bool = f();
    if (bool != ((GeneralData)this.a).mAllFieldsValid)
      ((GeneralData)this.a).mAllFieldsValid = bool;
    this.j.a(this, ((GeneralData)this.a).mAllFieldsValid);
  }

  public void onClick(View paramView)
  {
    Intent localIntent;
    if (paramView.getId() == R.id.location)
    {
      localIntent = ViberActionRunner.a(this.c.getContext(), 1, true);
      if (localIntent == null)
        ViberApplication.getInstance().showToast(paramView.getContext().getString(R.string.toast_maps_lib_missing));
    }
    else
    {
      return;
    }
    this.c.startActivityForResult(localIntent, 102);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.general.base.a
 * JD-Core Version:    0.6.2
 */