package com.viber.voip.gallery.preview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.an;
import com.viber.voip.an.c;
import com.viber.voip.an.d;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.gallery.GalleryCoach;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.gallery.b.d;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.ui.PositioningAwareFrameLayout;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.messages.ui.cd.a;
import com.viber.voip.settings.d.am;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhotoPreviewActivity extends ViberFragmentActivity
  implements LoaderManager.LoaderCallbacks<ArrayList<GalleryItem>>, b, e
{
  protected View a;
  protected View b;
  protected EditText c;
  protected PositioningAwareFrameLayout d;
  private android.support.v7.app.a e;
  private an f;
  private f g;
  private c h;
  private ArrayList<GalleryItem> i = new ArrayList();
  private ai j;
  private boolean k;
  private an.d l = new an.d()
  {
    public void a(int paramAnonymousInt, Uri paramAnonymousUri)
    {
    }

    public void a(int paramAnonymousInt, an.c paramAnonymousc)
    {
      if (PhotoPreviewActivity.a(PhotoPreviewActivity.this))
      {
        Uri localUri = ((GalleryItem)PhotoPreviewActivity.c(PhotoPreviewActivity.this).get(paramAnonymousInt)).getOriginalUri();
        PhotoPreviewActivity.d(PhotoPreviewActivity.this).a(localUri, paramAnonymousc);
      }
    }

    public void b(int paramAnonymousInt, an.c paramAnonymousc)
    {
      if ((PhotoPreviewActivity.a(PhotoPreviewActivity.this)) && (PhotoPreviewActivity.b(PhotoPreviewActivity.this).b() == paramAnonymousInt))
      {
        localGalleryItem = (GalleryItem)PhotoPreviewActivity.c(PhotoPreviewActivity.this).get(paramAnonymousInt);
        localUri = localGalleryItem.getOriginalUri();
        PhotoPreviewActivity.d(PhotoPreviewActivity.this).a(localUri, paramAnonymousc);
        PhotoPreviewActivity.e(PhotoPreviewActivity.this).d(paramAnonymousInt, localUri, localGalleryItem.getMimeType());
        PhotoPreviewActivity.this.c();
      }
      while ((PhotoPreviewActivity.f(PhotoPreviewActivity.this)) || (PhotoPreviewActivity.this.isFinishing()))
      {
        GalleryItem localGalleryItem;
        Uri localUri;
        return;
      }
      PhotoPreviewActivity.g(PhotoPreviewActivity.this);
      PhotoPreviewActivity.this.c();
    }
  };
  private TextWatcher m = new TextWatcher()
  {
    private boolean b;

    public void afterTextChanged(Editable paramAnonymousEditable)
    {
    }

    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }

    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      if (!this.b)
      {
        this.b = true;
        int i = paramAnonymousInt1 + paramAnonymousInt3;
        PhotoPreviewActivity.h(PhotoPreviewActivity.this).a(PhotoPreviewActivity.this.c, aj.b, paramAnonymousInt1, i);
        Editable localEditable = PhotoPreviewActivity.this.c.getText();
        ImageSpan[] arrayOfImageSpan = (ImageSpan[])localEditable.getSpans(i, i, ImageSpan.class);
        if ((arrayOfImageSpan != null) && (arrayOfImageSpan.length > 0))
        {
          ImageSpan localImageSpan = arrayOfImageSpan[0];
          if (localEditable.getSpanStart(localImageSpan) < i)
            PhotoPreviewActivity.this.c.setSelection(localEditable.getSpanEnd(localImageSpan));
        }
        this.b = false;
      }
    }
  };

  private void a(int paramInt, ArrayList<GalleryItem> paramArrayList)
  {
    Context localContext = getApplicationContext();
    int n = R.string.max_pictures_limit_exceeded;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    Toast.makeText(localContext, getString(n, arrayOfObject), 0).show();
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("image_uri_list", paramArrayList);
    localBundle.putInt("max_size", paramInt);
    getSupportLoaderManager().initLoader(1, localBundle, this);
  }

  private void a(Intent paramIntent)
  {
    ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("image_list");
    if (localArrayList == null)
      localArrayList = new ArrayList();
    if (localArrayList.size() > 10)
    {
      b();
      a(10, localArrayList);
    }
    while (true)
    {
      a(this.g, "photo_preview", false);
      return;
      a(localArrayList);
    }
  }

  private void a(String paramString, boolean paramBoolean)
  {
    this.c.setEnabled(paramBoolean);
    this.c.setText(paramString);
    this.j.a(this.c, aj.b);
    if (!TextUtils.isEmpty(paramString))
      this.c.setSelection(paramString.length());
  }

  private static boolean a(List<GalleryItem> paramList)
  {
    if (paramList == null)
      return false;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      if (!((GalleryItem)localIterator.next()).isGif())
        return false;
    return true;
  }

  private void f()
  {
    this.d = ((PositioningAwareFrameLayout)findViewById(R.id.content));
    this.a = findViewById(R.id.progress);
    this.b = findViewById(R.id.description_container);
    this.c = ((EditText)findViewById(R.id.description));
    this.e = getSupportActionBar();
    this.e.e(true);
    this.e.a(false);
    this.e.b(true);
    this.c.addTextChangedListener(this.m);
    this.j = new ai(this);
    this.d.setPositioningListener(new cd.a()
    {
      public void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        Resources localResources = PhotoPreviewActivity.this.getResources();
        int i = paramAnonymousInt1 - 2 * (int)localResources.getDimension(R.dimen.gallery_left_right_paddings);
        int j = paramAnonymousInt2 - ((int)localResources.getDimension(R.dimen.gallery_bottom_paddings) + (int)localResources.getDimension(R.dimen.gallery_top_paddings));
        PhotoPreviewActivity.e(PhotoPreviewActivity.this).a(i, j);
        PhotoPreviewActivity.this.d.post(new Runnable()
        {
          public void run()
          {
            if (PhotoPreviewActivity.b(PhotoPreviewActivity.this) != null)
              PhotoPreviewActivity.b(PhotoPreviewActivity.this).a();
          }
        });
      }
    });
  }

  private void g()
  {
    View localView;
    if (!isFinishing())
    {
      this.g.a(this.i);
      this.k = true;
      localView = this.b;
      if (!a(this.i))
        break label89;
    }
    label89: for (int n = 8; ; n = 0)
    {
      localView.setVisibility(n);
      c(this.g.b());
      if (d.am.a.d())
      {
        startActivity(new Intent(this, GalleryCoach.class));
        d.am.a.a(false);
      }
      return;
    }
  }

  private void h()
  {
    dj.c(this.c);
  }

  private void i()
  {
    int n = this.g.b();
    if (n < this.i.size())
    {
      GalleryItem localGalleryItem = (GalleryItem)this.i.get(n);
      Uri localUri = localGalleryItem.getItemUri();
      if (this.f.a(n, localUri, localGalleryItem.getMimeType()) == null)
      {
        b();
        this.f.b(n, localUri, localGalleryItem.getMimeType());
        return;
      }
      g();
      return;
    }
    g();
  }

  private boolean j()
  {
    return (this.h != null) && (this.h.isAdded());
  }

  public void a()
  {
  }

  public void a(int paramInt)
  {
    android.support.v7.app.a locala = this.e;
    int n = R.string.media_message_counter;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    locala.a(getString(n, arrayOfObject));
  }

  public void a(Uri paramUri, Bitmap paramBitmap)
  {
    int n = this.g.b();
    if (n < this.i.size())
    {
      GalleryItem localGalleryItem = (GalleryItem)this.i.get(n);
      localGalleryItem.setItemUri(paramUri);
      this.f.a(n, paramBitmap, localGalleryItem.getMimeType());
      onBackPressed();
    }
    c();
  }

  protected final void a(Fragment paramFragment, String paramString, boolean paramBoolean)
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    localFragmentTransaction.setTransition(0);
    localFragmentTransaction.add(R.id.content, paramFragment, paramString);
    if (paramBoolean)
      localFragmentTransaction.addToBackStack(null);
    localFragmentTransaction.commit();
  }

  public void a(Loader<ArrayList<GalleryItem>> paramLoader, ArrayList<GalleryItem> paramArrayList)
  {
    getSupportLoaderManager().destroyLoader(paramLoader.getId());
    a(paramArrayList);
  }

  public void a(ArrayList<GalleryItem> paramArrayList)
  {
    this.k = false;
    this.i = paramArrayList;
    i();
  }

  public void b()
  {
    if (this.a.getVisibility() == 0)
      return;
    this.a.setAlpha(1.0F);
    this.a.setVisibility(0);
    this.d.setVisibility(8);
    this.b.setVisibility(8);
  }

  public void b(int paramInt)
  {
    if (paramInt < this.i.size())
      ((GalleryItem)this.i.get(paramInt)).setDescription(this.c.getText().toString().trim());
  }

  public void c()
  {
    if (this.a.getVisibility() != 0)
      return;
    this.d.setVisibility(0);
    View localView = this.b;
    if (d());
    for (int n = 0; ; n = 8)
    {
      localView.setVisibility(n);
      this.c.requestFocus();
      this.a.setAlpha(1.0F);
      this.d.setAlpha(0.0F);
      this.b.setAlpha(0.0F);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(ObjectAnimator.ofFloat(this.a, "alpha", new float[] { 0.0F }));
      localArrayList.add(ObjectAnimator.ofFloat(this.d, "alpha", new float[] { 1.0F }));
      localArrayList.add(ObjectAnimator.ofFloat(this.b, "alpha", new float[] { 1.0F }));
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(localArrayList);
      localAnimatorSet.setDuration(1000L);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
        }

        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          PhotoPreviewActivity.this.a.setVisibility(8);
        }

        public void onAnimationRepeat(Animator paramAnonymousAnimator)
        {
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
        }
      });
      localAnimatorSet.start();
      return;
    }
  }

  public void c(int paramInt)
  {
    if (paramInt < this.i.size())
    {
      GalleryItem localGalleryItem = (GalleryItem)this.i.get(paramInt);
      String str = localGalleryItem.getDescription();
      if (!localGalleryItem.isGif());
      for (boolean bool = true; ; bool = false)
      {
        a(str, bool);
        return;
      }
    }
    a(null, false);
  }

  protected boolean d()
  {
    return !a(this.i);
  }

  public void e()
  {
    this.c.setText(null);
    this.c.setEnabled(false);
  }

  public void finish()
  {
    h();
    if (this.f != null)
    {
      this.f.b(this.l);
      this.f.b();
    }
    this.g.a(null);
    super.finish();
  }

  public void onBackPressed()
  {
    if (!getSupportFragmentManager().popBackStackImmediate())
    {
      b(this.g.b());
      Intent localIntent1 = (Intent)getIntent().getParcelableExtra("open_on_canceled_action");
      if (localIntent1 != null)
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.i.iterator();
        while (localIterator.hasNext())
        {
          GalleryItem localGalleryItem = (GalleryItem)localIterator.next();
          if (localGalleryItem.hasDoodle())
            localArrayList.add(localGalleryItem.getOriginalUri());
        }
        if (localArrayList.size() > 0)
          av.a(av.e.g).post(new a(localArrayList));
        startActivity(localIntent1);
      }
    }
    do
    {
      return;
      Intent localIntent2 = new Intent();
      localIntent2.putParcelableArrayListExtra("image_list", this.i);
      setResult(-1, localIntent2);
      super.onBackPressed();
      return;
      this.h = null;
      a();
    }
    while (this.k);
    g();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.doodle_base_activity);
    setActionBarTitle(R.string.photo_preview_title);
    dj.c(this, false);
    f();
    Intent localIntent = getIntent();
    Resources localResources = getResources();
    int n = this.d.getWidth() - (int)(2.0F * localResources.getDimension(R.dimen.gallery_left_right_paddings));
    int i1 = this.d.getHeight() - (int)(localResources.getDimension(R.dimen.gallery_bottom_paddings) + localResources.getDimension(R.dimen.gallery_top_paddings));
    this.f = new an(getApplicationContext(), n, i1, 0.5F);
    this.f.a(this.l);
    FragmentManager localFragmentManager = getSupportFragmentManager();
    this.g = ((f)localFragmentManager.findFragmentByTag("photo_preview"));
    if (this.g == null)
      this.g = f.a((ConversationData)localIntent.getParcelableExtra("extra_conversation_data"), (Bundle)localIntent.getParcelableExtra("options"));
    this.g.a(this.f);
    if (paramBundle != null)
    {
      this.i = paramBundle.getParcelableArrayList("photo_data_list");
      this.h = ((c)localFragmentManager.findFragmentByTag("photo_edit"));
      a(this.i.size());
      i();
      return;
    }
    a(localIntent);
  }

  public Loader<ArrayList<GalleryItem>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new d(paramBundle.getParcelableArrayList("image_uri_list"), paramBundle.getInt("max_size"), getApplicationContext());
  }

  public void onLoaderReset(Loader<ArrayList<GalleryItem>> paramLoader)
  {
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelableArrayList("photo_data_list", this.i);
  }

  public boolean onSupportNavigateUp()
  {
    onBackPressed();
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.preview.PhotoPreviewActivity
 * JD-Core Version:    0.6.2
 */