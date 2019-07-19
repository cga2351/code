package com.viber.voip.billing;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.c.a;
import android.widget.EditText;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.dialer.DialerController;
import com.viber.voip.R.string;
import com.viber.voip.R.style;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.phone.call.CallInitiationId;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.af;
import com.viber.voip.util.da;
import org.onepf.oms.InAppBillingHelper;
import org.onepf.oms.InAppBillingHelper.OnIabPurchaseFinishedListener;

public class PurchaseSupportActivity extends ViberFragmentActivity
  implements m.c
{
  private static final Logger a = b.a(PurchaseSupportActivity.class);
  private static String e = "";
  private ProgressDialog b;
  private dagger.a<h> c;
  private BroadcastReceiver d = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ("finish-purchase-support".equals(paramAnonymousIntent.getAction()))
        PurchaseSupportActivity.this.finish();
    }
  };

  private ProgressDialog a(String paramString, final DialogInterface.OnCancelListener paramOnCancelListener)
  {
    ProgressDialog localProgressDialog = new ProgressDialog(this, R.style.ProgressDialogStyle);
    localProgressDialog.setMessage(paramString);
    localProgressDialog.setIndeterminate(true);
    localProgressDialog.setCancelable(true);
    localProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        if (paramOnCancelListener != null)
          paramOnCancelListener.onCancel(paramAnonymousDialogInterface);
      }
    });
    localProgressDialog.show();
    return localProgressDialog;
  }

  private static Intent a(a parama)
  {
    Intent localIntent = new Intent(ViberApplication.getApplication(), PurchaseSupportActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("EXTRA_METHOD", parama.ordinal());
    return localIntent;
  }

  public static Bundle a(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("show_vo_screen_on_complete", paramBoolean);
    return localBundle;
  }

  public static void a()
  {
    a(null);
  }

  public static void a(Activity paramActivity)
  {
    c.a locala = new c.a(paramActivity);
    locala.a("Enter phone number");
    locala.b("Enter the phone number to which the dialog 602 (payment succeeded) should refer");
    EditText localEditText = new EditText(paramActivity);
    localEditText.setText(e);
    locala.b(localEditText);
    locala.a(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        PurchaseSupportActivity.b(this.a.getText().toString());
        PurchaseSupportActivity.a("$0.99", new b.t(PurchaseSupportActivity.c()));
      }
    });
    locala.b(17039360, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    });
    locala.c();
  }

  private static void a(Intent paramIntent)
  {
    ViberApplication.getApplication().startActivity(paramIntent);
  }

  public static void a(IabProductId paramIabProductId, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    Intent localIntent = a(a.a);
    if (da.a(paramIabProductId.getJson()));
    for (String str = paramIabProductId.toString(); ; str = paramIabProductId.getJson())
    {
      localIntent.putExtra(b.d.name(), str);
      localIntent.putExtra(b.e.name(), paramString1);
      localIntent.putExtra(b.a.name(), paramString3);
      localIntent.putExtra(b.h.name(), paramString2);
      localIntent.putExtra(b.i.name(), paramString4);
      localIntent.putExtra(b.j.name(), paramBundle);
      localIntent.putExtra(b.k.name(), paramIabProductId.getProductId().getCategory());
      a(localIntent);
      return;
    }
  }

  private void a(b.t paramt)
  {
    CallInitiationId.noteNextCallInitiationAttemptId();
    h localh = (h)this.c.get();
    h.a.a locala = com.viber.voip.analytics.story.b.a.h.a.i();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramt.a();
    localh.b(locala.a(arrayOfString).b("Viber Out").b(true).a());
    ViberApplication.getInstance().getEngine(true).getDialerController().handleDialViberOut(paramt.a());
  }

  public static void a(String paramString)
  {
    Intent localIntent = a(a.c);
    if (paramString != null)
      localIntent.putExtra(b.a.name(), paramString);
    a(localIntent);
  }

  public static void a(String paramString, b.t paramt)
  {
    a(paramString, paramt, false, null);
  }

  public static void a(String paramString, b.t paramt, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool1 = true;
    Intent localIntent = a(a.d);
    localIntent.putExtra("is_calling_plan_purchase", paramBoolean);
    boolean bool2;
    if ((paramBundle != null) && (paramBundle.getBoolean("show_vo_screen_on_complete")))
    {
      bool2 = bool1;
      localIntent.putExtra("show_vo_screen_on_complete", bool2);
      if ((paramBundle == null) || (!paramBundle.getBoolean("is_vln_context")))
        break label118;
    }
    while (true)
    {
      localIntent.putExtra("is_vln_context", bool1);
      localIntent.putExtra(b.f.name(), paramString);
      if (paramt != null)
        localIntent.putExtra(b.g.name(), paramt.a());
      a(localIntent);
      return;
      bool2 = false;
      break;
      label118: bool1 = false;
    }
  }

  private void a(String paramString, b.t paramt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramt != null)
    {
      c(getString(R.string.viberout_dialog_payment_in_progress));
      b.a().a(paramt, new b.v()
      {
        public void a(final b.t paramAnonymoust, final b.u paramAnonymousu)
        {
          if (PurchaseSupportActivity.a(PurchaseSupportActivity.this) == null)
          {
            PurchaseSupportActivity.this.finish();
            return;
          }
          paramAnonymoust.a(new b.t.a()
          {
            public void a(String paramAnonymous2String)
            {
              PurchaseSupportActivity.b(PurchaseSupportActivity.this);
              if (paramAnonymous2String != null)
                if (paramAnonymousu == null)
                  break label78;
              label78: for (String str = paramAnonymousu.b; ; str = null)
              {
                af.a(paramAnonymous2String, str).d(true).a(paramAnonymoust).a(PurchaseSupportActivity.this).a(PurchaseSupportActivity.this);
                return;
                paramAnonymous2String = paramAnonymoust.a();
                break;
              }
            }
          });
        }
      });
      return;
    }
    d();
    if (paramBoolean1)
    {
      b(paramBoolean2);
      return;
    }
    a(paramString, paramBoolean2, paramBoolean3);
  }

  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    af.a(paramString, paramBoolean1, paramBoolean2).d(true).a(this);
  }

  public static void b()
  {
    Application localApplication = ViberApplication.getApplication();
    Intent localIntent = new Intent("finish-purchase-support");
    LocalBroadcastManager.getInstance(localApplication).sendBroadcast(localIntent);
  }

  private void b(Intent paramIntent)
  {
    com.viber.common.dialogs.a locala = m.a(this, paramIntent);
    if (locala != null)
    {
      if (a.b == locala.g())
      {
        d();
        return;
      }
      finish();
      return;
    }
    a locala1 = a.values()[paramIntent.getIntExtra("EXTRA_METHOD", -1)];
    switch (7.a[locala1.ordinal()])
    {
    default:
      finish();
      return;
    case 1:
      ProductCategory localProductCategory = (ProductCategory)paramIntent.getSerializableExtra(b.k.name());
      IabProductId localIabProductId = IabProductId.fromString(paramIntent.getStringExtra(b.d.name()), localProductCategory);
      String str3 = paramIntent.getStringExtra(b.e.name());
      String str4 = paramIntent.getStringExtra(b.a.name());
      b(localIabProductId, str3, paramIntent.getStringExtra(b.h.name()), str4, paramIntent.getStringExtra(b.i.name()), paramIntent.getBundleExtra(b.j.name()));
      return;
    case 2:
      c(paramIntent.getStringExtra(b.a.name()));
      return;
    case 3:
    }
    d();
    String str1 = paramIntent.getStringExtra(b.f.name());
    String str2 = paramIntent.getStringExtra(b.g.name());
    boolean bool1 = paramIntent.getBooleanExtra("is_calling_plan_purchase", false);
    boolean bool2 = paramIntent.getBooleanExtra("show_vo_screen_on_complete", false);
    boolean bool3 = paramIntent.getBooleanExtra("is_vln_context", false);
    if (str2 == null);
    for (b.t localt = null; ; localt = new b.t(str2))
    {
      a(str1, localt, bool1, bool2, bool3);
      return;
    }
  }

  private void b(IabProductId paramIabProductId, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    l locall = l.a();
    c(null);
    InAppBillingHelper.OnIabPurchaseFinishedListener localOnIabPurchaseFinishedListener = locall.b(paramIabProductId, paramString2, paramString3, paramBundle);
    if ("inapp".equals(paramIabProductId.getItemType()))
    {
      locall.c().launchPurchaseFlow(this, paramIabProductId, 11000, paramString4, localOnIabPurchaseFinishedListener, paramString1);
      return;
    }
    locall.c().launchSubscriptionPurchaseFlow(this, paramIabProductId, 11000, paramString4, localOnIabPurchaseFinishedListener, paramString1);
  }

  private void b(boolean paramBoolean)
  {
    af.a(paramBoolean).d(true).a(this);
  }

  private void c(String paramString)
  {
    if (paramString == null)
      paramString = getString(R.string.generic_please_wait_dialog_text);
    if (this.b != null)
      this.b.dismiss();
    this.b = a(paramString, new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        paramAnonymousDialogInterface.dismiss();
        PurchaseSupportActivity.a(PurchaseSupportActivity.this, null);
        PurchaseSupportActivity.this.finish();
      }
    });
  }

  private void d()
  {
    if (this.b != null)
    {
      this.b.dismiss();
      this.b = null;
    }
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!l.a().c().handleActivityResult(paramInt1, paramInt2, paramIntent))
      a(this, paramInt1, paramInt2, paramIntent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = ViberApplication.getInstance().getLazyUserStartsCallEventCollector();
    if (!com.viber.common.d.a.m())
      com.viber.voip.n.a.c(this);
    b(getIntent());
    LocalBroadcastManager.getInstance(this).registerReceiver(this.d, new IntentFilter("finish-purchase-support"));
  }

  protected void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(this.d);
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D602)) && (-1 == paramInt) && ((paramm.d() instanceof b.t)))
      a((b.t)paramm.d());
  }

  protected void onNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
    b(paramIntent);
  }

  protected void onPause()
  {
    super.onPause();
    d();
  }

  protected void onResume()
  {
    super.onResume();
    l.a().c().parentActivityResumed();
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    d();
    super.startActivityForResult(paramIntent, paramInt);
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }
  }

  public static enum b
  {
    static
    {
      b[] arrayOfb = new b[11];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      arrayOfb[5] = f;
      arrayOfb[6] = g;
      arrayOfb[7] = h;
      arrayOfb[8] = i;
      arrayOfb[9] = j;
      arrayOfb[10] = k;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.PurchaseSupportActivity
 * JD-Core Version:    0.6.2
 */