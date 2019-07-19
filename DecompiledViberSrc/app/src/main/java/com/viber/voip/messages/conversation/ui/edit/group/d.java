package com.viber.voip.messages.conversation.ui.edit.group;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.g;
import com.viber.common.dialogs.z;
import com.viber.common.ui.ShapeImageView;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.ui.aq;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.util.ay;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.h.a;

public class d extends aq
  implements m.g
{
  private static final Logger a = ViberEnv.getLogger();
  private AddGroupDetailsPresenter b;
  private e c;
  private m.g d;

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.c.a(paramInt1, paramInt2, paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.group_add_details_layout, paramViewGroup, false);
    ViberApplication localViberApplication = ViberApplication.getInstance();
    FragmentActivity localFragmentActivity = getActivity();
    LoaderManager localLoaderManager = localFragmentActivity.getSupportLoaderManager();
    b localb = new b(localFragmentActivity, g.a());
    AddGroupDetailsWithPhotoResolverModel localAddGroupDetailsWithPhotoResolverModel = new AddGroupDetailsWithPhotoResolverModel(this, localLoaderManager, localViberApplication.getLazyMessagesManager(), o.a(), localViberApplication.getMessagesManager().d(), localViberApplication.getEngine(false).getPhoneController());
    this.c = localAddGroupDetailsWithPhotoResolverModel;
    this.b = new AddGroupDetailsPresenterImpl(localb, localAddGroupDetailsWithPhotoResolverModel, cj.a(ViberApplication.getApplication()));
    a locala = new a(getActivity(), this, localView, this.b);
    this.d = ((m.g)locala);
    this.b.a(locala);
    if (paramBundle != null)
    {
      this.c.a(paramBundle.getParcelable("restore_model"));
      this.b.a(paramBundle.getParcelable("restore_present"));
      return localView;
    }
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      long l = localBundle.getLong("conversation_id");
      AddGroupDetailsPresenter.AddDetailsGoNextAction localAddDetailsGoNextAction = (AddGroupDetailsPresenter.AddDetailsGoNextAction)localBundle.getParcelable("add_details_action");
      if ((l <= 0L) || (localAddDetailsGoNextAction == null))
        throw new IllegalArgumentException("GroupAddDetailsFragment unknown arguments");
      this.b.a(localAddDetailsGoNextAction);
      this.b.b(l);
      return localView;
    }
    throw new IllegalArgumentException("GroupAddDetailsFragment unknown arguments");
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.b.i();
  }

  public void onDialogListAction(m paramm, int paramInt)
  {
    this.d.onDialogListAction(paramm, paramInt);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Parcelable localParcelable1 = this.b.j();
    if (localParcelable1 != null)
      paramBundle.putParcelable("restore_present", localParcelable1);
    Parcelable localParcelable2 = this.c.f();
    if (localParcelable2 != null)
      paramBundle.putParcelable("restore_model", localParcelable2);
  }

  public void onStart()
  {
    super.onStart();
    this.b.g();
  }

  public void onStop()
  {
    super.onStop();
    this.b.h();
  }

  private static class a
    implements View.OnClickListener, m.g, c, h.a
  {
    d a;
    private final FragmentManager b;
    private final TextView c;
    private final EditText d;
    private ShapeImageView e;
    private View f;
    private final AddGroupDetailsPresenter g;
    private final com.viber.voip.util.e.e h;
    private final f i;
    private int j;

    public a(Activity paramActivity, d paramd, View paramView, AddGroupDetailsPresenter paramAddGroupDetailsPresenter)
    {
      this.j = paramActivity.getResources().getDimensionPixelSize(R.dimen.add_details_photo_padding);
      this.g = paramAddGroupDetailsPresenter;
      this.h = com.viber.voip.util.e.e.a(paramActivity.getApplicationContext());
      this.i = f.a(R.drawable.ic_composer_camera_normal);
      this.a = paramd;
      this.b = this.a.getFragmentManager();
      this.c = ((TextView)paramView.findViewById(R.id.btn_save));
      this.f = paramView.findViewById(R.id.edit_icon_view);
      this.d = ((EditText)paramView.findViewById(R.id.edit_group_name));
      this.e = ((ShapeImageView)paramView.findViewById(R.id.img_take_photo));
      this.e.setOnClickListener(this);
      paramView.findViewById(R.id.btn_skip).setOnClickListener(this);
      this.c.setOnClickListener(this);
      this.d.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
        }

        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
        }

        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          d.a.a(d.a.this).a(paramAnonymousCharSequence.toString());
        }
      });
    }

    private void a(a.a parama)
    {
      parama.a(this.a).c(this.a);
    }

    public void a()
    {
      ay.a(this.a, false);
    }

    public void a(Uri paramUri)
    {
      this.h.a(paramUri, this.e, this.i, this);
    }

    public void a(String paramString)
    {
      this.d.setText(paramString);
      if (!da.a(paramString))
        this.d.setSelection(paramString.length());
    }

    public void a(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        ad.b().b(this.b);
        return;
      }
      z.b(this.b, DialogCode.D_PROGRESS);
    }

    public void b()
    {
      a(ad.a());
    }

    public void b(boolean paramBoolean)
    {
      this.c.setEnabled(paramBoolean);
    }

    public void c()
    {
      a(com.viber.voip.ui.dialogs.k.n());
    }

    public void onClick(View paramView)
    {
      int k = paramView.getId();
      if (k == R.id.btn_save)
        this.g.b();
      do
      {
        return;
        if (k == R.id.btn_skip)
        {
          this.g.c();
          return;
        }
      }
      while (k != R.id.img_take_photo);
      this.g.d();
    }

    public void onDialogListAction(m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.DC19))
      {
        if (paramInt != 0)
          break label24;
        this.g.e();
      }
      label24: 
      while (paramInt != 1)
        return;
      this.g.f();
    }

    public void onLoadComplete(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.f.setVisibility(4);
        this.e.setPadding(this.j, this.j, this.j, this.j);
        return;
      }
      this.f.setVisibility(0);
      this.e.setPadding(0, 0, 0, 0);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.edit.group.d
 * JD-Core Version:    0.6.2
 */