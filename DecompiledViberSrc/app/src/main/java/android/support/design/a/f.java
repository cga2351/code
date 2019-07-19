package android.support.design.a;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public class f extends Property<ImageView, Matrix>
{
  private final Matrix a = new Matrix();

  public f()
  {
    super(Matrix.class, "imageMatrixProperty");
  }

  public Matrix a(ImageView paramImageView)
  {
    this.a.set(paramImageView.getImageMatrix());
    return this.a;
  }

  public void a(ImageView paramImageView, Matrix paramMatrix)
  {
    paramImageView.setImageMatrix(paramMatrix);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.a.f
 * JD-Core Version:    0.6.2
 */