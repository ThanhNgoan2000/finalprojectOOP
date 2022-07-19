package model;

import java.util.ArrayList;

import view.Observer;

public abstract class Observable {
    private ArrayList<Observer> list = new ArrayList<>();
    public void registerObs(Observer o) {
    	list.add(o);
    }
    public void removeObs(Observer o) {
    	list.remove(o);
    }
	public void notifyObs() {
    	for(Observer o: list) {
    		o.update();
    	}
    }
	public int getSize() {
		return list.size();
	}
}
