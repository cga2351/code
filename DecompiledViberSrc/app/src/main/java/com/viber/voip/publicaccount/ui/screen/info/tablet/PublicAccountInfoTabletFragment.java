package com.viber.voip.publicaccount.ui.screen.info.tablet;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.a;
import android.view.MenuItem;
import android.view.View;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.publicaccount.ui.screen.info.PublicAccountInfoFragment;
import com.viber.voip.widget.toolbar.c;

public class PublicAccountInfoTabletFragment extends PublicAccountInfoFragment
{
  private View S;

  protected void P()
  {
    ((AppCompatActivity)getActivity()).getSupportActionBar().m();
  }

  protected void a(View paramView)
  {
  }

  protected void b(View paramView)
  {
    this.Q = new c((AppCompatActivity)getActivity());
  }

  protected void c(View paramView)
  {
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.S.getLayoutParams().height = ((int)getResources().getDimension(R.dimen.public_account_info_icon_height));
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return onMenuItemClick(paramMenuItem);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.S = paramView.findViewById(R.id.icon);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.screen.info.tablet.PublicAccountInfoTabletFragment
 * JD-Core Version:    0.6.2
 */