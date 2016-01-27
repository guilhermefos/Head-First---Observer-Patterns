
public interface Subject {
	
	public void registerObserver(Observer newObserver);
	public void removeObserver(Observer newObserver);
	public void notifyObservers();

}
