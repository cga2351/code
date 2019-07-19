package com.viber.voip.gdpr.ui.iabconsent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.viber.voip.R.string;
import com.viber.voip.app.ViberSingleFragmentActivity;

public class ConsentActivity extends ViberSingleFragmentActivity
{
  protected Fragment onCreatePane()
  {
    int i = 1;
    Bundle localBundle = new Bundle(i);
    int k = getIntent().getIntExtra("ConsentActivity.ScreenId", 0);
    localBundle.putInt("ConsentActivity.ScreenId", k);
    android.support.v7.app.a locala = getSupportActionBar();
    if (k == 2)
    {
      locala.b(i);
      setDefaultTitle(R.string.gdpr_consent_screen_header);
      switch (k)
      {
      default:
      case 1:
      case 2:
      }
    }
    for (Object localObject = new a(); ; localObject = new g())
    {
      ((Fragment)localObject).setArguments(localBundle);
      return localObject;
      int j = 0;
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.ui.iabconsent.ConsentActivity
 * JD-Core Version:    0.6.2
 */