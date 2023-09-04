package observers;

import core.GameObject;
import observers.events.Event;

public interface Observer {

	void onNotify(GameObject object, Event event);
}
