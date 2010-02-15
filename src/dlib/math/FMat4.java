package dlib.math;

public class FMat4 extends FMat
{
	public FMat4()
	{
		mat = new float[4][4];
	}
	
	public void setIdentity()
	{
		mat[0][0] = 1;
		mat[0][1] = 0;
		mat[0][2] = 0;
		mat[0][3] = 0;
		
		mat[1][0] = 0;
		mat[1][1] = 1;
		mat[1][2] = 0;
		mat[1][3] = 0;
		
		mat[2][0] = 0;
		mat[2][1] = 0;
		mat[2][2] = 0;
		mat[2][3] = 1;
		
		mat[3][0] = 0;
		mat[3][1] = 0;
		mat[3][2] = 0;
		mat[3][3] = 1;
	}
	
	public void rotX( float angle )
	{
		float sinAngle = (float) Math.sin( angle );
		float cosAngle = (float) Math.cos( angle );
		mat[0][0] = 1;
		mat[0][1] = 0;
		mat[0][2] = 0;
		mat[0][3] = 0;
		
		mat[1][0] = 0;
		mat[1][1] = cosAngle;
		mat[1][2] = -sinAngle;
		mat[1][3] = 0;
		
		mat[2][0] = 0;
		mat[2][1] = sinAngle;
		mat[2][2] = cosAngle;
		mat[2][3] = 1;
		
		mat[3][0] = 0;
		mat[3][1] = 0;
		mat[3][2] = 0;
		mat[3][3] = 1;
	}
}
