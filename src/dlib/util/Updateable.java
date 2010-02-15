package dlib.util;

public interface Updateable<E>
{
	public boolean isAlive();
	public abstract void update(E e);
	public abstract void render(E e);
}
