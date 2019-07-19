package com.viber.voip.messages.ui.media;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Address;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CameraPosition.Builder;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.viber.voip.R.attr;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.raw;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.extras.map.b.f;
import com.viber.voip.messages.k;
import com.viber.voip.ui.c.c;
import com.viber.voip.ui.c.h;
import com.viber.voip.ui.j.av;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.Iterator;

public class GoogleApiMapPreviewActivityV2 extends ViberFragmentActivity
  implements GoogleMap.OnMapClickListener, com.viber.voip.messages.extras.map.d.a, d.a
{
  private GoogleMap a;
  private View b;
  private View c;
  private MarkerOptions d;
  private Marker e;
  private d f = new d();
  private a g;
  private ArrayList<Runnable> h = new ArrayList();
  private com.viber.voip.messages.extras.map.d i;

  private void a(Address paramAddress, String paramString1, int paramInt1, int paramInt2, long paramLong1, String paramString2, long paramLong2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    b.f localf = new b.f();
    LatLng localLatLng1 = new LatLng(paramInt1 / 1000000.0D, paramInt2 / 1000000.0D);
    LatLng localLatLng2;
    if (TextUtils.isEmpty(paramString1))
    {
      localf.c(DateUtils.formatDateTime(this, paramLong1, 341));
      localf.a(localLatLng1);
      localf.e(paramString2);
      localLatLng2 = new LatLng(paramInt1 / 1000000.0D, paramInt2 / 1000000.0D);
      if (!paramBoolean1)
        break label303;
    }
    label303: for (float f1 = 16.0F; ; f1 = 10.0F)
    {
      CameraPosition localCameraPosition = new CameraPosition(localLatLng2, f1, 0.0F, 0.0F);
      if (paramBoolean1)
      {
        this.d = new MarkerOptions();
        this.d.icon(BitmapDescriptorFactory.fromResource(R.drawable._ics_location_point));
        this.d.title(localf.g());
        this.d.snippet(localf.e());
        this.d.position(new LatLng(localCameraPosition.target.latitude, localCameraPosition.target.longitude));
        this.e = this.a.addMarker(this.d);
        this.e.showInfoWindow();
      }
      this.a.animateCamera(CameraUpdateFactory.newCameraPosition(localCameraPosition));
      this.a.getUiSettings().setZoomControlsEnabled(false);
      this.f.a().a(false);
      if ((paramLong2 > 0L) && (!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString3)))
        ViberApplication.getInstance().getMessagesManager().c().b(paramLong2, paramString1);
      return;
      paramString2 = paramString1;
      break;
    }
  }

  private void a(Runnable paramRunnable)
  {
    if (this.h != null)
    {
      this.h.add(paramRunnable);
      return;
    }
    paramRunnable.run();
  }

  private void d()
  {
    FragmentManager localFragmentManager = getSupportFragmentManager();
    this.i = ((com.viber.voip.messages.extras.map.d)localFragmentManager.findFragmentById(R.id.map_v2_container));
    if (this.i == null)
    {
      FragmentTransaction localFragmentTransaction = localFragmentManager.beginTransaction();
      this.i = new com.viber.voip.messages.extras.map.d();
      localFragmentTransaction.add(R.id.map_v2_container, this.i);
      localFragmentTransaction.commit();
    }
  }

  private void e()
  {
    this.g = new a(getLayoutInflater());
    this.a.setInfoWindowAdapter(this.g);
    this.a.setOnMapClickListener(this);
    if (dc.b(this, R.attr.mapStyleDark))
      this.a.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.mapstyle_night));
    this.b = findViewById(R.id.move_to_my_btn);
    this.b.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((GoogleApiMapPreviewActivityV2.c(GoogleApiMapPreviewActivityV2.this) != null) && (GoogleApiMapPreviewActivityV2.c(GoogleApiMapPreviewActivityV2.this).getPosition() != null) && (GoogleApiMapPreviewActivityV2.c(GoogleApiMapPreviewActivityV2.this).getPosition().latitude != 0.0D))
        {
          CameraPosition localCameraPosition = new CameraPosition.Builder().target(GoogleApiMapPreviewActivityV2.c(GoogleApiMapPreviewActivityV2.this).getPosition()).zoom(GoogleApiMapPreviewActivityV2.d(GoogleApiMapPreviewActivityV2.this).getCameraPosition().zoom).bearing(GoogleApiMapPreviewActivityV2.d(GoogleApiMapPreviewActivityV2.this).getCameraPosition().bearing).tilt(GoogleApiMapPreviewActivityV2.d(GoogleApiMapPreviewActivityV2.this).getCameraPosition().tilt).build();
          GoogleApiMapPreviewActivityV2.d(GoogleApiMapPreviewActivityV2.this).animateCamera(CameraUpdateFactory.newCameraPosition(localCameraPosition));
        }
      }
    });
  }

  private void f()
  {
    if (this.h != null)
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
        ((Runnable)localIterator.next()).run();
    }
    this.h = null;
  }

  public View a()
  {
    this.b = findViewById(R.id.move_to_my_btn);
    this.c = findViewById(R.id.map_container);
    d();
    return this.c;
  }

  public void a(int paramInt1, int paramInt2, long paramLong1, String paramString1, long paramLong2, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(new a(this, paramString2, paramInt1, paramInt2, paramBoolean2, paramLong1, paramString1, paramLong2, paramBoolean1));
  }

  public void a(Bundle paramBundle)
  {
    this.i.getMapAsync(new OnMapReadyCallback()
    {
      public void onMapReady(GoogleMap paramAnonymousGoogleMap)
      {
        GoogleApiMapPreviewActivityV2.a(GoogleApiMapPreviewActivityV2.this, paramAnonymousGoogleMap);
        GoogleApiMapPreviewActivityV2.a(GoogleApiMapPreviewActivityV2.this);
        GoogleApiMapPreviewActivityV2.b(GoogleApiMapPreviewActivityV2.this);
      }
    });
  }

  public int b()
  {
    return R.layout.map_v2_preview;
  }

  protected c createActivityDecorator()
  {
    return new com.viber.voip.ui.c.d(new h(), this, (av)ViberApplication.getInstance().getThemeController().get());
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.f.a(paramConfiguration);
    super.onConfigurationChanged(paramConfiguration);
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    if (!this.f.a(paramMenuItem))
      return super.onContextItemSelected(paramMenuItem);
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    supportRequestWindowFeature(5);
    super.onCreate(paramBundle);
    dc.a(this);
    getSupportActionBar().a(false);
    getSupportActionBar().b(true);
    this.f.a(this);
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    this.f.a(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (this.f.a().a(paramMenu))
      return true;
    return super.onCreateOptionsMenu(paramMenu);
  }

  public void onMapClick(LatLng paramLatLng)
  {
    if (this.e != null)
      this.e.showInfoWindow();
  }

  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.f.a(paramIntent);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (this.f.a().a(paramMenuItem))
      return true;
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected void onStart()
  {
    this.f.c();
    super.onStart();
  }

  protected void onStop()
  {
    this.f.d();
    super.onStop();
  }

  class a
    implements GoogleMap.InfoWindowAdapter
  {
    LayoutInflater a = null;

    a(LayoutInflater arg2)
    {
      Object localObject;
      this.a = localObject;
    }

    public View getInfoContents(Marker paramMarker)
    {
      return null;
    }

    public View getInfoWindow(Marker paramMarker)
    {
      View localView = this.a.inflate(R.layout.balloon_overlay, null);
      FrameLayout localFrameLayout = (FrameLayout)localView.findViewById(R.id.balloon_layout);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(0, 0, 0, 0);
      localFrameLayout.setLayoutParams(localLayoutParams);
      dj.a(localFrameLayout, GoogleApiMapPreviewActivityV2.this.getResources().getDrawable(R.drawable.location_tool_tip_adress));
      ((ProgressBar)localView.findViewById(R.id.balloon_loading)).setVisibility(8);
      ((TextView)localView.findViewById(R.id.balloon_item_title)).setText(paramMarker.getTitle());
      TextView localTextView = (TextView)localView.findViewById(R.id.balloon_item_snippet);
      localTextView.setText(paramMarker.getSnippet());
      localTextView.setVisibility(0);
      return localView;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.GoogleApiMapPreviewActivityV2
 * JD-Core Version:    0.6.2
 */