package com.viber.voip.messages.ui.media;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.a;
import android.text.Html;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.viber.common.d.e;
import com.viber.common.d.e.a;
import com.viber.dexshared.Logger;
import com.viber.jni.LocationInfo;
import com.viber.voip.R.attr;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.ViberActionRunner.u;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.widget.aj;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class d
{
  private static final Logger b = ViberEnv.getLogger();
  protected b a;
  private Activity c;
  private View d;
  private int e;
  private int f;
  private boolean g = true;
  private boolean h = true;
  private boolean i;
  private a j;

  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.c.getWindow().setFlags(1024, 1024);
      return;
    }
    this.c.getWindow().clearFlags(1024);
  }

  private void b(Intent paramIntent)
  {
    this.a.a(true);
    Bundle localBundle = paramIntent.getExtras();
    this.e = localBundle.getInt("user_lat");
    this.f = localBundle.getInt("user_lng");
    long l1 = localBundle.getLong("location_date");
    String str1 = localBundle.getString("user_name");
    String str2 = localBundle.getString("bucket_text");
    long l2 = localBundle.getLong("message_id");
    this.g = localBundle.getBoolean("show_bucket", true);
    this.h = localBundle.getBoolean("show_share_menu", true);
    this.i = localBundle.getBoolean("localityAccuracy", false);
    this.a.a(str1);
    this.j.a(this.e / 10, this.f / 10, l1, str1, l2, str2, this.g, this.i);
  }

  private String f()
  {
    LocationInfo localLocationInfo = new LocationInfo(this.e, this.f);
    return localLocationInfo.lat() + "," + localLocationInfo.lng();
  }

  public b a()
  {
    return this.a;
  }

  public void a(Intent paramIntent)
  {
    b(paramIntent);
  }

  public void a(Configuration paramConfiguration)
  {
    int k = 1;
    if (paramConfiguration.orientation == k);
    while (true)
    {
      a(k);
      return;
      int m = 0;
    }
  }

  public void a(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    View localView = LayoutInflater.from(this.c).inflate(R.layout.context_menu_header, null);
    ((TextView)localView.findViewById(R.id.text)).setText(R.string.menu_sharing_title);
    ((ImageView)localView.findViewById(R.id.icon)).setImageResource(R.drawable.ic_btn_actionmenu_share_default);
    paramContextMenu.setHeaderView(localView);
    this.c.getMenuInflater().inflate(R.menu.context_menu_map_preview, paramContextMenu);
  }

  protected void a(a parama)
  {
    this.j = parama;
    this.c = this.j.c();
    this.c.setContentView(this.j.b());
    this.a = new b(this.c.getWindow().getDecorView());
    this.d = this.j.a();
    b(this.c.getIntent());
    if (!dj.c(this.c));
    for (boolean bool = true; ; bool = false)
    {
      a(bool);
      return;
    }
  }

  public boolean a(MenuItem paramMenuItem)
  {
    int k = paramMenuItem.getItemId();
    Intent localIntent2;
    StringBuilder localStringBuilder;
    String str;
    if (k == R.id.menu_map_open_map)
      if (f() != null)
      {
        localIntent2 = new Intent("android.intent.action.VIEW");
        localStringBuilder = new StringBuilder().append("https://maps.google.com/maps?q=loc:").append(f()).append(" (You)");
        if (!this.g)
          break label103;
        str = "";
      }
    while (true)
    {
      localIntent2.setData(Uri.parse(str));
      try
      {
        this.c.startActivity(localIntent2);
        while (true)
        {
          label101: return true;
          label103: str = "&z=10";
          break;
          if (k == R.id.menu_map_send_mail)
          {
            e();
          }
          else
          {
            if (k != R.id.menu_map_forward)
              break label155;
            Intent localIntent1 = ViberActionRunner.u.a(this.e, this.f);
            this.c.startActivity(localIntent1);
          }
        }
        label155: return false;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        break label101;
      }
    }
  }

  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("https://maps.google.com/maps?q=loc:").append(f()).append(" (You)");
    if (this.g);
    for (String str = ""; ; str = "&z=10")
      return Uri.parse(str).toString();
  }

  protected void c()
  {
  }

  protected void d()
  {
  }

  public void e()
  {
    Geocoder localGeocoder = new Geocoder(this.c, Locale.getDefault());
    try
    {
      LocationInfo localLocationInfo = new LocationInfo(this.e, this.f);
      List localList = localGeocoder.getFromLocation(localLocationInfo.getLatitude(), localLocationInfo.getLongitude(), 1);
      StringBuilder localStringBuilder = new StringBuilder();
      if (localList.size() > 0)
      {
        Address localAddress = (Address)localList.get(0);
        k = localAddress.getMaxAddressLineIndex();
        if (k >= 0)
        {
          if (localAddress.getAddressLine(k) == null)
            break label273;
          localStringBuilder.append(localAddress.getAddressLine(k));
          if (k <= 0)
            break label273;
          localStringBuilder.append(" / ");
          break label273;
        }
      }
      String str3 = localStringBuilder.toString();
      str1 = str3;
      String str2 = this.c.getString(R.string.email_location_sent) + "<br/>" + str1 + "<br/><a href=\"" + "https://maps.google.com/maps?q=loc:" + f() + "\">" + this.c.getString(R.string.email_location_show_on) + "</a>";
      new e.a().c(this.c.getString(R.string.email_location_subj)).a(Html.fromHtml(str2)).a().a(this.c, "plain/text", null);
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        int k;
        String str1 = "";
        continue;
        label273: k--;
      }
    }
  }

  public static abstract interface a
  {
    public abstract View a();

    public abstract void a(int paramInt1, int paramInt2, long paramLong1, String paramString1, long paramLong2, String paramString2, boolean paramBoolean1, boolean paramBoolean2);

    public abstract int b();

    public abstract Activity c();
  }

  public class b
  {
    private TextView b;
    private ProgressBar c;

    public b(View arg2)
    {
      if (!a())
      {
        View localView;
        this.b = ((TextView)localView.findViewById(R.id.toolbar_title));
        this.c = ((ProgressBar)localView.findViewById(R.id.toolbar_indeterminate_progress));
        localView.findViewById(R.id.toolbar_navigation).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            d.a(d.this).finish();
          }
        });
        localView.findViewById(R.id.toolbar_up).setVisibility(0);
        aj localaj = new aj(localView);
        localaj.a(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            d.a(d.this).registerForContextMenu(d.b(d.this));
            d.a(d.this).openContextMenu(d.b(d.this));
            d.a(d.this).unregisterForContextMenu(d.b(d.this));
          }
        });
        localaj.a(R.drawable.ic_ab_theme_dark_share);
        localaj.b(dc.d(localView.getContext(), R.attr.menuItemIconTint));
        localaj.c(R.string.menu_contact_share);
      }
    }

    public void a(String paramString)
    {
      if (a())
      {
        ((AppCompatActivity)d.a(d.this)).getSupportActionBar().a(paramString);
        return;
      }
      this.b.setText(paramString);
    }

    public void a(boolean paramBoolean)
    {
      if (a())
      {
        d.a(d.this).setProgressBarIndeterminateVisibility(paramBoolean);
        return;
      }
      ProgressBar localProgressBar = this.c;
      if (paramBoolean);
      for (int i = 0; ; i = 8)
      {
        localProgressBar.setVisibility(i);
        return;
      }
    }

    protected boolean a()
    {
      return d.a(d.this) instanceof AppCompatActivity;
    }

    public boolean a(Menu paramMenu)
    {
      if (a())
      {
        d.a(d.this).getMenuInflater().inflate(R.menu.menu_map_preview, paramMenu);
        paramMenu.findItem(R.id.menu_share).setVisible(d.c(d.this));
        return true;
      }
      return false;
    }

    public boolean a(MenuItem paramMenuItem)
    {
      if (a())
      {
        int i = paramMenuItem.getItemId();
        if (i == 16908332)
        {
          d.a(d.this).finish();
          return true;
        }
        if (i == R.id.menu_share)
        {
          d.a(d.this).registerForContextMenu(d.b(d.this));
          d.a(d.this).openContextMenu(d.b(d.this));
          d.a(d.this).unregisterForContextMenu(d.b(d.this));
          return true;
        }
      }
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.d
 * JD-Core Version:    0.6.2
 */