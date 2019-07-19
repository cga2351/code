package com.viber.voip.messages.ui.forward;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.MenuItem;
import com.viber.common.permission.b;
import com.viber.common.permission.c;
import com.viber.voip.R.string;
import com.viber.voip.analytics.g;
import com.viber.voip.api.scheme.action.OpenChatExtensionAction.Description;
import com.viber.voip.contacts.ui.ContactsFragment.a;
import com.viber.voip.contacts.ui.MultiTabsParticipantSelectorActivity;
import com.viber.voip.contacts.ui.s;
import com.viber.voip.messages.controller.publicaccount.SendRichMessageRequest;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.view.ScreenshotConversationData;
import com.viber.voip.messages.extras.wink.WinkDescription;
import com.viber.voip.messages.ui.media.ComposeDataContainer;
import com.viber.voip.news.NewsShareAnalyticsData;
import com.viber.voip.permissions.f;
import com.viber.voip.permissions.k;
import com.viber.voip.permissions.l;
import com.viber.voip.permissions.n;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.util.ae;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import javax.inject.Inject;

public class ForwardActivity extends MultiTabsParticipantSelectorActivity
  implements ContactsFragment.a, l
{
  private d A;
  private b B;
  private Bundle C;

  @Inject
  ForwardPresenter d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private long[] i;
  private int j;
  private int k;
  private ArrayList<Uri> l;
  private String m;
  private String n;
  private String o;
  private boolean p = true;
  private boolean q;
  private int r;
  private ComposeDataContainer s;
  private NewsShareAnalyticsData t;
  private WinkDescription u;
  private String v;
  private OpenChatExtensionAction.Description w;
  private SendRichMessageRequest x;
  private c y;
  private ScreenshotConversationData z;

  public ForwardActivity()
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(134);
    this.B = new f(this, arrayOfPair)
    {
      public void onCustomDialogAction(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        if (DialogCode.D_EXPLAIN_PERMISSION.code().equals(paramAnonymousString))
          if (paramAnonymousInt2 != -1)
            ForwardActivity.this.finish();
        while ((!DialogCode.D_ASK_PERMISSION.code().equals(paramAnonymousString)) || (paramAnonymousInt2 == -1))
          return;
        ForwardActivity.this.finish();
      }

      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
      }
    };
  }

  private void e(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    String str;
    if (localBundle != null)
    {
      this.e = localBundle.getBoolean("external_share");
      this.l = localBundle.getParcelableArrayList("share_files_uri");
      this.m = localBundle.getString("share_uri");
      this.p = localBundle.getBoolean("need_description", true);
      this.r = localBundle.getInt("media_type");
      this.n = localBundle.getString("share_text");
      this.i = localBundle.getLongArray("default_message_forward_array");
      this.h = localBundle.getBoolean("is_forward_only_locations", false);
      this.j = localBundle.getInt("forward_locations_lat", 0);
      this.k = localBundle.getInt("forward_locations_lng", 0);
      this.o = localBundle.getString("forward _draft");
      this.g = localBundle.getBoolean("forward_formatted_message_extra", false);
      this.s = ((ComposeDataContainer)paramIntent.getParcelableExtra("compose_data_extra"));
      this.u = ((WinkDescription)paramIntent.getParcelableExtra("com.viber.voip.wink.WINK_DESCRIPTION"));
      this.v = localBundle.getString("open_share_and_shop_product_id");
      this.w = ((OpenChatExtensionAction.Description)localBundle.getParcelable("open_chat_extension"));
      this.x = ((SendRichMessageRequest)localBundle.getParcelable("send_rich_message"));
      this.C = localBundle.getBundle("options");
      this.z = ((ScreenshotConversationData)localBundle.getParcelable("extra_community_screenshot_data"));
      this.f = localBundle.getBoolean("alter_extra_up", false);
      this.t = ((NewsShareAnalyticsData)localBundle.getParcelable("news_provider_base_url"));
      this.q = localBundle.getBoolean("show_ivm_promotion", false);
      str = localBundle.getString("extra_def_tab");
      if (da.a(str));
    }
    try
    {
      b(Integer.valueOf(str).intValue());
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
  }

  private void f(Intent paramIntent)
  {
    if (this.e)
      paramIntent.putExtra("external_share", this.e);
    if (this.l != null)
    {
      paramIntent.putParcelableArrayListExtra("share_files_uri", this.l);
      if (this.n != null)
        paramIntent.putExtra("share_text", this.n);
    }
    while (true)
    {
      if (((this.i != null) && (this.i.length > 0)) || (this.h))
      {
        paramIntent.putExtra("default_message_forward_array", this.i);
        paramIntent.putExtra("is_forward_only_locations", this.h);
        paramIntent.putExtra("forward_locations_lat", this.j);
        paramIntent.putExtra("forward_locations_lng", this.k);
        paramIntent.putExtra("forward", true);
      }
      if (this.u != null)
      {
        paramIntent.putExtra("com.viber.voip.wink.WINK_DESCRIPTION", this.u);
        paramIntent.putExtra("media_type", this.r);
        paramIntent.putExtra("need_description", false);
      }
      if (this.v != null)
        paramIntent.putExtra("open_share_and_shop_product_id", this.v);
      if (this.w != null)
        paramIntent.putExtra("open_chat_extension", this.w);
      if (this.x != null)
        paramIntent.putExtra("send_rich_message", this.x);
      if (this.C != null)
      {
        this.A.a(this.C);
        paramIntent.putExtra("options", this.C);
      }
      if (this.z != null)
        paramIntent.putExtra("extra_community_screenshot_data", this.z);
      if (this.f)
        paramIntent.putExtra("go_up", false);
      paramIntent.putExtra("show_ivm_promotion", this.q);
      this.A.b(paramIntent);
      return;
      if (this.m != null)
      {
        paramIntent.putExtra("share_uri", this.m);
        paramIntent.putExtra("need_description", this.p);
        paramIntent.putExtra("media_type", this.r);
        if (this.n != null)
          paramIntent.putExtra("share_text", this.n);
      }
      else if (this.n != null)
      {
        paramIntent.putExtra("share_text", this.n);
      }
      else if (this.o != null)
      {
        paramIntent.putExtra("forward _draft", this.o);
      }
      else if (this.s != null)
      {
        paramIntent.putExtra("compose_data_extra", this.s);
      }
    }
  }

  private void g(Intent paramIntent)
  {
    int i1;
    String str;
    if ((this.t != null) && (this.t.isValid()))
    {
      ConversationData localConversationData = (ConversationData)paramIntent.getParcelableExtra("extra_conversation_data");
      if (localConversationData != null)
      {
        i1 = localConversationData.getConversationType();
        if (!com.viber.voip.messages.m.g(i1))
          break label103;
        str = "1-on-1 Chat";
      }
    }
    while (true)
    {
      g.a().c().c().b(this.t.origin, this.t.baseProviderUrl, str, ae.b());
      startActivity(paramIntent);
      if (!paramIntent.getBooleanExtra("extra_forward_compose", false))
        finish();
      return;
      label103: if (com.viber.voip.messages.m.b(i1))
        str = "Community";
      else
        str = "Group";
    }
  }

  public void a(int paramInt, Fragment paramFragment)
  {
  }

  public void a(boolean paramBoolean, Intent paramIntent)
  {
    f(paramIntent);
  }

  protected void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.A = new d(this.d, findViewById(16908290), this, new a(this));
    a(this.A, this.d, paramBundle);
  }

  protected boolean b()
  {
    return !this.g;
  }

  protected Fragment c()
  {
    if (!b())
      return new com.viber.voip.contacts.ui.o();
    return new s();
  }

  protected void c(Intent paramIntent)
  {
    f(paramIntent);
  }

  public k getPermissionConfigForFragment(Fragment paramFragment)
  {
    k localk = new k();
    localk.a(0, 91);
    return localk;
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    e(getIntent());
    super.onCreate(paramBundle);
    setActionBarTitle(R.string.forward_title);
    if (getIntent().getBooleanExtra("extra_forward_contact", false))
      getSupportActionBar().b(R.string.forward_title_for_share_contact);
    if (getIntent().getBooleanExtra("extra_forward_chatex", false))
      getSupportActionBar().b(R.string.select);
    if (this.u != null)
      getSupportActionBar().b(R.string.forward_send_a_wink_title);
    this.y = c.a(this);
    if ((this.l != null) && (!this.y.a(n.m)))
      this.y.a(this, 134, n.m);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 16908332:
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      dj.d(this);
    }
  }

  protected void onStart()
  {
    super.onStart();
    this.y.a(this.B);
  }

  protected void onStop()
  {
    super.onStop();
    this.y.b(this.B);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.forward.ForwardActivity
 * JD-Core Version:    0.6.2
 */