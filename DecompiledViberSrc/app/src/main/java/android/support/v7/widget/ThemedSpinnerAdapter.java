package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.support.v7.view.d;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;

public abstract interface ThemedSpinnerAdapter extends SpinnerAdapter
{
  public abstract Resources.Theme getDropDownViewTheme();

  public abstract void setDropDownViewTheme(Resources.Theme paramTheme);

  public static final class Helper
  {
    private final Context mContext;
    private LayoutInflater mDropDownInflater;
    private final LayoutInflater mInflater;

    public Helper(Context paramContext)
    {
      this.mContext = paramContext;
      this.mInflater = LayoutInflater.from(paramContext);
    }

    public LayoutInflater getDropDownViewInflater()
    {
      if (this.mDropDownInflater != null)
        return this.mDropDownInflater;
      return this.mInflater;
    }

    public Resources.Theme getDropDownViewTheme()
    {
      if (this.mDropDownInflater == null)
        return null;
      return this.mDropDownInflater.getContext().getTheme();
    }

    public void setDropDownViewTheme(Resources.Theme paramTheme)
    {
      if (paramTheme == null)
      {
        this.mDropDownInflater = null;
        return;
      }
      if (paramTheme == this.mContext.getTheme())
      {
        this.mDropDownInflater = this.mInflater;
        return;
      }
      this.mDropDownInflater = LayoutInflater.from(new d(this.mContext, paramTheme));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ThemedSpinnerAdapter
 * JD-Core Version:    0.6.2
 */