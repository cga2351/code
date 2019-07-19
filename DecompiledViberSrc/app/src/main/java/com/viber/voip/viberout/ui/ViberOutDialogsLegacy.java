package com.viber.voip.viberout.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.c;
import android.support.v7.app.c.a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.billing.IabInventory;
import com.viber.voip.billing.IabProductId;
import com.viber.voip.billing.Purchase;
import com.viber.voip.billing.b.d;
import com.viber.voip.billing.b.g;
import com.viber.voip.billing.b.h;
import com.viber.voip.billing.b.j;
import com.viber.voip.billing.b.t;
import com.viber.voip.billing.f;
import com.viber.voip.billing.l;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.bj;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.user.UserManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.onepf.oms.InAppBillingHelper;
import org.onepf.oms.InAppBillingHelper.OnConsumeFinishedListener;
import org.onepf.oms.InAppBillingHelper.QueryInventoryFinishedListener;
import org.onepf.oms.appstore.googleUtils.IabResult;

public class ViberOutDialogsLegacy extends ViberFragmentActivity
{
  private static final Logger a = com.viber.voip.billing.b.a(ViberOutDialogsLegacy.class);
  private static final Set<String> b = new HashSet(Arrays.asList(new String[] { "FR", "RU", "US", "CA", "AU", "IN" }));
  private boolean c;

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

  private ProgressDialog a(String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return a(this, paramString, paramOnCancelListener);
  }

  private static DialogInterface.OnCancelListener a(String paramString, a parama)
  {
    if (parama != null)
      return new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          this.a.a();
        }
      };
    return null;
  }

  private static Intent a(b paramb)
  {
    Intent localIntent = new Intent(ViberApplication.getApplication(), ViberOutDialogsLegacy.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("METHOD", paramb.ordinal());
    return localIntent;
  }

  private void a(int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    a(this, paramInt1, paramInt2, paramOnCancelListener);
  }

  private void a(int paramInt1, int paramInt2, a parama)
  {
    a(paramInt1, paramInt2, parama, null);
  }

  private void a(int paramInt1, int paramInt2, a parama, String paramString)
  {
    c.a locala = new c.a(this);
    if (paramInt1 != 0)
      locala.a(paramInt1);
    if (paramInt2 != 0)
      locala.b(paramInt2);
    a(locala, parama, paramString);
    locala.a(true);
    locala.a(a(paramString, parama));
    locala.c();
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

  private void a(c.a parama, final a parama1, final String paramString)
  {
    parama.a(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
        if ((paramString == null) || (parama1 != null))
          parama1.a();
      }
    });
  }

  private void a(b.g paramg)
  {
    switch (10.b[paramg.b().ordinal()])
    {
    default:
      b(i());
      return;
    case 1:
    }
    a(i());
  }

  private void a(final b.t paramt)
  {
    final ProgressDialog[] arrayOfProgressDialog = new ProgressDialog[1];
    com.viber.voip.billing.b.a().a(new b.j()
    {
      public void a(b.g paramAnonymousg)
      {
        if ((arrayOfProgressDialog[0] != null) && (ViberOutDialogsLegacy.this.c()))
        {
          arrayOfProgressDialog[0].dismiss();
          if (paramAnonymousg.a())
            ViberOutDialogsLegacy.a(ViberOutDialogsLegacy.this, paramAnonymousg.d(), paramt);
        }
        else
        {
          return;
        }
        ViberOutDialogsLegacy.a(ViberOutDialogsLegacy.this, paramAnonymousg);
      }
    });
    arrayOfProgressDialog[0] = a(this, getString(R.string.generic_please_wait_dialog_text), new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        arrayOfProgressDialog[0] = null;
        ViberOutDialogsLegacy.this.finish();
      }
    });
  }

  private void a(a parama)
  {
    a(R.string.dialog_no_network_title, R.string.dialog_no_internet_connection_download_action, parama);
  }

  @Deprecated
  private void a(c paramc, final f paramf, final String paramString1, String paramString2)
  {
    paramc.a(paramf.a(), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
        ViberOutDialogsLegacy.this.a(paramf.b(), paramString1);
      }
    });
  }

  private void a(c paramc, f[] paramArrayOff, boolean paramBoolean)
  {
    a(paramc, paramArrayOff, paramBoolean, null);
  }

  private void a(c paramc, f[] paramArrayOff, boolean paramBoolean, String paramString)
  {
    String str = UserManager.from(ViberApplication.getApplication()).getRegistrationValues().g();
    if (paramArrayOff != null)
      for (int i = 0; i < paramArrayOff.length; i++)
        if ((!paramBoolean) || (paramArrayOff[i].f() < 3))
          a(paramc, paramArrayOff[i], str, paramString);
  }

  private void a(f[] paramArrayOff, final b.t paramt)
  {
    c localc = new c(this, getLayoutInflater());
    localc.a(R.string.viberout_dialog_dialpad_buy_credits_title);
    localc.a(getString(R.string.viberout_dialog_contact_details_buy_credits_text));
    a(localc, paramArrayOff, true);
    localc.a(R.string.viberout_dialog_button_view_rates, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        String str = com.viber.voip.billing.b.a().a(paramt);
        GenericWebViewActivity.a(ViberOutDialogsLegacy.this, str, ViberOutDialogsLegacy.this.getString(R.string.viberout_web_title_rates));
      }
    });
    localc.a(R.string.viberout_dialog_button_maybe_later, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
        ViberOutDialogsLegacy.this.finish();
      }
    });
    localc.a(true);
    localc.a(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        ViberOutDialogsLegacy.this.finish();
      }
    });
    localc.a();
  }

  public static boolean a()
  {
    af localaf = UserManager.from(ViberApplication.getApplication()).getRegistrationValues();
    return (d.bj.i.d()) || ((localaf != null) && (b.contains(localaf.e())));
  }

  public static void b()
  {
    a(a(b.b));
  }

  private void b(a parama)
  {
    a(R.string.no_service_error_dialog_title, R.string.no_service_error_dialog_message, parama);
  }

  private void e()
  {
    a(R.string.billing_error_billing_unavailable_title, R.string.billing_error_billing_unavailable_message, i());
  }

  private void f()
  {
    a(i());
  }

  private void g()
  {
    b(i());
  }

  private DialogInterface.OnCancelListener h()
  {
    return new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        ViberOutDialogsLegacy.this.finish();
      }
    };
  }

  private a i()
  {
    return new a()
    {
      public void a()
      {
        ViberOutDialogsLegacy.this.finish();
      }
    };
  }

  public void a(final IabProductId paramIabProductId, final String paramString)
  {
    final ProgressDialog[] arrayOfProgressDialog = new ProgressDialog[1];
    arrayOfProgressDialog[0] = a(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        arrayOfProgressDialog[0] = null;
        ViberOutDialogsLegacy.this.finish();
      }
    });
    final Runnable local2 = new Runnable()
    {
      public void run()
      {
        com.viber.voip.billing.b.a().a(new b.d()
        {
          public void onBillingHealthIssues(int paramAnonymous2Int)
          {
            if (ViberOutDialogsLegacy.2.this.a[0] != null)
            {
              ViberOutDialogsLegacy.2.this.a[0].dismiss();
              ViberOutDialogsLegacy.a(ViberOutDialogsLegacy.this, R.string.billing_error_default_title, R.string.billing_error_health_issues, ViberOutDialogsLegacy.b(ViberOutDialogsLegacy.this));
            }
          }

          public void onBillingHealthOk()
          {
            if ((ViberOutDialogsLegacy.2.this.a[0] != null) && (ViberOutDialogsLegacy.this.c()))
            {
              ViberOutDialogsLegacy.2.this.a[0].dismiss();
              com.viber.voip.billing.b.a().a(ViberOutDialogsLegacy.2.this.b, ViberOutDialogsLegacy.2.this.c);
              ViberOutDialogsLegacy.this.finish();
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
        if ((arrayOfProgressDialog[0] != null) && (ViberOutDialogsLegacy.this.c()))
        {
          if (!paramAnonymousIabResult.isSuccess())
            break label73;
          localPurchase = paramAnonymousIabInventory.getPurchase(paramIabProductId);
          if (localPurchase == null)
            local2.run();
        }
        else
        {
          return;
        }
        l.a().c().consumeAsync(localPurchase, new InAppBillingHelper.OnConsumeFinishedListener()
        {
          public void onConsumeFinished(Purchase paramAnonymous2Purchase, IabResult paramAnonymous2IabResult)
          {
            if ((ViberOutDialogsLegacy.3.this.a[0] != null) && (ViberOutDialogsLegacy.this.c()))
              ViberOutDialogsLegacy.3.this.c.run();
          }
        });
        return;
        label73: arrayOfProgressDialog[0].dismiss();
        ViberApplication.getInstance().getEngine(false).getCdrController().handleReportPurchaseStatusStatistics(paramIabProductId.getMerchantProductId(), paramAnonymousIabResult.getResponse(), "", "");
        ViberOutDialogsLegacy.this.finish();
        l.a().a(paramAnonymousIabResult, paramIabProductId.getMerchantProductId());
      }
    });
  }

  boolean c()
  {
    return !this.c;
  }

  public void d()
  {
    final ProgressDialog[] arrayOfProgressDialog = new ProgressDialog[1];
    com.viber.voip.billing.b.a().a(new b.j()
    {
      public void a(b.g paramAnonymousg)
      {
        if ((arrayOfProgressDialog[0] != null) && (ViberOutDialogsLegacy.this.c()))
        {
          arrayOfProgressDialog[0].dismiss();
          if (!paramAnonymousg.a())
            break label122;
          if (paramAnonymousg.d().length > 0)
          {
            ViberOutDialogsLegacy.c localc = new ViberOutDialogsLegacy.c(ViberOutDialogsLegacy.this, ViberOutDialogsLegacy.this.getLayoutInflater());
            localc.a(R.string.viberout_main_buy_credit_dialog_title);
            ViberOutDialogsLegacy.a(ViberOutDialogsLegacy.this, localc, paramAnonymousg.d(), false);
            localc.a(17039360, new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                paramAnonymous2DialogInterface.dismiss();
                ViberOutDialogsLegacy.this.finish();
              }
            });
            localc.a(new DialogInterface.OnCancelListener()
            {
              public void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                ViberOutDialogsLegacy.this.finish();
              }
            });
            localc.a();
          }
        }
        else
        {
          return;
        }
        ViberOutDialogsLegacy.a(ViberOutDialogsLegacy.this);
        return;
        label122: ViberOutDialogsLegacy.a(ViberOutDialogsLegacy.this, paramAnonymousg);
      }
    });
    arrayOfProgressDialog[0] = a(getString(R.string.generic_please_wait_dialog_text), new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        arrayOfProgressDialog[0] = null;
        ViberOutDialogsLegacy.this.finish();
      }
    });
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
    b localb = b.values()[localIntent.getIntExtra("METHOD", -1)];
    switch (10.a[localb.ordinal()])
    {
    default:
      return;
    case 1:
      a(new b.t(localIntent.getStringExtra("NUMBER")));
      return;
    case 2:
      d();
      return;
    case 3:
      String str1 = UserManager.from(ViberApplication.getApplication()).getRegistrationValues().g();
      String str2 = localIntent.getStringExtra("PRODUCT_ID");
      try
      {
        a(IabProductId.fromString(str2), str1);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        finish();
        return;
      }
    case 4:
      f();
      return;
    case 5:
    }
    g();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.c = true;
  }

  static abstract interface a
  {
    public abstract void a();
  }

  private static enum b
  {
    static
    {
      b[] arrayOfb = new b[6];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      arrayOfb[5] = f;
    }
  }

  private static class c
  {
    private TextView a;
    private ViewGroup b;
    private TextView c;
    private View d;
    private Context e;
    private c f;
    private c.a g;
    private boolean h;
    private LayoutInflater i;

    public c(Context paramContext, LayoutInflater paramLayoutInflater)
    {
      this.e = paramContext;
      this.i = paramLayoutInflater;
      View localView = this.i.inflate(R.layout.viberout_dialog, null);
      this.b = ((ViewGroup)localView.findViewById(R.id.button_container));
      this.a = ((TextView)localView.findViewById(R.id.text));
      this.c = ((TextView)localView.findViewById(R.id.title));
      this.d = localView.findViewById(R.id.title_view);
      this.g = new c.a(this.e);
      this.g.b(localView);
    }

    public View a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      return a(this.e.getString(paramInt), paramOnClickListener);
    }

    public View a(String paramString, final DialogInterface.OnClickListener paramOnClickListener)
    {
      Button localButton = (Button)this.i.inflate(R.layout.viberout_dialog_button, this.b, false);
      localButton.setText(paramString);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramOnClickListener.onClick(ViberOutDialogsLegacy.c.a(ViberOutDialogsLegacy.c.this), 0);
        }
      });
      this.b.addView(localButton);
      return localButton;
    }

    public void a()
    {
      this.f = this.g.b();
      this.f.supportRequestWindowFeature(1);
      if (TextUtils.isEmpty(this.a.getText()))
        this.a.setVisibility(8);
      this.f.show();
    }

    public void a(int paramInt)
    {
      this.d.setVisibility(0);
      this.c.setText(paramInt);
      this.h = true;
    }

    public void a(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.g.a(paramOnCancelListener);
    }

    public void a(String paramString)
    {
      this.a.setText(paramString);
    }

    public void a(boolean paramBoolean)
    {
      this.g.a(paramBoolean);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.ViberOutDialogsLegacy
 * JD-Core Version:    0.6.2
 */