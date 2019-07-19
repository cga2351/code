package com.viber.voip.news;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ui.o;
import com.viber.voip.util.dz;

public class m extends o
{
  private i a;

  public m()
  {
    super(3);
  }

  protected void e()
  {
  }

  protected void h()
  {
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
      dz.a(localFragmentActivity.getIntent());
    super.onActivityCreated(paramBundle);
  }

  public boolean onBackPressed()
  {
    if (this.a != null)
      return (this.a.onBackPressed()) || (super.onBackPressed());
    return super.onBackPressed();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    if ((!g()) || (isDetached()) || (getActivity() == null))
      return;
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_home_screen_news, paramViewGroup, false);
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.a = null;
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    super.onFragmentVisibilityChanged(paramBoolean);
    if (this.a != null)
      this.a.onFragmentVisibilityChanged(paramBoolean);
  }

  public void onTabReselected()
  {
    super.onTabReselected();
    if (this.a != null)
      this.a.onTabReselected();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.a = ((i)getChildFragmentManager().findFragmentById(R.id.viber_news_browser_container));
  }

  protected void t()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.news.m
 * JD-Core Version:    0.6.2
 */