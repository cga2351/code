package com.viber.voip.messages.ui.media;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CameraPosition.Builder;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.raw;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;
import com.viber.voip.messages.extras.b.a.a;
import com.viber.voip.messages.extras.b.d.c;
import com.viber.voip.messages.extras.map.BalloonView;
import com.viber.voip.messages.extras.map.b.d;
import com.viber.voip.messages.extras.map.b.f;
import com.viber.voip.messages.extras.map.d.a;
import com.viber.voip.messages.extras.map.g;
import com.viber.voip.messages.extras.map.g.a;
import com.viber.voip.permissions.f;
import com.viber.voip.permissions.n;
import com.viber.voip.settings.d.f;
import com.viber.voip.ui.c.h;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import javax.inject.Inject;

public class LocationMessageActivityV2 extends ViberFragmentActivity
  implements m.c, a.a, b.d, d.a
{
  private static final Logger c = ViberEnv.getLogger();
  private int A;

  @Inject
  com.viber.voip.messages.extensions.c a;
  GroundOverlay b;
  private MarkerOptions d;
  private MarkerOptions e;
  private Marker f;
  private GoogleMap g;
  private final Object h = new Object();
  private b.f i;
  private com.viber.voip.messages.extras.map.b j;
  private Handler k;
  private a l;
  private BalloonView m;
  private ImageView n;
  private g.a o;
  private View p;
  private boolean q;
  private boolean r;
  private boolean s;
  private MenuItem t;
  private com.viber.voip.messages.extras.map.d u;
  private boolean v;
  private com.viber.common.permission.c w;
  private com.viber.common.permission.b x;
  private TextView y;
  private BotReplyRequest z;

  public LocationMessageActivityV2()
  {
    Pair[] arrayOfPair = new Pair[2];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(64);
    arrayOfPair[1] = com.viber.voip.permissions.m.a(65);
    this.x = new f(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 64:
        case 65:
        }
        LocationMessageActivityV2.a(LocationMessageActivityV2.this);
      }
    };
    this.A = 1;
  }

  public static Intent a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, "");
  }

  public static Intent a(int paramInt1, int paramInt2, String paramString)
  {
    return new Intent().putExtra("extra_location_lat", paramInt1).putExtra("extra_location_lon", paramInt2).putExtra("extra_location_text", paramString);
  }

  public static Intent a(Location paramLocation)
  {
    return a((int)(1000000.0D * paramLocation.getLatitude()), (int)(1000000.0D * paramLocation.getLongitude()), "");
  }

  private void a()
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      this.r = localBundle.containsKey("localityAccuracy");
      if (this.r)
        this.s = localBundle.getBoolean("localityAccuracy");
      this.v = localBundle.getBoolean("fromConversation", false);
    }
  }

  private void a(Intent paramIntent)
  {
    if (getIntent() != null)
      paramIntent.putExtra("extra_bot_reply_pending_request", this.z);
    setResult(-1, paramIntent);
    finish();
  }

  private void a(LatLng paramLatLng)
  {
    synchronized (this.h)
    {
      this.i = new b.f();
      this.i.a(null);
      this.i.b(null);
      this.i.e("");
      this.i.a(paramLatLng);
      return;
    }
  }

  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      getWindow().setFlags(1024, 1024);
      return;
    }
    getWindow().clearFlags(1024);
  }

  private void b()
  {
    FragmentManager localFragmentManager = getSupportFragmentManager();
    this.u = ((com.viber.voip.messages.extras.map.d)localFragmentManager.findFragmentById(R.id.map_v2_container));
    if (this.u == null)
    {
      FragmentTransaction localFragmentTransaction = localFragmentManager.beginTransaction();
      this.u = new com.viber.voip.messages.extras.map.d();
      localFragmentTransaction.add(R.id.map_v2_container, this.u);
      localFragmentTransaction.commit();
    }
  }

  private void b(final Location paramLocation)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (LocationMessageActivityV2.i(LocationMessageActivityV2.this) != null)
          LocationMessageActivityV2.i(LocationMessageActivityV2.this).setPosition(new LatLng(paramLocation.getLatitude(), paramLocation.getLongitude()));
        while (true)
        {
          LocationMessageActivityV2.a(LocationMessageActivityV2.this, paramLocation);
          return;
          LocationMessageActivityV2.a(LocationMessageActivityV2.this, LocationMessageActivityV2.k(LocationMessageActivityV2.this).addMarker(LocationMessageActivityV2.l(LocationMessageActivityV2.this).position(new LatLng(paramLocation.getLatitude(), paramLocation.getLongitude()))));
        }
      }
    });
  }

  private void b(boolean paramBoolean)
  {
    if (this.t != null)
      this.t.setVisible(paramBoolean);
  }

  private void c()
  {
    if (this.w.a(n.l))
    {
      d();
      return;
    }
    com.viber.common.permission.c localc = this.w;
    if (this.v);
    for (int i1 = 64; ; i1 = 65)
    {
      localc.a(this, i1, n.l);
      return;
    }
  }

  private void c(Location paramLocation)
  {
    if (this.b != null)
      this.b.remove();
    BitmapDescriptor localBitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.location_accuracy);
    this.b = this.g.addGroundOverlay(new GroundOverlayOptions().image(localBitmapDescriptor).transparency(0.0F).position(new LatLng(paramLocation.getLatitude(), paramLocation.getLongitude()), 2.0F * paramLocation.getAccuracy(), 2.0F * paramLocation.getAccuracy()));
  }

  private void d()
  {
    ViberApplication.getInstance().getLocationManager().a(this.A, this);
  }

  private void e()
  {
    this.d = new MarkerOptions();
    this.d.anchor(0.5F, 0.5F);
    this.d.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker));
    this.e = new MarkerOptions();
    this.e.icon(BitmapDescriptorFactory.fromResource(R.drawable._ics_location_point));
    this.g.getUiSettings().setZoomControlsEnabled(false);
    this.g.getUiSettings().setMyLocationButtonEnabled(true);
    if (dc.b(this, R.attr.mapStyleDark))
      this.g.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.mapstyle_night));
    this.m = ((BalloonView)findViewById(R.id.ballonView));
    this.n = ((ImageView)findViewById(R.id.mapLocationPin));
    this.g.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener()
    {
      public void onCameraChange(CameraPosition paramAnonymousCameraPosition)
      {
        LocationMessageActivityV2.a(LocationMessageActivityV2.this, paramAnonymousCameraPosition.target);
        LocationMessageActivityV2.e(LocationMessageActivityV2.this).removeCallbacks(LocationMessageActivityV2.d(LocationMessageActivityV2.this));
        LocationMessageActivityV2.e(LocationMessageActivityV2.this).postDelayed(LocationMessageActivityV2.d(LocationMessageActivityV2.this), 700L);
        LocationMessageActivityV2.a(LocationMessageActivityV2.this, true);
      }
    });
    this.o = new g.a()
    {
      public void a()
      {
        LocationMessageActivityV2.h(LocationMessageActivityV2.this).setVisibility(4);
        LocationMessageActivityV2.e(LocationMessageActivityV2.this).removeCallbacks(LocationMessageActivityV2.d(LocationMessageActivityV2.this));
        LocationMessageActivityV2.a(LocationMessageActivityV2.this, false);
      }

      public void b()
      {
        if (!LocationMessageActivityV2.f(LocationMessageActivityV2.this))
        {
          LocationMessageActivityV2.g(LocationMessageActivityV2.this).e("");
          LocationMessageActivityV2.e(LocationMessageActivityV2.this).removeCallbacks(LocationMessageActivityV2.d(LocationMessageActivityV2.this));
          LocationMessageActivityV2.h(LocationMessageActivityV2.this).setVisibility(0);
          LocationMessageActivityV2.h(LocationMessageActivityV2.this).a(LocationMessageActivityV2.g(LocationMessageActivityV2.this));
          LocationMessageActivityV2.e(LocationMessageActivityV2.this).postDelayed(LocationMessageActivityV2.d(LocationMessageActivityV2.this), 700L);
        }
      }
    };
    this.u.a().setMapTouchCallback(this.o);
    this.p = findViewById(R.id.move_to_my_btn);
    this.p.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        LocationMessageActivityV2.e(LocationMessageActivityV2.this).removeCallbacks(LocationMessageActivityV2.d(LocationMessageActivityV2.this));
        if ((LocationMessageActivityV2.i(LocationMessageActivityV2.this) != null) && (LocationMessageActivityV2.i(LocationMessageActivityV2.this).getPosition() != null) && (LocationMessageActivityV2.i(LocationMessageActivityV2.this).getPosition().latitude != 0.0D))
        {
          BalloonView localBalloonView = LocationMessageActivityV2.h(LocationMessageActivityV2.this);
          if (LocationMessageActivityV2.j(LocationMessageActivityV2.this) == true);
          for (int i = 4; ; i = 0)
          {
            localBalloonView.setVisibility(i);
            LocationMessageActivityV2.g(LocationMessageActivityV2.this).e("");
            CameraPosition localCameraPosition = new CameraPosition.Builder().target(LocationMessageActivityV2.i(LocationMessageActivityV2.this).getPosition()).zoom(LocationMessageActivityV2.k(LocationMessageActivityV2.this).getCameraPosition().zoom).bearing(LocationMessageActivityV2.k(LocationMessageActivityV2.this).getCameraPosition().bearing).tilt(LocationMessageActivityV2.k(LocationMessageActivityV2.this).getCameraPosition().tilt).build();
            LocationMessageActivityV2.k(LocationMessageActivityV2.this).animateCamera(CameraUpdateFactory.newCameraPosition(localCameraPosition));
            return;
          }
        }
        LocationMessageActivityV2.c(LocationMessageActivityV2.this);
      }
    });
  }

  private void f()
  {
    synchronized (this.h)
    {
      if (this.i.b() != null)
      {
        a(a(this.i.b().a(), this.i.b().b(), this.i.d()));
        return;
      }
      a(a((int)(1000000.0D * this.g.getCameraPosition().target.latitude), (int)(1000000.0D * this.g.getCameraPosition().target.longitude)));
    }
  }

  private boolean g()
  {
    double d1 = Math.abs(this.f.getPosition().latitude - this.g.getCameraPosition().target.latitude);
    double d2 = Math.abs(this.f.getPosition().longitude - this.g.getCameraPosition().target.longitude);
    return (d1 >= 0.0009D) || (d2 >= 0.0009D);
  }

  private TextView h()
  {
    if (this.y == null)
      this.y = ((TextView)((ViewStub)findViewById(R.id.alert_banner_share_location_with_bot_stub)).inflate());
    return this.y;
  }

  public void a(final Location paramLocation, d.c paramc)
  {
    if (paramLocation == null)
      return;
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        LocationMessageActivityV2.b(LocationMessageActivityV2.this, true);
        CameraPosition.Builder localBuilder = new CameraPosition.Builder().target(new LatLng(paramLocation.getLatitude(), paramLocation.getLongitude()));
        if ("passive".equals(paramLocation.getProvider()));
        for (float f = 6.0F; ; f = 16.0F)
        {
          CameraPosition localCameraPosition = localBuilder.zoom(f).bearing(0.0F).tilt(0.0F).build();
          LocationMessageActivityV2.a(LocationMessageActivityV2.this, paramLocation);
          if (localCameraPosition != null)
          {
            LocationMessageActivityV2.b(LocationMessageActivityV2.this, paramLocation);
            LocationMessageActivityV2.k(LocationMessageActivityV2.this).animateCamera(CameraUpdateFactory.newCameraPosition(localCameraPosition));
            LocationMessageActivityV2.a(LocationMessageActivityV2.this, localCameraPosition.target);
          }
          return;
        }
      }
    });
  }

  public void a(Bundle paramBundle)
  {
    this.u.getMapAsync(new OnMapReadyCallback()
    {
      public void onMapReady(GoogleMap paramAnonymousGoogleMap)
      {
        LocationMessageActivityV2.a(LocationMessageActivityV2.this, paramAnonymousGoogleMap);
        LocationMessageActivityV2.b(LocationMessageActivityV2.this);
        LocationMessageActivityV2.c(LocationMessageActivityV2.this);
      }
    });
  }

  public void a(b.f paramf)
  {
    while (true)
    {
      synchronized (this.h)
      {
        this.i = paramf;
        if (TextUtils.isEmpty(paramf.f()))
        {
          str = getString(R.string.message_type_location);
          paramf.e(str);
          this.m.a(paramf);
          this.m.setVisibility(0);
          this.n.setVisibility(0);
          b(true);
          return;
        }
      }
      String str = paramf.f();
    }
  }

  protected com.viber.voip.ui.c.c createActivityDecorator()
  {
    return new com.viber.voip.ui.c.d(new h(), this, (com.viber.voip.ui.j.av)ViberApplication.getInstance().getThemeController().get());
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    int i1 = 1;
    if (paramConfiguration.orientation == i1);
    while (true)
    {
      a(i1);
      super.onConfigurationChanged(paramConfiguration);
      return;
      int i2 = 0;
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    int i1;
    boolean bool;
    label120: String str2;
    if (MapsInitializer.initialize(getApplicationContext()) == 0)
    {
      setContentView(R.layout.map_v2_view);
      a();
      this.j = new com.viber.voip.messages.extras.map.b(null, this);
      this.l = new a(null);
      this.i = new b.f();
      b();
      android.support.v7.app.a locala = getSupportActionBar();
      if (this.v)
      {
        i1 = R.string.msg_send_location_title;
        locala.b(i1);
        getSupportActionBar().a(false);
        getSupportActionBar().b(true);
        if (dj.c(this))
          break label262;
        bool = true;
        a(bool);
        this.k = com.viber.voip.av.a(av.e.a);
        this.w = com.viber.common.permission.c.a(this);
        Intent localIntent = getIntent();
        if (localIntent != null)
        {
          this.z = ((BotReplyRequest)localIntent.getParcelableExtra("extra_bot_reply_pending_request"));
          this.A = localIntent.getIntExtra("extra_location_format", 1);
        }
        if (this.z != null)
        {
          getSupportActionBar().b(R.string.my_location);
          ChatExtensionLoaderEntity localChatExtensionLoaderEntity = this.a.a(this.z.publicAccountId);
          if (localChatExtensionLoaderEntity == null)
            break label290;
          str2 = localChatExtensionLoaderEntity.getName();
          label227: if (!TextUtils.isEmpty(str2))
            break label296;
        }
      }
    }
    label262: label290: label296: for (String str3 = getString(R.string.share_location_with_pa_banner_message_regular); ; str3 = getString(R.string.share_location_with_pa_banner_message, new Object[] { str2 }))
    {
      h().setText(str3);
      return;
      i1 = R.string.select_vibe_location_hint;
      break;
      bool = false;
      break label120;
      String str1 = ViberApplication.getLocalizedResources().getString(R.string.toast_maps_lib_missing);
      ViberApplication.getInstance().showToast(str1);
      finish();
      return;
      str2 = null;
      break label227;
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_send_location, paramMenu);
    this.t = paramMenu.findItem(R.id.menu_send);
    if (this.z != null)
    {
      this.t.setTitle(R.string.user_save_button);
      if ((this.f != null) && (this.f.getPosition().latitude != 0.0D))
      {
        b(true);
        return true;
      }
    }
    else
    {
      boolean bool = getIntent().getBooleanExtra("fromConversation", false);
      MenuItem localMenuItem = this.t;
      if (bool);
      for (int i1 = R.string.btn_msg_send; ; i1 = R.string.user_save_button)
      {
        localMenuItem.setTitle(i1);
        break;
      }
    }
    b(false);
    return true;
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D_EXPLAIN_PERMISSION)) && (paramInt == -1))
      this.w.a(this, 64, new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" });
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    this.k.removeCallbacks(this.l);
    int i1 = paramMenuItem.getItemId();
    if (i1 == 16908332)
    {
      finish();
      return true;
    }
    if (i1 == R.id.menu_send)
    {
      f();
      return true;
    }
    return false;
  }

  protected void onStart()
  {
    super.onStart();
    this.w.a(this.x);
  }

  protected void onStop()
  {
    super.onStop();
    this.w.b(this.x);
  }

  private class a
    implements Runnable
  {
    private a()
    {
    }

    public void run()
    {
      boolean bool2;
      boolean bool1;
      synchronized (LocationMessageActivityV2.m(LocationMessageActivityV2.this))
      {
        LocationMessageActivityV2.a(LocationMessageActivityV2.this, LocationMessageActivityV2.k(LocationMessageActivityV2.this).getCameraPosition().target);
        double d1 = LocationMessageActivityV2.g(LocationMessageActivityV2.this).c().latitude;
        double d2 = LocationMessageActivityV2.g(LocationMessageActivityV2.this).c().longitude;
        if (!LocationMessageActivityV2.n(LocationMessageActivityV2.this))
        {
          if (com.viber.voip.messages.extras.b.b.a(LocationMessageActivityV2.o(LocationMessageActivityV2.this), d.f.e.d()) != 0)
            break label143;
          bool2 = true;
          break label136;
          LocationMessageActivityV2.q(LocationMessageActivityV2.this).a(LocationMessageActivityV2.o(LocationMessageActivityV2.this), d1, d2, bool1);
        }
        else
        {
          bool1 = LocationMessageActivityV2.p(LocationMessageActivityV2.this);
        }
      }
      while (true)
      {
        label136: bool1 = bool2;
        break;
        label143: bool2 = false;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.LocationMessageActivityV2
 * JD-Core Version:    0.6.2
 */