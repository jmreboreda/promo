package com.github.jmreboreda.promo.model.exceptions.daoexceptions;


public class InstanceNotFoundException extends InstanceException {

	private static final long serialVersionUID = -1765310600493994975L;

	public InstanceNotFoundException(Object key, String className) {
        super("Instance not found", key, className);
    }
    
}
