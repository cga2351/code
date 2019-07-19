package com.viber.voip.market;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.billing.l;
import com.viber.voip.market.a.a.f;
import com.viber.voip.market.a.a.g;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.entity.a;
import com.viber.voip.stickers.i;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.ui.aq;
import com.viber.voip.util.dj;
import com.viber.voip.widget.dslv.DragSortListView;
import java.util.List;

public class h extends aq
  implements View.OnClickListener
{
  private static final Logger a = ViberEnv.getLogger();
  private final Handler b = av.a(av.e.a);
  private volatile int c;
  private a d;
  private i e;
  private com.viber.voip.market.a.a.b f;
  private g g;
  private f h;
  private com.viber.voip.market.a.a.h i;
  private com.viber.voip.stickers.e.b j = new com.viber.voip.stickers.e.b()
  {
    public void onStickerDeployed(Sticker paramAnonymousSticker)
    {
    }

    public void onStickerPackageDeployed(a paramAnonymousa)
    {
      h.a(h.this, -1);
    }

    public void onStickerPackageDownloadError(boolean paramAnonymousBoolean, a paramAnonymousa)
    {
      h.a(h.this, -1);
    }

    public void onStickerPackageDownloadScheduled(a paramAnonymousa)
    {
      h.a(h.this, 1);
    }

    public void onStickerPackageDownloadStarted(a paramAnonymousa)
    {
    }

    public void onStickerPackageDownloading(a paramAnonymousa, int paramAnonymousInt)
    {
    }
  };
  private Runnable k = new Runnable()
  {
    public void run()
    {
      h.b(h.this);
      h.a.a(h.a(h.this), false);
    }
  };

  private void a()
  {
    this.c = 0;
    c();
    l.a(null, true);
  }

  private void a(int paramInt)
  {
    this.b.removeCallbacks(this.k);
    this.c = (paramInt + this.c);
    if (this.c <= 0)
    {
      this.b.postDelayed(this.k, 1000L);
      return;
    }
    this.b.post(new Runnable()
    {
      public void run()
      {
        h.a.a(h.a(h.this), true);
      }
    });
  }

  private void a(List<a> paramList)
  {
    DragSortListView localDragSortListView = this.d.a;
    if (paramList.size() > 1);
    Context localContext;
    for (boolean bool = true; ; bool = false)
    {
      localDragSortListView.setDragEnabled(bool);
      localContext = this.d.a.getContext();
      if (paramList.size() != 0)
        break;
      this.d.f.setText(localContext.getString(R.string.no_packages));
      this.d.g.setVisibility(8);
      this.d.h.setPadding(0, 0, 0, 0);
      return;
    }
    this.d.h.setPadding(0, localContext.getResources().getDimensionPixelSize(R.dimen.sticker_package_icon_size), 0, 0);
    TextView localTextView = this.d.f;
    int m = R.string.my_packages;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramList.size());
    localTextView.setText(localContext.getString(m, arrayOfObject));
    this.d.g.setVisibility(0);
  }

  private void b()
  {
    if (getActivity() == null)
      return;
    String str = ap.c().as;
    GenericWebViewActivity.a(getActivity(), str, getString(R.string.market_settings_btn_support));
  }

  private void c()
  {
    i.a().a(this.j);
  }

  private void d()
  {
    i.a().b(this.j);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    dj.a((AppCompatActivity)getActivity(), getString(R.string.market_settings_title));
    this.e = i.a();
    List localList = this.e.i();
    this.h = new f(localList);
    this.i = new com.viber.voip.market.a.a.h(getActivity(), this.h);
    this.g = new g(this.d.a, this.h, this.i, this.f);
    this.f = new com.viber.voip.market.a.a.b(this.e, this.h, this.i)
    {
      public void a(List<a> paramAnonymousList)
      {
        if (!h.this.isAdded())
          return;
        super.a(paramAnonymousList);
        h.a(h.this, paramAnonymousList);
      }
    };
    a(localList);
    this.d.a.setFloatViewManager(this.g);
    this.d.a.setOnTouchListener(this.g);
    this.d.a.setDragScrollProfile(this.g);
    this.d.a.setDropListener(this.i);
    this.d.a.setAdapter(this.i);
    this.e.a(this.f);
  }

  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m == R.id.btn_sync)
      a();
    while (m != R.id.btn_support)
      return;
    b();
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.add(0, R.id.deleteButton, 0, "Delete all stickers");
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView1 = paramLayoutInflater.inflate(R.layout.market_settings_layout, null);
    View localView2 = paramLayoutInflater.inflate(R.layout.market_settings_layout_footer, null);
    this.d = new a(localView1, paramLayoutInflater.inflate(R.layout.sticker_packages_header, null), localView2, null);
    this.d.b.setOnClickListener(this);
    this.d.c.setOnClickListener(this);
    a.a(this.d, false);
    return localView1;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.e.b(this.f);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == R.id.deleteButton)
    {
      final ProgressDialog localProgressDialog = ProgressDialog.show(getActivity(), "", "Deleting packages");
      i.a().a(false, new Runnable()
      {
        public void run()
        {
          if ((localProgressDialog != null) && (localProgressDialog.isShowing()))
            localProgressDialog.dismiss();
        }
      });
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onPause()
  {
    super.onPause();
    List localList = this.h.c();
    this.e.c(localList);
  }

  public void onStop()
  {
    super.onStop();
    a.a(this.d, false);
    d();
  }

  private static class a
  {
    final DragSortListView a;
    final View b;
    final View c;
    final TextView d;
    final ProgressBar e;
    final TextView f;
    final View g;
    final View h;

    private a(View paramView1, View paramView2, View paramView3)
    {
      this.a = ((DragSortListView)paramView1.findViewById(16908298));
      this.a.addFooterView(paramView3);
      this.a.addHeaderView(paramView2);
      this.h = paramView3;
      this.f = ((TextView)paramView2.findViewById(R.id.label));
      this.b = paramView3.findViewById(R.id.btn_sync);
      this.c = paramView3.findViewById(R.id.btn_support);
      this.d = ((TextView)paramView3.findViewById(R.id.downloading_label));
      this.e = ((ProgressBar)paramView3.findViewById(R.id.downloading_progress));
      this.g = paramView2.findViewById(R.id.on_off);
    }

    private void a(boolean paramBoolean)
    {
      View localView = this.b;
      int i;
      int j;
      label30: ProgressBar localProgressBar;
      int k;
      if (paramBoolean)
      {
        i = 8;
        localView.setVisibility(i);
        TextView localTextView = this.d;
        if (!paramBoolean)
          break label63;
        j = 0;
        localTextView.setVisibility(j);
        localProgressBar = this.e;
        k = 0;
        if (!paramBoolean)
          break label70;
      }
      while (true)
      {
        localProgressBar.setVisibility(k);
        return;
        i = 0;
        break;
        label63: j = 8;
        break label30;
        label70: k = 8;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.h
 * JD-Core Version:    0.6.2
 */