package com.viber.voip.vln;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.viber.dexshared.Logger;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.e.a.e;
import com.viber.voip.react.ReactContextManager.Params;
import com.viber.voip.react.ViberReactActivity;
import com.viber.voip.react.d;
import com.viber.voip.react.g;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;

public class VlnActivity extends ViberReactActivity
  implements com.viber.voip.react.b
{
  private static final Logger f = ViberEnv.getLogger();

  @Inject
  Map<String, d> d;

  @Inject
  dagger.a<ICdrController> e;
  private g<com.viber.voip.react.b> g;
  private com.viber.voip.react.c h;
  private long i;
  private Intent j;
  private String k;

  private long e()
  {
    return new SecureRandom().nextLong();
  }

  public void a()
  {
    this.a.post(new b(this));
  }

  public void a(String paramString1, String paramString2)
  {
    ((ICdrController)this.e.get()).handleReportWeb(paramString1, paramString2, this.i);
  }

  public void b()
  {
    finish();
  }

  public String c()
  {
    Uri localUri = getIntent().getData();
    if (localUri != null)
      return localUri.toString();
    return "";
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_react);
    setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
    getSupportActionBar().b(true);
    getSupportActionBar().a(null);
    Bundle localBundle = getIntent().getExtras();
    ReactContextManager.Params localParams;
    if ((localBundle != null) && (localBundle.containsKey("com.viber.voip.ReactContextFactoryParams")))
    {
      localParams = (ReactContextManager.Params)localBundle.getParcelable("com.viber.voip.ReactContextFactoryParams");
      if (localParams == null)
        break label220;
    }
    label220: for (String str = localParams.getReactContextKey(); ; str = "")
    {
      d locald = (d)this.d.get(str);
      if (locald != null)
      {
        this.h = locald.b(localParams);
        this.g = locald.a(localParams);
        this.g.a(this);
      }
      this.a = new com.swmansion.gesturehandler.react.a(this);
      e.b().a("react", "load view");
      this.a.startReactApplication(this.c, "ViberNumberApp", null);
      this.a.setVisibility(4);
      ((FrameLayout)findViewById(16908290)).addView(this.a, new FrameLayout.LayoutParams(-1, -1));
      this.k = Locale.getDefault().getLanguage();
      return;
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.g != null)
      this.g.b(null);
  }

  public void onNewIntent(Intent paramIntent)
  {
    this.j = paramIntent;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onResume()
  {
    super.onResume();
    Locale.getDefault().getLanguage();
  }

  public void onStart()
  {
    super.onStart();
    this.i = e();
    if ((this.j != null) && (this.h != null))
    {
      setIntent(this.j);
      this.j = null;
      WritableNativeMap localWritableNativeMap = new WritableNativeMap();
      localWritableNativeMap.putString("url", c());
      this.h.a("url", localWritableNativeMap);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.VlnActivity
 * JD-Core Version:    0.6.2
 */