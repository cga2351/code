package android.support.v8.renderscript;

public class Matrix2f
{
  final float[] mMat = new float[4];

  public Matrix2f()
  {
    loadIdentity();
  }

  public Matrix2f(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, this.mMat, 0, this.mMat.length);
  }

  public float get(int paramInt1, int paramInt2)
  {
    return this.mMat[(paramInt2 + paramInt1 * 2)];
  }

  public float[] getArray()
  {
    return this.mMat;
  }

  public void load(Matrix2f paramMatrix2f)
  {
    System.arraycopy(paramMatrix2f.getArray(), 0, this.mMat, 0, this.mMat.length);
  }

  public void loadIdentity()
  {
    this.mMat[0] = 1.0F;
    this.mMat[1] = 0.0F;
    this.mMat[2] = 0.0F;
    this.mMat[3] = 1.0F;
  }

  public void loadMultiply(Matrix2f paramMatrix2f1, Matrix2f paramMatrix2f2)
  {
    for (int i = 0; i < 2; i++)
    {
      int j = 0;
      float f1 = 0.0F;
      float f2 = 0.0F;
      while (j < 2)
      {
        float f3 = paramMatrix2f2.get(i, j);
        f2 += f3 * paramMatrix2f1.get(j, 0);
        f1 += f3 * paramMatrix2f1.get(j, 1);
        j++;
      }
      set(i, 0, f2);
      set(i, 1, f1);
    }
  }

  public void loadRotate(float paramFloat)
  {
    float f1 = 0.01745329F * paramFloat;
    float f2 = (float)Math.cos(f1);
    float f3 = (float)Math.sin(f1);
    this.mMat[0] = f2;
    this.mMat[1] = (-f3);
    this.mMat[2] = f3;
    this.mMat[3] = f2;
  }

  public void loadScale(float paramFloat1, float paramFloat2)
  {
    loadIdentity();
    this.mMat[0] = paramFloat1;
    this.mMat[3] = paramFloat2;
  }

  public void multiply(Matrix2f paramMatrix2f)
  {
    Matrix2f localMatrix2f = new Matrix2f();
    localMatrix2f.loadMultiply(this, paramMatrix2f);
    load(localMatrix2f);
  }

  public void rotate(float paramFloat)
  {
    Matrix2f localMatrix2f = new Matrix2f();
    localMatrix2f.loadRotate(paramFloat);
    multiply(localMatrix2f);
  }

  public void scale(float paramFloat1, float paramFloat2)
  {
    Matrix2f localMatrix2f = new Matrix2f();
    localMatrix2f.loadScale(paramFloat1, paramFloat2);
    multiply(localMatrix2f);
  }

  public void set(int paramInt1, int paramInt2, float paramFloat)
  {
    this.mMat[(paramInt2 + paramInt1 * 2)] = paramFloat;
  }

  public void transpose()
  {
    float f = this.mMat[1];
    this.mMat[1] = this.mMat[2];
    this.mMat[2] = f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.Matrix2f
 * JD-Core Version:    0.6.2
 */