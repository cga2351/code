package com.viber.voip.api;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.color;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberAppCompatActivity;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.a.j;
import com.viber.voip.api.scheme.action.c.a;
import com.viber.voip.api.scheme.e;
import com.viber.voip.api.scheme.f;
import com.viber.voip.api.scheme.h;
import com.viber.voip.api.scheme.l;
import com.viber.voip.api.scheme.m;
import com.viber.voip.api.scheme.n;
import com.viber.voip.api.scheme.o;
import com.viber.voip.api.scheme.p;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ao;
import com.viber.voip.util.dj;
import com.viber.voip.util.dk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLSchemeHandlerActivity extends ViberAppCompatActivity
{
  private static final Logger a = ViberEnv.getLogger();
  private static final Pattern b = Pattern.compile("(?i)https://viber.com/client/");
  private static final ArrayList<h> c = new ArrayList();
  private View d;
  private View e;

  static
  {
    c.add(com.viber.voip.api.scheme.c.h);
    c.add(com.viber.voip.api.scheme.a.h);
    c.add(com.viber.voip.api.scheme.d.J);
    c.add(p.b);
    c.add(o.d);
    c.add(m.g);
    c.add(e.w);
    c.add(n.y);
    c.add(com.viber.voip.api.scheme.k.b);
    c.add(com.viber.voip.api.scheme.b.b);
    c.add(f.b);
    c.add(l.c);
  }

  private void a()
  {
    com.viber.voip.ui.dialogs.k.r().a(new ViberDialogHandlers.ao()).d();
    finish();
  }

  private void a(Uri paramUri, Bundle paramBundle)
  {
    if (dk.l(paramUri))
    {
      a();
      return;
    }
    Matcher localMatcher = b.matcher(paramUri.toString());
    if (localMatcher.find())
      paramUri = Uri.parse(localMatcher.replaceFirst("viber://"));
    Object localObject;
    if (ViberApplication.isActivated())
    {
      localObject = c;
      label51: Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        com.viber.voip.api.scheme.action.c localc = ((h)localIterator.next()).a(this, paramUri, paramBundle);
        if (localc != null)
          localc.a(this, new c.a()
          {
            public void a()
            {
              URLSchemeHandlerActivity.a(URLSchemeHandlerActivity.this);
            }

            public void b()
            {
              URLSchemeHandlerActivity.this.finish();
            }
          });
      }
    }
    for (int i = 1; ; i = 0)
    {
      j.a(paramUri);
      if (i != 0)
        break;
      a();
      return;
      localObject = Collections.singletonList(com.viber.voip.api.scheme.a.h);
      break label51;
    }
  }

  private void b()
  {
    this.d.setBackgroundColor(ContextCompat.getColor(this, R.color.solid_50));
    dj.b(this.e, true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    dj.f(this);
    setContentView(R.layout.activity_url_scheme_handler);
    this.d = findViewById(R.id.content);
    this.e = findViewById(R.id.progress);
    Intent localIntent = getIntent();
    Uri localUri = localIntent.getData();
    Bundle localBundle = localIntent.getExtras();
    if ((!"android.intent.action.VIEW".equals(localIntent.getAction())) || (localUri == null))
    {
      finish();
      return;
    }
    localIntent.setDataAndType(null, localIntent.getType());
    setIntent(localIntent);
    a(localUri, localBundle);
  }

  protected void onPause()
  {
    super.onPause();
    if (isFinishing())
      overridePendingTransition(0, 0);
  }

  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new d(this, paramArrayOfIntent, paramBundle), paramArrayOfIntent);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new b(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    com.viber.common.app.a.a(new c(this, paramIntent, paramInt), new Intent[] { paramIntent });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.URLSchemeHandlerActivity
 * JD-Core Version:    0.6.2
 */