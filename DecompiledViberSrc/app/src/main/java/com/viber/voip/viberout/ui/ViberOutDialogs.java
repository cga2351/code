package com.viber.voip.viberout.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.c.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.billing.IabInventory;
import com.viber.voip.billing.IabProductId;
import com.viber.voip.billing.Purchase;
import com.viber.voip.billing.PurchaseSupportActivity;
import com.viber.voip.billing.b;
import com.viber.voip.billing.b.d;
import com.viber.voip.billing.l;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserManager;
import java.util.ArrayList;
import org.onepf.oms.InAppBillingHelper;
import org.onepf.oms.InAppBillingHelper.OnConsumeFinishedListener;
import org.onepf.oms.InAppBillingHelper.QueryInventoryFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabResult;

public class ViberOutDialogs extends ViberFragmentActivity
{
  private static final Logger a = b.a(ViberOutDialogs.class);
  private boolean b;

  private static ProgressDialog a(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    ProgressDialog localProgressDialog = new ProgressDialog(paramContext);
    localProgressDialog.setMessage(paramString);
    localProgressDialog.setIndeterminate(true);
    localProgressDialog.setCancelable(true);
    localProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        if (this.a != null)
          this.a.onCancel(paramAnonymousDialogInterface);
      }
    });
    localProgressDialog.show();
    return localProgressDialog;
  }

  private ProgressDialog a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return a(this, getString(R.string.please_wait), paramOnCancelListener);
  }

  private static Intent a(a parama)
  {
    Intent localIntent = new Intent(ViberApplication.getApplication(), ViberOutDialogs.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("METHOD", parama.ordinal());
    return localIntent;
  }

  private void a(int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    a(this, paramInt1, paramInt2, paramOnCancelListener);
  }

  public static void a(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    c.a locala = new c.a(paramContext);
    if (paramInt1 != 0)
      locala.a(paramInt1);
    locala.b(paramInt2);
    locala.a(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
        if (this.a != null)
          this.a.onCancel(paramAnonymousDialogInterface);
      }
    });
    locala.a(true);
    if (paramOnCancelListener != null)
      locala.a(paramOnCancelListener);
    locala.c();
  }

  private static void a(Intent paramIntent)
  {
    ViberApplication.getApplication().startActivity(paramIntent);
  }

  public static void a(String paramString)
  {
    a(paramString, false);
  }

  public static void a(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean, false);
  }

  public static void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intent localIntent = a(a.a);
    localIntent.putExtra("PRODUCT_ID", paramString);
    localIntent.putExtra("show_vo_special_dialog", paramBoolean1);
    localIntent.putExtra("additional_params", PurchaseSupportActivity.a(paramBoolean2));
    a(localIntent);
  }

  private DialogInterface.OnCancelListener b()
  {
    return new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        ViberOutDialogs.this.finish();
      }
    };
  }

  public void a(final IabProductId paramIabProductId, final String paramString, final boolean paramBoolean, final Bundle paramBundle)
  {
    final ProgressDialog[] arrayOfProgressDialog = new ProgressDialog[1];
    arrayOfProgressDialog[0] = a(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        arrayOfProgressDialog[0] = null;
        ViberOutDialogs.this.finish();
      }
    });
    final Runnable local2 = new Runnable()
    {
      public void run()
      {
        b.a().a(new b.d()
        {
          public void onBillingHealthIssues(int paramAnonymous2Int)
          {
            if (ViberOutDialogs.2.this.a[0] != null)
            {
              ViberOutDialogs.2.this.a[0].dismiss();
              ViberOutDialogs.a(ViberOutDialogs.this, R.string.billing_error_default_title, R.string.billing_error_health_issues, ViberOutDialogs.a(ViberOutDialogs.this));
            }
          }

          public void onBillingHealthOk()
          {
            if ((ViberOutDialogs.2.this.a[0] != null) && (ViberOutDialogs.this.a()))
            {
              ViberOutDialogs.2.this.a[0].dismiss();
              if (!ViberOutDialogs.2.this.b)
                break label87;
              b.a().a(ViberOutDialogs.2.this.c, ViberOutDialogs.2.this.d, "calling_plan", ViberOutDialogs.2.this.e);
            }
            while (true)
            {
              ViberOutDialogs.this.finish();
              return;
              label87: b.a().a(ViberOutDialogs.2.this.c, ViberOutDialogs.2.this.d, ViberOutDialogs.2.this.e);
            }
          }
        });
      }
    };
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramIabProductId);
    l.a().c().queryInventoryAsync(true, localArrayList, new InAppBillingHelper.QueryInventoryFinishedListener()
    {
      public void onQueryInventoryFinished(IabResult paramAnonymousIabResult, IabInventory paramAnonymousIabInventory)
      {
        Purchase localPurchase;
        if ((arrayOfProgressDialog[0] != null) && (ViberOutDialogs.this.a()))
        {
          if (!paramAnonymousIabResult.isSuccess())
            break label106;
          localPurchase = paramAnonymousIabInventory.getPurchase(paramIabProductId);
          if (localPurchase == null)
            local2.run();
        }
        else
        {
          return;
        }
        if ("inapp".equals(localPurchase.getProductId().getItemType()))
        {
          l.a().c().consumeAsync(localPurchase, new InAppBillingHelper.OnConsumeFinishedListener()
          {
            public void onConsumeFinished(Purchase paramAnonymous2Purchase, IabResult paramAnonymous2IabResult)
            {
              if ((ViberOutDialogs.3.this.a[0] != null) && (ViberOutDialogs.this.a()))
                ViberOutDialogs.3.this.c.run();
            }
          });
          return;
        }
        arrayOfProgressDialog[0].dismiss();
        ViberOutDialogs.this.finish();
        return;
        label106: arrayOfProgressDialog[0].dismiss();
        ViberApplication.getInstance().getEngine(false).getCdrController().handleReportPurchaseStatusStatistics(paramIabProductId.getMerchantProductId(), paramAnonymousIabResult.getResponse(), "", "");
        ViberOutDialogs.this.finish();
        if (paramBoolean)
        {
          l.a().g();
          return;
        }
        l.a().a(paramAnonymousIabResult, paramIabProductId.getMerchantProductId());
      }
    });
  }

  boolean a()
  {
    return !this.b;
  }

  public void finish()
  {
    try
    {
      throw new Exception("tracing finish() call");
    }
    catch (Exception localException)
    {
      super.finish();
    }
  }

  public void onBackPressed()
  {
    super.onBackPressed();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    a locala = a.values()[localIntent.getIntExtra("METHOD", -1)];
    switch (7.a[locala.ordinal()])
    {
    default:
      return;
    case 1:
    }
    String str1 = UserManager.from(ViberApplication.getApplication()).getRegistrationValues().g();
    String str2 = localIntent.getStringExtra("PRODUCT_ID");
    boolean bool = localIntent.getBooleanExtra("show_vo_special_dialog", false);
    Bundle localBundle = localIntent.getBundleExtra("additional_params");
    try
    {
      a(IabProductId.fromString(str2), str1, bool, localBundle);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      finish();
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.b = true;
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[1];
      arrayOfa[0] = a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.ViberOutDialogs
 * JD-Core Version:    0.6.2
 */