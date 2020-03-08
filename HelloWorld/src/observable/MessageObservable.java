package observable;

import java.util.Observable;

public class MessageObservable extends Observable{

	public MessageObservable() {
		super();
	}
	
	public void changeData(Object data) {
        setChanged();
        notifyObservers(data);
    }
	
}
