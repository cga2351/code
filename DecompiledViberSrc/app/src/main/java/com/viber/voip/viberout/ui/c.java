package com.viber.voip.viberout.ui;

import android.support.v4.app.FragmentActivity;
import android.support.v4.util.Pair;
import android.widget.Toast;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.z;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.billing.b;
import com.viber.voip.billing.b.c;
import com.viber.voip.billing.b.q;
import com.viber.voip.contacts.b.b;
import com.viber.voip.contacts.ui.ParticipantSelector;
import com.viber.voip.contacts.ui.s;
import com.viber.voip.contacts.ui.x;
import com.viber.voip.ui.ac;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.af;
import com.viber.voip.ui.dialogs.f;
import com.viber.voip.util.da;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends s
{
  private static final Logger a = ViberEnv.getLogger();
  private List<a> b = new ArrayList();

  private void a(b.c paramc)
  {
    if (!isAdded())
      return;
    if ((paramc == null) || (!paramc.a()))
    {
      f.d().b(this);
      return;
    }
    JSONObject localJSONObject1 = paramc.d();
    this.b.clear();
    if (localJSONObject1 != null)
    {
      JSONArray localJSONArray = localJSONObject1.optJSONArray("invites");
      if ((localJSONArray == null) || (localJSONArray.length() == 0))
      {
        f.d().b(this);
        return;
      }
      int i = 0;
      try
      {
        while (i < localJSONArray.length())
        {
          JSONObject localJSONObject2 = localJSONArray.getJSONObject(i);
          this.b.add(new a(localJSONObject2.optString("phone_number"), localJSONObject2.optInt("status")));
          i++;
        }
      }
      catch (JSONException localJSONException)
      {
      }
    }
    a(this.b);
  }

  private void a(List<a> paramList)
  {
    Iterator localIterator = paramList.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (((a)localIterator.next()).b == 2);
    for (int i = 0; ; i = 1)
    {
      if (i != 0)
      {
        if (paramList.size() > 1);
        for (boolean bool = true; ; bool = false)
        {
          af.b(bool).b(this);
          return;
        }
      }
      getActivity().setResult(-1);
      getActivity().finish();
      return;
    }
  }

  protected boolean canAddCustomNumber()
  {
    return false;
  }

  protected boolean considerHimself()
  {
    return false;
  }

  protected void handleDone()
  {
    ad.a(R.string.generic_please_wait_dialog_text).b(false).b(this);
    Set localSet = this.mParticipantSelector.f();
    b.a().a(localSet, new b.q()
    {
      public void a(b.c paramAnonymousc)
      {
        z.a(c.this, DialogCode.D_PROGRESS);
        c.a(c.this, paramAnonymousc);
      }
    });
  }

  public void onDetach()
  {
    super.onDetach();
    if (this.mParticipantsLimitToast != null)
      this.mParticipantsLimitToast.cancel();
  }

  protected Pair<Boolean, String> shouldShowToast()
  {
    return new Pair(Boolean.valueOf(true), String.valueOf(this.mTotalParticipants));
  }

  protected void updateEmptyScreen()
  {
    x localx = this.mActivityWrapper;
    b.b localb = b.b.b;
    int i = this.mSyncState;
    if (!da.a(this.mSearchMediator.a()));
    for (boolean bool = true; ; bool = false)
    {
      localx.a(localb, i, true, bool, false);
      return;
    }
  }

  static class a
  {
    String a;
    int b;

    public a(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.c
 * JD-Core Version:    0.6.2
 */