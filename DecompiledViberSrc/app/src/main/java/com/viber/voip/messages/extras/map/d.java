package com.viber.voip.messages.extras.map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.SupportMapFragment;
import com.viber.common.app.a;

public class d extends SupportMapFragment
{
  private View a;
  private g b;
  private a c;

  public g a()
  {
    return this.b;
  }

  public View getView()
  {
    return this.a;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.c.a(paramBundle);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      this.c = ((a)paramActivity);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
    }
    throw new ClassCastException(paramActivity.toString() + " must implement " + a.class.getSimpleName());
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.b = new g(getActivity());
    this.b.addView(this.a);
    return this.b;
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    a.a(new e(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    a.a(new f(this, paramIntent, paramInt, paramBundle), new Intent[] { paramIntent });
  }

  public static abstract interface a
  {
    public abstract void a(Bundle paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extras.map.d
 * JD-Core Version:    0.6.2
 */