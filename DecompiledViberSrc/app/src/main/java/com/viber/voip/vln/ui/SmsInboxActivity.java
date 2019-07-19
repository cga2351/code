package com.viber.voip.vln.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.viber.voip.R.string;
import com.viber.voip.ui.BaseInboxActivity;
import com.viber.voip.util.cg;

public class SmsInboxActivity extends BaseInboxActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getSupportActionBar() != null)
    {
      String str = cg.a(this, getIntent().getStringExtra("to_number"));
      getSupportActionBar().b(str);
    }
    setDefaultTitle(R.string.vln_inbox);
  }

  protected Fragment onCreatePane()
  {
    return a.b(getIntent().getStringExtra("to_number"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.ui.SmsInboxActivity
 * JD-Core Version:    0.6.2
 */