package android.support.v7.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.c;
import android.support.v7.app.c.a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public abstract class f extends DialogFragment
  implements DialogInterface.OnClickListener
{
  private DialogPreference a;
  private CharSequence b;
  private CharSequence c;
  private CharSequence d;
  private CharSequence e;
  private int f;
  private BitmapDrawable g;
  private int h;

  private void a(Dialog paramDialog)
  {
    paramDialog.getWindow().setSoftInputMode(5);
  }

  protected View a(Context paramContext)
  {
    int i = this.f;
    if (i == 0)
      return null;
    return LayoutInflater.from(paramContext).inflate(i, null);
  }

  protected void a(c.a parama)
  {
  }

  protected void a(View paramView)
  {
    View localView = paramView.findViewById(16908299);
    if (localView != null)
    {
      CharSequence localCharSequence = this.e;
      int i = 8;
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if ((localView instanceof TextView))
          ((TextView)localView).setText(localCharSequence);
        i = 0;
      }
      if (localView.getVisibility() != i)
        localView.setVisibility(i);
    }
  }

  public abstract void a(boolean paramBoolean);

  protected boolean a()
  {
    return false;
  }

  public DialogPreference b()
  {
    if (this.a == null)
    {
      String str = getArguments().getString("key");
      this.a = ((DialogPreference)((DialogPreference.a)getTargetFragment()).a(str));
    }
    return this.a;
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.h = paramInt;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Fragment localFragment = getTargetFragment();
    if (!(localFragment instanceof DialogPreference.a))
      throw new IllegalStateException("Target fragment must implement TargetFragment interface");
    DialogPreference.a locala = (DialogPreference.a)localFragment;
    String str = getArguments().getString("key");
    Drawable localDrawable;
    if (paramBundle == null)
    {
      this.a = ((DialogPreference)locala.a(str));
      this.b = this.a.e();
      this.c = this.a.h();
      this.d = this.a.i();
      this.e = this.a.f();
      this.f = this.a.j();
      localDrawable = this.a.g();
      if ((localDrawable == null) || ((localDrawable instanceof BitmapDrawable)))
        this.g = ((BitmapDrawable)localDrawable);
    }
    Bitmap localBitmap1;
    do
    {
      return;
      Bitmap localBitmap2 = Bitmap.createBitmap(localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap2);
      localDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      localDrawable.draw(localCanvas);
      this.g = new BitmapDrawable(getResources(), localBitmap2);
      return;
      this.b = paramBundle.getCharSequence("PreferenceDialogFragment.title");
      this.c = paramBundle.getCharSequence("PreferenceDialogFragment.positiveText");
      this.d = paramBundle.getCharSequence("PreferenceDialogFragment.negativeText");
      this.e = paramBundle.getCharSequence("PreferenceDialogFragment.message");
      this.f = paramBundle.getInt("PreferenceDialogFragment.layout", 0);
      localBitmap1 = (Bitmap)paramBundle.getParcelable("PreferenceDialogFragment.icon");
    }
    while (localBitmap1 == null);
    this.g = new BitmapDrawable(getResources(), localBitmap1);
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    FragmentActivity localFragmentActivity = getActivity();
    this.h = -2;
    c.a locala = new c.a(localFragmentActivity).a(this.b).a(this.g).a(this.c, this).b(this.d, this);
    View localView = a(localFragmentActivity);
    if (localView != null)
    {
      a(localView);
      locala.b(localView);
    }
    while (true)
    {
      a(locala);
      c localc = locala.b();
      if (a())
        a(localc);
      return localc;
      locala.b(this.e);
    }
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (this.h == -1);
    for (boolean bool = true; ; bool = false)
    {
      a(bool);
      return;
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putCharSequence("PreferenceDialogFragment.title", this.b);
    paramBundle.putCharSequence("PreferenceDialogFragment.positiveText", this.c);
    paramBundle.putCharSequence("PreferenceDialogFragment.negativeText", this.d);
    paramBundle.putCharSequence("PreferenceDialogFragment.message", this.e);
    paramBundle.putInt("PreferenceDialogFragment.layout", this.f);
    if (this.g != null)
      paramBundle.putParcelable("PreferenceDialogFragment.icon", this.g.getBitmap());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.f
 * JD-Core Version:    0.6.2
 */