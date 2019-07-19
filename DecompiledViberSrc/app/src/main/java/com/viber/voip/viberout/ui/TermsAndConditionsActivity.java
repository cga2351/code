package com.viber.voip.viberout.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.viber.common.b.b;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.ViberApplication;
import com.viber.voip.market.MarketPublicGroupInfo;
import com.viber.voip.market.b.a;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.controller.publicaccount.ae;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationData;
import com.viber.voip.messages.k;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.settings.d.ap;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.dz;

public class TermsAndConditionsActivity extends GenericWebViewActivity
{
  private boolean a;

  public static Intent a(Activity paramActivity, String paramString1, String paramString2, String paramString3, PublicGroupConversationData paramPublicGroupConversationData, a parama, ae paramae)
  {
    Intent localIntent = new Intent(paramActivity, TermsAndConditionsActivity.class);
    localIntent.putExtra("extra_url", paramString1);
    localIntent.putExtra("extra_title", paramString2);
    localIntent.putExtra("groupData", paramPublicGroupConversationData);
    localIntent.putExtra("action", parama.name());
    localIntent.putExtra("url_sheme", paramString3);
    if (paramae != null)
      localIntent.putExtra("follow_source", paramae);
    return localIntent;
  }

  public static void b(Activity paramActivity, String paramString1, String paramString2, String paramString3, PublicGroupConversationData paramPublicGroupConversationData, a parama, ae paramae)
  {
    dz.a(paramActivity, a(paramActivity, paramString1, paramString2, paramString3, paramPublicGroupConversationData, parama, paramae));
  }

  private void f()
  {
    d.ap.b.a(false);
    Intent localIntent1 = getIntent();
    a locala = a.valueOf(localIntent1.getStringExtra("action"));
    PublicGroupConversationData localPublicGroupConversationData = (PublicGroupConversationData)localIntent1.getParcelableExtra("groupData");
    ae localae = (ae)localIntent1.getSerializableExtra("follow_source");
    switch (1.a[locala.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    while (true)
    {
      finish();
      return;
      new a().a(new MarketPublicGroupInfo(localPublicGroupConversationData), false, true, localae);
      continue;
      new a().a(new MarketPublicGroupInfo(localPublicGroupConversationData), false, true, localae);
      startActivity(ViberActionRunner.aq.a(this, false, localPublicGroupConversationData.publicGroupInfo.hasPublicChat(), localPublicGroupConversationData));
      continue;
      ViberActionRunner.aq.a(this, localPublicGroupConversationData);
      continue;
      String str = localPublicGroupConversationData.publicAccountId;
      if (str != null)
        ViberApplication.getInstance().getMessagesManager().d().a(ViberApplication.getInstance().getEngine(true).getPhoneController().generateSequence(), localPublicGroupConversationData.groupId, localPublicGroupConversationData.publicGroupInfo.getGroupUri(), localPublicGroupConversationData.groupName, localPublicGroupConversationData.publicGroupInfo.getIcon(), str, localPublicGroupConversationData.invitationToken, localPublicGroupConversationData.invitationNumber, false, localae);
      if (localIntent1.getStringExtra("url_sheme") != null)
      {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(localIntent1.getStringExtra("url_sheme"))));
        continue;
        Intent localIntent2 = new Intent();
        localIntent2.putExtra("data", (Bundle)localIntent1.getParcelableExtra("data"));
        setResult(-1, localIntent2);
      }
    }
  }

  public void a()
  {
    this.a = true;
    invalidateOptionsMenu();
  }

  public void onBackPressed()
  {
    PublicGroupConversationData localPublicGroupConversationData = (PublicGroupConversationData)getIntent().getParcelableExtra("groupData");
    if (localPublicGroupConversationData != null)
      o.a().b(0, localPublicGroupConversationData.groupId, 2, -3);
    super.onBackPressed();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_terms_and_conditions, paramMenu);
    MenuItem localMenuItem = paramMenu.findItem(R.id.menu_accept);
    if (this.a)
      localMenuItem.setVisible(true);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (R.id.menu_accept == paramMenuItem.getItemId())
    {
      f();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[7];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.TermsAndConditionsActivity
 * JD-Core Version:    0.6.2
 */