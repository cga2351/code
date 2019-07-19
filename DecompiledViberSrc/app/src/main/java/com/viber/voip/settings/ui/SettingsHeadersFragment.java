package com.viber.voip.settings.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.notif.g;
import com.viber.voip.settings.a.a.b;
import com.viber.voip.settings.a.j;
import com.viber.voip.settings.a.j.a;
import com.viber.voip.ui.aq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsHeadersFragment extends aq
  implements j.a
{
  boolean a;
  private j b;
  private a c;
  private Fragment d = null;
  private int e = -1;
  private byte f = 0;
  private String g;
  private RecyclerView h;
  private g i;

  private void a(Context paramContext, boolean paramBoolean)
  {
    this.a = paramBoolean;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new a.b(paramContext, R.string.pref_category_account_key).a(R.string.settings_account).c(R.drawable.account_icon).a());
    localArrayList.add(new a.b(paramContext, R.string.pref_category_privacy_key).a(R.string.pref_category_privacy).c(R.drawable.privacy_icon).a());
    localArrayList.add(new a.b(paramContext, R.string.pref_category_notifications_key).a(R.string.pref_category_notifications).c(R.drawable.notification_icon).c(new ah(this)).a());
    localArrayList.add(new a.b(paramContext, R.string.pref_category_calls_and_messages_key).a(R.string.pref_category_calls_and_messages).c(R.drawable.messages_icon).a());
    localArrayList.add(new a.b(paramContext, R.string.pref_category_media_key).a(R.string.pref_category_media).c(R.drawable.media_icon).a());
    localArrayList.add(new a.b(paramContext, R.string.pref_category_display_key).a(R.string.pref_category_appearance).c(R.drawable.appearance_icon).a());
    localArrayList.add(new a.b(paramContext, R.string.pref_category_general_key).a(R.string.pref_category_general).c(R.drawable.general_icon).a());
    this.b = new j(paramContext, localArrayList, R.layout.settings_item, this.mIsTablet, this, getLayoutInflater());
  }

  private void a(Bundle paramBundle)
  {
    paramBundle.putByte("inner_screen", this.f);
    this.f = 0;
  }

  public static void a(FragmentManager paramFragmentManager, Fragment paramFragment)
  {
    List localList = paramFragmentManager.getFragments();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment1 = (Fragment)localIterator.next();
        if (localFragment1 != null)
        {
          Fragment localFragment2 = localFragment1.getTargetFragment();
          if ((localFragment2 != null) && (paramFragment != null) && (localFragment2.getClass().equals(paramFragment.getClass())))
            localFragment1.setTargetFragment(paramFragment, 0);
        }
      }
    }
  }

  private void c()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
    {
      boolean bool = this.i.i();
      if ((this.a != bool) && (this.b != null))
      {
        this.a = bool;
        int j = this.b.c(R.string.pref_category_notifications_key);
        if (-1 != j)
          this.b.notifyItemChanged(j);
      }
    }
  }

  public Fragment a(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    if (this.e == R.string.pref_category_privacy_key)
    {
      this.d = new y();
      a(localBundle);
    }
    while (true)
    {
      localBundle.putBoolean("restored", paramBoolean);
      this.d.setArguments(localBundle);
      return this.d;
      if (this.e == R.string.pref_category_notifications_key)
      {
        this.d = new v();
      }
      else if (this.e == R.string.pref_category_calls_and_messages_key)
      {
        this.d = new c();
      }
      else if (this.e == R.string.pref_category_media_key)
      {
        this.d = new u();
        a(localBundle);
      }
      else if (this.e == R.string.pref_category_display_key)
      {
        this.d = new i();
      }
      else if (this.e == R.string.pref_category_general_key)
      {
        this.d = new GeneralPreferenceFragment();
        a(localBundle);
        if (this.g != null)
          localBundle.putString("ui_language", this.g);
      }
      else if (this.e == R.string.pref_category_debug_key)
      {
        this.d = new d();
      }
      else if (this.e == R.string.pref_category_account_key)
      {
        this.d = new a();
      }
    }
  }

  public com.viber.voip.settings.a.a a(int paramInt)
  {
    if (this.b == null)
      a(ViberApplication.getApplication(), this.i.i());
    return this.b.d(paramInt);
  }

  public void a()
  {
    if (getView() == null);
    int j;
    do
    {
      do
        return;
      while (this.e == -1);
      j = this.b.c(this.e);
    }
    while (j == -1);
    this.b.b(j);
  }

  public void a(byte paramByte)
  {
    this.f = paramByte;
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.c.a(paramInt2, this.e);
  }

  public void a(String paramString)
  {
    this.g = paramString;
  }

  public void b(int paramInt)
  {
    this.e = paramInt;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a();
  }

  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    if (!(paramContext instanceof a))
      throw new ClassCastException("Activity must implement fragment's callbacks.");
    this.c = ((a)paramContext);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.i = g.a(ViberApplication.getApplication());
    FragmentActivity localFragmentActivity = getActivity();
    if ((this.b == null) && (localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
      a(localFragmentActivity, this.i.i());
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.activity_preference, paramViewGroup, false);
    this.h = ((RecyclerView)localView.findViewById(R.id.list));
    this.h.setAdapter(this.b);
    return localView;
  }

  public void onDestroyView()
  {
    this.e = -1;
    this.h = null;
    super.onDestroyView();
  }

  public void onStart()
  {
    super.onStart();
    c();
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.SettingsHeadersFragment
 * JD-Core Version:    0.6.2
 */