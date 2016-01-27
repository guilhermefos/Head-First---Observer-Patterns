import java.util.ArrayList;

public class WeatherData implements Subject{
	
	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData(){
		observers = new ArrayList();
	}

	@Override
	public void registerObserver(Observer newObserver) {
		observers.add(newObserver);
	}

	@Override
	public void removeObserver(Observer newObserver) {
		int i = observers.indexOf(newObserver);
		if(i >= 0){
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for(int i = 0; i < observers.size(); i++){
			Observer observer = (Observer)observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}
	
	public void setMeasurements(float newTemperature, float newHumidity, float newPressure){
		this.temperature = newTemperature;
		this.humidity    = newHumidity;
		this.pressure    = newPressure;
		
		measurementsChanged();
	}

}
