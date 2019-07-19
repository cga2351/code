package com.viber.voip.registration.changephonenumber;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.m.h;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.controller.ci.a;
import com.viber.voip.messages.k;
import com.viber.voip.permissions.b;
import com.viber.voip.permissions.c.a;
import com.viber.voip.registration.CountryCode;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.registration.ac;
import com.viber.voip.registration.ac.b;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.registration.l;
import com.viber.voip.registration.v;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.t;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cg;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

public class ChangePhoneNumberEnterNewNumberFragment extends a
  implements View.OnClickListener, m.c, m.h, c.a, ac.b
{
  private final Logger c = ViberEnv.getLogger();
  private ac d;
  private Button e;
  private PhoneController f;
  private af g;
  private PhoneNumberInfo h;
  private com.viber.common.permission.c i;
  private com.viber.voip.permissions.c j;

  public void a(Intent paramIntent, int paramInt)
  {
    startActivityForResult(paramIntent, paramInt);
  }

  void a(com.viber.voip.model.entity.m paramm, boolean paramBoolean)
  {
    String str1 = paramm.o();
    Uri localUri1 = paramm.p();
    UserManager localUserManager = UserManager.from(getActivity());
    UserData localUserData = localUserManager.getUserData();
    Uri localUri2 = localUserData.getImage();
    String str2 = localUserData.getViberName();
    if (da.a(str2))
      str2 = localUserManager.getRegistrationValues().h();
    ad.w().a(this).a(new VerifyAccountDialogData(str2, localUri2, str1, localUri1, paramBoolean)).b(this);
  }

  protected void a(PhoneNumberInfo paramPhoneNumberInfo)
  {
    String str = cg.a(getContext(), paramPhoneNumberInfo.getCountyIddCode(), paramPhoneNumberInfo.phoneNumber, paramPhoneNumberInfo.getCanonizedPhoneNumberWithPlus());
    if (ao.f());
    for (l.a locala = com.viber.voip.ui.dialogs.a.d(str); ; locala = com.viber.voip.ui.dialogs.a.c(str))
    {
      locala.a(this).b(this);
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.e.setEnabled(paramBoolean);
  }

  public void aa_()
  {
    CountryCode localCountryCode = this.d.a();
    String str1 = this.d.b();
    localCountryCode.getName();
    String str2 = this.f.canonizePhoneNumberForCountryCode(Integer.parseInt(localCountryCode.getIddCode()), str1);
    this.h = new PhoneNumberInfo(localCountryCode, str1, str2);
    if (!new v().a(localCountryCode.getIddCode(), str1))
    {
      com.viber.voip.ui.dialogs.a.a().b(this);
      return;
    }
    String str3 = this.f.canonizePhoneNumber(this.g.f());
    if ((!da.a(str2)) && (str2.equals(str3)))
    {
      t.q().b(this);
      return;
    }
    a(this.h);
  }

  void b(boolean paramBoolean)
  {
    this.b.a(this.h.countryCode, this.h.phoneNumber, paramBoolean);
  }

  void c(boolean paramBoolean)
  {
    this.b.b(this.h.countryCode, this.h.phoneNumber, paramBoolean);
  }

  public void f_(final boolean paramBoolean)
  {
    if (!cj.a(this, true))
      return;
    ViberApplication.getInstance().getMessagesManager().e().b(this.h.getCanonizedPhoneNumberWithPlus(), new ci.a()
    {
      public void onGetUserDetail(com.viber.voip.model.entity.m[] paramAnonymousArrayOfm)
      {
        ChangePhoneNumberEnterNewNumberFragment.this.a(paramAnonymousArrayOfm[0], paramBoolean);
      }

      public void onGetUserError()
      {
        ChangePhoneNumberEnterNewNumberFragment.this.c(paramBoolean);
      }
    }
    , false);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (paramBundle != null)
    {
      this.h = ((PhoneNumberInfo)paramBundle.getParcelable("phone_number_info"));
      if (this.h == null)
        this.d.b(null, null);
    }
    while (true)
    {
      this.i = com.viber.common.permission.c.a(getActivity());
      this.j = new b(this, this.i, this);
      return;
      this.d.b(this.h.countryCode, this.h.phoneNumber);
      continue;
      this.d.c();
    }
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.d.a(paramInt1, paramInt2, paramIntent);
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.btn_continue)
      aa_();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.fragment_change_phone_enter_number_new_number, paramViewGroup, false);
    this.f = ViberApplication.getInstance().getEngine(false).getPhoneController();
    this.g = UserManager.from(ViberApplication.getApplication()).getRegistrationValues();
    this.e = ((Button)localView.findViewById(R.id.btn_continue));
    this.e.setOnClickListener(this);
    ((TextView)localView.findViewById(R.id.my_current_number)).setText(cg.a(getContext(), this.g.b(), this.g.f(), this.g.h()));
    l locall = ViberApplication.getInstance().getCountryCodeManager();
    HardwareParameters localHardwareParameters = ViberApplication.getInstance().getHardwareParameters();
    if ((paramBundle == null) && (localHardwareParameters.isSimChanged()))
    {
      localHardwareParameters.updatePhoneRelatedInfo();
      locall.e();
    }
    this.d = new ac(getActivity(), localView, locall, this);
    return localView;
  }

  public void onDestroy()
  {
    this.d.d();
    super.onDestroy();
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D105)) || (paramm.a(DialogCode.D105e)))
      switch (paramInt)
      {
      default:
      case -1:
      }
    while (true)
    {
      this.j.onDialogAction(paramm, paramInt);
      return;
      dj.d(getActivity());
      this.j.a();
      continue;
      if (paramm.a(DialogCode.D402i))
      {
        VerifyAccountDialogData localVerifyAccountDialogData = (VerifyAccountDialogData)paramm.d();
        switch (paramInt)
        {
        default:
          break;
        case -1:
          b(localVerifyAccountDialogData.isTzintukEnabled);
        }
      }
    }
  }

  public void onPrepareDialogView(final com.viber.common.dialogs.m paramm, View paramView, int paramInt)
  {
    if (paramm.a(DialogCode.D_CPN_VERIFY_ACCOUNT))
    {
      final VerifyAccountDialogData localVerifyAccountDialogData = (VerifyAccountDialogData)paramm.d();
      ImageView localImageView1 = (ImageView)paramView.findViewById(R.id.current_account_icon);
      TextView localTextView1 = (TextView)paramView.findViewById(R.id.current_account_name);
      ImageView localImageView2 = (ImageView)paramView.findViewById(R.id.other_account_icon);
      TextView localTextView2 = (TextView)paramView.findViewById(R.id.other_account_name);
      paramView.findViewById(R.id.select_current_account).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ChangePhoneNumberEnterNewNumberFragment.this.c(localVerifyAccountDialogData.isTzintukEnabled);
          paramm.dismiss();
        }
      });
      paramView.findViewById(R.id.select_other_account).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          t.c(ChangePhoneNumberEnterNewNumberFragment.a(ChangePhoneNumberEnterNewNumberFragment.this).h()).a(localVerifyAccountDialogData).a(ChangePhoneNumberEnterNewNumberFragment.this).b(ChangePhoneNumberEnterNewNumberFragment.this);
          paramm.dismiss();
        }
      });
      localTextView1.setText(localVerifyAccountDialogData.currentAccountName);
      localTextView2.setText(localVerifyAccountDialogData.otherAccountName);
      e locale = e.a(paramm.getContext());
      f localf = f.a(R.drawable.generic_image_70x70);
      locale.a(localVerifyAccountDialogData.currentAccountPhoto, localImageView1, localf);
      locale.a(localVerifyAccountDialogData.otherAccountPhoto, localImageView2, localf);
      return;
    }
    super.onPrepareDialogView(paramm, paramView, paramInt);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("phone_number_info", this.h);
    super.onSaveInstanceState(paramBundle);
  }

  public void onStart()
  {
    super.onStart();
    this.i.a(this.j);
  }

  public void onStop()
  {
    super.onStop();
    this.i.b(this.j);
  }

  static class VerifyAccountDialogData
    implements Parcelable
  {
    public static final Parcelable.Creator<VerifyAccountDialogData> CREATOR = new Parcelable.Creator()
    {
      public ChangePhoneNumberEnterNewNumberFragment.VerifyAccountDialogData a(Parcel paramAnonymousParcel)
      {
        return new ChangePhoneNumberEnterNewNumberFragment.VerifyAccountDialogData(paramAnonymousParcel);
      }

      public ChangePhoneNumberEnterNewNumberFragment.VerifyAccountDialogData[] a(int paramAnonymousInt)
      {
        return new ChangePhoneNumberEnterNewNumberFragment.VerifyAccountDialogData[paramAnonymousInt];
      }
    };
    public final String currentAccountName;
    public final Uri currentAccountPhoto;
    public final boolean isTzintukEnabled;
    public final String otherAccountName;
    public final Uri otherAccountPhoto;

    VerifyAccountDialogData(Parcel paramParcel)
    {
      this.currentAccountName = paramParcel.readString();
      this.otherAccountName = paramParcel.readString();
      if (paramParcel.readInt() != 0);
      for (boolean bool = true; ; bool = false)
      {
        this.isTzintukEnabled = bool;
        this.currentAccountPhoto = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
        this.otherAccountPhoto = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
        return;
      }
    }

    VerifyAccountDialogData(String paramString1, Uri paramUri1, String paramString2, Uri paramUri2, boolean paramBoolean)
    {
      this.currentAccountName = paramString1;
      this.currentAccountPhoto = paramUri1;
      this.otherAccountName = paramString2;
      this.otherAccountPhoto = paramUri2;
      this.isTzintukEnabled = paramBoolean;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.currentAccountName);
      paramParcel.writeString(this.otherAccountName);
      if (this.isTzintukEnabled);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeInt(i);
        paramParcel.writeParcelable(this.currentAccountPhoto, paramInt);
        paramParcel.writeParcelable(this.otherAccountPhoto, paramInt);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.changephonenumber.ChangePhoneNumberEnterNewNumberFragment
 * JD-Core Version:    0.6.2
 */